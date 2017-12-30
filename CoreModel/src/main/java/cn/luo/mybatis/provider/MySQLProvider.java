package cn.luo.mybatis.provider;

import cn.luo.mybatis.base.BaseProvider;
import cn.luo.utils.StringUtils;

import javax.naming.InvalidNameException;

public class MySQLProvider implements BaseProvider {

    public String selectAll(String tableName) throws InvalidNameException {
        return select(null, tableName, null, 0, 0);
    }

    public String select(String selectStr, String tableName, String whereStr, int limit, int offset) throws InvalidNameException {
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT ");
        if (StringUtils.stringIsEmpty(selectStr)) {
            builder.append("*");
        } else {
            builder.append(selectStr);
        }

        builder.append(" FROM ");
        if (StringUtils.stringIsEmpty(tableName)) {
            throw new InvalidNameException("The table name '" + tableName + "' is not invalid");
        } else {
            builder.append(tableName);
        }

        if (!StringUtils.stringIsEmpty(whereStr)) {
            builder.append(" WHERE ");
            builder.append(whereStr);
        }

        if (limit > 0) {
            builder.append(" LIMIT ");
            if (offset > 0) {
                builder.append(offset).append(",");
            }
            builder.append(limit);
        }

        return builder.toString();
    }
}
