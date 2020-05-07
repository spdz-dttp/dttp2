package operation;

import book.Book;
import book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * @program: 2020.5.4
 * @description:打印书籍
 * @author: spdz
 * @create: 2020-05-04 15:40
 **/
public class DisplayOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
