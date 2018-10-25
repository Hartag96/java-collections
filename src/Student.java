import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student{
    private int numerAlbumu;
    private String imie;
    private String nazwisko;
    private ArrayList<Double>oceny;
    private Set<Student> hashset;

    Student(int _numerAlbumu, String _imie, String _nazwisko) {
        this.numerAlbumu = _numerAlbumu;
        this.imie = _imie;
        this.nazwisko = _nazwisko;
        this.oceny = new ArrayList<Double>();
        this.hashset = new HashSet<>();
    }

    public String toString(){
        String str = String.format("Uczen: %s %s z indeksem %d ", this.imie, this.nazwisko, this.numerAlbumu);
        if (!this.oceny.isEmpty())
            str += "Jego oceny to: " + this.oceny;
        if(!this.hashset.isEmpty())
            str += dajPrzyjaciol();

        return str;
    }

    public void dodajOcene(double grade){
        this.oceny.add(grade);
    }

    //    4
    public void dodajPrzyjaciela(Student przyjaciel){
        this.hashset.add(przyjaciel);
        przyjaciel.hashset.add(this);
    }

    private String dajPrzyjaciol(){
        String przyjaciele = "\nPrzyjaciele tego studenta to: ";
        for(Student student: this.hashset){
            przyjaciele += String.format("%s %s \t", student.imie, student.nazwisko);
        }
        return przyjaciele;
    }

    public int compareToIndex( final Student other) {
        return Integer.compare(this.numerAlbumu, other.numerAlbumu);
    }

    public int compareToName( final Student other) {
        int cmp = this.nazwisko.compareTo(other.nazwisko);
        if (cmp == 0)
            cmp = this.imie.compareTo(other.imie);

        return cmp;
    }

    public int compareToGrades( final Student other) {
        return (int) (this.oceny.stream().mapToDouble(val -> val).average().orElse(0.0) - other.oceny.stream().mapToDouble(val -> val).average().orElse(0.0));
    }
}
