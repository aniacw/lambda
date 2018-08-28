package Exe1;

import java.util.List;
import java.util.function.Predicate;

public class Person {

    private String name, surname, email;
    private int age;

    public Person(String name, String surname, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public Person() {
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

    public void setAge(int age) {
        this.age = age;
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

//    Napisz funkcję
//    void applyAll( List<Person> list, void(Person)... functions )
//        która ma argumenty: lista osób i dowolna ilość funkcji, z których każda ma być wywołana na każdym elemencie listy
//        Np możemy użyć jej tak, że przekazujemy listę i 2 funkcje: jedna zwiększa wiek o 1, druga czyści pole email.
//


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