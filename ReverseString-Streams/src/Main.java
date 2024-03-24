public class Main {
    public static void main(String[] args) {
        String str = "Reverse My String";

        String revString = myStringRev(str);
        System.out.println("Reversing the String: " +revString);
    }

    private static String myStringRev(String str) {
        String revString = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce((s1, s2) -> s2 + s1)
                .orElse(" ");

        //String revString = Stream.of(str)
        // .map(String -> new StringBuffer(str).reverse())
        //  .collect(Collectors.joining(str));
        return revString;
    }
}
