import java.util.Random;
import java.util.stream.Stream;

public class RandNumbers {
    public Stream<Integer> Generator() {
        return Stream.generate(() -> new Random().nextInt(48)+1).distinct().limit(6).sorted();
    }
}