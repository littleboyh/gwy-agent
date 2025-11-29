package com.hqhe.agent.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDTO {
    /**
     * 用户名
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 邮箱地址
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度至少为6位")
    private String password;


    /**
     * 邀请码
     */
    @NotBlank(message = "邀请码不能为空")
    private String inviteCode;
}
