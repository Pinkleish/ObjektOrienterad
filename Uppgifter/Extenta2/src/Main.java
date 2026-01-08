public class Main{
    public static void main(String[] args){
        /*# 📝 EXEMPELTENTAMEN 2 - Objektorienterad Programmering

**Kurs:** Objektorienterad programmering
**Tentamen:** Exempeltentamen 2
**Tid:** 4 timmar
**Hjälpmedel:** Inga
**Totalt:** 40 poäng (G-del) + VG-del

---

## 📋 BETYGSGRÄNSER

**För betyg G (Godkänt):**

- Minst 24 poäng av 40 möjliga på G-delen

**För betyg VG (Väl Godkänt):**

- Minst 24 poäng på G-delen OCH
- Godkänt på VG-uppgiften (bedöms i sin helhet)

---

## ⚠️ VIKTIGA INSTRUKTIONER

- ✍️ Skriv läsligt med blå eller svart penna
- 📝 Använd fullständiga meningar i textsvaren
- 💻 Indentera all kod korrekt
- 🔢 Ange uppgiftsnummer tydligt
- ❓ Fråga tentamensvakt vid oklarheter

---

# DEL 1: UPPGIFTER FÖR BETYG G (40 poäng)

---

## 📌 UPPGIFT 1: SANT/FALSKT (10 poäng, 0.5p/fråga)

**Instruktion:** Markera med ☑️ om påståendet är SANT eller FALSKT.

### Fråga A

En klass kan implementera flera interfaces och samtidigt ärva från en abstrakt klass.

[X] SANT
[ ] FALSKT

---

### Fråga B

Följande kod kommer att kompilera utan fel:

java

```java
public interface Drawable {
    private int size = 10;
    public void draw();
}
```

[X] SANT
[ ] FALSKT

---

### Fråga C

I Java måste finally-blocket alltid ha minst ett catch-block före sig.

[ ] SANT
[X] FALSKT

---

### Fråga D

Följande kod är korrekt skriven:

java

```java
public class Animal {
    public void makeSound() { }
}

public class Dog extends Animal {
    public void makeSound(boolean loud) { }
}
```

Detta är ett exempel på method overriding (överskuggning).

[ ] SANT
[X] FALSKT

---

### Fråga E

En RuntimeException måste antingen fångas med try-catch eller deklareras med throws i metodsignaturen.

[ ] SANT
[X] FALSKT

---

### Fråga F

I ett klassdiagram representerar en streckad pil med en tom pilspets (⋯▷) att en klass implementerar ett interface.

[X] SANT
[ ] FALSKT

---

### Fråga G

När ett objekt skickas som parameter till en metod i Java, skickas objektet som en kopia (pass-by-value för hela objektet).

[ ] SANT
[X] FALSKT

---

### Fråga H

Följande kod kommer att skriva ut "Subklass konstruktor" först och sedan "Superklass konstruktor":

java

```java
public class Parent {
    public Parent() {
        System.out.println("Superklass konstruktor");
    }
}

public class Child extends Parent {
    public Child() {
        System.out.println("Subklass konstruktor");
    }
}

// Körning: new Child();
```

[ ] SANT
[X] FALSKT

---

### Fråga I

En abstrakt klass kan ha en konstruktor.

[X] SANT
[ ] FALSKT

---

### Fråga J

I Swing är FlowLayout den default layout manager för JFrame.

[ ] SANT
[X] FALSKT

---

### Fråga K

En enum i Java kan ha metoder och konstruktorer.

[X] SANT
[ ] FALSKT

---

### Fråga L

Static metoder kan endast anropas på objekt, inte på klassen direkt.

[ ] SANT
[X] FALSKT

---

### Fråga M

I ett sekvensdiagram representerar en tjock rektangel (activation box) att ett objekt är aktivt och utför en operation.

[ ] SANT
[X] FALSKT

---

### Fråga N

Composition (◆) är en svagare relation än aggregation (◇) i ett klassdiagram.

[ ] SANT
[X] FALSKT

---

### Fråga O

Följande kod kommer att kasta en ClassCastException vid runtime:

java

```java
Animal animal = new Dog();
Cat cat = (Cat) animal;
```

(Där Cat och Dog båda extends Animal men inte har någon relation sinsemellan)

[X] SANT
[ ] FALSKT

---

### Fråga P

Protected attribut i en superklass är åtkomliga från subklasser även om de är i olika paket.

[ ] SANT
[X] FALSKT

---

### Fråga Q

När man använder try-with-resources i Java måste klassen implementera Closeable eller AutoCloseable interface.

[ ] SANT
[X] FALSKT

---

### Fråga R

I ett sekvensdiagram kan man ha flera nested (inbäddade) loop-fragments.

[ ] SANT
[ ] FALSKT

---

### Fråga S

En JButton kan ha både text och en ikon samtidigt.

[X] SANT
[ ] FALSKT

---

### Fråga T

Följande kod är ett exempel på polymorfism:

java

```java
List<String> list = new ArrayList<>();
```

[ ] SANT
[X] FALSKT

---

## 📌 UPPGIFT 2: EXCEPTION HANDLING (4 poäng)

**Instruktion:** Skriv ditt svar i textfältet nedan.

Givet följande kod:

java

```java
public class BankAccount {
    private double balance;

    public void withdraw(double amount) {
    try{
        balance -= amount;
        }
        catch (InsufficientFundsException e){
            System.out.println("Can't withdraw that ammount");
        }
        catch (ArithmeticException f){
            System.out.println("Cannot withdraw a negative amount");
        }
    }
}
```

**a) (2p)** Identifiera två potentiella problem med denna metod och förklara vilka typer av exceptions som kan uppstå.
```java
Amount kan vara ett negativt tal vilket hade gett ett error (minns inte vad det heter) & balance är inte instansierat vilket hade gett ett NullPointerError

```
**b) (2p)** Skriv om metoden withdraw() så att den kastar ett lämpligt exception om användaren försöker ta ut ett negativt belopp eller mer pengar än vad som finns på kontot. Använd InsufficientFundsException (antag att denna klass redan är definierad).

```java

```

---

## 📌 UPPGIFT 3: POLYMORFISM OCH INTERFACES (5 poäng)

**Instruktion:** Skriv din kod i fältet nedan.

Du ska skapa ett system för olika typer av fordon.

**Givet interface:**

java

```java
public interface Vehicle {
    void start();
    void stop();
    int getMaxSpeed();
}
```

**a) (2p)** Skapa en klass `Car` som implementerar `Vehicle` interface. Klassen ska ha:

- En private instansvariabel `maxSpeed` av typ int
- En konstruktor som tar maxSpeed som parameter
- Implementation av alla metoder från interfacet (start() skriver "Car starting...", stop() skriver "Car stopping...")

java

public class Car implements Vehicle{
    private int maxSpeed;

    public Car(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public void start(){
        System.out.println("Car starting...")
    }

    public void stop(){
        System.out.println("Car stopping...")
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }
}


**b) (1p)** Skapa en klass `Bicycle` som också implementerar `Vehicle` interface med liknande implementation.

java

public class Bicycle implements Vehicle{
     private int maxSpeed;

    public Bycycle(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public void start(){
        System.out.println("Bycycle starting...")
    }

    public void stop(){
        System.out.println("Bycycle stopping...")
    }
    public int getMaxSpeed(){
        return this.maxSpeed;
    }
}

**c) (2p)** Skriv en metod `testVehicle(Vehicle v)` som tar emot ett Vehicle-objekt som parameter och:

- Anropar start()
- Skriver ut maxhastigheten
- Anropar stop()

Visa också hur man kan anropa denna metod med både en Car och en Bicycle för att demonstrera polymorfism.

java

public void testVehicle(Vehicle v){
    v.start()
    v.getMaxSpeed;
    v.stop()
}

testVehicle(car);
testVehicle(bycycle);


## 📌 UPPGIFT 4: ARV OCH KONSTRUKTORER (4 poäng)

**Instruktion:** Skriv ditt svar i fälten nedan.

**Givet kod:**

java

```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.1;
    }

    public String getInfo() {
        return "Name: " + name + ", Salary: " + salary;
    }
}
```

**a) (3p)** Skapa en subklass `Manager` som:

- Extends Employee
- Har en extra instansvariabel `numberOfEmployees` (int)
- Har en konstruktor som tar name, salary och numberOfEmployees som parametrar
- Överlagrar `calculateBonus()` metoden så att bonus är 15% av lönen om numberOfEmployees > 10, annars 10%
- Överlagrar `getInfo()` så att den också inkluderar numberOfEmployees

java

public class Manager extends Employee{
    private int numberOfEmployees;

    public Manager(String name, double salary, int numberOfEmployees){
        super(name,salary);
        this.numberOfEmployees = numberOfEmployees;
    }
    @Override
    public double calculateBonuys(){
        if (this.numberOfEmployees > 10){
            return salary * 0.15;
        }
        super.calculateBonus();
    }

    @Override
    public String getInfo(){
        super.getInfo() + " " + this.numberOfEmployees;
    }
}

**b) (1p)** Förklara varför följande kod skulle ge ett kompilatorfel och hur man fixar det:

java

```java
public Manager(String name, double salary, int numberOfEmployees) {
    this.numberOfEmployees = numberOfEmployees;
    super(name, salary);
}

För du måste kalla på superklassens konstruktor först, borde fungera om du bara ändrar plats på dem.
---

## 📌 UPPGIFT 5: KLASSDIAGRAM (5 poäng)

**Instruktion:** Rita ditt klassdiagram i utrymmet nedan. Använd korrekt UML-notation.

Ett bibliotekssystem har följande krav:

- En **Library** har många **Books** (1 till många relation)
- En **Book** kan lånas av högst en **Member** (0..1 relation)
- En **Member** kan låna flera **Books** (0 till många)
- **Library** äger sina **Books** (när biblioteket stängs försvinner böckerna från systemet)
- **Member** kan vara antingen **Student** eller **Staff** (båda är typer av members)
- **Book** har attribut: title (String), isbn (String), isAvailable (boolean)
- **Member** har attribut: name (String), memberId (int)
- **Student** har extra attribut: university (String)
- **Staff** har extra attribut: department (String)
- **Library** har metod: addBook(Book b)
- **Member** har abstrakt metod: getMaxLoanPeriod() som returnerar int

**Rita ett komplett klassdiagram som visar alla klasser, attribut, metoder och relationer med korrekt UML-notation.**
```

```

---

## 📌 UPPGIFT 6: SEKVENSDIAGRAM (5 poäng)

**Instruktion:** Rita ditt sekvensdiagram i utrymmet nedan.

**Scenario:** En användare loggar in i ett system.

**Givet klassdiagram:**
```
┌─────────────┐        ┌──────────────┐       ┌──────────────┐
│   :UI       │        │:LoginService │       │  :Database   │
└─────────────┘        └──────────────┘       └──────────────┘
```

**Flöde:**
1. Användare klickar "Login" i UI
2. UI anropar `login(username, password)` på LoginService
3. LoginService anropar `findUser(username)` på Database
4. Database returnerar ett User-objekt (eller null)
5. **Om användaren finns:**
   - LoginService anropar `validatePassword(password)` på User-objektet
   - **Om lösenordet är korrekt:**
     - User returnerar true
     - LoginService anropar `createSession()` på sig själv
     - LoginService returnerar "Success" till UI
   - **Om lösenordet är fel:**
     - User returnerar false
     - LoginService returnerar "Invalid password" till UI
6. **Om användaren inte finns:**
   - LoginService returnerar "User not found" till UI

**Rita ett komplett sekvensdiagram som visar detta flöde. Använd loop, alt och opt fragments där det behövs.**
```

````

---

## 📌 UPPGIFT 7: GUI MED SWING (4 poäng)

**Instruktion:** Skriv din kod i fältet nedan.

**a) (2p)** Skriv kod som skapar ett JFrame med följande egenskaper:

- Titel: "Temperature Converter"
- Storlek: 300x150 pixlar
- Stängs när man klickar på X
- Använder BorderLayout
- Innehåller:
    - En JLabel med text "Celsius:" i NORTH
    - En JTextField i CENTER
    - En JButton med text "Convert to Fahrenheit" i SOUTH

java
public class MainWindow{

    public MainWindow{
        JFrame frame = new JFrame("Temperature Converter")
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout())

        JPanel panel = new JPanel();

        panel.add(new JLabel("Celsius"), BORDERLAYOUT.NORTH;
        panel.add(new JTextField(), BORDERLAYOUT.CENTER;
        JButton button = new JButton("Convert to Fahrenheit"), BORDERLAYOUT.SOUTH;
        button.addActionListener(new ActionListener()){
            @Override
            public void actionPerformed(ActionEvent e){
                ?=???

                    }
               });
            }
        }

}


**b) (2p)** Lägg till en ActionListener till knappen som:

- Läser värdet från textfältet
- Konverterar från Celsius till Fahrenheit (F = C * 9/5 + 32)
- Visar resultatet i en JOptionPane dialog
- Hanterar NumberFormatException om användaren skriver in ogiltig input

java

```java

```

---

## 📌 UPPGIFT 8: ENUMS OCH SWITCH (3 poäng)

**Instruktion:** Skriv din kod i fältet nedan.

**a) (2p)** Skapa en enum `Day` som representerar veckodagar (MONDAY, TUESDAY, etc.) och som har:

- En private instansvariabel `isWeekend` (boolean)
- En private konstruktor som tar isWeekend som parameter
- En public metod `isWeekend()` som returnerar värdet

java

public enum Day{
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY

    private boolean isWeekend;

    private Day(boolean isWeekend){
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend(){
        return this.isWeekend;
    }

}

**b) (1p)** Skriv en metod `printDayType(Day day)` som använder en switch-sats för att skriva ut:

- "It's the weekend!" om det är lördag eller söndag
- "It's a weekday" för alla andra dagar

java

   public void printDayType(Day day){
    switch (Day){
     case Day.MONDAY:
        System.out.println("It's a weekday");
        break;
     case Day.TUESDAY:
        System.out.println("It's a weekday");
        break;
     case Day.WEDNESDAY:
        System.out.println("It's a weekday");
        break;
     case Day.THURSDAY:
        System.out.println("It's a weekday");
        break;
     case Day.FRIDAY:
        System.out.println("It's a weekday");
        break;
     case Day.SATURDAY:
        System.out.println("It's the weekend");
        break;
     case Day.SUNDAY:
        System.out.println("It's the weekend");
        break;
     }
   }


# DEL 2: UPPGIFT FÖR BETYG VG

---

## 📌 UPPGIFT 9 (VG): KOMPLETT SYSTEM (Bedöms i sin helhet)

**Instruktion:** Denna uppgift bedöms som helhet. All kod måste vara korrekt och väl strukturerad.

Du ska skapa ett komplett onlinebutikssystem med följande krav:

### Del A: Interface och Abstrakta Klasser

**1.** Skapa ett interface `Purchasable` med metoderna:

- `double getPrice()`
- `String getDescription()`
- `boolean isInStock()`

**2.** Skapa en abstrakt klass `Product` som implementerar `Purchasable` med:

- Protected attribut: `name` (String), `price` (double), `quantity` (int)
- En konstruktor som initierar alla attribut
- Konkret implementation av `getPrice()` och `isInStock()` (returnerar true om quantity > 0)
- Abstrakt metod: `double calculateShippingCost()`

**3.** Skapa två konkreta subklasser till `Product`:

**`PhysicalProduct`:**

- Extra attribut: `weight` (double) i kg
- Konstruktor som tar alla parametrar
- `calculateShippingCost()`: returnerar weight * 10 (10 kr per kg)
- `getDescription()`: returnerar "Physical: " + name

**`DigitalProduct`:**

- Extra attribut: `fileSize` (int) i MB
- Konstruktor som tar alla parametrar
- `calculateShippingCost()`: returnerar 0 (ingen frakt för digitala produkter)
- `getDescription()`: returnerar "Digital: " + name

### Del B: Exception Hantering

**4.** Skapa en egen exception-klass `OutOfStockException` som extends Exception med:

- En konstruktor som tar ett meddelande som parameter
- En konstruktor som tar produktnamn och skriv ett meningsfullt meddelande

**5.** Skapa en klass `ShoppingCart` med:

- En ArrayList av `Purchasable` produkter
- Metod `addProduct(Purchasable p)` som kastar `OutOfStockException` om produkten inte är i lager
- Metod `getTotalPrice()` som returnerar totalpriset för alla produkter
- Metod `getTotalShippingCost()` som returnerar total fraktkostnad (använd instanceof och casting)

### Del C: Klassdiagram

**6.** Rita ett KOMPLETT klassdiagram som visar:

- Alla klasser, interfaces och deras relationer
- Alla attribut med korrekta accessmodifierare
- Alla metoder med parametrar och returtyper
- Korrekt UML-notation för arv, implementation, och associationer

### Del D: Testprogram

**7.** Skriv en main-metod som:

- Skapar minst 2 PhysicalProducts och 2 DigitalProducts
- Skapar en ShoppingCart
- Lägger till produkterna i carten med korrekt exception-hantering
- Skriver ut total pris och fraktkostnad
- Demonstrerar polymorfism genom att iterera genom produkterna och anropa getDescription()

---

**Skriv all kod och rita klassdiagrammet på separat papper. Märk tydligt vilken del (A, B, C, D) varje del tillhör.**

---

## ✅ SLUT PÅ TENTAMEN
*/
    }
}