import java.util.*;

public class Processor {
    public String cores; //количество ядер
    public String ggz; // тактовая частота
    public String cashmemory; // объём кэш памяти
    public String names; // название
    public String manufacture; // производитель

    public Processor(String cores, String ggz, String cashmemory, String names, String manufacture) {
        this.cores = cores;
        this.ggz = ggz;
        this.cashmemory = cashmemory;
        this.names = names;
        this.manufacture = manufacture;

    }


}