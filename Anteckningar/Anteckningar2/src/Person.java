public class Person {

    private String name;
    private int birthYear;

    public Person(){
        name = "No name given";
    }
    public Person(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }
    public String getName(){
        return name;
    }
    public int getBirthYear(){
        return birthYear;
    }
    public void setName(String newName){
        name = newName;
    }
    public String toString() {
        return this.name + " " + this.birthYear;
    }
}
