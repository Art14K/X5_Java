import java.util.*;
public class HomeProject4 {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Triangle(23, 15);
        shape[1] = new Circle(19);
        shape[2] = new Rectangle(12, 23);
        for (Shape sh: shape){
            System.out.println("Площадь фигуры: "+sh.square());
        }
    }
}