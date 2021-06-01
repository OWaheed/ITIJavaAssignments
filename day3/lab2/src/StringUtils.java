import java.util.function.BiPredicate;

public class StringUtils {
    public  static String betterString(String string1, String string2, BiPredicate<String,String> bi)
    {
      return bi.test(string1,string2) ? string1:string2;
    }
    public static boolean isLetter(String str){
        return str.chars().allMatch(a -> Character.isLetter(a));
}}
