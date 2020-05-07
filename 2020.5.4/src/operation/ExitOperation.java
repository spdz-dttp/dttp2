package operation;

import book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * @program: 2020.5.4
 * @description:退出
 * @author: spdz
 * @create: 2020-05-04 15:41
 **/
public class ExitOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("退出");
        System.exit(1);
    }
}
