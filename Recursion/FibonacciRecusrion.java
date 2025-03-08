
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibonacciRecusrion {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        // dont worry much about this, its just a fancy list comprehension
        List<Integer> list = IntStream.range(0, n + 1).mapToObj(FibonacciRecusrion::fibonacci).collect(Collectors.toList());
        System.out.println(list);
    }
}
