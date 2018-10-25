import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NumberConverter {
    public static Map<Integer, String> map;

    NumberConverter(){
        map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "jeden");
        map.put(2, "dwa");
        map.put(3, "trzy");
        map.put(4, "cztery");
        map.put(5, "piec");
        map.put(6, "szesc");
        map.put(7, "siedem");
        map.put(8, "osiem");
        map.put(9, "dziewiec");
        map.put(10, "dziesiec");
        map.put(11, "jedenascie");
        map.put(12, "dwanascie");
        map.put(13, "trzynascie");
        map.put(14, "czternascie");
        map.put(15, "pietnascie");
        map.put(16, "szesnascie");
        map.put(17, "siedemnascie");
        map.put(18, "osiemnascie");
        map.put(19, "dziewietnascie");
        map.put(20, "dwadziescia");
        map.put(30, "trzydziesci");
        map.put(40, "czterdziesci");
        map.put(50, "piecdziesiat");
        map.put(60, "szescdziesiat");
        map.put(70, "siedemdziesiat");
        map.put(80, "osiemdziesiat");
        map.put(90, "dziewiecdziesiat");
        map.put(100, "sto");
        map.put(200, "dwiescie");
        map.put(300, "trzysta");
        map.put(400, "cztersta");
        map.put(500, "piecset");
        map.put(600, "szescset");
        map.put(700, "siedemset");
        map.put(800, "osiemset");
        map.put(900, "dziwiecset");
    }

    public static String converter(int n) throws WrongNumberException{
        if (n >= 0 && n < 20) {
            return map.get(n);
        } else if (n >= 20 && n < 100) {
            return String.join(" ", map.get((n/10)*10), n % 10 != 0 ? map.get(n % 10) : "");
        } else if (n > 100 && n < 1000) {
            return String.join(" ",
                    map.get((n / 100)*100),
                    (((n % 10) / 10)*10) != 0 ? map.get(((n % 10) / 10)*10) : "",
                    n % 100 != 0 ? map.get(n / 100) : "");
        } else {
            throw new WrongNumberException();
        }
    }

    static class WrongNumberException extends Exception {
    }
}