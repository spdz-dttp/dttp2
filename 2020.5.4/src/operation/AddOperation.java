package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @program: 2020.5.4
 * @description:新增书籍
 * @author: spdz
 * @create: 2020-05-04 15:33
 **/
public class AddOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书名字:");
        String name = scanner.nextLine();
        System.out.println("请输入图书作者:");
        String author = scanner.nextLine();
        System.out.println("请输入图书价格:");
        double price = scanner.nextDouble();
        System.out.println("请输入图书类型:");
        String type = scanner.next();

        Book book = new Book(name,author,price,type);

        bookList.setBooks(bookList.getUsedSize(),book);

        bookList.setUsedSize(bookList.getUsedSize() + 1);

        System.out.println("新增成功!");
    }
}
