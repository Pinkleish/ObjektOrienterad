public class Kitty implements IKittyCat{
    String name = "Gardfiemd";
    int age = 2;

    public Kitty(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
    public void patkitty(){
        System.out.println("Hallo my name is " + name + " and I am " + age + " years old");
    }

    @Override
    public String Meow() {
        return "meow";
    }
}
