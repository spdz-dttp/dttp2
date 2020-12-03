package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: 2020.11.16
 * @description: 评论指定文章
 * @author: spdz
 * @create: 2020-11-17 21:16
 **/
public class ArticleCommentAction implements Action {
    @Override
    public void run() {
        if (!User.isLogined()) {
            System.out.println("** 需要先登录，才能操作该功能！！");
            System.out.println();
            return;
        }

        System.out.println("发表评论中 ...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文章id> ");
        String id = scanner.nextLine();
        System.out.println("请输入评论正文> ");
        String content = scanner.nextLine();
        int userId = User.getCurrentUser().id;
        Date publishedAt = new Date();  // new 完的对象，本来就是当前时间
        // publishedAt 现在是 Date 对象，我们把 Date 对象 format 成 String 格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishedAtStr = format.format(publishedAt);

        try(Connection connection = DBUtil.getConnection()){
            String sql = "insert into comments (user_id, article_id, published_at, content) values (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, userId);
                statement.setString(2, id);
                statement.setString(3, publishedAtStr);
                statement.setString(4, content);

                statement.executeUpdate();

                System.out.println(" 评论发表成功！");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
