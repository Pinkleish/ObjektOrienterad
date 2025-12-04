package L3Uppgift2;

public class Book{
    private String title;
    private String location;
    private String author;
    private int numberOfPages;

    public Book(String title,String author, int numberOfPages){
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void SetLocation(String newLocation){
        this.location = newLocation;
    }

    public String getLocation(){
        return this.location;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public int getNumberOfPages(){
        return this.numberOfPages;
    }

    @Override
    public String toString() {
        return "Title: " + title + " Author: " + author + " Number of pages: " + numberOfPages;
    }
}
