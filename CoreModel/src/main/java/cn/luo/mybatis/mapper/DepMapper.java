package cn.luo.mybatis.mapper;

import cn.luo.mybatis.model.Dep;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface DepMapper {
    @Delete({
        "delete from dep",
        "where depId = #{depid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String depid);

    @Insert({
        "insert into dep (depId, name)",
        "values (#{depid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Dep record);

    @Select({
        "select",
        "depId, name",
        "from dep",
        "where depId = #{depid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="depId", property="depid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Dep selectByPrimaryKey(String depid);

    @Select({
        "select",
        "depId, name",
        "from dep"
    })
    @Results({
        @Result(column="depId", property="depid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Dep> selectAll();

    @Update({
        "update dep",
        "set name = #{name,jdbcType=VARCHAR}",
        "where depId = #{depid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Dep record);
}