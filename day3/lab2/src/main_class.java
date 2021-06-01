public class main_class {
    public static void main(String[] args) {
        String string1="i am trying ";
        String string2="Still trying";

        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);

        System.out.println("Longer String is: " + longer);
        System.out.println("First String is: " + first);

        System.out.println();

        // Lambda Expression and Method Reference: Lab Exercise 2
        String charsonly = "OnlyAlphabets";
        String mixed = "letters 2205 + Alphabets";

        System.out.println(StringUtils.isLetter(charsonly)? "only letters" : "letters and other types");
        System.out.println(StringUtils.isLetter(mixed )? "only letters" : "letters and other types");

    }
}
