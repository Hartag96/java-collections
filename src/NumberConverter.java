public class NumberConverter {

    public static String converter(int n) throws WrongNumberException{
        if (n > 10 && n < 20) {
            return nascie(n % 10);
        } else if (n < 10) {
            return jednocyfrowe(n % 10);
        } else if (n >= 20 && n < 100) {
            return String.join(" ", dwucyfrowe(n / 10), jednocyfrowe(n % 10));
        } else if (n > 100 && n < 1000) {
            return String.join(" ", trzycyfrowe(n / 100), dwucyfrowe((n / 10) / 10), jednocyfrowe(n % 10));
        } else {
            throw new WrongNumberException();
        }
    }

    private static String jednocyfrowe(int n) {
        String[] word = {"", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec"};
        return word[n];
    }

    private static String nascie(int n) {
        String[] word = {"jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie"};
        return word[n - 1];
    }

    private static String dwucyfrowe(int n) {
        String[] word = {"dziesiec", "dwadziescia", "trzydziesci", "czterdziesci", "piecdziesiat", "szescdziesiac", "siedemdziesiac", "osiemdziesiat", "dziewiecdziesiat"};
        return word[n - 1];
    }

    private static String trzycyfrowe(int n) {
        String[] word = {"sto", "dwiescie", "trzysta", "czterysta", "piecset", "szescset", "siedemset", "osiemset", "dziewiecset"};
        return word[n - 1];
    }

    static class WrongNumberException extends Exception {
    }
}