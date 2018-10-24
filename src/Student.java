import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private int numerAlbumu;
    private String imie;
    private String nazwisko;
    private ArrayList<Double>oceny;
    private ArrayList<Student>przyjaciele;

    Student(int _numerAlbumu, String _imie, String _nazwisko) {
        this.numerAlbumu = _numerAlbumu;
        this.imie = _imie;
        this.nazwisko = _nazwisko;
        this.oceny = new ArrayList<Double>();
        this.przyjaciele = new ArrayList<Student>();
    }

    public String toString(){
        String str = String.format("Uczen: %s %s z indeksem %d ", this.imie, this.nazwisko, this.numerAlbumu);
        if (!this.oceny.isEmpty())
            str += "Jego oceny to: " + this.oceny;
        if(!this.przyjaciele.isEmpty())
            str += dajPrzyjaciol();

        return str;
    }

    public void dodajOcene(double grade){
        this.oceny.add(grade);
    }

    //    4
    public void dodajPrzyjaciela(Student przyjaciel){
        this.przyjaciele.add(przyjaciel);
        przyjaciel.przyjaciele.add(this);
    }

    private String dajPrzyjaciol(){
        String przyjaciele = "\nPrzyjaciele tego studenta to: ";
        for(Student student: this.przyjaciele){
            przyjaciele += String.format("%s %s \t", student.imie, student.nazwisko);
        }
        return przyjaciele;
    }

//    compere po numerze albumu
    @Override
    public int compareTo( final Student other) {
        return Integer.compare(this.numerAlbumu, other.numerAlbumu);
    }

//    compere po nazwisku a nastepnie imie
//    @Override
//    public int compareTo( final Student other) {
//        int cmp = this.nazwisko.compareTo(other.nazwisko);
//        if (cmp == 0)
//            cmp = this.imie.compareTo(other.imie);
//
//        return cmp;
//    }

//    compere po sredniej ocen
//    @Override
//    public int compareTo( final Student other) {
//        return (int) (this.oceny.stream().mapToDouble(val -> val).average().orElse(0.0) - other.oceny.stream().mapToDouble(val -> val).average().orElse(0.0));
//    }
}
