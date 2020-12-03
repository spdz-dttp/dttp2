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
 * @description:发表文章
 * @author: spdz
 * @create: 2020-11-17 15:57
 **/

public class ArticlePublishAction implements Action {
    @Override
    public void run() {
        if (!User.isLogined()) {
            System.out.println("** 需要先登录，才能操作该功能！！");
            System.out.println();
            return;
        }

        // 和注册用户基本一致
        // 获取用户的输入（标题、正文）
        // 根据当前登录用户，获取作者 id
        // 通过调用 API，获取当前时间

        System.out.println("发表文章中 ...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文章标题> ");
        String title = scanner.nextLine();
        System.out.println("请输入文章正文> ");
        String content = scanner.nextLine();
        int authorId = User.getCurrentUser().id;
        Date publishedAt = new Date();  // new 完的对象，本来就是当前时间
        // publishedAt 现在是 Date 对象，我们把 Date 对象 format 成 String 格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishedAtStr = format.format(publishedAt);

        // 现在信息已经获取完全，通过 jdbc 执行 insert 操作
        try (Connection connection = DBUtil.getConnection()) {
            String sql = "insert into articles (author_id, title, published_at, content) values (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, authorId);
                statement.setString(2, title);
                statement.setString(3, publishedAtStr); // "2020-06-08 20:10:38"
                statement.setString(4, content);

                statement.executeUpdate();

                System.out.println("《" + title + "》 文章发表成功！");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("错误：" + e.getMessage());
        }
    }
}
