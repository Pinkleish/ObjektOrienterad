package L3Uppgift2;

public class BookCase {
    private BookShelf[] bookShelves;


    public BookCase(){
        this.bookShelves = new BookShelf[6];
    }

    public void addShelf(String name){
        for (int i = 0; i <= bookShelves.length; i++){
            if (this.bookShelves[i] == null){
                this.bookShelves[i] = new BookShelf(name);
                return;
            }
        }
    }

    public void returnBookToShelf(Book book){
        for (int i = 0; i <= this.bookShelves.length; i++){
            if (book.getLocation().equals(this.bookShelves[i].getShelfName())){
                this.bookShelves[i].addBook(book);
                return;
            }
        }
    }

    public BookShelf[] getBookShelves(){
        return this.bookShelves;
    }
}
