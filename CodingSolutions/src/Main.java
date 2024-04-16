import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //Square the list of numbers and then filer out the numbers greater than 10
        //then find avg of filtered numbers
        List<Integer> list = Arrays.asList(1,2,10,3,4,5,-1);
        System.out.println(list.stream().mapToInt(i -> i * i).filter(square -> square > 10).average().getAsDouble());

        double averageOfNumber = list.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Average of the "+list+" list is: " +averageOfNumber);

        double numSquareAvg = list.stream().map(e -> e * e).filter(e -> e > 1)
                .mapToInt(e -> e).average().getAsDouble();
        System.out.println("Number Square Average of the "+list+" list is: " +numSquareAvg);

        Integer maximumNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        Integer minimumNumber = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("The List "+list+" has maximum number = "+maximumNumber+ " and minimum number = "+minimumNumber);


    }
}