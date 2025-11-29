package com.hqhe.agent.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.hqhe.agent.common.web.ResponseCode;
import com.hqhe.agent.common.web.vo.Result;
import com.hqhe.agent.entity.vo.UserInfoVO;
import com.hqhe.agent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 获取用户的个人资料
     */
    @GetMapping("/profile")
    public Result<UserInfoVO> getUserProfile() {
        try {
            Long userId = Long.parseLong(String.valueOf(StpUtil.getLoginId()));
            return Result.success(userService.getUserProfile(userId));
        } catch (NotLoginException e) {
            return Result.error(ResponseCode.ILLEGAL_ARGUMENT.name(), "用户未登录");
        } catch (IllegalArgumentException e) {
            return Result.error(ResponseCode.ILLEGAL_ARGUMENT.name(), e.getMessage());
        } catch (Exception e) {
            return Result.error(ResponseCode.SYSTEM_ERROR.name(), "获取用户信息失败");
        }
    }
}
