package L3Uppgift2;

public class Main {

    public static void main(String[] args){

        BookCase Bookcase1 = new BookCase();
        Bookcase1.addShelf("Cooking");
        Bookcase1.addShelf("Fantasy");
        Bookcase1.addShelf("Poetry");
        Bookcase1.addShelf("Course Books");
        Bookcase1.addShelf("WhoDunnIt");
        Bookcase1.addShelf("Thriller");

        Book[] books = new Book[12];

        books[0] = new Book("Java: How to Program", "Dietel & Dietel",1248);
        books[1] = new Book("The Fellowship of the Ring", "J. R. R. Tolkien",407);
        books[2] = new Book("The Two Towers", "J. R. R. Tolkien",334);
        books[3] = new Book("The Return of the King", "J. R. R. Tolkien",437);
        books[4] = new Book("Samlade dikter", "Hjalmar Gullberg",170);
        books[5] = new Book("Zeinas bröd", "Zeina Mourtada",173);
        books[6] = new Book("Five Little Pigs", "Agatha Christie",258);
        books[7] = new Book("The Colour of Revenge", "Cornelia Funke",326);
        books[8] = new Book("Jack Glass", "Adam Roberts",371);
        books[9] = new Book("Världens bästa Lyrik i urval", "Johannes Edfelt",533);
        books[10] = new Book("Den enögda kaninen", "Christoffer Carlsson",447);
        books[11] = new Book("Sherlock Holmes Collection","Sir Arthur Conan Doyle",479);

        int temp = 0;
        for (int i = 0; i < books.length; i++){
            if (books[i].getNumberOfPages() > books[temp].getNumberOfPages()){
                temp = i;
            }
        }
        System.out.println(books[temp]);

        String searchedForAuthor = "J. R. R. Tolkien";
        for (int i = 0; i < books.length; i++){
            if (books[i].getAuthor().equals(searchedForAuthor)){
                System.out.println(books[i].getTitle());
            }
        }

    }
}
