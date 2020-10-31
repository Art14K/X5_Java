import java.util.*;
public class SportCar extends Car {
    private String maxspeed;

    public SportCar(Engine engine, String clas, String marka, String massa, String maxspeed) {
        super(engine, clas, marka, massa);
        this.maxspeed = maxspeed;
    }

    public void printinfo() {
        System.out.println("Производитель двигателя: " + engine.getInfo(engine.manufacture));
        System.out.println("Мощность двигателя: " + engine.getInfo(engine.power));
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