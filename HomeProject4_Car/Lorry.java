import java.util.*;
public class Lorry extends Car {
    public String tonnage;
    public Lorry(String engman, String engpow, String clas, String marka, String massa, String tonnage) {
        super(engman, engpow, clas, marka, massa);
        this.tonnage = tonnage;
    }

    public void printinfo() {
        System.out.println("Производитель двигателя: " + engman);
        System.out.println("Мощность двигателя: " + engpow);
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