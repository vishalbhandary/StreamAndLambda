import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysProblem
{

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(18,34,48,29,17,7,4,50,13,24,48,18,7);

/*********************************** get all the even numbers *******************************************/
        // for(Integer i : list){
        //     if(i%2==0){
        //        System.out.println("Even " +i);
        //     }
        // }
        list.stream().filter(i->i%2==0).forEach(num ->System.out.println("Even " +num));
/*********************************** find duplicate elements in array *******************************************/
        Set<Integer> duplicate = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());
        System.out.println("Duplicate Numbers are "+duplicate);
        System.out.println("---Alternate Method by using Hashset---");
        Set<Integer> dup = new HashSet<>();
        Set<Integer> duplicateNumber = list.stream().filter(e -> !dup.add(e)).collect(Collectors.toSet());
        System.out.println("Duplicate Numbers using Hashset are " +duplicateNumber);

/******************************** Sorting in Arrays **********************************************/

//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = 0; j < list.size() - i - 1; j++) {
//                if (list.get(j) > list.get(j + 1)) {
//                    int temp = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, temp);
//                }
//            }
//        }
//        System.out.println("sort " + list);

        System.out.println("Sort using stream");
        list.stream().sorted().forEach(System.out::println);

/******************************* second-highest number in an array ********************************/
        Optional<Integer> secondHighest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        secondHighest.ifPresent(value -> System.out.println("Second Highest Number: "+value));

        System.out.println("If the given array is primitive type then covert to wrapper class");

        int[] ptoW = { 5,35,11,60,15,46,8,29,1,-2 };
        Integer secondHighestNumber = Arrays.stream(ptoW).boxed()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Array is->"+Arrays.toString(ptoW)+
                " & Second Highest Number is->" +secondHighestNumber);

/******************************* Longest String in Array ********************************/
        String[] strArray = {"java", "Core", "SpringBoot","Microservice"};

        String longestStringInArray = Arrays.stream(strArray).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println("String Array is -> "+Arrays.toString(strArray)+
                        " & Longest String in the Array is -> " +longestStringInArray);

/******************************* find all elements from array who stats with 1 ********************************/
        List<String> elementStartsWithOne = Arrays.stream(ptoW).boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(elementStartsWithOne);
        System.out.println("-----Alternate Method with Positive & Negative-----");

        List<Integer> posAndNeg = Arrays.stream(ptoW).boxed().map(e -> String.valueOf(e))
                .filter(e -> e.startsWith("2") || e.startsWith("-2"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(posAndNeg);

/******************************* join, skip, limit ********************************/
        List<String> nos = Arrays.asList("1","2","3","4");
        String joinExample = String.join("-", nos);
        System.out.println(joinExample);

        System.out.println("Print num between 1 and 10 but skip first and last");
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);

/******************************* Search in Arrays(BinarySearch) ********************************/




    }
}
