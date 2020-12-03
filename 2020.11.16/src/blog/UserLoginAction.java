package blog;

import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @program: 2020.11.16
 * @description: 登录
 * @author: spdz
 * @create: 2020-11-17 14:50
 **/
public class UserLoginAction implements Action {

    @Override
    public void run() {

        System.out.println("请开始登录...");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名> ");
        String username = scanner.nextLine();
        System.out.print("请输入密码> ");
        String password = scanner.nextLine();

        try(Connection connection = DBUtil.getConnection()) {
            String sql = "select id, nickname from users where username = ? and password = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,username);
                statement.setString(2,password);
                try(ResultSet resultSet = statement.executeQuery()){
                    // 因为 username 是 unique
                    // 所以查找的过程，要不返回 1 行数据，要不返回 0 行数据
                    // 不可能找到多个
                    if (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String nickname = resultSet.getString(2);
                        User user = new User();
                        user.id = id;
                        user.username = username;
                        user.nickname = nickname;

                        // 进行用户登录
                        User.login(user);
                    } else {
                        System.out.println("** 用户名或者密码错误，请重新输入!!");
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println("错误: " + e.getMessage());
        }

    }
}
