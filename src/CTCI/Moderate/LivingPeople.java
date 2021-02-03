package CTCI.Moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LivingPeople {
    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person(1911, 1944),
                new Person(1920, 1939),
                new Person(1920, 1955),
                new Person(1937, 1940),
                new Person(1938, 1939),
        };

        System.out.println(yearWithMaxPeopleAlive(people));

    }

    private static class Person {
        int birthYear;
        int deathYear;

        Person(int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public int getDeathYear() {
            return deathYear;
        }
    }

    private static int yearWithMaxPeopleAlive(Person[] people) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Person person : people) {
            map.put(person.birthYear, 0);
            map.put(person.deathYear, 0);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = 0;
            for (Person person : people)
                if (person.birthYear <= entry.getValue() && person.deathYear >= entry.getValue())
                    map.put(entry.getKey(), map.get(entry.getKey()) + 1);
        }

        for (Map.Entry entry : map.entrySet())
            System.out.println(entry.getKey() + "|" + entry.getValue());
        return 0;
    }
}
