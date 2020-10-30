import java.util.*;
public class HomeProject4Car {
    public static void main(String[] args) {
        Lorry lor = new Lorry("BMW", "239 л.с.", "Гоузовик", "BMW", "7 тонн", "20 тонн");
        lor.printinfo();
        lor.start();
        lor.turnLeft();
        lor.turnRight();
        lor.stop();

        SportCar spcar = new SportCar("Ferrari", "569", "Спорткар", "Ferrari", "1 тонна 127 килограммов", "340 км/ч");
        spcar.printinfo();
        spcar.start();
        spcar.turnLeft();
        spcar.turnRight();
        spcar.stop();
    }
}