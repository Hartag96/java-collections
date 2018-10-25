import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import static java.lang.String.join;

public class Main{

    public static void main(String[] args) {

////        //      1
        NumberConverter numberConverter = new NumberConverter();
        try{
            System.out.println(numberConverter.converter(0));
            System.out.println(numberConverter.converter(15));
            System.out.println(numberConverter.converter(30));
            System.out.println(numberConverter.converter(500));
            System.out.println(numberConverter.converter(4000));
        }catch (NumberConverter.WrongNumberException e){
            System.out.println("Blad! \nNumer z poza zakresu 1 - 999");
        }

        //      2
        RandNumbers randNumbers = new RandNumbers();
        Stream<Integer> numbers = randNumbers.Generator();
        numbers.forEach(System.out::println);

        //      3
        ArrayList<Student> obecnosci = DawajStudentow();

        System.out.println("\t Sortowanie po numerze albumu");
        Collections.sort(obecnosci);
        WyswietlStudentow(obecnosci);

//        System.out.println("\t Sortowanie po numerze albumu");
//        obecnosci.sort((Student o1, Student o2)-> {
//            return o1.numerAlbumu - o2.numerAlbumu;
//        });
//        WyswietlStudentow(obecnosci);

        System.out.println("\t Sortowanie po nazwisku, nastepnie po imieniu");
        Collections.sort(obecnosci);
        WyswietlStudentow(obecnosci);

//        System.out.println("\t Sortowanie po nazwisku, nastepnie po imieniu");
//        obecnosci.sort((Student o1, Student o2)-> {
//            int cmp = o1.nazwisko.compareTo(o2.nazwisko);
//            if (cmp == 0){
//                cmp = o1.imie.compareTo(o2.imie);
//            }
//            return cmp;
//        });
//        WyswietlStudentow(obecnosci);

        System.out.println("\t Sortowanie po sredniej ocen");
        Collections.sort(obecnosci);
        WyswietlStudentow(obecnosci);

//        System.out.println("\t Sortowanie po sredniej ocen");
//        obecnosci.sort((Student o1, Student o2)-> {
//            return (int) (o1.oceny.stream().mapToDouble(val -> val).average().orElse(0.0) - o2.oceny.stream().mapToDouble(val -> val).average().orElse(0.0));
//        });
//        WyswietlStudentow(obecnosci);

//              4
        Student student1 = obecnosci.get(0);
        Student student2 = obecnosci.get(1);
        Student student3 = obecnosci.get(2);

        student1.dodajPrzyjaciela(student2);
        student1.dodajPrzyjaciela(student3);
        System.out.println("Przyjazny student\n"+student1.toString());
        System.out.println("Przyjazny student\n"+student2.toString());
    }


    private static void WyswietlStudentow(ArrayList<Student> obecnosci){
        for (Student student: obecnosci) {
            System.out.println(student.toString());
        }
    }
    private static ArrayList<Student> DawajStudentow() {

        ArrayList<Student> obecnosci = new ArrayList<Student>();

        obecnosci.add(new Student(206969, "Jan", "Dzban"));
        obecnosci.add(new Student(213799, "Pawel", "Wojtylak"));
        obecnosci.add(new Student(200997, "Juri", "Wojtylak"));
        obecnosci.add(new Student(201999, "Brajan", "Brzeczek"));

        obecnosci.get(0).dodajOcene((float) 5.0);
        obecnosci.get(0).dodajOcene((float) 4.5);
        obecnosci.get(0).dodajOcene((float) 3.5);

        obecnosci.get(1).dodajOcene((float) 3.0);
        obecnosci.get(1).dodajOcene((float) 3.5);
        obecnosci.get(1).dodajOcene((float) 3.5);

        obecnosci.get(2).dodajOcene((float) 4.5);
        obecnosci.get(2).dodajOcene((float) 4.5);
        obecnosci.get(2).dodajOcene((float) 2);

        obecnosci.get(3).dodajOcene((float) 2);
        obecnosci.get(3).dodajOcene((float) 2.5);
        obecnosci.get(3).dodajOcene((float) 4);

        return obecnosci;

    }    }