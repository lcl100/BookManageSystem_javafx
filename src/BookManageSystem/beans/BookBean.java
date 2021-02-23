package BookManageSystem.beans;

public class BookBean {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookAuthorSex;
    private float bookPrice;
    private String bookDescription;
    private String bookTypeId;

    public BookBean() { }

    public BookBean(int bookId, String bookName, String bookAuthor, String bookAuthorSex, float bookPrice, String bookDescription, String bookTypeId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookAuthorSex = bookAuthorSex;
        this.bookPrice = bookPrice;
        this.bookDescription = bookDescription;
        this.bookTypeId = bookTypeId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthorSex() {
        return bookAuthorSex;
    }

    public void setBookAuthorSex(String bookAuthorSex) {
        this.bookAuthorSex = bookAuthorSex;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(String bookTypeId) {
        this.bookTypeId = bookTypeId;
    }
}
