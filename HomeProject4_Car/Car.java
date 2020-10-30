import java.util.*;
public abstract class Car {
   protected String engman;
   protected String engpow;
   protected String clas;
   protected String marka;
   protected String massa;

    public Car(String engman, String engpow, String clas, String marka, String massa) {
        this.engman = engman;
        this.engpow = engpow;
        this.clas = clas;
        this.marka = marka;
        this.massa = massa;
    }

    public abstract void start();
    public abstract void stop();

    public void turnRight() {
        System.out.println("Поворот на право");
    }

    public void turnLeft() {
        System.out.println("Поворот на лево");
    }

    public abstract void printinfo();




}