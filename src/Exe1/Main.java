package Exe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList(Arrays.asList(
                new Person("John", "Smith", "john@gmail.com", 30),
                new Person("John", "Jackson", "katie1@gmail.com", 33),
                new Person("Jennifer", "Aniston", "jenny9@hotmail.com", 27),
                new Person("Monica", "Geller", "mgeller@gmail.com", 29),
                new Person("Chandler", "Bing", "mrbing@gmail.com", 32),
                new Person("Ross", "Geller", "rossgel@hotmail.com", 33),
                new Person("Rachel", "Green", "rgreen@hotmail.com", 29),
                new Person("Phoebe", "Buffet", "pbuff@gmail.com", 34),
                new Person("Joey", "Tribianni", "joey@hotmail.com", 26),
                new Person("Tony", "Jones", "tonyj@gmail.com", 35)
        ));

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

        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int n;
                n = o1.getName().compareTo(o2.getName());
                if (n == 0)
                    n = o1.getSurname().compareTo(o2.getSurname());
                return n;
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
                boolean o1Contains = o1.getEmail().contains(o1.getName()) || o1.getEmail().contains(o1.getSurname());
                boolean o2Contains = o2.getEmail().contains(o2.getName()) || o2.getEmail().contains(o2.getSurname());
                if (o1Contains && !o2Contains)
                    return 1;
                else if (!o1Contains && o2Contains)
                    return -1;
                else
                    return 0;
            }});

        System.out.println("Sorted by email containing name or surname (first):");
        for(Person p :personList) {
                System.out.println(p);
            }
        }
    }