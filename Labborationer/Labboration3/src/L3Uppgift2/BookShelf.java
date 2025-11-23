package L3Uppgift2;

public class BookShelf{

    private String shelfName;
    private Book[] books;
    private int maximumNumberOfBooks = 10;
    private int numberOfBooks = -1;


    public BookShelf(String shelfName){
        this.shelfName = shelfName;
    }

    public Book getBookByTitle(String title){
        for (int i = 0; i <= this.numberOfBooks+1;i++){
            if (this.books[i].getTitle().equals(title)){
                return this.books[i];
            }
        }
        return null;
    }

    public Book[] getAllBooks(){
        return this.books;
    }

    public void addBook(Book book){
        for (int i=this.numberOfBooks+1; i <= maximumNumberOfBooks; i++){
            this.books[i] = book;
            this.numberOfBooks++;
        }

    }

    public String getShelfName(){
        return this.shelfName;
    }

}
