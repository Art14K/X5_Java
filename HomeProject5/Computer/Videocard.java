import java.util.*;

public class Videocard {
    public String manufacture; // Производитель видеокарты
    public String memorytype; // Тип памяти
    public String volumememory; // Объём памяти
    public CoolType cooltype;

        public Videocard(String manufacture, String memorytype, String volumememory, CoolType cooltype) {
            this.manufacture = manufacture;
            this.memorytype = memorytype;
            this.volumememory = volumememory;
            this.cooltype = cooltype;
        }




}