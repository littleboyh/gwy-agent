package com.hqhe.agent.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqhe.agent.domain.user.User;
import com.hqhe.agent.entity.dto.LoginDTO;
import com.hqhe.agent.entity.dto.RegisterDTO;
import com.hqhe.agent.entity.vo.LoginVO;
import com.hqhe.agent.entity.vo.UserInfoVO;
import com.hqhe.agent.mapper.UserMapper;
import com.hqhe.agent.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单的内存实现，后续可替换为数据库存储
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Set<String> availableInviteCodes = ConcurrentHashMap.newKeySet();
    private static final String DEFAULT_AVATAR = "https://api.dicebear.com/7.x/avataaars/svg?seed=Felix";

    public UserServiceImpl() {
        // 预置一个示例邀请码；实际使用时可改为从数据库或配置加载
        availableInviteCodes.add("DEFAULT-INVITE");
    }

    @Override
    public Boolean register(RegisterDTO registerDTO) {
        if (!availableInviteCodes.contains(registerDTO.getInviteCode())) {
            throw new IllegalArgumentException("邀请码不存在");
        }
        boolean inviteUsed = lambdaQuery().eq(User::getInviteCode, registerDTO.getInviteCode()).exists();
        if (inviteUsed && !"DEFAULT-INVITE".equals(registerDTO.getInviteCode())) {
            throw new IllegalArgumentException("邀请码已被使用");
        }


        boolean emailExist = lambdaQuery().eq(User::getEmail, registerDTO.getEmail()).exists();
        if (emailExist) {
            throw new IllegalArgumentException("邮箱已注册");
        }

        boolean nickNameExist = lambdaQuery().eq(User::getNickName, registerDTO.getNickName()).exists();
        if (nickNameExist) {
            throw new IllegalArgumentException("用户名已被使用");
        }

        User user = new User();
        user.setNickName(registerDTO.getNickName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user.setAvatarUrl(DEFAULT_AVATAR);
        user.setIsPro(Boolean.FALSE);
        user.setProExpireTime(null);
        user.setInviteCode(registerDTO.getInviteCode());
        return this.save(user);
    }

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        User user = lambdaQuery().eq(User::getEmail, loginDTO.getEmail()).one();
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new IllegalArgumentException("密码不正确");
        }

        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        LoginVO loginVO = new LoginVO();
        loginVO.setUserId(String.valueOf(user.getId()));
        loginVO.setToken(tokenInfo.getTokenValue());
        loginVO.setTokenExpiration(tokenInfo.getTokenTimeout());
        return loginVO;
    }

    @Override
    public UserInfoVO getUserProfile(Long userId) {
        User user = getById(userId);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }
        return toUserInfoVO(user);
    }

    private UserInfoVO toUserInfoVO(User user) {
        UserInfoVO vo = new UserInfoVO();
        vo.setUserId(user.getId());
        vo.setNickName(user.getNickName());
        vo.setAvatar(user.getAvatarUrl());
        vo.setEmail(user.getEmail());
        vo.setIsPro(user.getIsPro());
        vo.setProExpireTime(user.getProExpireTime());
        vo.setExamsCount(0);
        vo.setAvgScore(0.0);
        vo.setDaysActive(0);
        return vo;
    }
}
