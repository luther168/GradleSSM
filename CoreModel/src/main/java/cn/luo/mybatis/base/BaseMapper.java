package cn.luo.mybatis.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper {

    List<Map<String, Object>> select(String selectStr, String tableName, String whereStr, int limit, int offset);

    List<Map<String,Object>> selectAll(String tableName);
}
