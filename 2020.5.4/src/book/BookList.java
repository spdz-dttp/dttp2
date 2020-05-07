package book;

/**
 * @program: 2020.5.4
 * @description:书库
 * @author: spdz
 * @create: 2020-05-04 15:09
 **/
public class BookList {
    private Book[] books = new Book[100];
    private int usedSize = 0;

    public BookList() {
        books[0] = new Book("三国演义","罗贯中",
                99.9,"小说");
        books[1] = new Book("水浒传","施耐庵",
                99.85,"小说");
        books[2] = new Book("西游记","吴承恩",
                100,"小说");
        this.usedSize = 3;
    }

    public void setBooks(int pos,Book book) {
        this.books[pos] = book;
    }

    public Book getBook(int pos) {
        return this.books[pos];
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
