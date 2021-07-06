package excercise2;

import java.util.function.BiPredicate;

public class StringUtils {
    public static String betterString(String str1, String str2, BiPredicate<String, String> biPredicate){
        return biPredicate.test(str1,str2)? str1 : str2;
    }


    public static boolean isLetter(String str){

        return str.chars().allMatch(a -> Character.isLetter(a));
    }
}
