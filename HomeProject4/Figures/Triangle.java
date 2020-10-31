import java.util.*;
public class Triangle implements Shape {
     private int b; // основание
     private int h; // высота
     private int s; // площадь

     Triangle(int b, int h) {
          this.b = b;
          this.h = h;
     }

     public int square() {
          s = (b * h) / 2;
          System.out.print("Треугольник ");
          return s; }
}