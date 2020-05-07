package user;

import book.BookList;
import operation.IOperation;

/**
 * @program: 2020.5.4
 * @description:
 * @author: spdz
 * @create: 2020-05-04 15:57
 **/
public abstract class User {
    protected String name;

    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(BookList bookList,int choice) {
        this.operations[choice].work(bookList);
    }
}
