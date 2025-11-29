package com.hqhe.agent.service;

import com.hqhe.agent.entity.dto.LoginDTO;
import com.hqhe.agent.entity.dto.RegisterDTO;
import com.hqhe.agent.entity.vo.LoginVO;
import com.hqhe.agent.entity.vo.UserInfoVO;

public interface UserService {

    /**
     * 用户注册
     */
    Boolean register(RegisterDTO registerDTO);

    /**
     * 用户登录
     */
    LoginVO login(LoginDTO loginDTO);

    /**
     * 查询用户个人信息
     */
    UserInfoVO getUserProfile(Long userId);
}
