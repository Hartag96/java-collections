import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandNumbers {
    public Stream<Integer> Generator() {
        Stream<Integer> stream = Stream.generate(() -> new Random().nextInt(49 + 1) + 1).limit(6).distinct().sorted();
        return(stream);
    }
    private Integer IntGenerator() {
        Random r = new Random();
        return r.nextInt((49 - 1) + 1) + 1;
    }

}
