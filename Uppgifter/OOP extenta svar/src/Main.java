/*
UPPGIFT 1
B
D
F
G
I
J
M


UPPGIFT 2
Use-association är t.ex mellan Main & Controller där deras relation enbart är för att "köra" programmet
En vanlig association är mer flexible och kan uppstå t.ex mellan en klass och ett enum klassen får, men måste inte, använda.

Så skillnaden är att use måste användas medan association är mer en tillgänglighet.

UPPGIFT 3
Känns inte lämplig då varken källare, trapphus eller tak är en typ av byggnad. De är definitivt relaterade till byggnader
men om vi t.ex definierar en byggnad som att ha en dörr, rum & folk som bor i byggnaden så blir det fel om
subklasserna skulle ärva dessa attribut då t.ex ett trapphus inte har varken rum eller folk som bor i det.


UPPGIFT 5
"#2: result = 339 DA

UPPGIFT 6
public String returnStringElement(){
    String[] numberArray = new String[1];
    String text = numberArray[0];
    if (numberArray[0] == null){
        return "No text to return";
    }
    return numberArray[0];
}

UPPGIFT 7
public class University extends Building {

    private int nbrRooms;
    private int nbrTeachers;

    public University(String name, int id, String address, String ownerName, String ownerPhoneNumber, int nbrRooms, int nbrTeachers){
    super(this);
    this.name = name;
    this.id = id;
    }

    public String toString(){
    return "| Building name: " + this.name + " | ID: " + this.id + " | Address: " + this.address + " | Owner: " + this.owner + " | Rooms: " + this.nbrRooms + " | Teachers: " + this.nbrTeachers;
    }
}


UPPGIFT 8
visual paradigm

UPPGIFT 10

public abstract class Literature implements ILiterature{
    private int totalNbrOfWords = 3000;


    public void setLiteratureType(LiteratureType type){
        this.type = type;
    }
    public LiteratureType getLiteratureType(){
        return this.type;
    }
    public int getNbrOfPages(){
        return totalNbrOfWords / nbrOfWordsPerPage;
    }
    public int calculateNumberOfPAges(){
        return (this.totalNbrOfWords / this.getNbrOfPages);
    }
    public abstract String getLiteratureInfo();





}


public interface ILiterature {
    private LiteratureType type;
    private int nbrOfWordsPerPage = 250;

    public void setLiteratureType(LiteratureType type);
    public LiteratureType getLiteratureType();
    public int getNbrOfPages();
    public String getLiteratureInfo();


}

public class Book extends Literature {
    private int weight;

    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }
    public String getLiteratureInfo(){
        return "Fantastic book\n" + "This book weighs: " + this.weight + "\n This book contains " + this.getNbrOfPages() + " pages"
    }
}

public class E_Book extends Literature {
    private int diskSpace;

    public setDiskSpace(int diskSpace){
        this.diskSpace = diskSpace;
    }

    public getDiskSPace(){
        return this.diskSpace;
    }
    public String getLiteratureInfo(){
    return "Nice E-book\n" + "E-book needs: " + this.diskSpace + "MB of free disk space" + "\n This book contains " + this.getNbrOfPages() + " pages"

}

public class MainProgram {
    public static void main(String[] args) {
        createLiterature(LiteratureType.E_Book);
        createLiterature(LiteratureType.Book);
    }
    public static void createLiterature(LiteratureType 1Type){
    Literature literature;
    if (1Type == E_Book){
        Literature = new E_Book;
    }
    else-if (1Type == Book){
        Literature = new Book;
    }
    else{
        return null;
    }
       Literature.getLiteratureInfo();
       Literature.calculateNumberOfPages
    }
}



 */