import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Print 5 Random numbers using for each
        Random r = new Random();
        System.out.println("Generating 5 random number ");
        r.ints(5,1,11).forEach(i-> System.out.println(i));
        System.out.println("Using method Reference in For Each");
        r.ints(5,1,11).forEach(System.out::println);

        //sort the random numbers using for each
        System.out.println("Sorting here ---");
        r.ints(5,1,11).sorted().forEach(System.out::println);
    }
}