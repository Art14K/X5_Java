import java.util.*;
public class Car {
   protected Engine engine;
   protected String clas;
   protected String marka;
   protected String massa;

    public Car(Engine engine, String clas, String marka, String massa) {
        this.engine = engine;
        this.clas = clas;
        this.marka = marka;
        this.massa = massa;
    }


    public void turnRight() {
        System.out.println("Поворот на право");
    }

    public void turnLeft() {
        System.out.println("Поворот на лево");
    }

}