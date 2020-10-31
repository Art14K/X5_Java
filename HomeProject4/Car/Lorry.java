import java.util.*;
public class Lorry extends Car {
    private String tonnage;
    public Lorry(Engine engine, String clas, String marka, String massa, String tonnage) {
        super(engine, clas, marka, massa);
        this.tonnage = tonnage;
    }

    public void printinfo() {
        System.out.println("Производитель двигателя: " + engine.getInfo(engine.manufacture));
        System.out.println("Мощность двигателя: " + engine.getInfo(engine.power));
        System.out.println("Класс автомобиля: " + clas);
        System.out.println("Марка автомобиля: " + marka);
        System.out.println("Масса автомобиля: " + massa);
        System.out.println("Максимальная грузоподъёмность: " + tonnage);
    }

    public void start() {
        System.out.println("Грузовик поехал");
    }

    public void stop() {
        System.out.println("Грузовик остановился");
    }
}