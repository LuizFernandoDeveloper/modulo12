import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Type the names separated by commas.");
        String names = sc.nextLine();

        List<String> listaNames = presentedNames(names);
        Collections.sort(listaNames);

        System.out.println("Names in alphabetical order.");
        for (String name : listaNames) {
            System.out.println(name);
        }

        System.out.println("Please, now enter the name with its gender.");
        names = sc.nextLine();
        List<Pessoas> genderNames = genderName(names);

        System.out.println("People grouped by gender.");
        printPeopleByGender(genderNames);

    }

    public static List<String> presentedNames(String names) {
        String[] parts = names.split(",");
        List<String> listNames = new ArrayList<>();
        for (String part : parts) {
            listNames.add(part.trim());
        }
        return listNames;
    }

    public static List<Pessoas> genderName(String names) {
        String[] parts = names.split(",");
        List<Pessoas> listGender = new ArrayList<>();
        for (int i = 0; i < parts.length; i += 2) {
            String name = parts[i].trim();
            String sexo = parts[i + 1].trim();
            listGender.add(new Pessoas(name, sexo));
        }
        return listGender;
    }

    public static void printPeopleByGender(List<Pessoas> genderNames) {
        List<Pessoas> female = new ArrayList<>();
        List<Pessoas> male = new ArrayList<>();

        for (Pessoas person : genderNames) {
            if (person.getSexo().equalsIgnoreCase("F")) {
                female.add(person);
            } else if (person.getSexo().equalsIgnoreCase("M")) {
                male.add(person);
            }
        }

        System.out.println("Female: ");
        for (Pessoas person : female) {
            System.out.println(person.getName());

        }

        System.out.println("\nMale: ");
        for (Pessoas person : male) {
            System.out.println(person.getName());
        }
    }
}