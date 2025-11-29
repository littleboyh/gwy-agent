package com.hqhe.agent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hqhe.agent.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
