package Exe1;

import java.util.function.Consumer;

public class GetOlder implements Consumer<Person> {

    Boolean isOlderThan18 = false;

    @Override
    public void accept(Person person) {
        if (person.getAge() < 18)
            person.setAge(person.getAge() + 1);
        if (person.getAge() >= 18)
            isOlderThan18 = true;
    }

    @Override
    public Consumer<Person> andThen(Consumer<? super Person> after) {
        return null;
    }
}

//Napisz klasę GetOlder implementującą interfejs funkcyjny Consumer<Person>, która będzie zwiększać wiek osoby o 1
//i zapamiętywać czy osoba ta przekroczyła 18 lat.
//Po stworzeniu obiektu tej klasy i wywołaniu applyAll na liście przekazując ten obiekt jako funkcję powinniśmy
//zwiększyć wiek wszystkich osób o 1, i dostać zmagazynowaną w obiekcie funkcyjnym informację
//ile osób przekroczyło 18 lat. Czyli kod wyglądałby mniej więcej tak:
//
//List<Person> list = Arrays.asList(new Person(...), ... ) ;
//GetOlder f = new GetOlder();
//applyAll(list, f);
//System.out.println(f.getAdultsNumber());