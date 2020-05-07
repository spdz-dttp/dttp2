package operation;

import book.Book;
import book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

/**
 * @program: 2020.5.4
 * @description:查找
 * @author: spdz
 * @create: 2020-05-04 15:41
 **/
public class FindOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书籍名字: ");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println(book);
                System.out.println("查找成功!");
                return;
            }
        }
        System.out.println("没有你要借阅的书籍!");
    }
}
