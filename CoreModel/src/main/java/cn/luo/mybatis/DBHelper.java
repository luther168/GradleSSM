package cn.luo.mybatis;

import cn.luo.mybatis.base.BaseMapper;
import cn.luo.mybatis.dao.mapper.MySQLMapper;
import cn.luo.mybatis.dao.mapper.SQLServerMapper;
import cn.luo.mybatis.dao.mapper.SQLiteMapper;
import cn.luo.utils.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBHelper {

    public static final String DATA_SOURCE_MYSQL = "mySqlDataSource";
    public static final String DATA_SOURCE_SQlITE = "sqLiteDataSource";
    public static final String DATA_SOURCE_SQL_SERVER = "sqlServerDataSource";

    private static DBHelper dbHelper = new DBHelper();
    private BaseMapper mapper;
    private String currentDataSource = null;
    private ApplicationContext applicationContext;

    private DBHelper() {
        //初始化ApplicationContext
        applicationContext = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");
        switchDataSource(DATA_SOURCE_SQlITE);
    }

    public static DBHelper getInstance() {
        return dbHelper;
    }

    public void switchDataSource(String dataSource) {
        DBContextHolder.setDbType(dataSource);
        currentDataSource = dataSource;
        if (DATA_SOURCE_SQlITE.equals(dataSource)) {
            mapper = applicationContext.getBean(SQLiteMapper.class);
        } else if (DATA_SOURCE_MYSQL.equals(dataSource)) {
            mapper = applicationContext.getBean(MySQLMapper.class);
        } else if (DATA_SOURCE_SQL_SERVER.equals(dataSource)) {
            mapper = applicationContext.getBean(SQLServerMapper.class);
        }
    }

    public List<Map<String, Object>> select(String tableName) {
        if (StringUtils.stringIsEmpty(currentDataSource)) {
            return new ArrayList<>();
        }
        return mapper.selectAll(tableName);
    }
}
