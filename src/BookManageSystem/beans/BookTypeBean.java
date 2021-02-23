package BookManageSystem.beans;

public class BookTypeBean {
    private int bookTypeId;
    private String bookTypeName;
    private String bookTypeDescription;

    public BookTypeBean() {}

    public BookTypeBean(int bookTypeId, String bookTypeName, String bookTypeDescription) {
        this.bookTypeId = bookTypeId;
        this.bookTypeName = bookTypeName;
        this.bookTypeDescription = bookTypeDescription;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public String getBookTypeDescription() {
        return bookTypeDescription;
    }

    public void setBookTypeDescription(String bookTypeDescription) {
        this.bookTypeDescription = bookTypeDescription;
    }
}
