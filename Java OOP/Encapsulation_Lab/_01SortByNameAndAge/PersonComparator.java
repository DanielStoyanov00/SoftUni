package _01SortByNameAndAge;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int sComp = p1.getFirstName().compareTo(p2.getFirstName());

        if (sComp != 0) {
            return sComp;
        } else {
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    }
}
