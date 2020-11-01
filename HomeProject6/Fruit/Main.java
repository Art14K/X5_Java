import java.util.*;

public class Main {
    public static void main (String[] args) {

        Box<Orange> or = new Box<>();
        Box<Orange> or1 = new Box<>();
        Box<Apple> ap = new Box<>();
        Box<Apple> ap1 = new Box<>();
        or.addFruit(new Orange(),14);
        or1.addFruit(new Orange(),18);
        ap.addFruit(new Apple(),12);
        ap1.addFruit(new Apple(),15);
        System.out.println("Коробка 1: "+or.getWeight());
        System.out.println("Коробка 2: "+or1.getWeight());
        System.out.println("Коробка 3: "+ap.getWeight());
        System.out.println("Коробка 4: "+ap1.getWeight());
        System.out.println("Сравниваем коробку 1 с коробкой 3: "+or.compare(ap));
        System.out.println("Сравниваем коробку 2 с коробкой 4: "+or1.compare(ap1));
        or.pourTo(or1);
        ap.pourTo(ap1);
        System.out.println("Коробка 1: "+or.getWeight());
        System.out.println("Коробка 2: "+or1.getWeight());
        System.out.println("Коробка 3: "+ap.getWeight());
        System.out.println("Коробка 4: "+ap1.getWeight());


    }

}