package cn.luo.mybatis.service;

import cn.luo.mybatis.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserById(String userId);

    void updateUserEmailById(String userId, String sex);

    void deleteUserById(String userId);

    void insertUser(User user);
}