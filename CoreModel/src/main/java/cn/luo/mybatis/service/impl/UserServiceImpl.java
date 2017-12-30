package cn.luo.mybatis.service.impl;

import cn.luo.mybatis.mapper.UserMapper;
import cn.luo.mybatis.service.UserService;
import cn.luo.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    public List<User> getUserList() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public void updateUserEmailById(String userId, String sex) {
        userMapper.updateUserEmailById(userId, sex);
    }

    public void deleteUserById(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    public void insertUser(User user) {
        userMapper.insert(user);
    }
}