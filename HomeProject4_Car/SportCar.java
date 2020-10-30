import java.util.*;
public class SportCar extends Car {
    public String maxspeed;

    public SportCar(String engman, String engpow, String clas, String marka, String massa, String maxspeed) {
        super(engman, engpow, clas, marka, massa);
        this.maxspeed = maxspeed;
    }

    public void printinfo() {
        System.out.println("Производитель двигателя: " + engman);
        System.out.println("Мощность двигателя: " + engpow);
        System.out.println("Класс автомобиля: " + clas);
        System.out.println("Марка автомобиля: " + marka);
        System.out.println("Масса автомобиля: " + massa);
        System.out.println("Максимальная грузоподъёмность: " + maxspeed);
    }

    public void start() {
        System.out.println("SportCar поехал");
    }

    public void stop() {
        System.out.println("SportCar остановился");
    }
}