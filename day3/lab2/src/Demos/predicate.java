package Demos;

import java.util.ArrayList;
import java.util.List;

public class predicate {



}
class Apple{
    double weight;
    String color;

    public Apple(double weight, String color) {
        this.weight = weight;
        this.color = color;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    public interface Predicate<T>{
        boolean test(T t);
    }
    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
}
}