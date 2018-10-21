import java.util.ArrayList;

public class Student {
    int numerAlbumu;
    String imie;
    String nazwisko;
    ArrayList<Double>oceny;
    ArrayList<Student>przyjaciele;

    Student(int _numerAlbumu, String _imie, String _nazwisko) {
        this.numerAlbumu = _numerAlbumu;
        this.imie = _imie;
        this.nazwisko = _nazwisko;
        this.oceny = new ArrayList<Double>();
        this.przyjaciele = new ArrayList<Student>();
    }

    public String toString(){
        if (!this.przyjaciele.isEmpty()) {
            wyswitlPrzyjaciol();
        }
        return "Uczeń: " + this.imie + " " + this.nazwisko + "  z indeksem: " + this.numerAlbumu + "\nA to jego oceny: " + this.oceny + "\n";
    }
    public void dodajOcene(double grade){
        this.oceny.add(grade);
    }

    //    4
    public void dodajPrzyjaciela(Student przyjaciel){
        this.przyjaciele.add(przyjaciel);
        przyjaciel.przyjaciele.add(this);
    }
    public void wyswitlPrzyjaciol(){
        System.out.println("Przyjaciele " + this.imie + this.nazwisko + "to: ");
        for(Student student: this.przyjaciele){
            System.out.println(student.toString());
        }
    }
}
