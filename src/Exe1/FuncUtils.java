package Exe1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FuncUtils {
    public static void applyAll(List<Person> list, Consumer<Person>... personConsumer) {
        for (Person p : list)
            for (Consumer<Person> c : personConsumer)
                c.accept(p);
    }

    public static void main(String[] args){
        List<Person> people=new ArrayList<>();
        GetOlder g = new GetOlder();
        applyAll(people, g, p->p.setName("Marek"));
    }
}
