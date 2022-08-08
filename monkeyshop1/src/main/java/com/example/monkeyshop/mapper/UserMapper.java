package com.example.monkeyshop.mapper;

import com.example.monkeyshop.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findusername(@Param("userId") String userId);

    User login(@Param("userId") String userId, @Param("userPassword") String userPassword);

    User findByUserId(@Param("userId") String userId);

    Integer userUpdate(User user);

    List<User> findAll();

    Integer totalPage(@Param("keyword")String keyword);

    Integer delById(@Param("userId")Integer userId);

    User findById(@Param("id") Integer id);

    Integer insert(User user);
}
