import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Square the list of numbers and then filer out the numbers greater than 10
        //then find avg of filtered numbers
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list.stream().mapToInt(i -> i * i).filter(square -> square > 10).average().getAsDouble());

    }
}