import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( 1,2,3,4,5,6,7,8,9,10 );

        //using sum function
        //int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        //without using sum function
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                        .reduce(0, Integer::sum);

        System.out.println("Sum of Numbers are:" +sum);


    }
}