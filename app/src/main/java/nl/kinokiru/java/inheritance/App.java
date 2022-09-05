/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package nl.kinokiru.java.inheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import nl.kinokiru.java.inheritance.models.DeathRowInmate;
import nl.kinokiru.java.inheritance.models.Person;
import nl.kinokiru.java.inheritance.models.Student;

public class App {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        DeathRowInmate jan = new DeathRowInmate("4322de3", 21, "Jan Eggbart Humming", -1);
        jan.sayGreetings();

        Student mark = new Student("64372ER", 4, "Mark Kinderbetaster");
        jan.addFriend(mark);

        System.out.println(jan);

        var namesStream = App.class.getClassLoader().getResourceAsStream("names.txt");
        Scanner sc = new Scanner(namesStream);
        while (sc.hasNextLine()) {
            names.add(sc.nextLine());
        }
        sc.close();
        Collections.shuffle(names);

        for (int i = 0; i <= 100; i++) {
            int age = ((int) Math.floor(Math.random() * 100) + 1);
            String ssn = generateSSN(8);

            if (i % 2 == 0) {
                list.add(new Student(ssn, age, names.get(i)));
            } else {
                int daysLeftToLive = ((int) Math.floor(Math.random() * 4) + 1);
                list.add(new DeathRowInmate(ssn, age, names.get(i), daysLeftToLive));
            }
        }

        for (Person person : list) {
            for (int i = 0; i < ((int) Math.floor(Math.random() * 4) + 1); i++) {
                person.addFriend(list.get(((int) Math.floor(Math.random() * list.size()))));
            }
        }
        Person friend = list.get(0);
        Person target = list.get(1);
        System.out.println("friend " + friend.getName() + "; target " + target.getName());
        System.out.println(friend.getCorrelationPath(target));
    }

    public static String generateSSN(int length) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) ((Math.random() * 26) + 97));
        }
        return sb.toString();
    }
}
