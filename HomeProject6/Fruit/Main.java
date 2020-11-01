import java.util.*;

public class Main {
    public static void main (String[] args) {

        Box<Orange> orange = new Box<>();
        Box<Orange> orange_1 = new Box<>();
        Box<Apple> apple = new Box<>();
        Box<Apple> apple_1 = new Box<>();
        orange.addFruit(new Orange(),14);
        orange_1.addFruit(new Orange(),18);
        apple.addFruit(new Apple(),12);
        apple_1.addFruit(new Apple(),15);
        System.out.println("Коробка 1: "+orange.getWeight());
        System.out.println("Коробка 2: "+orange_1.getWeight());
        System.out.println("Коробка 3: "+apple.getWeight());
        System.out.println("Коробка 4: "+apple_1.getWeight());
        System.out.println("Сравниваем коробку 1 с коробкой 3: "+orange.compare(apple));
        System.out.println("Сравниваем коробку 2 с коробкой 4: "+orange_1.compare(apple_1));
        orange.pourTo(orange_1);
        apple.pourTo(apple_1);
        System.out.println("Коробка 1: "+orange.getWeight());
        System.out.println("Коробка 2: "+orange_1.getWeight());
        System.out.println("Коробка 3: "+apple.getWeight());
        System.out.println("Коробка 4: "+apple_1.getWeight());


    }

}