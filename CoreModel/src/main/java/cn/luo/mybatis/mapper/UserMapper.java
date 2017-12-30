package cn.luo.mybatis.mapper;

import cn.luo.mybatis.model.User;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where userId = #{userid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userid);

    @Insert({
        "insert into user (userId, name, ",
        "depId, sex)",
        "values (#{userid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{depid,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @Select({
        "select",
        "userId, name, depId, sex",
        "from user",
        "where userId = #{userid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="depId", property="depid", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(String userid);

    @Select({
        "select",
        "userId, name, depId, sex",
        "from user"
    })
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="depId", property="depid", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectAll();

    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "depId = #{depid,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR}",
        "where userId = #{userid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);

    @Update("UPDATE user SET sex = #{sex} WHERE userId = #{userId}")
    void updateUserEmailById(@Param("userId") String userId, @Param("sex") String sex);
}