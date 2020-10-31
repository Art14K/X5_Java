import java.util.*;
public class HomeProject4Car {
    public static void main(String[] args) {
        Engine engine_lorry = new Engine("BMW", 239);
        Engine engine_sportcar = new Engine("Ferrari", 569);
        Lorry lorry = new Lorry(engine_lorry, "Гоузовик", "BMW", "7 тонн", "20 тонн");
        lorry.printinfo();
        lorry.start();
        lorry.turnLeft();
        lorry.turnRight();
        lorry.stop();

        SportCar sportcar = new SportCar(engine_sportcar, "Спорткар", "Ferrari", "1 тонна 127 килограммов", "340 км/ч");
        sportcar.printinfo();
        sportcar.start();
        sportcar.turnLeft();
        sportcar.turnRight();
        sportcar.stop();
    }
}