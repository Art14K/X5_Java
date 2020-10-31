import java.util.*;
public class Circle implements Shape {
    private int r; // Радиус круга
    private  int s; // Площадь

    Circle(int r) {
        this.r = r;
    }

    public int square() {
        r = r * r;
        s = (int) 3.14 * r;
        System.out.print("Круг ");
        return s;
    }

}