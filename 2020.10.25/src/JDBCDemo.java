import java.sql.*;

/**
 * @program: 2020.10.23
 * @description:JDBC的使用
 * @author: spdz
 * @create: 2020-10-23 20:18
 **/
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        //判断是否配置成功
//       Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
//       System.out.println(cls.getSimpleName()); //输出 Driver 则配置成功

        //1.注册驱动（mysql）
        Class.forName("com.mysql.jdbc.Driver");

        //2.建立数据库连接

        //写明 MySQL 服务端所在地
        //以后写项目，只需要修改默认数据库名称
        String defaultDatabaseName = "dttp_1";
        String user = "root";
        String password = "spdz";
        String ur1 = "jdbc:mysql://127.0.0.1:3306/" + defaultDatabaseName + "?useSSL=false&characterEncoding=utf8";

        Connection connection = DriverManager.getConnection(ur1, user, password);
        //打印 connection 判断是否连接成功
        System.out.println(connection);

        //queryDemo(connection);

        updateDemo(connection);

        //-1 关闭刚才的连接
        connection.close();

    }

    //插入演示
    private static void updateDemo(Connection connection) throws SQLException {
        //获取 Statement 对象
        Statement statement = connection.createStatement();
        String sql = "insert into student_1 (sn, name, sex) values ('20201023', '凯多','男')";
        int affectedRows = statement.executeUpdate(sql);
        System.out.printf("Query OK,%d row affected%n", affectedRows);
        statement.close();
    }

    //查询演示
    private static void queryDemo(Connection connection) throws SQLException {
        //获取 Statement 对象
        Statement statement = connection.createStatement();

        String sql = "select * from student_1";

        //获得 ResultSet（结果集）对象；
        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;
        System.out.println("+----+------+--------+-----+");
        System.out.println("| id | sn   | name   | sex |");
        System.out.println("+----+------+--------+-----+");
        while(resultSet.next()) {
            String id = resultSet.getString(1);
            String sn = resultSet.getString(2);
            String name = resultSet.getString(3);
            String sex = resultSet.getString(4);
            count++;
            System.out.format("| %2s | %4s | %s | %2s |%n",id, sn, name, sex);
        }
        System.out.println("+----+------+--------+-----+");
        System.out.format("%d row in set", count);

        //-3 关闭 resultSet 对象
        resultSet.close();

        //-2 关闭 statement 对象
        statement.close();
    }
}
