package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @program: 2020.5.4
 * @description:删除书籍
 * @author: spdz
 * @create: 2020-05-04 15:39
 **/
public class DelOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书籍名字: ");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                for (int pos = i; pos < bookList.getUsedSize()-1; pos++) {
                    bookList.setBooks(pos,bookList.getBook(pos+1));
                }
                bookList.setUsedSize(bookList.getUsedSize()-1);
                System.out.println("删除成功!");
                return;
            }
        }
        System.out.println("没有你要删除的书籍!");
    }
}
