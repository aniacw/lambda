package Exe1;

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


//
//    Napisz funkcję
//    Integer sum( Integer(Integer) func, Collection<Integer> collection)
//    która wykona podaną w argumencie funkcję na wszystkich elementach kolekcji, zsumuje wyniki tych wywołań i zwróci sumę
//    Przetestuj podając lambdę za funkcję w argumencie
//
///////////////////////////////////////////////////////////////////////////////////////////
//
//    Napisz funkcję
//    Boolean trueForAll( Boolean(String) func, Collection<String> collection)
//    która sprawdzi czy podana funkcja logiczna zwraca true dla wszystkich elementów kolekcji
//    Przetestuj podając lambdę za funkcję w argumencie
//
///////////////////////////////////////////////////////////////////////////////////////////
//
//    Napisz funkcję
//    Boolean(String) negate( Boolean(String) )
//    która zwróci funkcję będącą zaprzeczeniem logicznym podanej
//    Np podając funkcję, która sprawdza czy kolekcja jest pusta, dostaniemy funkcję która podaje przeciwną
//    wartość, czyli sprawdza czy kolekcja nie jest pusta.

    public static <T> Predicate<T> negate(Predicate<T> predicate){
        return t -> !predicate.test(t);
    }


    public static <T> Integer sum(Collection<T> collection, Function<T, Integer> f){
        int n = 0;
        for(T i : collection){
            n += f.apply(i);
        }
        return n;
    }

    private static class GetAge implements Function<Person, Integer>{
        @Override
        public Integer apply(Person person) {
            return person.getAge();
        }
    }


    public static boolean trueForAll(Predicate<String> pred, Collection<String> collection) {
        for (String c : collection) {
            if (pred.test(c) == false)
                return false;
        }
        return true;
    }

        public static void main (String[]args){

            int[] array = new int[]{9, 4, 67, 2, 34};


            GetOlder getOlder = new GetOlder();


            List<Person> personList = new ArrayList(Arrays.asList(
                    new Person("John", "Smith", "john111111111111111@gmail.com", 30),
                    new Person("John", "Jackson", "katie1@gmail.com", 33),
                    new Person("Jennifer", "Aniston", "jenny9@hotmail.com", 27),
                    new Person("Monica", "Geller", "mgeller@gmail.com", 29),
                    new Person("Chandler", "Bing", "mrbing@gmail.com", 32),
                    new Person("Ross", "Geller", "rossgel@hotmail.com", 15),
                    new Person("Rachel", "Green", "rgreen@hotmail.com", 29),
                    new Person("Phoebe", "Buffet", "pbuff@gmail.com", 17),
                    new Person("Joey", "Tribianni", "joey@hotmail.com", 18),
                    new Person("Tony", "Jones", "tonyj@gmail.com", 35)
            ));


            Predicate<Person> pred = p->p.getAge() > 18;

            personList.removeIf(negate(pred));

            sum(personList, Person::getAge);

            System.out.println("Unsorted:");
            for (Person p : personList) {
                System.out.println(p);
            }

            personList.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.getAge() - o2.getAge();
                }
            });

            System.out.println("Sorted by age:");
            for (Person p : personList) {
                System.out.println(p);
            }

//        personList.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                int n;
//                n = o1.getName().compareTo(o2.getName());
//                if (n == 0)
//                    n = o1.getSurname().compareTo(o2.getSurname());
//                return n;
//            }
//        });

            personList.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return (o1.getName() + o1.getSurname()).compareTo(o2.getName() + o2.getSurname());
                }
            });

            System.out.println("Sorted by name:");
            for (Person p : personList) {
                System.out.println(p);
            }

            personList.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return (o1.getName().length() + o1.getSurname().length()) - (o2.getName().length() + o2.getSurname().length());
                }
            });

            System.out.println("Sorted by name and surname length:");
            for (Person p : personList) {
                System.out.println(p);
            }

            personList.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    boolean o1Contains = o1.getEmail().contains(o1.getName().toLowerCase()) || o1.getEmail().contains(o1.getSurname().toLowerCase());
                    boolean o2Contains = o2.getEmail().contains(o2.getName().toLowerCase()) || o2.getEmail().contains(o2.getSurname().toLowerCase());
                    if (o1Contains && !o2Contains)
                        return -1;
                    else if (!o1Contains && o2Contains)
                        return 1;
                    else
                        return 0;
                }
            });

            System.out.println("Sorted by email containing name or surname (first):");
            for (Person p : personList) {
                System.out.println(p);
            }

            //another age sort
            personList.sort(Comparator.comparingInt(Person::getAge));

            System.out.println("Sorted by age (lambda):");
            for (Person p : personList) {
                System.out.println(p);
            }


            //
            personList.sort((o1, o2) -> (o1.getName() + o1.getSurname()).compareTo(o2.getName() + o2.getSurname()));

            System.out.println("Sorted by name+surname alph lambda");
            for (Person p : personList) {
                System.out.println(p);
            }

            personList.sort((o1, o2) -> (o1.getName().length() + o1.getSurname().length()) -
                    (o2.getName().length() + o2.getSurname().length()));

            System.out.println("Sorted by name+surname length lambda");
            for (Person p : personList) {
                System.out.println(p);
            }

            //remove under 18
            personList.removeIf(person -> person.getAge() < 18);

            System.out.println("Removed under 18:");
            for (Person p : personList) {
                System.out.println(p);
            }

            //longest email removal
            int longestEmail = personList.get(0).getEmail().length();

            for (int i = 1; i < personList.size() - 1; i++) {
                if (personList.get(i).getEmail().length() > longestEmail)
                    longestEmail = personList.get(i).getEmail().length();
            }

            final int longestEmailfound = longestEmail;

            personList.removeIf(person -> person.getEmail().length() == longestEmailfound);


            int maxEmailLength =
                    Collections.max(
                            personList,
                            Comparator.comparingInt(
                                    person -> person.getEmail().length()
                            )
                    ).getEmail().length();


            System.out.println("Removed person with the longest email:");
            for (Person p : personList) {
                System.out.println(p);
            }
        }


    }