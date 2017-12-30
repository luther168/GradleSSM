package cn.luo.mybatis;

import cn.luo.mybatis.mapper.UserMapper;
import cn.luo.mybatis.config.DataConfig;
import cn.luo.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Luther on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void getUserById(){
        User user = userMapper.selectByPrimaryKey("user0005");
        System.out.println(user.toString());
    }

    @Test
    public void getUserList(){
        List<User> list = userMapper.selectAll();
        for (User user : list){
            System.out.println(user.toString());
        }
    }

    @Test
    public void updateUserEmailById(){
        userMapper.updateUserEmailById("user0006","女");
    }

    @Test
    public void deleteUserById(){
        userMapper.deleteByPrimaryKey("user0006");
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserid("user0009");
        user.setName("张三7");
        user.setDepid("010102");
        user.setSex("男");
        userMapper.insert(user);
    }
}
