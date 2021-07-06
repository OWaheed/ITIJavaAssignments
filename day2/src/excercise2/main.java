package excercise2;

public class main {
    public static void main(String[] args) {
        String first_str = "The first string";
        String second_str = "This second and longest string";

        String longer = StringUtils.betterString(first_str, second_str, (s1, s2) -> s1.length() > s2.length());
        String first = StringUtils.betterString(first_str, second_str, (s1, s2) -> true);

        System.out.println("Longer String is: " + longer);
        System.out.println("First String is: " + first);

        String Stringalphaonly = "OnlyAlphabets";
        String StringWithalphaandother = "letters 2205 + Alphabets";

        System.out.println(StringUtils.isLetter(Stringalphaonly)? "only alphabets" : "Contains other characters");
        System.out.println(StringUtils.isLetter(StringWithalphaandother)? "only alphabets" : "Contains other characters");
    }


}
