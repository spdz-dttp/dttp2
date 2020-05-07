package book;

/**
 * @program: 2020.5.4
 * @description:书籍
 * @author: spdz
 * @create: 2020-05-04 14:58
 **/

public class Book {
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isborrowded;

    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsborrowded() {
        return isborrowded;
    }

    public void setIsborrowded(boolean isborrowded) {
        this.isborrowded = isborrowded;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isborrowded=" + isborrowded +
                '}';
    }
}
