import java.util.*;
public class Rectangle implements Shape {
    private int a; // Ширина
    private int b; // Высота
    private int s; // Площадь

    Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int square() {
        s = a * b;
        System.out.print("Прямоугольник ");
        return s;
    }
}