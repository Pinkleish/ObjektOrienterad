/*# 📚 KOMPLETT TENTAMENSGUIDE - Objektorienterad Programmering

## Del 1: Grundläggande Koncept och Klasser/Objekt

---

        ## 🎯 INNEHÅLLSFÖRTECKNING (HELA GUIDEN)

1. **Java Grunderna och OOP-filosofi**
        2. **Klasser och Objekt - Kärnan i OOP**
        3. **Arv och Generalisering**
        4. **Polymorfism och Interfaces**
        5. **Undantagshantering (Exceptions)**
        6. **UML - Klassdiagram**
        7. **UML - Sekvensdiagram**
        8. **GUI med Swing och Händelsehantering**
        9. **Vanliga Tentamensfrågor och Svar**

        ---

        # 📖 KAPITEL 1: JAVA GRUNDERNA OCH OOP-FILOSOFI

## 1.1 Vad är Objektorienterad Programmering?

        ### 🔑 Nyckelkoncept

**Definition**: Objektorienterad programmering (OOP) är ett programmeringsparadigm som organiserar kod kring **objekt** istället för funktioner och logik.

**Skillnad från Python**:

        - **Python**: Kan vara både procedurell och objektorienterad
- **Java**: Är strikt objektorienterad - ALLT måste vara i klasser

### De Fyra Pelarna i OOP

1. **Inkapsling (Encapsulation)** 🔒
        - Döljer interna detaljer
    - Skyddar data med private/public
2. **Arv (Inheritance)** 👨‍👦
        - Klasser kan ärva egenskaper från andra klasser
    - Undviker kodduplicering
3. **Polymorfism** 🎭
        - "Många former"
        - Samma interface, olika implementation
4. **Abstraktion** 🎨
        - Fokusera på VAD istället för HUR
    - Gömmer komplexitet

---

        ## 1.2 Java vs Python - Snabb Jämförelse

|**Aspekt**|**Python**|**Java**|
        |---|---|---|
        |Typning|Dynamisk|Statisk, stark|
        |Variabler|`x = 5`|`int x = 5;`|
        |Klasser|Valfritt|Obligatoriskt|
        |Kompilering|Tolkas|Kompileras först|
        |Minnehantering|Automatisk|Automatisk (Garbage Collection)|
        |Syntax|Indrag|Klammerparenteser {}|

        **Viktigt**: I Java måste du ALLTID deklarera typen när du skapar en variabel!

java

```java
// Python
        name = "Anna"
age = 25

// Java
String name = "Anna";
int age = 25;
```

        ---

        # 📖 KAPITEL 2: KLASSER OCH OBJEKT

## 2.1 Vad är en Klass?

        ### 🏗️ Grundläggande Koncept

**Definition**: En klass är en **ritning** eller **mall** för att skapa objekt.

        **Analogi**:

        - **Klass** = Ritning av ett hus
- **Objekt** = Det faktiska huset byggt från ritningen

### Klassens Byggstenar

En klass består av:

        1. **Attribut (Instansvariabler)** 📊
        - Data som objektet lagrar
    - Exempel: namn, ålder, färg
2. **Metoder (Operationer)** ⚙️
        - Funktioner som objektet kan utföra
    - Exempel: äta(), sova(), arbeta()
3. **Konstruktor** 🔨
        - Special-metod som körs när objekt skapas
    - Initialiserar objektets tillstånd

---

        ## 2.2 Skapa din Första Klass

### Exempel: Person-klass

        java

```java
public class Person {
    // ATTRIBUT (instansvariabler)
    private String name;
    private int birthYear;
    private String personID;

    // KONSTRUKTOR
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.personID = generateID();
    }

    // METODER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        int currentYear = 2026;
        return currentYear - birthYear;
    }

    public String greet() {
        return "Hej, jag heter " + name;
    }

    private String generateID() {
        return "ID-" + Math.random();
    }
}
```

        ### Användning av Klassen

        java

```java
public class Main {
    public static void main(String[] args) {
        // Skapa objekt (instansiering)
        Person person1 = new Person("Anna", 1995);
        Person person2 = new Person("Erik", 2000);

        // Använda objekten
        System.out.println(person1.greet());  // "Hej, jag heter Anna"
        System.out.println(person1.getAge()); // 31

        person1.setName("Anna Andersson");
        System.out.println(person1.getName()); // "Anna Andersson"
    }
}
```

        ---

        ## 2.3 Accessmodifierare (Access Modifiers)

### 🔐 De Fyra Nivåerna

|**Modifierare**|**Åtkomst**|**Symbol**|**Användning**|
        |---|---|---|---|
        |`private`|Endast inom klassen|`-`|Attribut, hjälpmetoder|
        |`default` (ingen)|Endast inom paketet|`~`|Paketintern kod|
        |`protected`|Paket + subklasser|`#`|För arv|
        |`public`|Överallt|`+`|Publika metoder|

        ### Best Practice: Inkapsling

**Regel**: Gör alltid attribut `private` och tillhandahåll `public` getter/setter-metoder!

        **Varför?**

        1. **Kontroll**: Du styr hur data ändras
2. **Validering**: Kan kolla att data är korrekt
3. **Flexibilitet**: Kan ändra intern implementation utan att påverka kod som använder klassen

        java

```java
public class BankAccount {
    private double balance;  // PRIVATE - ingen direkt åtkomst!

    // PUBLIC getter
    public double getBalance() {
        return balance;
    }

    // PUBLIC setter med validering
    public void deposit(double amount) {
        if (amount > 0) {  // Validering!
            balance += amount;
        } else {
            System.out.println("Felaktigt belopp!");
        }
    }
}
```

        ---

        ## 2.4 Konstruktorer - Djupdykning

### 🔨 Vad är en Konstruktor?

        **Definition**: En special-metod som körs AUTOMATISKT när ett objekt skapas.

        **Regler**:

        1. Måste ha SAMMA namn som klassen
2. Har INGEN returtyp (inte ens void)
3. Kan vara `public`, `private` eller `protected`

        ### Default Konstruktor

Om du INTE skriver någon konstruktor skapar Java en åt dig:

java

```java
public class Dog {
    // Java skapar automatiskt:
    // public Dog() { }
}
```

        ### Överlagrade Konstruktorer

Du kan ha FLERA konstruktorer med olika parametrar:

java

```java
public class Student {
    private String name;
    private int studentID;
    private String program;

    // Konstruktor 1: Alla parametrar
    public Student(String name, int studentID, String program) {
        this.name = name;
        this.studentID = studentID;
        this.program = program;
    }

    // Konstruktor 2: Färre parametrar
    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
        this.program = "Okänt";  // Default värde
    }

    // Konstruktor 3: Minimalt
    public Student(String name) {
        this(name, 0);  // Anropar konstruktor 2!
    }
}
```

        ### `this` Keyword

**Användning 1**: Referera till objektets egna variabler

        java

```java
public Person(String name) {
    this.name = name;  // this.name = instansvariabeln
    // name = parametern
}
```

        **Användning 2**: Anropa en annan konstruktor

java

```java
public Student(String name) {
    this(name, 0);  // Måste vara FÖRSTA raden!
}
```

        ---

        ## 2.5 Metoder

### Metodsignatur

        java

```java
public int calculateSum(int a, int b) {
//  ^     ^       ^         ^
//  |     |       |         |
// access return method  parameters
// modifier type  name

    return a + b;  // Returvärde
}
```

        ### Olika Typer av Metoder

**1. Getter-metoder** (Accessors)

java

```java
public String getName() {
    return name;
}
```

        **2. Setter-metoder** (Mutators)

java

```java
public void setName(String name) {
    this.name = name;
}
```

        **3. Utility-metoder**

java

```java
public int getAge() {
    return 2026 - birthYear;
}
```

        **4. Void-metoder** (returnerar inget)

java

```java
public void printInfo() {
    System.out.println("Namn: " + name);
}
```

        ### Static vs Instance Metoder

**Instance-metod**: Jobbar med ett specifikt objekt

        java

```java
Person p = new Person("Anna", 1995);
p.getName();  // Anropas på objektet
```

        **Static-metod**: Tillhör klassen, inte objekten

        java

```java
Math.sqrt(16);  // Anropas på klassen
```

java

```java
public class Calculator {
    // Static - ingen instans behövs
    public static int add(int a, int b) {
        return a + b;
    }
}

// Användning
int result = Calculator.add(5, 3);  // Direkt på klassen!
```

        ---

        ## 2.6 Arrays av Objekt

### Skapa och Använda

        java

```java
// Skapa array
Person[] people = new Person[3];

// Populera array
people[0] = new Person("Anna", 1995);
people[1] = new Person("Erik", 2000);
people[2] = new Person("Sara", 1998);

// Iterera med vanlig loop
for (int i = 0; i < people.length; i++) {
        System.out.println(people[i].getName());
        }

// Enhanced for-loop (bättre!)
        for (Person p : people) {
        System.out.println(p.getName());
        }
        ```

        ### ⚠️ Null-hantering

**VIKTIGT**: När du skapar en array av objekt är den fylld med `null`!

java

```java
Person[] people = new Person[3];
// people = [null, null, null]

// Detta ger NullPointerException!
people[0].getName();  // KRASCHAR!

// Rätt sätt:
if (people[0] != null) {
        System.out.println(people[0].getName());
        }
        ```

        ---

        ## 2.7 Objekt som Parametrar

### Referens vs Värde

**I Java**:

        - **Primitiva typer** (int, double, boolean) skickas som VÄRDE
- **Objekt** skickas som REFERENS

**Detta liknar Python's listor!**

java

```java
public class Example {
    public static void changePrimitive(int x) {
        x = 100;  // Ändrar bara lokala kopian
    }

    public static void changeObject(Person p) {
        p.setName("Nytt namn");  // Ändrar det faktiska objektet!
    }

    public static void main(String[] args) {
        int number = 5;
        changePrimitive(number);
        System.out.println(number);  // 5 (oförändrat)

        Person person = new Person("Anna", 1995);
        changeObject(person);
        System.out.println(person.getName());  // "Nytt namn"
    }
}
```

        ---

        ## 2.8 toString() Metoden

### Varför Används Den?

När du printar ett objekt utan `toString()`:

java

```java
Person p = new Person("Anna", 1995);
System.out.println(p);
// Output: Person@15db9742  (minnesadress)
```

Med `toString()`:

java

```java
public class Person {
    private String name;
    private int birthYear;

    @Override
    public String toString() {
        return "Person[name=" + name + ", birthYear=" + birthYear + "]";
    }
}

Person p = new Person("Anna", 1995);
System.out.println(p);
// Output: Person[name=Anna, birthYear=1995]
```

        **Viktigt**: Alla klasser ärver från `Object` som har en `toString()`. Du överlagrar den!

        ---

        ## 2.9 Enums - Mini-objekt

### Grundläggande Enum

java

```java
public enum Breed {
    GOLDEN_RETRIEVER,
    BORDER_COLLIE,
    LABRADOR
}

// Användning
Breed myDog = Breed.GOLDEN_RETRIEVER;
```

        ### Enum med Metoder och Konstruktor

        java

```java
public enum Breed {
    GOLDEN_RETRIEVER("Golden Retriever", 30),
    BORDER_COLLIE("Border Collie", 20),
    LABRADOR("Labrador", 32);

    private final String fullName;
    private final int averageWeight;

    // Private konstruktor
    Breed(String fullName, int averageWeight) {
        this.fullName = fullName;
        this.averageWeight = averageWeight;
    }

    // Public metoder
    public String getFullName() {
        return fullName;
    }

    public int getAverageWeight() {
        return averageWeight;
    }
}

// Användning
Breed dog = Breed.GOLDEN_RETRIEVER;
System.out.println(dog.getFullName());  // "Golden Retriever"
        System.out.println(dog.getAverageWeight());  // 30
        ```

        ---

        ## ✅ SAMMANFATTNING KAPITEL 2

        **Nyckelpunkter att komma ihåg**:

        1. ✨ **Klass = Mall**, **Objekt = Instans av mallen**
        2. 🔒 **Inkapsling**: Alltid `private` attribut + `public` getters/setters
3. 🔨 **Konstruktor**: Samma namn som klassen, ingen returtyp
4. 🎯 **this**: Referera till objektets egna variabler/metoder
5. 📊 **Accessmodifierare**: private < default < protected < public
6. 🔗 **Objekt**: Skickas som REFERENS (som listor i Python)
7. 📝 **toString()**: Override för snygg utskrift

---
        # 📖 KAPITEL 3: ARV OCH GENERALISERING

## 3.1 Varför Behöver Vi Arv?

        ### 🎯 Problemet Utan Arv

Tänk dig att du ska skapa klasser för olika typer av personer:

java

```java
public class Student {
    private String name;
    private int birthYear;
    private String personID;

    // ... getters, setters, metoder
}

public class Teacher {
    private String name;        // DUPLICERAD KOD!
    private int birthYear;      // DUPLICERAD KOD!
    private String personID;    // DUPLICERAD KOD!

    // ... getters, setters, metoder
}
```

        **Problem**: Vi upprepar samma kod! Detta bryter mot **DRY-principen** (Don't Repeat Yourself).

        ### ✨ Lösningen: Arv

Vi skapar en **gemensam superklass** och låter subklasser ärva från den:

java

```java
// SUPERKLASS (basklass)
public class Person {
    private String name;
    private int birthYear;
    private String personID;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() { return name; }
    public int getBirthYear() { return birthYear; }
}

// SUBKLASS 1
public class Student extends Person {
    private String program;
    private int studentID;

    public Student(String name, int birthYear, String program) {
        super(name, birthYear);  // Anropa superklassens konstruktor
        this.program = program;
    }

    public void study() {
        System.out.println(getName() + " studerar " + program);
    }
}

// SUBKLASS 2
public class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher(String name, int birthYear, String subject) {
        super(name, birthYear);
        this.subject = subject;
    }

    public void teach() {
        System.out.println(getName() + " undervisar i " + subject);
    }
}
```

        ---

        ## 3.2 Grundläggande Arvsterminologi

### 🏗️ Viktig Terminologi

| **Term** | **Betydelse** | **Exempel** |
        |----------|--------------|-------------|
        | **Superklass** | Klassen som ärvs FRÅN | Person |
        | **Subklass** | Klassen som ärver | Student, Teacher |
        | **Generalisering** | Konceptet med super/sub-relation | Designprincip |
        | **Arv** | Implementeringen i kod | `extends` keyword |
        | **extends** | Java-nyckelord för arv | `class Student extends Person` |

        ### 📊 Visualisering av Arv
```
Person (Superklass)
           |
                   +------+------+
                   |             |
Student       Teacher
        (Subklass)   (Subklass)
        ````

        **Viktigt att förstå**:

        - Subklasser **ärver** alla publika och protected medlemmar från superklassen
- Subklasser kan **lägga till** sina egna medlemmar
- Subklasser kan **överskugga** (override) superklassens metoder
- I Java kan en klass bara ärva från **EN** superklass (men kan implementera flera interfaces)

---

        ## 3.3 Konstruktorer och Arv

### 🔨 Hur Konstruktorer Fungerar vid Arv

**VIKTIG REGEL**: När ett objekt av en subklass skapas, körs FÖRST superklassens konstruktor, SEDAN subklassens konstruktor.

java

```java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
        System.out.println("Person-konstruktor körs");
    }
}

public class Student extends Person {
    private String program;

    public Student(String name, String program) {
        super(name);  // MÅSTE vara första raden!
        this.program = program;
        System.out.println("Student-konstruktor körs");
    }
}

// Användning:
Student s = new Student("Anna", "Datateknik");
// Output:
// Person-konstruktor körs
// Student-konstruktor körs
```

        ### `super` Keyword

**Två användningsområden**:

        **1. Anropa superklassens konstruktor**

java

```java
public Student(String name, String program) {
    super(name);  // Anropa Person-konstruktorn
    this.program = program;
}
```

        **2. Anropa superklassens metoder**

java

```java
public class Student extends Person {
    @Override
    public String toString() {
        return super.toString() + ", Program: " + program;
    }
}
```

        ### ⚠️ Vanliga Fel

**FEL 1: Glömma anropa super()**

java

```java
public Student(String name, String program) {
    // super(name);  <-- GLÖMT!
    this.program = program;
}
// KOMPILATORSFEL: implicit super constructor Person() is undefined
```

        **FEL 2: super() inte på första raden**

java

```java
public Student(String name, String program) {
    this.program = program;
    super(name);  // FEL! Måste vara FÖRST
}
```

        ---

        ## 3.4 Protected Access Modifier

### 🔐 Tre Nivåer av Åtkomst vid Arv

java

```java
public class Person {
    private String ssn;        // Endast i Person
    protected String name;     // I Person OCH subklasser
    public int age;           // Överallt
}

public class Student extends Person {
    public void printInfo() {
        // System.out.println(ssn);   // FEL! private
        System.out.println(name);     // OK! protected
        System.out.println(age);      // OK! public
    }
}
```

        ### När Ska Man Använda Protected?

        **Använd `protected` när**:

        - Du vill att subklasser ska kunna komma åt variabeln direkt
- Men externa klasser INTE ska komma åt den

**Best Practice**: Använd fortfarande `private` + protected getters/setters!

java

```java
public class Person {
    private String name;  // private är bättre!

    protected String getName() {  // Subklasser kan använda denna
        return name;
    }
}
```

        ---

        ## 3.5 Method Overriding (Överskuggning)

### 🎭 Vad är Override?

        **Definition**: När en subklass skriver sin egen version av en metod som finns i superklassen.

java

```java
public class Person {
    public String greet() {
        return "Hej!";
    }
}

public class Student extends Person {
    @Override  // Annotation som hjälper kompilatorn
    public String greet() {
        return "Hej, jag är student!";
    }
}

// Användning:
Person p = new Person();
System.out.println(p.greet());  // "Hej!"

Student s = new Student("Anna", "IT");
System.out.println(s.greet());  // "Hej, jag är student!"
        ```

        ### @Override Annotation

**Varför använda @Override?**

        1. **Kompilatorkontroll**: Kompilatorn varnar om metoden inte faktiskt överlagrar något
2. **Läsbarhet**: Tydligt för andra programmerare att detta är en override
3. **Säkerhet**: Upptäcker stavfel i metodnamn

java

```java
@Override
public String greeet() {  // Stavfel!
    // KOMPILATORSFEL: Method does not override method from its superclass
}
```

        ### Regler för Override

1. **Samma signatur**: Namn, parametrar och returtyp måste matcha
2. **Lika eller mer tillgänglig**: Kan inte göra metoden mer restriktiv
3. **Inte static**: Static metoder kan inte överlagras (de döljs istället)

java

```java
// RÄTT
public class Person {
    protected String getName() { return name; }
}

public class Student extends Person {
    @Override
    public String getName() {  // protected -> public är OK!
        return "Student: " + super.getName();
    }
}

// FEL
public class Person {
    public String getName() { return name; }
}

public class Student extends Person {
    @Override
    private String getName() {  // public -> private är FEL!
        return name;
    }
}
```

        ---

        ## 3.6 Object-klassen - Alla Klassers Superklass

### 🌳 Arvshierarkin

**ALLA klasser i Java ärver (direkt eller indirekt) från `Object`**:
        ```
Object
             |
Person
             |
                     +--------+--------+
                     |                 |
Student           Teacher
````

        ### Viktiga Metoder från Object

java

```java
public class Object {
    public String toString()     // Beskriver objektet som sträng
    public boolean equals(Object obj)  // Jämför objekt
    public int hashCode()        // Hash-kod för objekt
    public Class<?> getClass()   // Returnerar objektets klass
}
```

        ### toString() - Djupdykning

**Varför finns det?** För att alla objekt ska kunna konverteras till String!

java

```java
public class Person {
    private String name;
    private int birthYear;

    // Utan override:
    // Output: Person@15db9742

    // Med override:
    @Override
    public String toString() {
        return String.format("Person[name=%s, born=%d]", name, birthYear);
    }
}

// Användning:
Person p = new Person("Anna", 1995);
System.out.println(p);  // Anropar automatiskt toString()!
String s = "Info: " + p;  // toString() anropas här också!
```

        ---

        # 📖 KAPITEL 4: POLYMORFISM

## 4.1 Vad är Polymorfism?

        ### 🎭 Definition

**Polymorfism** = "Många former" (från grekiska: poly = många, morph = form)

        **I OOP**: Möjligheten att behandla objekt av olika typer genom ett gemensamt interface.

        ### Enkel Förklaring

Tänk på polymorfism som en fjärrkontroll:

        - **Samma knappar** (interface)
        - **Olika beteenden** beroende på vilken TV/stereo/AC du kontrollerar (implementation)

---

        ## 4.2 Polymorfism med Arv

### 📊 Grundprincip

En referensvariabel av typ **superklass** kan peka på objekt av typ **subklass**!

java

```java
// Detta är helt giltigt i Java!
Person p1 = new Person("Anna", 1995);     // Person pekar på Person
Person p2 = new Student("Erik", 2000, "IT");  // Person pekar på Student
Person p3 = new Teacher("Sara", 1985, "Math"); // Person pekar på Teacher
```

        ### Varför är Detta Användbart?

        **Exempel: Array med olika objekt**

java

```java
Person[] people = new Person[3];
people[0] = new Person("Anna", 1995);
people[1] = new Student("Erik", 2000, "IT");
people[2] = new Teacher("Sara", 1985, "Math");

// Iterera genom alla
for (Person p : people) {
        System.out.println(p.getName());  // Fungerar för alla!
        System.out.println(p.greet());    // Olika beteende!
        }
        ```

        ---

        ## 4.3 Dynamisk Bindning (Dynamic Dispatch)

### 🔄 Compile-time vs Runtime

**Viktigt koncept**: Java bestämmer vilken metod som ska köras vid **runtime**, inte vid compile-time!

java

```java
public class Person {
    public String getRole() {
        return "Person";
    }
}

public class Student extends Person {
    @Override
    public String getRole() {
        return "Student";
    }
}

public class Teacher extends Person {
    @Override
    public String getRole() {
        return "Teacher";
    }
}

// Magiskt exempel:
Person p1 = new Student("Anna", 2000, "IT");
Person p2 = new Teacher("Erik", 1985, "Math");

System.out.println(p1.getRole());  // "Student" - INTE "Person"!
        System.out.println(p2.getRole());  // "Teacher" - INTE "Person"!
        ```

        **Varför?** Java kollar vilken TYP objektet faktiskt är vid runtime, inte vad variabeln är deklarerad som!

        ### Regel för Polymorfism
```
Variabelns typ bestämmer: Vilka metoder du KAN anropa
Objektets typ bestämmer: Vilken implementation som körs
````

        ---

        ## 4.4 Typkonvertering (Casting)

### ⬆️ Upcasting (Automatisk)

Att konvertera från subklass till superklass - alltid säkert och automatiskt!

java

```java
Student s = new Student("Anna", 2000, "IT");
Person p = s;  // Implicit upcast - alltid OK!
```

        ### ⬇️ Downcasting (Manuell)

Att konvertera från superklass till subklass - måste göras explicit och kan krascha!

java

```java
Person p = new Student("Anna", 2000, "IT");

// Detta fungerar eftersom p FAKTISKT är en Student
Student s = (Student) p;  // Explicit downcast
s.study();  // Nu kan vi anropa Student-metoder

// Detta kraschar!
Person p2 = new Person("Erik", 1995);
Student s2 = (Student) p2;  // ClassCastException vid runtime!
```

        ### instanceof - Säker Typkontroll

**Använd `instanceof` för att kolla typen före casting:**

java

```java
Person p = new Student("Anna", 2000, "IT");

if (p instanceof Student) {
Student s = (Student) p;
    s.study();  // Säkert!
}

        if (p instanceof Teacher) {
// Detta block körs INTE
Teacher t = (Teacher) p;
}
        ```

        ### Praktiskt Exempel

java

```java
public void processPersons(Person[] people) {
    for (Person p : people) {
        System.out.println(p.getName());  // Alla har getName()

        // Specifik hantering baserat på typ
        if (p instanceof Student) {
            Student s = (Student) p;
            System.out.println("Studerar: " + s.getProgram());
        } else if (p instanceof Teacher) {
            Teacher t = (Teacher) p;
            System.out.println("Undervisar: " + t.getSubject());
        }
    }
}
```

        ---

        ## 4.5 Begränsningar med Polymorfism

### ❌ Vad Du INTE Kan Göra

        java

```java
Person p = new Student("Anna", 2000, "IT");

// FEL! Kompilatorn ser bara Person
p.study();  // KOMPILATORSFEL: The method study() is undefined for type Person

// Kräver downcasting:
if (p instanceof Student) {
        ((Student) p).study();  // OK!
}
        ```

        **Minnesregel**: Kompilatorn kollar bara variabelns TYP, inte objektets faktiska typ!

        ---

        # 📖 KAPITEL 5: ABSTRAKTA KLASSER

## 5.1 Vad är en Abstrakt Klass?

        ### 💡 Grundkoncept

**Definition**: En klass som **inte kan instansieras** - den måste ärvas från.

        **Varför?** För att definiera en gemensam mall som subklasser MÅSTE implementera.

        ### Syntax

        java

```java
public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    // Vanlig metod med implementation
    public String getColor() {
        return color;
    }

    // Abstrakt metod - INGEN implementation!
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
```

        ### Användning

        java

```java
// Detta fungerar INTE:
Shape s = new Shape("red");  // KOMPILATORSFEL!

// Måste skapa konkreta subklasser:
public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // MÅSTE implementera alla abstrakta metoder
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

// Nu kan vi använda polymorfism!
Shape[] shapes = new Shape[2];
shapes[0] = new Circle("red", 5.0);
shapes[1] = new Rectangle("blue", 4.0, 6.0);

for (Shape s : shapes) {
        System.out.println("Area: " + s.calculateArea());
        }
        ```

        ---

        ## 5.2 Abstrakta Metoder

### 📝 Regler

1. **Ingen implementation**: Bara signaturen, inget block
2. **Måste vara i abstrakt klass**: Kan inte ha abstrakta metoder i konkret klass
3. **Subklasser måste implementera**: Annars måste även subklassen vara abstrakt

java

```java
public abstract class Animal {
    // Abstrakt metod - ingen implementation
    public abstract void makeSound();

    // Konkret metod - har implementation
    public void sleep() {
        System.out.println("Zzz...");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
    // sleep() ärvs automatiskt
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
```

        ---

        ## 5.3 När Ska Man Använda Abstrakta Klasser?

        ### ✅ Använd När

1. **Delad kod**: Flera subklasser har gemensam implementation
2. **Gemensam bas**: Du vill tvinga en gemensam struktur
3. **Polymorfism**: Du vill behandla olika objekt genom samma interface

### Exempel: Game Characters

java

```java
public abstract class GameCharacter {
    private String name;
    private int health;
    private int x, y;  // Position

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Gemensam kod för alla characters
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            die();
        }
    }

    // Varje character har olika attack
    public abstract void attack(GameCharacter target);

    // Varje character dör på olika sätt
    public abstract void die();

    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
}

public class Warrior extends GameCharacter {
    private int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " swings sword!");
        target.takeDamage(strength * 2);
    }

    @Override
    public void die() {
        System.out.println(getName() + " falls in battle!");
    }
}

public class Mage extends GameCharacter {
    private int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        if (mana >= 10) {
            System.out.println(getName() + " casts fireball!");
            target.takeDamage(30);
            mana -= 10;
        }
    }

    @Override
    public void die() {
        System.out.println(getName() + " vanishes in a puff of smoke!");
    }
}
```

        ---

        # 📖 KAPITEL 6: INTERFACES

## 6.1 Vad är ett Interface?

        ### 🎯 Definition

**Interface** = Ett "kontrakt" som anger VILKA metoder en klass måste ha, men INTE hur de implementeras.

        **Analogi**: En interface är som en jobbannons - den beskriver vad som krävs, men inte hur du ska göra det.

### Grundläggande Syntax

java

```java
public interface Flyable {
    // Alla metoder är automatiskt public abstract
    void fly();
    void land();

    // Konstanter (automatiskt public static final)
    int MAX_ALTITUDE = 10000;
}
```

        ### Implementera ett Interface

        java

```java
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flapping wings!");
    }

    @Override
    public void land() {
        System.out.println("Landing on branch");
    }
}

public class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Engines roaring!");
    }

    @Override
    public void land() {
        System.out.println("Landing on runway");
    }
}

// Polymorfism!
Flyable f1 = new Bird();
Flyable f2 = new Airplane();

f1.fly();  // "Flapping wings!"
f2.fly();  // "Engines roaring!"
```

        ---

        ## 6.2 Interface vs Abstrakt Klass

### 📊 Jämförelse

|**Aspekt**|**Interface**|**Abstrakt Klass**|
        |---|---|---|
        |**Metoder**|Endast abstrakta (mestadels)|Både abstrakta och konkreta|
        |**Attribut**|Endast konstanter|Alla typer av variabler|
        |**Konstruktor**|NEJ|JA|
        |**Multipelt arv**|En klass kan implementera FLERA|En klass kan bara ärva från EN|
        |**När använda**|Definiera förmåga/beteende|Definiera gemensam bas|

        ### Visualisering

        java

```java
// INTERFACE - "Kan göra något"
public interface Swimable {
    void swim();
}

public interface Flyable {
    void fly();
}

// Kan implementera FLERA interfaces!
public class Duck implements Flyable, Swimable {
    @Override
    public void fly() {
        System.out.println("Duck flies");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}

// ABSTRAKT KLASS - "Är något"
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();
}

// Kan bara ärva från EN klass
public class Dog extends Animal implements Swimable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void swim() {
        System.out.println("Dog swims");
    }
}
```

        ---

        ## 6.3 Arv av Implementation vs Arv av Gränssnitt

### 🔍 Viktigt Begrepp för Tentan!

        **Arv av implementation** (`extends`):

        - Ärver BÅDE kod OCH kontrakt
- Subklassen får färdig kod från superklassen
- Kan endast ärva från EN klass

**Arv av gränssnitt** (`implements`):

        - Ärver ENDAST kontrakt (metodsignaturer)
- Måste själv skriva all kod
- Kan implementera FLERA interfaces

java

```java
// ARV AV IMPLEMENTATION
public abstract class Vehicle {
    protected int speed;

    // Konkret metod - KOD ÄRV
    public void accelerate(int amount) {
        speed += amount;
    }

    // Abstrakt metod - GRÄNSSNITT ARVSÖD
    public abstract void refuel();
}

public class Car extends Vehicle {
    @Override
    public void refuel() {
        System.out.println("Filling with gasoline");
    }
    // accelerate() ärvs med implementation!
}

// ARV AV GRÄNSSNITT
public interface Driveable {
    void drive();
    void stop();
}

public class Bicycle implements Driveable {
    // MÅSTE implementera ALLT själv
    @Override
    public void drive() {
        System.out.println("Pedaling");
    }

    @Override
    public void stop() {
        System.out.println("Braking");
    }
}
```

        ---

        ## 6.4 Praktiskt Exempel: Comparable Interface

### 📏 Java's Inbyggda Interface

        **`Comparable`** används för att jämföra objekt:

java

```java
public class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        // Negativt: denna < other
        // 0: denna == other
        // Positivt: denna > other

        if (this.gpa < other.gpa) return -1;
        if (this.gpa > other.gpa) return 1;
        return 0;

        // Eller enklare:
        // return Double.compare(this.gpa, other.gpa);
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
}

// Användning:
Student[] students = new Student[3];
students[0] = new Student("Anna", 3.5);
students[1] = new Student("Erik", 4.0);
students[2] = new Student("Sara", 3.8);

Arrays.sort(students);  // Sorterar baserat på compareTo()!

for (Student s : students) {
        System.out.println(s.getName() + ": " + s.getGpa());
        }
// Output:
// Anna: 3.5
// Sara: 3.8
// Erik: 4.0
        ```

        ---

        ## 6.5 Multipla Interfaces - Kraftfull Flexibilitet

### 🚀 Kombinera Förmågor

java

```java
public interface Readable {
    String read();
}

public interface Writable {
    void write(String content);
}

public interface Closeable {
    void close();
}

// Implementera flera!
public class File implements Readable, Writable, Closeable {
    private String content = "";
    private boolean isOpen = true;

    @Override
    public String read() {
        if (!isOpen) throw new IllegalStateException("File is closed");
        return content;
    }

    @Override
    public void write(String content) {
        if (!isOpen) throw new IllegalStateException("File is closed");
        this.content += content;
    }

    @Override
    public void close() {
        isOpen = false;
        System.out.println("File closed");
    }
}

// Polymorfism med interfaces!
Readable r = new File();
String data = r.read();

Writable w = new File();
w.write("Hello");
```

        ---

        ## ✅ SAMMANFATTNING KAPITEL 3-6

        ### 🎓 Nyckelkoncept att Komma Ihåg

**ARV (extends)**:

        - ✨ En klass kan ärva från EN superklass
- 🔨 `super()` anropar superklassens konstruktor/metoder
- 🔐 `protected` ger åtkomst till subklasser
- 🎭 `@Override` för att överskugga metoder

**POLYMORFISM**:

        - 🔄 Superklass-referens kan peka på subklass-objekt
- ⚡ Dynamisk bindning - rätt metod väljs vid runtime
- ⬆️ Upcasting automatisk, downcasting kräver cast
- 🔍 `instanceof` för säker typkontroll

**ABSTRAKTA KLASSER**:

        - 🚫 Kan INTE instansieras
- 📝 Kan ha både abstrakta och konkreta metoder
- 🏗️ Definierar gemensam bas för subklasser

**INTERFACES**:

        - 📜 Kontrakt för vad en klass måste implementera
- 🔢 En klass kan implementera FLERA interfaces
- 🎯 Arv av gränssnitt, inte implementation
- ⚙️ Alla metoder public abstract, alla attribut public static final

### 🎯 Tentamenstips

1. **Förstå skillnaden** mellan abstract class och interface
2. **Kunna förklara** polymorfism med konkreta exempel
3. **Rita arvshierarkier** i klassdiagram
4. **Kunna identifiera** när något ska vara interface vs abstract class
5. **Förstå casting** och instanceof

        ---

        # 📖 KAPITEL 7: EXCEPTION HANDLING (UNDANTAGSHANTERING)

## 7.1 Varför Behöver Vi Exceptions?

        ### 🚨 Problemet Utan Exception Handling

Tänk dig detta scenario:

java

```java
public class Calculator {
    public int divide(int a, int b) {
        return a / b;  // Vad händer om b = 0?
    }
}

// Användning:
Calculator calc = new Calculator();
int result = calc.divide(10, 0);  // KRASCH! ArithmeticException
// Programmet avslutas abrupt
```

        **Problem**:

        1. ❌ Programmet kraschar helt
2. ❌ Användaren får inget användbart felmeddelande
3. ❌ Ingen möjlighet att återhämta sig från felet

### ✨ Lösningen: Exception Handling

**Exception** = Ett objekt som representerar ett fel eller ovanligt tillstånd

**Fördelar**:

        - ✅ Programmet kan fortsätta köra
- ✅ Tydliga felmeddelanden
- ✅ Separation av felhantering från vanlig kod
- ✅ Möjlighet att återhämta sig

---

        ## 7.2 Grundläggande Try-Catch Syntax

### 🎯 Basstruktur

        java

```java
try {
        // Kod som KAN kasta ett exception
        // "bevakad" kod
        } catch (ExceptionType e) {
        // Kod som HANTERAR exceptionet
        // Körs ENDAST om exception kastas
        } finally {
        // Kod som ALLTID körs
        // Körs oavsett om exception kastas eller inte
        }
        ```

        ### Enkelt Exempel

java

```java
public class DivisionExample {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // Kastar ArithmeticException
            System.out.println("Resultat: " + result);  // Körs INTE
        } catch (ArithmeticException e) {
            System.out.println("Fel: Division med noll!");
            System.out.println("Meddelande: " + e.getMessage());
        } finally {
            System.out.println("Programmet fortsätter...");
        }

        System.out.println("Efter try-catch");
    }
}

// Output:
// Fel: Division med noll!
// Meddelande: / by zero
// Programmet fortsätter...
// Efter try-catch
```

        ---

        ## 7.3 Exception-Hierarkin

### 🌳 Java's Exception-träd
        ```
Object
                      |
Throwable
                      |
                              +-------------+-------------+
                              |                           |
Error                      Exception
        |                           |
OutOfMemoryError      +-----------+-----------+
StackOverflowError    |                       |
        (Ska ej fångas)   RuntimeException    Checked Exceptions
                        |                       |
                                +---------+---------+    IOException
              |                   |    SQLException
ArithmeticException  NullPointerException  FileNotFoundException
ArrayIndexOutOfBounds ClassCastException   ...
NumberFormatException
````

        ### Viktiga Termer

**Throwable**: Basklassen för allt som kan kastas

- **Error**: Allvarliga fel som program inte ska fånga
- **Exception**: Fel som program KAN och BÖR hantera

---

        ## 7.4 Checked vs Unchecked Exceptions

### 🔍 Två Typer av Exceptions

|**Aspekt**|**Checked Exception**|**Unchecked Exception**|
        |---|---|---|
        |**Superklass**|`Exception` (men INTE `RuntimeException`)|`RuntimeException`|
        |**Kompilering**|MÅSTE hanteras|Behöver ej hanteras|
        |**Exempel**|IOException, SQLException|NullPointerException, ArithmeticException|
        |**Orsak**|Externa problem|Programmeringsfel|
        |**När**|Filhantering, nätverk, databaser|Logikfel, null-referenser|

        ### Checked Exception - MÅSTE Hanteras

java

```java
public void readFile(String filename) {
    // Detta ger KOMPILATORSFEL!
    FileReader reader = new FileReader(filename);  // IOException

    // MÅSTE antingen:
    // 1. Fånga med try-catch, ELLER
    // 2. Deklarera med throws
}

// Lösning 1: Fånga med try-catch
public void readFile(String filename) {
    try {
        FileReader reader = new FileReader(filename);
        // ... läs filen
    } catch (IOException e) {
        System.out.println("Kunde inte läsa fil: " + e.getMessage());
    }
}

// Lösning 2: Deklarera med throws
public void readFile(String filename) throws IOException {
    FileReader reader = new FileReader(filename);
    // Anropande metod måste hantera
}
```

        ### Unchecked Exception - Frivillig Hantering

java

```java
public void processArray(int[] numbers, int index) {
    // Ingen kompilatorskontroll
    int value = numbers[index];  // Kan kasta ArrayIndexOutOfBoundsException

    // MEN du KAN fånga om du vill:
    try {
        int value = numbers[index];
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Ogiltigt index!");
    }
}
```

        ---

        ## 7.5 Flera Catch-Block

### 📦 Hantera Olika Exception-Typer

        java

```java
public void processFile(String filename) {
    try {
        FileReader reader = new FileReader(filename);
        int data = reader.read();
        int result = 10 / data;  // Kan vara 0!

    } catch (FileNotFoundException e) {
        System.out.println("Filen hittades inte: " + e.getMessage());

    } catch (IOException e) {
        System.out.println("Fel vid läsning: " + e.getMessage());

    } catch (ArithmeticException e) {
        System.out.println("Division med noll!");
    }
}
```

        ### ⚠️ VIKTIG REGEL: Ordning Spelar Roll!

        **Alltid fånga mer SPECIFIKA exceptions FÖRE mer GENERELLA!**

java

```java
// ❌ FEL - kompilerar inte!
try {
        // ...kod
        } catch (Exception e) {          // Fångar ALLT
        // ...
        } catch (IOException e) {         // Kommer ALDRIG köras!
        // KOMPILATORSFEL: "Unreachable catch block"
        }

// ✅ RÄTT
        try {
        // ...kod
        } catch (IOException e) {         // Specifik först
        // ...
        } catch (Exception e) {          // Generell sist
        // ...
        }
        ```

        ### Multi-catch (Java 7+)

Fånga flera exceptions i samma block:

java

```java
try {
        // ...kod
        } catch (IOException | SQLException e) {
        System.out.println("Fil- eller databasfel: " + e.getMessage());
        }
        ```

        ---

        ## 7.6 Finally-Block - Alltid Körs

### 🔒 Garanterad Exekvering

**Finally-blocket körs ALLTID**, oavsett:

        - Om exception kastas eller inte
- Om catch fångar exceptionet eller inte
- Om try-blocket har return statement

        java

```java
public String readFile(String filename) {
    FileReader reader = null;
    try {
        reader = new FileReader(filename);
        // ...läs data
        return "Success";

    } catch (IOException e) {
        System.out.println("Fel: " + e.getMessage());
        return "Error";

    } finally {
        // Körs ALLTID, även om return kallas!
        if (reader != null) {
            try {
                reader.close();  // Stäng resursen!
            } catch (IOException e) {
                System.out.println("Kunde inte stänga fil");
            }
        }
        System.out.println("Finally körs alltid!");
    }
}
```

        ### När Körs Finally?

java

```java
// Scenario 1: Inget exception
try {
        System.out.println("1");
} finally {
        System.out.println("2");
}
        System.out.println("3");
// Output: 1, 2, 3

// Scenario 2: Exception fångat
try {
        System.out.println("1");
    throw new Exception();
} catch (Exception e) {
        System.out.println("2");
} finally {
        System.out.println("3");
}
        System.out.println("4");
// Output: 1, 2, 3, 4

// Scenario 3: Exception inte fångat
try {
        System.out.println("1");
    throw new RuntimeException();
} finally {
        System.out.println("2");  // Körs INNAN programmet kraschar
}
        System.out.println("3");  // Körs INTE
// Output: 1, 2, sedan krasch
```

        ### ⚡ Vanlig Användning: Stäng Resurser

java

```java
public void processData(String filename) {
    Scanner scanner = null;
    try {
        scanner = new Scanner(new File(filename));
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    } catch (FileNotFoundException e) {
        System.out.println("Fil hittades inte");
    } finally {
        if (scanner != null) {
            scanner.close();  // Viktigt att stänga!
        }
    }
}
```

        ---

        ## 7.7 Throws - Skicka Vidare Exception

### 📤 Två Sätt att Hantera Checked Exceptions

**Alternativ 1**: Hantera lokalt med try-catch **Alternativ 2**: Deklarera att metoden kan kasta exception med `throws`

        ### Throws Keyword

java

```java
public class FileProcessor {

    // Metod 1: Lokalt try-catch
    public void readFile1(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            // ...
        } catch (IOException e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }

    // Metod 2: Throws - skicka vidare
    public void readFile2(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        // Anropande metod måste hantera!
    }

    // Användning av readFile2
    public void processFiles() {
        try {
            readFile2("data.txt");  // Måste ha try-catch här
        } catch (IOException e) {
            System.out.println("Kunde inte läsa fil");
        }
    }
}
```

        ### Flera Exceptions i Throws

java

```java
public void complexOperation(String filename)
        throws IOException, SQLException, ParseException {
    // Kan kasta alla tre
    FileReader reader = new FileReader(filename);      // IOException
    Connection conn = DriverManager.getConnection(...); // SQLException
    Date date = DateFormat.parse("...");               // ParseException
}
```

        ### Call Stack och Exception Propagering

        java

```java
public class ExceptionFlow {

    public void method1() {
        try {
            method2();
        } catch (IOException e) {
            System.out.println("Fångad i method1");
        }
    }

    public void method2() throws IOException {
        method3();  // Skickar vidare
    }

    public void method3() throws IOException {
        throw new IOException("Fel i method3");
    }
}

// Flöde:
// method3 -> kastar IOException
// method2 -> skickar vidare (throws)
// method1 -> fångar i catch
```

        ---

        ## 7.8 Kasta Exceptions (Throw)

### 🎯 Throw vs Throws

|**Keyword**|**Användning**|**Exempel**|
        |---|---|---|
        |`throw`|Kasta ett exception-objekt|`throw new Exception();`|
        |`throws`|Deklarera att metod kan kasta|`void method() throws Exception`|

        ### Kasta Exceptions

java

```java
public class BankAccount {
    private double balance;

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Belopp måste vara positivt");
        }

        if (amount > balance) {
            throw new IllegalStateException("Otillräckligt saldo");
        }

        balance -= amount;
    }
}

// Användning:
BankAccount account = new BankAccount();
try {
        account.withdraw(-100);  // Kastar IllegalArgumentException
} catch (IllegalArgumentException e) {
        System.out.println("Fel: " + e.getMessage());
        }
        ```

        ### Re-throw: Kasta Vidare Efter Fångst

java

```java
public void processData() throws IOException {
    try {
        // ...läs fil
        FileReader reader = new FileReader("data.txt");
    } catch (IOException e) {
        System.out.println("Loggar fel: " + e.getMessage());
        throw e;  // Kastar vidare till anropande metod!
    }
}
```

        ---

        ## 7.9 Egna Exception-Klasser

### 🎨 Skapa Dina Egna Exceptions

**När?** När Javas inbyggda exceptions inte passar ditt specifika fel.

        java

```java
// Egen exception-klass
public class InsufficientFundsException extends Exception {
    private double amount;
    private double balance;

    public InsufficientFundsException(double amount, double balance) {
        super(String.format("Försök att ta ut %.2f men har bara %.2f",
                amount, balance));
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() { return amount; }
    public double getBalance() { return balance; }
}

// Användning:
public class BankAccount {
    private double balance;

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
    }
}

// I Main:
BankAccount account = new BankAccount();
try {
        account.withdraw(1000);
} catch (InsufficientFundsException e) {
        System.out.println("Fel: " + e.getMessage());
        System.out.println("Du försökte ta ut: " + e.getAmount());
        System.out.println("Ditt saldo är: " + e.getBalance());
        }
        ```

        ### Checked vs Unchecked - Ditt Val

java

```java
// Checked Exception - måste hanteras
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}

// Unchecked Exception - behöver ej hanteras
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}
```

        ---

        ## 7.10 Try-with-Resources (Modern Java)

### 🆕 Automatisk Resurshantering

**Problem**: Glömmer ofta stänga resurser i finally

        **Lösning**: Try-with-resources (Java 7+)

java

```java
// Gammalt sätt - MYCKET kod
public void oldWay(String filename) {
    Scanner scanner = null;
    try {
        scanner = new Scanner(new File(filename));
        // ...använd scanner
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
}

// Nytt sätt - ENKELT
public void newWay(String filename) {
    try (Scanner scanner = new Scanner(new File(filename))) {
        // ...använd scanner
        // scanner.close() anropas AUTOMATISKT!
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
```

        ### Flera Resurser

java

```java
public void copyFile(String source, String dest) {
    try (
            Scanner input = new Scanner(new File(source));
            PrintWriter output = new PrintWriter(new File(dest))
    ) {
        while (input.hasNext()) {
            output.println(input.nextLine());
        }
        // Båda stängs automatiskt!
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

        ---

        ## 7.11 Vanliga Exception-Typer

### 📋 Måste-Kunna för Tentan

        java

```java
// 1. NullPointerException
String text = null;
System.out.println(text.length());  // KRASCH!

// 2. ArrayIndexOutOfBoundsException
int[] numbers = {1, 2, 3};
System.out.println(numbers[5]);  // KRASCH!

// 3. NumberFormatException
String text = "abc";
int number = Integer.parseInt(text);  // KRASCH!

// 4. ArithmeticException
int result = 10 / 0;  // KRASCH!

// 5. ClassCastException
Object obj = "Hello";
Integer num = (Integer) obj;  // KRASCH!

// 6. IllegalArgumentException
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Ålder kan inte vara negativ");
    }
}

// 7. IllegalStateException
public void start() {
    if (isRunning) {
        throw new IllegalStateException("Redan startad");
    }
}

// 8. IOException (checked!)
FileReader reader = new FileReader("file.txt");  // Måste hantera

// 9. FileNotFoundException (checked!)
Scanner scanner = new Scanner(new File("missing.txt"));  // Måste hantera
```

        ---

        ## ✅ SAMMANFATTNING EXCEPTION HANDLING

### 🎓 Nyckelkoncept

**Grundläggande**:
        - 🎯 Exception = objekt som representerar fel
- 📦 Try-catch-finally för att hantera
- 🔄 Finally körs ALLTID

**Två Typer**:
        - ✅ **Checked**: MÅSTE hanteras (IOException, SQLException)
- ❌ **Unchecked**: Frivilligt (RuntimeException och subklasser)

**Hantering**:
        - 🔧 Try-catch: Hantera lokalt
- 📤 Throws: Skicka vidare
- 🎯 Throw: Kasta exception
- 🎨 Egna exceptions: Extend Exception eller RuntimeException

**Best Practices**:
        - ⚡ Fånga specifika exceptions först
- 🔒 Använd finally för att stänga resurser
- 🆕 Eller använd try-with-resources
- 📝 Ge användbara felmeddelanden

---

        # 📖 KAPITEL 8: UML KLASSDIAGRAM

## 8.1 Vad är UML?

        ### 🎨 Unified Modeling Language

**Definition**: Ett standardiserat sätt att rita diagram för att beskriva mjukvarudesign.

        **Varför UML?**
        1. 📊 **Visualisering**: Lättare att förstå struktur
2. 🗣️ **Kommunikation**: Gemensamt språk för utvecklare
3. 📝 **Dokumentation**: Bevarar designbeslut
4. 🏗️ **Design**: Planera innan kodning

---

        ## 8.2 Klassdiagram - Grundläggande Notation

### 📦 Hur Ritar Man en Klass?
        ```
        ┌─────────────────────────┐
        │      KlassNamn          │  <- Klassnamn (centrerat)
├─────────────────────────┤
        │ -attribut1 : typ        │  <- Attribut (med typ)
│ -attribut2 : typ        │
        │ #attribut3 : typ        │
        ├─────────────────────────┤
        │ +metod1() : returtyp    │  <- Metoder (med returtyp)
│ +metod2(param : typ)    │
        │ -metod3() : void        │
        └─────────────────────────┘
        ```

        ### Symbol för Access Modifiers

| **Symbol** | **Modifierare** | **Betydelse** |
        |-----------|----------------|---------------|
        | `+` | public | Åtkomst överallt |
        | `-` | private | Endast inom klassen |
        | `#` | protected | Klassen + subklasser |
        | `~` | default/package | Endast inom paketet |

        ### Komplett Exempel
```
        ┌─────────────────────────────────┐
        │           Student               │
        ├─────────────────────────────────┤
        │ -name : String                  │
        │ -studentID : int                │
        │ -grades : int[]                 │
        │ -courses : String[]             │
        ├─────────────────────────────────┤
        │ +Student(name:String, id:int)   │
        │ +getName() : String             │
        │ +getStudentID() : int           │
        │ +attendClass(course:String)     │
        │ +displayGrades()                │
        │ +takeTest(course:String) : int  │
        └─────────────────────────────────┘
        ````

        **Motsvarande Java-kod**:

java

```java
public class Student {
    private String name;
    private int studentID;
    private int[] grades;
    private String[] courses;

    public Student(String name, int id) { }
    public String getName() { }
    public int getStudentID() { }
    public void attendClass(String course) { }
    public void displayGrades() { }
    public int takeTest(String course) { }
}
```

        ---

        ## 8.3 Relationer i Klassdiagram

### 🔗 Fem Typer av Relationer

| **Relation** | **Symbol** | **Betydelse** | **Exempel** |
        |-------------|-----------|--------------|-------------|
        | **Association** | `────>` | "använder" | Student använder Course |
        | **Aggregation** | `◇────>` | "har" (svag) | Department har Teachers |
        | **Composition** | `◆────>` | "äger" (stark) | House äger Rooms |
        | **Generalization** | `────▷` | "är en" (arv) | Dog är Animal |
        | **Realization** | `⋯⋯▷` | implements | Circle implements Shape |

        ---

        ## 8.4 Association - Vanlig Koppling

### 📎 Grundläggande Association

**Definition**: En klass använder eller känner till en annan klass.
```
        ┌──────────┐              ┌──────────┐
        │ Student  │ 1        0..* │ Course   │
        │──────────│ ───────────> │──────────│
        │          │  tar         │          │
        └──────────┘              └──────────┘
        ````

        **Betydelse**:

        - En Student tar 0 eller flera Courses
- Pilen visar navigeringsriktning

**Java-kod**:

java

```java
public class Student {
    private List<Course> courses;  // Association!

    public void enrollCourse(Course course) {
        courses.add(course);
    }
}

public class Course {
    private String name;
    private String code;
}
```

        ### Multiplicitet (Kardinalitet)
```
Notation    Betydelse
───────────────────────────────
        1           Exakt en
0..1        Noll eller en
*           Noll eller flera
0..*        Noll eller flera
1..*        En eller flera
2..4        Mellan 2 och 4
        5           Exakt 5
        ```

        ### Exempel med Multiplicitet
```
        ┌──────────┐ 1        1..* ┌──────────┐
        │ Teacher  │ ────────────> │ Student  │
        └──────────┘  undervisar   └──────────┘

En lärare undervisar minst en student
```

        ### Bidirektionell Association
```
        ┌──────────┐              ┌──────────┐
        │ Person   │ 1        1   │ Passport │
        │──────────│ <──────────> │──────────│
        │          │  äger        │          │
        └──────────┘              └──────────┘
        ````

        **Java-kod**:

java

```java
public class Person {
    private Passport passport;  // Person känner till Passport
}

public class Passport {
    private Person owner;  // Passport känner till Person
}
```

        ---

        ## 8.5 Aggregation - "Har" Relation

### ◇ Vit Diamant

**Definition**: Svag "ägarrelation" där delarna kan existera utan helheten.

        **Symbol**: Tom (vit) diamant `◇` vid den ägande klassen
```
        ┌────────────┐             ┌──────────┐
        │ Department │ ◇────────> │ Teacher  │
        └────────────┘  1    0..*  └──────────┘
har/innehåller
````

        **Karaktäristik**:

        - 🔓 Svag ägarrelation
- 🆓 Delarna kan existera oberoende
- ♻️ Delarna kan delas mellan helheter

**Exempel**:

        - En avdelning har lärare
- Men lärare kan byta avdelning
- Lärare finns kvar även om avdelningen läggs ner

**Java-kod**:

java

```java
public class Department {
    private List<Teacher> teachers;  // Aggregation

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        // Teacher existerar fortfarande någon annanstans!
    }
}

public class Teacher {
    private String name;
    // Kan existera utan Department
}
```

        ---

        ## 8.6 Composition - "Äger" Relation

### ◆ Svart Diamant

**Definition**: Stark ägarrelation där delarna DÖR när helheten dör.

        **Symbol**: Fylld (svart) diamant `◆` vid den ägande klassen
```
        ┌──────┐             ┌──────┐
        │ House│ ◆────────> │ Room │
        └──────┘  1    1..* └──────┘
innehåller
````

        **Karaktäristik**:

        - 🔒 Stark ägarrelation
- 💀 Del kan INTE existera utan helhet
- 🚫 Del kan INTE delas mellan helheter

**Exempel**:

        - Ett hus äger sina rum
- Om huset rivs, försvinner rummen
- Ett rum kan inte tillhöra två hus samtidigt

**Java-kod**:

java

```java
public class House {
    private List<Room> rooms;  // Composition!

    public House() {
        // Rooms skapas MED House
        rooms = new ArrayList<>();
        rooms.add(new Room("Kitchen"));
        rooms.add(new Room("Bedroom"));
    }

    // När House förstörs, förstörs även alla Rooms
}

public class Room {
    private String name;

    // Room har ingen mening utan House
}
```

        ---

        ## 8.7 Aggregation vs Composition - Skillnaden

### 🔍 Hur Vet Man Vilken?

        **Ställ frågan**: "Kan delen existera OBEROENDE av helheten?"

        | **Aspekt** | **Aggregation ◇** | **Composition ◆** |
        |-----------|-------------------|-------------------|
        | **Styrka** | Svag | Stark |
        | **Livstid** | Oberoende | Beroende |
        | **Exempel** | Department - Teacher | House - Room |
        | **Minnesregel** | "har" | "äger" |
        | **Delning** | Kan delas | Kan EJ delas |

        ### Praktiska Exempel
```
AGGREGATION (◇):
        ────────────────
University ◇───> Student    (Student kan byta universitet)
Team ◇───> Player           (Spelare kan byta lag)
Library ◇───> Book          (Böcker kan flyttas)
Playlist ◇───> Song         (Låtar kan vara i flera listor)

COMPOSITION (◆):
        ────────────────
Car ◆───> Engine            (Motor dör med bilen)
Human ◆───> Heart           (Hjärta dör med människan)
Tree ◆───> Leaf             (Löv dör med trädet)
Window ◆───> Scroll         (Scrollbar dör med fönstret)
```

        ---

        ## 8.8 Generalisering (Arv)

### ▷ Tom Pil

**Definition**: "Är en" relation - arv mellan klasser.

**Symbol**: Tom pil `────▷` pekar MOT superklassen
```
        ┌──────────┐
        │  Person  │
        └──────────┘
        △
        │
        ┌───────┴───────┐
        │               │
        ┌────────┐      ┌────────┐
        │ Student│      │Teacher │
        └────────┘      └────────┘
        ````

        **Notera**: Allt i Person finns även i Student och Teacher!

        **Java-kod**:

java

```java
public class Person {
    protected String name;
    protected int birthYear;

    public String getName() { return name; }
}

public class Student extends Person {
    private String program;
    // Ärver name, birthYear, getName()
}

public class Teacher extends Person {
    private String subject;
    // Ärver name, birthYear, getName()
}
```

        ---

        ## 8.9 Realization (Interface Implementation)

### ⋯▷ Streckad Pil

**Definition**: En klass implementerar ett interface.

        **Symbol**: Streckad pil `⋯⋯▷` pekar MOT interface
```
        ┌─────────────────┐
        │ <<interface>>   │
        │    Flyable      │
        ├─────────────────┤
        │ +fly()          │
        │ +land()         │
        └─────────────────┘
        △
        ⋮
        ┌──────┴──────┐
        ⋮             ⋮
        ┌────────┐    ┌─────────┐
        │  Bird  │    │Airplane │
        └────────┘    └─────────┘
        ````

        **Java-kod**:

java

```java
public interface Flyable {
    void fly();
    void land();
}

public class Bird implements Flyable {
    @Override
    public void fly() { }

    @Override
    public void land() { }
}

public class Airplane implements Flyable {
    @Override
    public void fly() { }

    @Override
    public void land() { }
}
```

        ---

        ## 8.10 Abstrakt Klass i UML

### Kursiv Text

**Notation**: Klassnamn och abstrakta metoder skrivs i *kursiv*
        ```
        ┌──────────────────────────┐
        │       *Shape*            │  <- Kursiv = abstrakt
├──────────────────────────┤
        │ #color : String          │
        ├──────────────────────────┤
        │ +getColor() : String     │
        │ *+calculateArea() : double*  <- Kursiv = abstrakt metod
└──────────────────────────┘
        ```

        **Alternativ notation**:
        ```
        ┌──────────────────────────┐
        │    <<abstract>>          │
        │       Shape              │
        ├──────────────────────────┤
        │ #color : String          │
        ├──────────────────────────┤
        │ +getColor() : String     │
        │ +calculateArea() : double│ {abstract}
        └──────────────────────────┘
        ```

        ---

        ## 8.11 Use-Relation (Beroende)

### ⋯> Streckad Pil

**Definition**: Svagaste relationen - en klass använder tillfälligt en annan.

        **Symbol**: Streckad pil `⋯⋯>` utan diamant
```
        ┌────────────┐         ┌──────────┐
        │  Calculator│ ⋯⋯⋯⋯> │  Logger  │
        └────────────┘ uses    └──────────┘
        ````

        **När används den?**

        - Metod tar emot objekt som parameter
- Metod skapar tillfälligt objekt
- Metod returnerar objekt av typen

**Java-exempel**:

java

```java
public class Calculator {
    // Use-relation: Logger används tillfälligt
    public int add(int a, int b, Logger logger) {
        int result = a + b;
        logger.log("Added " + a + " and " + b);
        return result;
    }
}
```

        ### Use vs Association

|**Aspekt**|**Use (⋯>)**|**Association (──>)**|
        |---|---|---|
        |**Styrka**|Svagast|Starkare|
        |**Livstid**|Tillfällig|Permanent|
        |**Exempel**|Metodparameter|Instansvariabel|

java

```java
// ASSOCIATION - Permanent relation
public class Student {
    private Course course;  // Association!
}

// USE - Tillfällig relation
public class Student {
    public void printCourse(Course course) {  // Use!
        System.out.println(course.getName());
    }
}
```

        ---

        ## 8.12 Statiska Medlemmar i UML

### Understruken Text

**Notation**: Statiska attribut och metoder UNDERSTRYKS
```
        ┌─────────────────────────┐
        │       Math              │
        ├─────────────────────────┤
        │ PI : double             │  <- Understruken = static
│ E : double              │
        ├─────────────────────────┤
        │ sqrt(x:double):double   │  <- Understruken = static
│ pow(x:double,y:double)  │
        └─────────────────────────┘
        ````

        **Java-kod**:

java

```java
public class Math {
    public static final double PI = 3.14159;
    public static final double E = 2.71828;

    public static double sqrt(double x) { }
    public static double pow(double x, double y) { }
}
```

        ---

        ## 8.13 Komplett Exempel - Universitet System

### 📚 Fullständigt Klassdiagram
```
        ┌────────────────┐
        │  <<abstract>>  │
        │     Person     │
        ├────────────────┤
        │ #name : String │
        │ #id : String   │
        ├────────────────┤
        │ +getName()     │
        │ *+getRole()*   │
        └────────────────┘
        △
        │
        ┌───────────┴───────────┐
        │                       │
        ┌───────────────┐       ┌───────────────┐
        │   Student     │       │   Teacher     │
        ├───────────────┤       ├───────────────┤
        │-program:String│       │-subject:String│
        ├───────────────┤       ├───────────────┤
        │+study()       │       │+teach()       │
        │+getRole()     │       │+getRole()     │
        └───────────────┘       └───────────────┘
        │ 0..*                  │ 1..*
        │                       │
        │    ┌───────────┐      │
        └───>│  Course   │<─────┘
tar    ├───────────┤ undervisar
             │-name      │
        │-code      │
        ├───────────┤
        │+getName() │
        └───────────┘
        ◆
        │ 1
        │
        │ 1..*
        ┌───────────┐
        │  Lecture  │
        ├───────────┤
        │-date      │
        │-room      │
        └───────────┘
        ````

        **Relationer**:

        - Student och Teacher **ärver** från Person (generalisering ▷)
- Student **tar** Courses (association →)
- Teacher **undervisar** Courses (association →)
- Course **äger** Lectures (composition ◆)

---

        ## ✅ SAMMANFATTNING UML KLASSDIAGRAM

### 🎓 Checklista för Tentan

**Grundläggande Notation**:

        - ✅ Tre sektioner: Klassnamn, Attribut, Metoder
- ✅ Access modifiers: `+` public, `-` private, `#` protected
- ✅ Attribut format: `name : type`
        - ✅ Metod format: `methodName(param : type) : returnType`

        **Relationer** (viktigast!):

        - 🔗 **Association** `──>`: använder
- ◇ **Aggregation** `◇──>`: har (svag)
- ◆ **Composition** `◆──>`: äger (stark)
- ▷ **Generalization** `──▷`: ärver (tom pil)
- ⋯▷ **Realization** `⋯▷`: implements (streckad pil)
        - ⋯> **Use** `⋯>`: tillfällig användning

**Speciella Notationer**:

        - _Kursiv_ = Abstrakt klass/metod
- Understruken = Static
- `<<interface>>` = Interface
- `<<abstract>>` = Abstrakt klass

---
        # 📖 KAPITEL 9: UML SEKVENSDIAGRAM

## 9.1 Vad är ett Sekvensdiagram?

        ### 🎬 Definition

**Sekvensdiagram** = Visar HUR objekt interagerar med varandra ÖVER TID

**Skillnad från klassdiagram**:

        - **Klassdiagram**: Statisk struktur (VILKA klasser finns)
- **Sekvensdiagram**: Dynamiskt beteende (HUR de samarbetar)

**Varför viktigt?**

        - 📅 Visar ordningsföljd av metodanrop
- 🔄 Visar objekt-interaktioner
- 📝 Dokumenterar flöden
- 🐛 Hjälper med felsökning

---

        ## 9.2 Grundläggande Komponenter

### 🧩 Byggstenar i Sekvensdiagram

**1. Aktör (Actor)**

        ```
        👤
        │
        │
        ```

        - Representerar användare eller externt system
- Initierar ofta sekvensen

**2. Objekt/Instans**

        ```
        ┌─────────────────┐
        │ objektNamn:Klass│
        └─────────────────┘
        │
        │ (livslinje)
        │
        ▼
        ```

        **3. Livslinje (Lifeline)**

        ```
        │
        │ Streckad vertikal linje
    │ visar objektets existens
    │
            ▼
            ```

            **4. Aktivering (Activation)**

        ```
        │
        ▐ Smal rektangel
    ▐ visar när objekt
    ▐ är aktivt
    │
            ```

            **5. Meddelande (Message)**

        ```
        ────────────────────────> Synkront (väntar på svar)
- - - - - - - - - - - - > Asynkront (väntar ej)
<- - - - - - - - - - - - Returmeddelande
```

        ---

        ## 9.3 Komplett Exempel - Steg för Steg

### 📚 Scenario: Student Registrerar Kurs

**Deltagare**:

        - Student (aktör)
- RegistrationSystem (objekt)
- Course (objekt)
- Database (objekt)

**Sekvensdiagram**:

        ```
Student  :RegistrationSystem  :Course  :Database
  │              │                │         │
          │──register()─>│                │         │
        │              ▐                │         │
        │              ▐──getCourse()──>│         │
        │              ▐<───course──────│         │
        │              ▐                │         │
        │              ▐──checkAvail()─>│         │
        │              ▐<────true───────│         │
        │              ▐                │         │
        │              ▐──save()────────┼────────>│
        │              ▐<───success─────┼─────────│
        │              ▐                │         │
        │<──confirmed──▐                │         │
        │              │                │         │
        ```

        **Steg-för-steg förklaring**:

        1. **Student kallar register()** på RegistrationSystem
2. **RegistrationSystem aktiveras** (visas som tjock rektangel)
        3. **RegistrationSystem kallar getCourse()** på Course
4. **Course returnerar** courseobjektet
5. **RegistrationSystem kallar checkAvail()** för att kolla tillgänglighet
6. **Course returnerar** true (platser finns)
        7. **RegistrationSystem kallar save()** på Database
8. **Database returnerar** success
9. **RegistrationSystem returnerar** confirmed till Student

---

        ## 9.4 Typer av Meddelanden

### 📨 Olika Pilar och Deras Betydelse

|**Typ**|**Symbol**|**Betydelse**|**Användning**|
        |---|---|---|---|
        |**Synkront**|`────>`|Väntar på svar|Vanligaste typen|
        |**Asynkront**|`⋯⋯>`|Väntar ej på svar|Trådar, events|
        |**Retur**|`<⋯⋯`|Returvärde|Explicit svar|
        |**Skapa**|`────>`|Skapa objekt|Constructor call|
        |**Förstör**|`X`|Förstör objekt|Sällsynt i Java|

        ### Exempel med Olika Meddelandetyper

```
Client    :Service    :Logger
  │           │           │
          │──getData()>│           │ <- Synkront (väntar)
  │           ▐           │
          │           ▐⋯⋯log()⋯>  │ <- Asynkront (väntar ej)
  │           ▐           │
          │           ▐──query()─>│
        │           ▐<─result──┤ │
        │<⋯result⋯⋯▐           │ <- Explicit retur
  │           │           │
          ```

          **Java-kod som motsvarar detta**:

java

```java
public class Client {
    public void process() {
        Service service = new Service();
        String result = service.getData();  // Synkront anrop
    }
}

public class Service {
    private Logger logger = new Logger();
    private Database db = new Database();

    public String getData() {
        logger.log("Getting data");  // Asynkront (i egen tråd)
        String result = db.query();   // Synkront
        return result;                // Explicit retur
    }
}
```

        ---

        ## 9.5 Fragments - Kontrollstrukturer

### 🎛️ Loop, Alt, Opt - Villkor i Sekvensdiagram

**Fragment** = Rektangel som visar villkorlig logik

### 1. Loop - Iteration
```
        ┌─────────────────────────────────────┐
        │ loop [för varje student]            │
        │ ┌─────────────────────────────────┐ │
        │ │  Student    :System             │ │
        │ │     │          │                 │ │
        │ │     │──check()->                 │ │
        │ │     │<──ok────┤                 │ │
        │ └─────────────────────────────────┘ │
        └─────────────────────────────────────┘
        ````

        **Motsvarar Java**:

java

```java
for (Student student : students) {
        student.check();
}
        ```

        ### 2. Alt - Alternativ (if-else)
```
        ┌─────────────────────────────────────────────┐
        │ alt [saldo >= belopp]                       │
        │ ┌─────────────────────────────────────────┐ │
        │ │  withdraw()                              │ │
        │ │  return success                          │ │
        │ ├─────────────────────────────────────────┤ │
        │ │ [else]                                   │ │
        │ │  return error                            │ │
        │ └─────────────────────────────────────────┘ │
        └─────────────────────────────────────────────┘
        ````

        **Motsvarar Java**:

java

```java
if (balance >= amount) {
withdraw(amount);
    return "success";
            } else {
            return "error";
            }
            ```

            ### 3. Opt - Optional (if utan else)
```
        ┌─────────────────────────────────────┐
        │ opt [if logged in]                  │
        │ ┌─────────────────────────────────┐ │
        │ │  showDashboard()                │ │
        │ └─────────────────────────────────┘ │
        └─────────────────────────────────────┘
        ````

        **Motsvarar Java**:

java

```java
if (isLoggedIn) {
showDashboard();
}
        ```

        ---

        ## 9.6 Skapa och Förstöra Objekt

### 🔨 Constructor och Destructor

**Skapa objekt**:
        ```
Client    :NewObject
  │
          │──new──────>┌──────┐
          │            │:Object│
        │            └──────┘
        │               │
        ```

        **Förstöra objekt** (sällsynt i Java pga garbage collection):
        ```
        │
        │──delete()─>│
        │            X  <- Kryss markerar destruktion
```

        **Exempel med Object Creation**:
        ```
Manager   :Employee   :Salary
   │
           │──hire()──>┌──────┐
        │           │:Employee│
        │           └──────┘
        │              │
        │              │──new───>┌──────┐
        │              │          │:Salary│
        │              │          └──────┘
        │              │             │
        ````

        **Java-kod**:

java

```java
public class Manager {
    public void hire(String name) {
        Employee emp = new Employee(name);  // Skapar Employee
        // Employee skapar Salary i sin konstruktor
    }
}

public class Employee {
    private Salary salary;

    public Employee(String name) {
        this.salary = new Salary();  // Skapar Salary
    }
}
```

        ---

        ## 9.7 Self-Calls - Objekt Kallar Sig Själv

### 🔄 Rekursiva eller Interna Anrop
```
        :Object
   │
           ▐
           ▐───────┐
           ▐       │ internalMethod()
   ▐<──────┘
        ▐
        │
        ````

        **Exempel**:

java

```java
public class Calculator {
    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);  // Self-call!
    }
}
```

        **Sekvensdiagram**:
        ```
Client   :Calculator
   │          │
           │──fac(3)─>▐
        │          ▐───────┐
        │          ▐       │ fac(2)
   │          ▐<──────┘
        │          ▐───────┐
        │          ▐       │ fac(1)
   │          ▐<──────┘
        │<───6─────▐
        │          │
        ```

        ---

        ## 9.8 Praktiskt Exempel från Tentan

### 📝 Tentamensfråga: Hotellsystem

**Uppgift**: Rita sekvensdiagram för "Tilldela ny bonusnivå till kunder"

        **Klassdiagram givet**:
        ```
        ┌────────┐ *      1..* ┌─────────────┐ *     1 ┌──────┐
        │ Hotell │◇────────────│    Kund     │◆────────│ Rum  │
        ├────────┤             ├─────────────┤         ├──────┤
        │+tilldela│             │-bonusnivå   │         │-kvm  │
        │Bonus() │             │+getNights() │         │      │
        └────────┘             │+getRoomSize()│         └──────┘
        └─────────────┘
        │
        │ 1
        │
        │ 1..*
        ┌─────────────┐
        │Övernattning │
        ├─────────────┤
        │-dagar       │
        │+getDays()   │
        └─────────────┘
        ```

        **Krav**:
        - Kunder som övernattat minst 10 gånger med minst 3 dagar per gång ELLER
- Kunder som övernattat minst 4 gånger i rum på minst 20 kvm
→ Ska få bonusnivå 3

        **Lösning - Sekvensdiagram**:
        ```
Anställd  :Hotell      :Kund       :Övernattning  :Rum
   │          │            │               │         │
           │─tilldela─>│            │               │         │
        │          ▐            │               │         │
        │          ▐┌──────────────────────────┐│         │
        │          ▐│loop [för varje kund]     ││         │
        │          ▐│                           ││         │
        │          ▐│──getÖvernattningar()────>││         │
        │          ▐│<──lista──────────────────┘│         │
        │          ▐│                            │         │
        │          ▐│┌─────────────────────────────────┐  │
        │          ▐││loop [för varje övernattning]    │  │
        │          ▐││                                  │  │
        │          ▐││──getDays()──────────────────────>  │
        │          ▐││<──dagar─────────────────────────┘  │
        │          ▐││──getRum()───────────────────────>  │
        │          ▐││<──rum───────────────────────────┘  │
        │          ▐││                            │        │
        │          ▐││──getKvm()──────────────────┼───────>│
        │          ▐││<──kvm──────────────────────┼────────│
        │          ▐│└─────────────────────────────────┘  │
        │          ▐│                            │         │
        │          ▐│┌────────────────────────────────┐   │
        │          ▐││opt [uppfyller kriterier]       │   │
        │          ▐││                                 │   │
        │          ▐││──setBonusnivå(3)───────────────>   │
        │          ▐│└────────────────────────────────┘   │
        │          ▐└──────────────────────────┘│         │
        │          └──────────────────────────┘ │         │
        │<──klar────│                            │         │
        │           │                            │         │
        ```

        **Förklaring**:
        1. Anställd anropar `tildelaBonus()` på Hotell
2. **Loop 1**: För varje kund i hotellet
   - Hämta kundens övernattningar
3. **Loop 2**: För varje övernattning
   - Hämta antal dagar
   - Hämta rummet
   - Hämta rummets storlek (kvm)
4. **Opt**: Om villkoren är uppfyllda
   - Sätt bonusnivå till 3

        ---

        ## 9.9 Tips för att Rita Sekvensdiagram

### ✅ Checklista

**Börja med**:
        1. 📝 Identifiera aktörer och objekt
2. 🎯 Bestäm startpunkt (vem initierar?)
3. 📊 Lista alla steg i ordning
4. 🔄 Identifiera loopar och villkor

**Kom ihåg**:
        - ⏰ **Tid flödar NEDÅT** (topp till botten)
        - ➡️ **Pilar från vänster till höger** vanligast
- 📏 **Aktiveringsboxar** visar när objekt är aktivt
- 🔁 **Returpilar** ofta valfria (kan utelämnas)

**Vanliga Fel att Undvika**:
        - ❌ Glömma aktiveringsboxar
- ❌ Pilar som korsar varandra (otydligt)
- ❌ Glömma villkor i loops
- ❌ För många objekt (max 5-6 för tydlighet)

---

        ## ✅ SAMMANFATTNING SEKVENSDIAGRAM

### 🎓 Nyckelkoncept

**Komponenter**:
        - 👤 **Aktör**: Initierar ofta sekvensen
- 📦 **Objekt**: `:KlassNamn` med livslinje
- 📏 **Aktivering**: Tjock rektangel = aktivt objekt
- ➡️ **Meddelande**: Pilar mellan objekt

**Fragments**:
        - 🔁 **loop**: Iteration (for/while)
- ⚡ **alt**: If-else alternativ
- ❓ **opt**: Villkorlig exekvering (if utan else)

**Ordning**:
        1. Tid flödar NEDÅT
2. Pilar visar metodanrop
3. Streckade pilar = retur
4. Kryss (X) = destruktion

---

        # 📖 KAPITEL 10: GRAFISKA ANVÄNDARGRÄNSSNITT (GUI) MED SWING

## 10.1 Vad är GUI och Swing?

        ### 🖼️ Grundläggande Koncept

**GUI** = Graphical User Interface = Grafiskt användargränssnitt
- Windows, knappar, textfält
- Användaren interagerar med musen och tangentbordet

**Swing** = Javas bibliotek för att skapa GUI
- Paket: `javax.swing.*`
        - Alla Swing-komponenter börjar med `J`: JFrame, JButton, JLabel, etc.

**AWT** = Abstract Window Toolkit
- Äldre bibliotek (`java.awt.*`)
- Swing är byggt OVANPÅ AWT
- Vi använder båda!

        ---

        ## 10.2 Swing Klasshierarki

### 🌳 Viktiga Klasser
```
Object
  └─ Component (java.awt)
       └─ Container
            ├─ Window
            │    └─ Frame
            │         └─ JFrame (javax.swing)
            │
            └─ JComponent (javax.swing)
            ├─ JButton
            ├─ JLabel
            ├─ JTextField
            ├─ JTextArea
            ├─ JPanel
            └─ ...
                    ````

                         **Minnesregel**:

        - **JFrame**: Huvudfönster
- **JPanel**: Container för komponenter
- **JButton, JLabel, JTextField**: Komponenter

---

        ## 10.3 Skapa Ditt Första Fönster

### 🪟 Grundläggande JFrame

java

```java
import javax.swing.*;

public class FirstWindow {
    public static void main(String[] args) {
        // Skapa fönster
        JFrame frame = new JFrame("Mitt första fönster");

        // Sätt storlek (bredd, höjd)
        frame.setSize(400, 300);

        // Vad händer när man stänger fönstret?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gör fönstret synligt
        frame.setVisible(true);
    }
}
```

        **Viktiga metoder**:

        |**Metod**|**Beskrivning**|
        |---|---|
        |`setSize(w, h)`|Sätt storlek i pixlar|
        |`setTitle(s)`|Sätt fönstertext|
        |`setDefaultCloseOperation()`|Vad händer vid stängning|
        |`setVisible(true)`|Visa fönstret|
        |`setLocation(x, y)`|Placera fönstret på skärmen|
        |`setResizable(false)`|Tillåt/förbjud storleksändring|

        **EXIT_ON_CLOSE alternativ**:

java

```java
JFrame.EXIT_ON_CLOSE    // Avsluta programmet
JFrame.HIDE_ON_CLOSE    // Göm fönstret
JFrame.DISPOSE_ON_CLOSE // Stäng och frigör resurser
JFrame.DO_NOTHING_ON_CLOSE // Inget händer
```

        ---

        ## 10.4 Lägga Till Komponenter

### 🧩 JButton, JLabel, JTextField

        java

```java
import javax.swing.*;

public class ComponentExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Komponenter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Skapa panel (container)
        JPanel panel = new JPanel();

        // Skapa komponenter
        JLabel label = new JLabel("Skriv ditt namn:");
        JTextField textField = new JTextField(20); // 20 kolumner bred
        JButton button = new JButton("Klicka här");

        // Lägg till komponenter på panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Lägg till panel på frame
        frame.add(panel);

        frame.setVisible(true);
    }
}
```

        **Vanliga Komponenter**:

        |**Komponent**|**Beskrivning**|**Användning**|
        |---|---|---|
        |**JLabel**|Text som inte kan ändras|Etiketter, rubriker|
        |**JButton**|Klickbar knapp|Åtgärder|
        |**JTextField**|Enrads textinmatning|Namn, email, etc.|
        |**JTextArea**|Flerrads text|Meddelanden, kommentarer|
        |**JCheckBox**|Kryssruta|Ja/nej val|
        |**JRadioButton**|Radioknapp|Ett val av flera|
        |**JComboBox**|Dropdown-lista|Välja från lista|

        ---

        ## 10.5 Layout Managers - Placera Komponenter

### 📐 Tre Viktiga Layouts

Java använder **Layout Managers** för att placera komponenter automatiskt.

### 1. FlowLayout (Default för JPanel)

**Beteende**: Placerar komponenter från vänster till höger, topp till botten

java

```java
import javax.swing.*;
        import java.awt.FlowLayout;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sätt FlowLayout
        frame.setLayout(new FlowLayout());

        // Lägg till komponenter
        frame.add(new JButton("Knapp 1"));
        frame.add(new JButton("Knapp 2"));
        frame.add(new JButton("Knapp 3"));
        frame.add(new JButton("Knapp 4"));

        frame.setVisible(true);
    }
}
```

        **Resultat**: `[Knapp 1] [Knapp 2] [Knapp 3] [Knapp 4]` i rad

**Justering**:

java

```java
new FlowLayout(FlowLayout.LEFT)    // Vänsterjusterat
new FlowLayout(FlowLayout.CENTER)  // Centrerat (default)
new FlowLayout(FlowLayout.RIGHT)   // Högerjusterat
```

        ### 2. BorderLayout (Default för JFrame)

**Beteende**: Delar upp i 5 områden: NORTH, SOUTH, EAST, WEST, CENTER

        java

```java
import javax.swing.*;
        import java.awt.BorderLayout;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout är default för JFrame
        frame.setLayout(new BorderLayout());

        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("West"), BorderLayout.WEST);
        frame.add(new JButton("Center"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
```

        **Visualisering**:
        ```
        ┌─────────────────────┐
        │       NORTH         │
        ├────┬──────────┬─────┤
        │    │          │     │
        │WEST│  CENTER  │EAST │
        │    │          │     │
        ├────┴──────────┴─────┤
        │       SOUTH         │
        └─────────────────────┘
        ````

        ### 3. GridLayout

**Beteende**: Delar upp i rutnät med rader och kolumner

java

```java
import javax.swing.*;
        import java.awt.GridLayout;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3 rader, 3 kolumner
        frame.setLayout(new GridLayout(3, 3));

        // Lägg till 9 knappar
        for (int i = 1; i <= 9; i++) {
            frame.add(new JButton("" + i));
        }

        frame.setVisible(true);
    }
}
```

        **Resultat**:
        ```
        ┌───┬───┬───┐
        │ 1 │ 2 │ 3 │
        ├───┼───┼───┤
        │ 4 │ 5 │ 6 │
        ├───┼───┼───┤
        │ 7 │ 8 │ 9 │
        └───┴───┴───┘
        ````

        ---

        ## 10.6 Event Handling - Händelsehantering

### 🎯 Händelsestyrd Programmering

**Koncept**: Program reagerar på händelser (events)

- Musklick
- Tangenttryckningar
- Fönster som stängs
- Etc.

**Tre steg**:

        1. **Event Source**: Komponent som genererar händelsen (t.ex. JButton)
2. **Event**: Objektet som beskriver händelsen (t.ex. ActionEvent)
3. **Event Listener**: Objekt som hanterar händelsen

---

        ## 10.7 ActionListener - Hantera Knappklick

### 🖱️ Grundläggande Exempel

java

```java
import javax.swing.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Klicka mig!");

        // Lägg till ActionListener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Knappen klickades!");
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }
}
```

        ### Bättre: Separat Listener-klass

        java

```java
import javax.swing.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BetterButtonExample extends JFrame {
    private JButton button;
    private JLabel label;
    private int counter = 0;

    public BetterButtonExample() {
        setTitle("Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Klick: 0");
        button = new JButton("Klicka här");

        // Använd separat listener-klass
        button.addActionListener(new ButtonClickListener());

        add(label);
        add(button);

        setVisible(true);
    }

    // Inner class för listener
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            label.setText("Klick: " + counter);
        }
    }

    public static void main(String[] args) {
        new BetterButtonExample();
    }
}
```

        **Varför inner class?**

        - ✅ Har tillgång till ytterklasstens variabler (counter, label)
- ✅ Bättre organisation
- ✅ Inkapsling

---

        ## 10.8 Komplett GUI-Exempel: Mini Kalkylator

### 🧮 Praktiskt Exempel

java

```java
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    public Calculator() {
        setTitle("Mini Kalkylator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Skapa komponenter
        createComponents();

        // Lägg till listeners
        addListeners();

        setVisible(true);
    }

    private void createComponents() {
        // Panel för input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Tal 1:"));
        num1Field = new JTextField(10);
        inputPanel.add(num1Field);

        inputPanel.add(new JLabel("Tal 2:"));
        num2Field = new JTextField(10);
        inputPanel.add(num2Field);

        inputPanel.add(new JLabel("Resultat:"));
        resultLabel = new JLabel("0");
        inputPanel.add(resultLabel);

        // Panel för knappar
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 5, 5));

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Lägg till panels
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addListeners() {
        addButton.addActionListener(new OperationListener('+'));
        subtractButton.addActionListener(new OperationListener('-'));
        multiplyButton.addActionListener(new OperationListener('*'));
        divideButton.addActionListener(new OperationListener('/'));
    }

    // Inner class för operation listeners
    private class OperationListener implements ActionListener {
        private char operation;

        public OperationListener(char operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = 0;

                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            resultLabel.setText("Division med noll!");
                            return;
                        }
                        break;
                }

                resultLabel.setText(String.format("%.2f", result));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Ogiltiga tal!");
            }
        }
    }

    public static void main(String[] args) {
        // Kör GUI i Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
```

        **Förklaring**:

        1. **BorderLayout**: Huvudlayout - input i CENTER, knappar i SOUTH
2. **GridLayout**: För input (3 rader, 2 kolumner) och knappar (1 rad, 4 kolumner)
        3. **Inner class**: `OperationListener` hanterar alla räkneoperationer
4. **Exception handling**: Try-catch för NumberFormatException

---

        ## 10.9 Vanliga GUI-Komponenter

### 📋 JTextArea - Flerrads Text

java

```java
JTextArea textArea = new JTextArea(10, 30); // 10 rader, 30 kolumner
textArea.setLineWrap(true);         // Radbrytning
textArea.setWrapStyleWord(true);    // Bryt vid ord

// Scrollbar för stora texter
JScrollPane scrollPane = new JScrollPane(textArea);
frame.add(scrollPane);
```

        ### ☑️ JCheckBox - Kryssrutor

        java

```java
JCheckBox checkbox1 = new JCheckBox("Java");
JCheckBox checkbox2 = new JCheckBox("Python");
JCheckBox checkbox3 = new JCheckBox("C++");

checkbox1.addActionListener(e -> {
        if (checkbox1.isSelected()) {
        System.out.println("Java vald!");
    }
            });
            ```

            ### 🔘 JRadioButton - Radioknoppar

        java

```java
JRadioButton radio1 = new JRadioButton("Man");
JRadioButton radio2 = new JRadioButton("Kvinna");
JRadioButton radio3 = new JRadioButton("Annat");

// ButtonGroup - endast ett val åt gången
ButtonGroup group = new ButtonGroup();
group.add(radio1);
group.add(radio2);
group.add(radio3);
```

        ### 📜 JComboBox - Dropdown

        java

```java
String[] options = {"Välj stad", "Stockholm", "Göteborg", "Malmö"};
JComboBox<String> comboBox = new JComboBox<>(options);

comboBox.addActionListener(e -> {
String selected = (String) comboBox.getSelectedItem();
    System.out.println("Vald: " + selected);
});
        ```

        ---

        ## 10.10 JOptionPane - Dialog-rutor

### 💬 Enkla Meddelanden

java

```java
// Information
JOptionPane.showMessageDialog(null, "Välkommen till programmet!");

// Varning
JOptionPane.showMessageDialog(null,
                                      "Filen kunde inte sparas!",
                                      "Varning",
                              JOptionPane.WARNING_MESSAGE);

// Fel
JOptionPane.showMessageDialog(null,
                                      "Ett allvarligt fel inträffade!",
                                      "Fel",
                              JOptionPane.ERROR_MESSAGE);
```

        ### ❓ Input från Användare

        java

```java
// Text input
String name = JOptionPane.showInputDialog("Vad heter du?");

// Ja/Nej-fråga
int choice = JOptionPane.showConfirmDialog(null,
        "Vill du fortsätta?",
        "Bekräfta",
        JOptionPane.YES_NO_OPTION);

if (choice == JOptionPane.YES_OPTION) {
        System.out.println("Användaren valde Ja");
}
        ```

        ---

        ## 10.11 Event Dispatch Thread - EDT

### ⚠️ Viktigt för Trådsäkerhet

**Problem**: Swing är INTE trådsäkert!

        **Lösning**: Kör all GUI-kod i Event Dispatch Thread

        java

```java
public static void main(String[] args) {
    // RÄTT sätt - kör i EDT
    SwingUtilities.invokeLater(() -> {
        new MyFrame();
    });

    // Alternativt:
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new MyFrame();
        }
    });
}
```

        **Varför?**

        - ✅ Förhindrar race conditions
- ✅ Garanterar korrekt uppdatering
- ✅ Följer Swing's threading model

        ---

        ## ✅ SAMMANFATTNING GUI MED SWING

### 🎓 Nyckelkoncept

**Grundläggande Struktur**:

        - 🪟 **JFrame**: Huvudfönster
- 📦 **JPanel**: Container för komponenter
- 🧩 **Komponenter**: JButton, JLabel, JTextField, etc.

**Layout Managers**:

        - 🌊 **FlowLayout**: Vänster till höger
- 🧭 **BorderLayout**: 5 områden (N, S, E, W, CENTER)
- 📐 **GridLayout**: Rutnät

**Event Handling**:

        - 🎯 **ActionListener**: För knappar och actions
- 🎬 **actionPerformed()**: Metod som körs vid event
- 🏠 **Inner class**: Bra för listeners (tillgång till outer class)

**Best Practices**:

        - ✅ Använd `SwingUtilities.invokeLater()`
        - ✅ Separera GUI-skapande från logik
- ✅ Använd inner classes för listeners
- ✅ Hantera exceptions i event handlers

---

        # 📖 KAPITEL 11: TENTAMENSFÖRBEREDELSE

## 11.1 Vanliga Tentamensfrågor

### 📝 Sant/Falskt Frågor (från tentamen)

Låt oss gå igenom ALLA frågor från exempeltentamen:

        **A. En klass kan endast ärva från en klass och kan endast implementera ett interface.**

        - ❌ **FALSKT**
        - En klass kan bara ärva från EN klass
- Men kan implementera FLERA interfaces
- Exempel: `class Dog extends Animal implements Flyable, Swimable`

        **B. Metodanropet `method2(method1())` där method1 returnerar int[] och method2 tar int[] som parameter**

        - ✅ **SANT**
        - method1() körs först och returnerar en array
- Resultatet skickas direkt till method2()

**C. Ett interface kan endast ha publika instansvariabler samt konstanter.**

        - ❌ **FALSKT**
        - Interface kan INTE ha instansvariabler
- Kan bara ha konstanter (public static final)

**D. En abstrakt metod måste implementeras av alla subklasser.**

        - ✅ **SANT** (med reservation)
        - Alla KONKRETA subklasser måste implementera
- Abstrakta subklasser behöver inte

**E. Om en klass är abstrakt kan man inte skapa objekt av klassen.**

        - ✅ **SANT**
        - `new AbstractClass()` fungerar INTE
- Måste först ärva och göra konkret

**F. Ett interface innehåller vanligtvis inte implementationen av metoder.**

        - ✅ **SANT**
        - Interfaces har bara signaturer (före Java 8)
- Java 8+ kan ha default methods, men "vanligtvis inte"

        **G. toString() finns tillgänglig genom arv från Object.**

        - ✅ **SANT**
        - Alla klasser ärver från Object
- Object har toString()

**H. I arv: Subklassens konstruktor körs FÖRST, sedan superklassens.**

        - ❌ **FALSKT**
        - Superklassens konstruktor körs FÖRST
- Sedan subklassens konstruktor

**I. Kan man skriva: `Account account = new SavingsAccount(); account.addStuff();` där addStuff() bara finns i SavingsAccount?**

        - ❌ **FALSKT**
        - Kompilatorn ser bara Account-typen
- Account har inte addStuff()
- Måste casta: `((SavingsAccount)account).addStuff()`

        **J. Alla metoder i interface är implicit public och abstract.**

        - ✅ **SANT**
        - Även om du inte skriver det
- Kompilatorn lägger till automatiskt

**K. Vid exception-hantering: Ett catch-block och ett finally-block, men flera try-block.**

        - ❌ **FALSKT**
        - Ett try-block
- Flera catch-block (om man vill)
- Ett finally-block

**L. Överlagring (overloading) är samma som överskuggning (overriding).**

        - ❌ **FALSKT**
        - **Overloading**: Flera metoder med SAMMA namn men olika parametrar (INGEN arv)
- **Overriding**: Subklass skriver om superklassens metod (KRÄVER arv)

**M. Default accessmodifier är protected.**

        - ❌ **FALSKT**
        - Default = package-private (ingen modifierare)
        - Protected är en ANNAN modifierare

**N. Ett sekvensdiagram är ett statiskt diagram.**

        - ❌ **FALSKT**
        - Sekvensdiagram är DYNAMISKT (visar beteende över tid)
- Klassdiagram är STATISKT

**O. Use-association är svagare än vanlig association.**

        - ✅ **SANT**
        - Use (⋯>) = tillfällig användning
- Association (──>) = permanent relation

**P. I Model-View-Controller ska Model kommunicera direkt med View.**

        - ❌ **FALSKT**
        - Model kommunicerar med Controller
- Controller kommunicerar med View
- Model och View ska INTE prata direkt

**Q. En boundary-klass kan kommunicera med annat digitalt system.**

        - ✅ **SANT**
        - Boundary = gränssnitt mot externa system
- Kan vara UI, API, databas, etc.

**R. En klass kan vara både superklass och subklass.**

        - ✅ **SANT**
        - Exempel: Object > Person > Student
- Person är både super (till Student) och sub (till Object)

**S. Array som parameter beter sig som primitiva typer.**

        - ❌ **FALSKT**
        - Arrays är objekt
- Skickas som REFERENS (inte kopia)
- Ändringar påverkar originalet

**T. Vid generalisering fyller multiplicitet inget syfte.**

        - ✅ **SANT**
        - Generalisering (arv) har ingen multiplicitet
- Multiplicitet används vid associationer

---

        ## 11.2 Kodskrivningsövningar

### 🔧 Från Tentamen: Klassimplementation

**Uppgift 7**: Skapa University-klass som ärver från abstrakt Building-klass

**Givet**:

java

```java
public abstract class Building {
    private String name;
    private int id;
    private String address;
    private Owner owner;

    public Building(String name, int id, String address,
                    String ownerName, String ownerPhoneNumber) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.owner = new Owner(ownerName, ownerPhoneNumber);
    }

    @Override
    public String toString() {
        String textOut = String.format("Building name: %s | ID: %s | " +
                "Address: %s | Owner: %s", name, id, address, owner.toString());
        return textOut;
    }
}

public class Owner {
    private String name;
    private String phoneNumber;

    public Owner(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name + ", phone: " + phoneNumber;
    }
}
```

        **Lösning**:

java

```java
public class University extends Building {
    private int nbrRooms;
    private int nbrTeachers;

    // Konstruktor
    public University(String name, int id, String address,
                      String ownerName, String ownerPhone,
                      int nbrRooms, int nbrTeachers) {
        // Anropa superklassens konstruktor
        super(name, id, address, ownerName, ownerPhone);

        // Initiera egna variabler
        this.nbrRooms = nbrRooms;
        this.nbrTeachers = nbrTeachers;
    }

    // toString - använd super.toString() + egna delar
    @Override
    public String toString() {
        return super.toString() +
                " | Rooms: " + nbrRooms +
                " | Teachers: " + nbrTeachers;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        University university = new University("HQ", 1, "Main Street",
                "Boss", "123", 80, 40);
        System.out.println(university);
        // Output: Building name: HQ | ID: 1 | Address: Main Street |
        //         Owner: Boss, phone: 123 | Rooms: 80 | Teachers: 40
    }
}
```

        **Viktiga poänger**:

        1. ✅ `super()` MÅSTE vara först i konstruktorn
2. ✅ Använd `super.toString()` för att få superklassens del
3. ✅ Alla instansvariabler private

---

        ### 🔍 Från Tentamen: Läsa Sekvensdiagram

**Uppgift 4**: Skriv kod från sekvensdiagram

Se bilden i tentamen (sida 6). Översatt till kod:

java

```java
public class Djur {
    public String getNamn() {
        // returnera djurets namn
        return namn;
    }
}

public class Journal {
    private List<Anteckning> anteckningar;

    public String hamtaAnteckningar(String pnr) {
        StringBuilder result = new StringBuilder();

        // Iterera genom alla anteckningar
        for (Anteckning anteckning : anteckningar) {
            // Kolla om personnummer matchar
            boolean match = anteckning.skrivenAv(pnr);

            if (match) {
                // Om match, hämta info
                int id = anteckning.getId();
                String datum = anteckning.getDatum();
                String text = anteckning.getText();

                // Bygg resultat-sträng
                result.append("ID: ").append(id)
                        .append(", Datum: ").append(datum)
                        .append(", Text: ").append(text)
                        .append("\n");
            }
        }

        return result.toString();
    }
}
```

        ---

        ## 11.3 Designfrågor - Klassdiagram

### 🎨 Tips för att Rita Klassdiagram

**Scenario**: Ett system registrerar resultat för studenter på kurser

**Steg 1**: Identifiera substantiv (blir klasser)
- Student
- Kurs
- Provkod
- Resultat
- Personal (Kurslärare, Administratör, Examinator)

**Steg 2**: Identifiera relationer
- Student **tar** Kurser (association, 1 till *)
- Kurs **har** Provkoder (composition, 1 till 1..*)
- Student **har** Resultat för Provkoder (association)
- Personal **registrerar** Resultat
- Examinator **attesterar** Resultat

**Steg 3**: Rita diagrammet
```
        ┌──────────┐ 1     1..* ┌──────────┐
        │ Student  │◇──────────>│  Kurs    │
        └──────────┘  tar       └──────────┘
        │                        ◆
        │ *                      │ 1
        │                        │
        │ 1                      │ 1..*
        ▼                        ▼
        ┌──────────┐            ┌──────────┐
        │ Resultat │            │ Provkod  │
        └──────────┘            └──────────┘
        △
        │ registreras/
        │ attesteras av
     │
             ┌────┴─────────┬──────────┐
             │              │          │
             ┌────────┐ ┌──────────┐ ┌──────────┐
             │Kurslärare│ │Administr.│ │Examinator│
        └────────┘ └──────────┘ └──────────┘
        ````

        ---

        ## 11.4 Snabb Repetition - Alla Viktiga Koncept

### 📚 Blixtsammanfattning

**KLASSER & OBJEKT**:

        - Klass = Mall, Objekt = Instans
- Inkapsling: private attribut + public metoder
- Konstruktor: Samma namn som klass, ingen returtyp
- this = referens till nuvarande objekt

**ARV**:

        - extends = ärva från en klass
- super() = anropa superklassens konstruktor (måste vara först)
- @Override = överskugga metod
- protected = tillgänglig i subklasser

**POLYMORFISM**:

        - Superklass-referens kan peka på subklass-objekt
- Dynamisk bindning = rätt metod väljs vid runtime
- instanceof = kolla objektets typ
- Casting: upcast (automatisk), downcast (manuell)

        **ABSTRAKTA KLASSER**:

        - Kan INTE instansieras
- Kan ha både abstrakta och konkreta metoder
- abstract keyword för klass och metoder
- Subklasser MÅSTE implementera abstrakta metoder

**INTERFACES**:

        - Endast abstrakta metoder (vanligtvis)
- Endast konstanter (public static final)
- implements keyword
- En klass kan implementera FLERA interfaces

**EXCEPTIONS**:

        - try-catch-finally för hantering
- Checked: MÅSTE hanteras (IOException)
- Unchecked: Frivilligt (RuntimeException)
- throws = deklarera att metod kan kasta
- throw = faktiskt kasta exception

**UML KLASSDIAGRAM**:

        - +/- /#/~ = public/private/protected/default
- Association (──>): använder
- Aggregation (◇──>): har (svag)
- Composition (◆──>): äger (stark)
- Generalization (──▷): ärver
- Realization (⋯▷): implements

        **SEKVENSDIAGRAM**:

        - Visar interaktion över tid
- Livslinje = streckad linje nedåt
- Aktivering = tjock rektangel
- loop/alt/opt = fragments för kontroll
- Pilar = metodanrop

**GUI MED SWING**:

        - JFrame = huvudfönster
- JPanel = container
- JButton, JLabel, JTextField = komponenter
- ActionListener = hantera events
- FlowLayout, BorderLayout, GridLayout = layoutmanagers

---

        ## 11.5 Sista Tips Inför Tentan

### ✅ Checklista Dagen Före

**Teoretiska Koncept**:

        - [ ]  Kan förklara inkapsling, arv, polymorfism, abstraktion
- [ ]  Vet skillnaden mellan abstrakt klass och interface
- [ ]  Förstår checked vs unchecked exceptions
- [ ]  Kan rita och läsa klassdiagram
- [ ]  Kan rita och läsa sekvensdiagram

**Praktisk Kodning**:

        - [ ]  Kan skriva klass med konstruktor
- [ ]  Kan implementera arv med super()
        - [ ]  Kan implementera interface
- [ ]  Kan hantera exceptions med try-catch
        - [ ]  Kan skapa enkel GUI med JFrame och JButton

**UML**:

        - [ ]  Vet alla symboler i klassdiagram
- [ ]  Kan skilja på aggregation och composition
- [ ]  Kan rita sekvensdiagram med loop och alt
- [ ]  Vet vad aktivering betyder

### 🎯 Vanliga Misstag att Undvika

**Kodning**:

        - ❌ Glömma `super()` i subklass-konstruktor
- ❌ `super()` inte på första raden
- ❌ Fel accessmodifierare (t.ex. private i interface)
- ❌ Försöka instansiera abstrakt klass
- ❌ Glömma @Override annotation

**UML Klassdiagram**:

        - ❌ Pil i fel riktning (pilen pekar MOT superklassen vid arv)
- ❌ Fel diamant (vit vs svart för aggregation vs composition)
- ❌ Glömma multiplicitet
- ❌ Fel accessmodifierare-symbol

**Sekvensdiagram**:

        - ❌ Glömma aktiveringsboxar
- ❌ Pilar åt fel håll
- ❌ Glömma villkor i loops/alts
- ❌ Fel ordning på anrop

### 💡 Minnesregler

**ARV**: "En subklass ÄR EN superklass" (Dog ÄR EN Animal)

        **AGGREGATION vs COMPOSITION**: "Kan delen leva utan helheten?"

        - Ja → Aggregation ◇
        - Nej → Composition ◆

        **EXCEPTION**: "Checked = Compiler checks det" "Runtime = Körs först, kraschar sen"

        **SEKVENSDIAGRAM**: "Tid flödar som VATTEN - uppifrån och NER"

        **INTERFACE vs ABSTRACT**: "Interface säger VAD, Abstract säger VAD och lite HUR"

        ---

        ## ✅ FINAL SAMMANFATTNING

### 🏆 Det Allra Viktigaste

**För G (Godkänt)**:

        1. ✅ Förstå klasser, objekt, arv
2. ✅ Kunna skriva enkel Java-kod
3. ✅ Läsa och tolka klassdiagram
4. ✅ Grundläggande exception-hantering
5. ✅ Känna till GUI-komponenter

**För VG (Väl Godkänt)**:

        1. ✅ Djup förståelse av polymorfism
2. ✅ Designa system med klassdiagram
3. ✅ Rita och tolka sekvensdiagram
4. ✅ Implementera interfaces och abstrakta klasser
5. ✅ Hantera komplexa exceptions
6. ✅ Motivera designval

**Viktigaste Lärandemål från Kursplanen**:

        1. Konstruera program med polymorfism ✨
        2. Använda diagram för design 📊
        3. Integrera GUI och händelsehantering 🖼️
        4. Motivera val av kontrollstrukturer 🎯
        5. Förklara OOP-begrepp 📚

        ---

        ## 🎓 LYCKA TILL PÅ TENTAN!

        **Du klarar detta!** 💪

        **Sista råd**:

        - 😌 Vila ordentligt natten före
- 📖 Läs frågorna noggrant
- ⏰ Hantera tiden väl (svara på det du kan först)
- ✍️ Skriv TYDLIGT och INDENTERA kod korrekt
- 🤔 Tänk efter innan du svarar (särskilt på sant/falskt)

**När du är osäker**:

        - Fråga dig själv: "Hur fungerar detta i Python?"
        - Rita en enkel skiss
- Skriv pseudokod först
- Dubbelkolla accessmodifierare

---

        **Denna guide täcker**: ✅ Alla lärandemål från kursplanen ✅ Allt från läsanvisningarna (Deitel kapitel 2-13, 21) ✅ Alla ämnen från föreläsningarna ✅ Alla typer av frågor från exempeltentamen
        */
 */