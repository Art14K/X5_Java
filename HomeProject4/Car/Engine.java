import java.util.*;
public class Engine {
    public String manufacture;
    public int power;

    Engine(String manufacture, int power) {
        this.manufacture = manufacture;
        this.power = power;

    }

    public int getInfo(int power) {
        this.power = power;
        return power;
    }

    public String getInfo(String Engine) {
        this.manufacture = manufacture;
        return manufacture;
    }

}