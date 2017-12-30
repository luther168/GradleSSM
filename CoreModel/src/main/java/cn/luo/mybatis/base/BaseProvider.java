package cn.luo.mybatis.base;

import javax.naming.InvalidNameException;

public interface BaseProvider {
    public String selectAll(String tableName) throws InvalidNameException;

    public String select(String selectStr, String tableName, String whereStr, int limit, int offset) throws InvalidNameException;
}
