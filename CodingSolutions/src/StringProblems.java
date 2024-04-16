import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblems {
    public static void main(String[] args) {
        String word = "String Operations in Characters";
        System.out.println("My String is-> " + word);

/***************** Count the Occurrence of each character in string ******************/
        Map<Character, Long> occurrenceCount = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Counting the Occurrence: " + occurrenceCount);
        //occurrenceCount.forEach(((character, count) -> System.out.println(character + ":" +occurrenceCount) ));

        System.out.println("------Alternate Method-------");

        Map<String, Long> charsCount = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("count is: " + charsCount);

/***************** Find all duplicate elements in given string ******************/
        List<String> duplicateElements = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Duplicate Elements in given String is " + duplicateElements);

        System.out.println("------Alternate Method for duplication------");

        Map<Character, Integer> charMap = new HashMap<>();
        word.chars().forEach(c -> charMap.put((char) c, charMap.getOrDefault((char) c, 0) + 1));
        charMap.forEach((key, value) -> {
            if (value > 1) {
                System.out.println("Character '" + key + "' appears " + value + " times.");
            }
        });


/***************** Find Unique elements in given string ******************/
        List<String> uniqueElements = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Unique Elements in given String is "+uniqueElements);

        System.out.println("------Alternate Method for Unique Elements using SET------");

        Set<Character> uniqueChars = new HashSet<>();
        word.chars().forEach(c -> uniqueChars.add((char) c));
        //uniqueChars.forEach(System.out::println);
        List<Character> uniqueList = new ArrayList<>(uniqueChars);
        System.out.println("Unique Elements in given String is: " +uniqueList);


/***************** Find first non-repeat elements in given string ******************/
        String firstNonRepeat = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("First Non Repeat Element " +firstNonRepeat);

/***************** Find first repeat elements in given string ******************/
        String firstRepeat = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .findFirst().get().getKey();
        System.out.println("First Repeat Element " +firstRepeat);

/*****************  ******************/


    }
}
