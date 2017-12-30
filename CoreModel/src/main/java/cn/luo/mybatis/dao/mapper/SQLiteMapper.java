package cn.luo.mybatis.dao.mapper;

import cn.luo.mybatis.base.BaseMapper;
import cn.luo.mybatis.provider.SQLiteProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface SQLiteMapper extends BaseMapper {

    @Override
    @SelectProvider(type = SQLiteProvider.class, method = "select")
    List<Map<String, Object>> select(String selectStr, String tableName, String whereStr, int limit, int offset);

    @Override
    @SelectProvider(type = SQLiteProvider.class, method = "selectAll")
    List<Map<String, Object>> selectAll(String tableName);
}
