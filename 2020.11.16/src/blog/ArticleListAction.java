package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @program: 2020.11.16
 * @description: 文章列表
 * @author: spdz
 * @create: 2020-11-17 15:57
 **/

public class ArticleListAction implements Action {
    @Override
    public void run() {
        try (Connection connection = DBUtil.getConnection()) {
            List<String[]> articleList = new ArrayList<>();

            String sql = "select id, author_id, title, published_at from articles order by published_at desc";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String[] article = new String[4];
                        String id = resultSet.getString("id");
                        String authorId = resultSet.getString("author_id");
                        String title = resultSet.getString("title");
                        String publishedAt = resultSet.getString("published_at");
                        article[0] = id;
                        article[1] = authorId;
                        article[2] = title;
                        article[3] = publishedAt;

                        articleList.add(article);
                    }
                }
            }

            // 打印作者的昵称而不是id信息
            // 需要根据作者 id，再次去 users 表中查询出 用户的昵称信息

            // 提取出所有需要查询的作者的 id
            // 利用 Set 中不会存在重复的元素的特性
            Set<String> authorIdSet = new HashSet<>();
            for (String[] article : articleList) {
                String authorId = article[1];
                authorIdSet.add(authorId);
            }

            // 使用提取出的作者 id，拼接出一个根据 id，查询作者昵称的 sql
            // select id, nickname from users where id in (...)
            // 因为占位符需要多少个，在写代码的期间也不清楚，所以，需要动态生成
            StringBuilder querySql = new StringBuilder("select id, nickname from users where id in (");
            for (int i = 1; i < authorIdSet.size(); i++) {
                querySql.append("?,");
            }
            querySql.append("?)");
            System.out.println("DEBUG: " + querySql.toString());

            Map<String, String> userIdToNicknameMap = new HashMap<>();
            try (PreparedStatement statement = connection.prepareStatement(querySql.toString())) {
                int i = 1;
                for (String id : authorIdSet) {
                    statement.setString(i++, id);
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String id = resultSet.getString("id");
                        String nickname = resultSet.getString("nickname");
                        userIdToNicknameMap.put(id, nickname);
                    }
                }
            }


            System.out.printf("#ID  | 标题                  | 作者    | 发表时间%n");
            for (String[] article : articleList) {
                String id = article[0];
                String authorId = article[1];
                String authorNickname = userIdToNicknameMap.get(authorId);
                String title = article[2];
                String publishedAt = article[3];

                System.out.printf("%-4s | %-40s | %-10s | %s%n", id, title, authorNickname, publishedAt);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("错误：" + e.getMessage());
        }
    }
}
