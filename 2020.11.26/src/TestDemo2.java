import java.util.Scanner;

/**
 * @program: 2020.11.26
 * @description: 自定义异常做用户登录
 * @author: spdz
 * @create: 2020-11-26 23:35
 **/

class UserException extends RuntimeException {
    UserException(String massage) {
        super(massage);
    }
}

class PasswordException extends RuntimeException {
    PasswordException(String massage) {
        super(massage);
    }
}

public class TestDemo2 {
    private static String user = "spdz";
    private static String password = "123456";

    public static void login(String user1,String password1)throws UserException,PasswordException {
        if (!user1.equals(user)) {
            throw new UserException("用户名异常");
        }
        if (!password1.equals(password)) {
            throw new PasswordException("密码异常");
        }
        System.out.println("登录成功");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String password = scanner.nextLine();
        login(user,password);

        try {
            login(user,password);
        }catch (UserException i) {
            i.printStackTrace();
        }catch (PasswordException i) {
            i.printStackTrace();
        }

    }

}
