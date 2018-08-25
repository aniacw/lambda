package Exe1;

public class Person {

    private String name, surname, email;
    private int age;

    public Person(String name, String surname, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}


//    Napisz prostą klasę Person, mającą name, surname, age, email
//        Napisz kod który inicjalizuje listę 10 różnych osób, następnie (oddzielne przypadki):
//        sortuje ją:
//        - pod względem wieku
//        - pod względem kolejności alfabetycznej imienia i nazwiska
//        - pod względem sumarycznej ilości liter w imieniu i nazwisku
//        - pod względem tego czy imię albo nazwisko osoby jest zawarte w emailu
//        usuwa:
//        - osobę/y z najdłuższym emailem
//        - osobę/y z wiekiem < 18 lat
//
//        Użyj funkcji Listy: sort i removeIf