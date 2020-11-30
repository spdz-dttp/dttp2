import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class use_datasource {
    public static void getConnectionUseDriverManger() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/dttp_1?charsetEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "spdz";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // 目的是要获取 Connection 对象
        }
    }

    // 1. 这个是新版 JDBC 标准提供的写法
    // 2. 写法比 url 的方式更加明确，不容易出现拼写错误
    // 3. 支持连接池的方式，所以可能效率更高
    public static void getConnectionUseDataSource() throws SQLException {
        DataSource dataSource; //初始值是 null

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("spdz");
        mysqlDataSource.setDatabaseName("dttp_1");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSource = mysqlDataSource;

        try (Connection connection = dataSource.getConnection()) {
            // 目的是要获取 Connection 对象
        }
    }
}
