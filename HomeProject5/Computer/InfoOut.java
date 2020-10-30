import java.util.*;

public class InfoOut {
    private HDD hdd;
    private Videocard videocard;
    private Processor processor;
    private Ram ram;

    public InfoOut (HDD hdd, Videocard videocard, Processor processor, Ram ram) {
        this.hdd = hdd;
        this.processor = processor;
        this.ram = ram;
        this.videocard = videocard;
    }

    public void printinfo(HDD hdd) {
        System.out.println();
        System.out.println("Характеристика накопителя: ");
        System.out.println("Производитель: " + hdd.manufacture);
        System.out.println("Объём памяти: " + hdd.volumememory);
        System.out.println("Тип накопителя: " + hdd.hddtype);
        System.out.println("Форм - фактор: " + hdd.hddformfacture);
    }

    public void printinfo(Videocard videocard) {
        System.out.println();
        System.out.println("Хорактеристика видеокарты: ");
        System.out.println("Производитель видеокарты: " + videocard.manufacture);
        System.out.println("Тип памяти: " + videocard.memorytype);
        System.out.println("Объём памяти: " + videocard.volumememory);
        System.out.println("Тип охлаждения: " + videocard.cooltype);
    }

    public void printinfo(Processor processor) {
        System.out.println();
        System.out.println("Хорактеристики процессора:");
        System.out.println("Количество ядер: " + processor.cores);
        System.out.println("Тактовая частота: " + processor.ggz);
        System.out.println("Объём кэш - памяти: " + processor.cashmemory);
        System.out.println("Название: " + processor.names);
        System.out.println("Производитель: " + processor.manufacture);
    }

    public void printinfo(Ram ram) {
        System.out.println();
        System.out.println("Характеристики оперативной памяти: ");
        System.out.println("Производитель: " + ram.manufacture);
        System.out.println("Объём памяти: " + ram.volume);
        System.out.println("Тактовая частота: " + ram.ggz);
        System.out.println("Тип: " + ram.type);
    }
}