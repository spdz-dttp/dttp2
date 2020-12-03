package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @program: 2020.11.16
 * @description: 点赞指定文章
 * @author: spdz
 * @create: 2020-11-17 22:02
 **/
public class ArticleLikeAction implements Action {
    @Override
    public void run() {
        if (!User.isLogined()) {
            System.out.println("** 需要先登录，才能操作该功能！！");
            System.out.println();
            return;
        }

        System.out.println("点赞文章中 ...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文章id> ");
        String id = scanner.nextLine();
        int userId = User.getCurrentUser().id;

        try(Connection connection = DBUtil.getConnection()){
            String sql = "insert into like_relations (article_id, user_id) values (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, id);
                statement.setInt(2, userId);

                statement.executeUpdate();

                System.out.println(" 点赞成功！");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
