import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static java.lang.String.join;

public class Main{

    public static void main(String[] args) {

        //      1
        NumberConverter numberConverter = new NumberConverter();
        try{
            System.out.println(numberConverter.converter(0));
            System.out.println(numberConverter.converter(15));
            System.out.println(numberConverter.converter(30));
            System.out.println(numberConverter.converter(501));
            System.out.println(numberConverter.converter(2137));
        }catch (NumberConverter.WrongNumberException e){
            System.out.println("Blad! \nNumer z poza zakresu 1 - 999");
        }

        //      2
        RandNumbers randNumbers = new RandNumbers();
        Stream<Integer> numbers = randNumbers.Generator();
        numbers.forEach(System.out::println);

        //      3
        Student[] obecnosci = DawajStudentow();

        System.out.println("\t Sortowanie po numerze albumu");
        Arrays.sort(obecnosci, Student::compareToIndex);
        System.out.println(Arrays.deepToString(obecnosci));

        System.out.println("\t Sortowanie po nazwisku, nastepnie po imieniu");
        Arrays.sort(obecnosci, Student::compareToName);
        System.out.println(Arrays.deepToString(obecnosci));

        System.out.println("\t Sortowanie po sredniej ocen");
        Arrays.sort(obecnosci, Student::compareToGrades);
        System.out.println(Arrays.deepToString(obecnosci));

        //      4
        Student student1 = obecnosci[0];
        Student student2 = obecnosci[1];
        Student student3 = obecnosci[2];

        student1.dodajPrzyjaciela(student2);
        student1.dodajPrzyjaciela(student3);
        System.out.println("\nPrzyjazny student\n"+student1.toString());
        System.out.println("\nPrzyjazny student\n"+student2.toString());
    }

    private static Student[] DawajStudentow() {

        Student[] obecnosci = new Student[4];

        obecnosci[0] = new Student(206969, "Jan", "Dzban");
        obecnosci[1] = new Student(213799, "Pawel", "Wojtylak");
        obecnosci[2] = new Student(200997, "Juri", "Wojtylak");
        obecnosci[3] = new Student(201999, "Brajan", "Brzeczek");

        obecnosci[0].dodajOcene((float) 5.0);
        obecnosci[0].dodajOcene((float) 4.5);
        obecnosci[0].dodajOcene((float) 3.5);

        obecnosci[1].dodajOcene((float) 3.0);
        obecnosci[1].dodajOcene((float) 3.5);
        obecnosci[1].dodajOcene((float) 3.5);

        obecnosci[2].dodajOcene((float) 4.5);
        obecnosci[2].dodajOcene((float) 4.5);
        obecnosci[2].dodajOcene((float) 2);

        obecnosci[3].dodajOcene((float) 2);
        obecnosci[3].dodajOcene((float) 2.5);
        obecnosci[3].dodajOcene((float) 4);

        return obecnosci;

    }
}