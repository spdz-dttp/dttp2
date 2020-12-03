package blog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: 2020.11.16
 * @description: 初始化一个 DataSource
 * @author: spdz
 * @create: 2020-11-17 13:44
 **/

// Utilize 工具
public class DBUtil {
    // 静态属性，这个代码运行过程中，只有一份（整个进程运行过程中）
    private static DataSource dataSource = null;

    static {
        initDataSource();
    }

    private static void initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("spdz");
        mysqlDataSource.setDatabaseName("dttp_boke");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSource = mysqlDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
