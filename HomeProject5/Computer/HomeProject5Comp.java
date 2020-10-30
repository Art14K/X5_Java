import java.util.*;

public class HomeProject5Comp {
     public static void main(String[] args) {

        Processor processor = new Processor("8", "3,4", "3MB", "Intel Xeon", "Intel");
        Ram ram = new Ram("AMD", "32GB", "1,6 GGZ", "DDR3");
        Videocard videocard = new Videocard("Nvidia", "GDDR5", "12GB", CoolType.Активное);
        HDD hdd = new HDD("Western Digital", "500GB", HDDType.SSD, "2,5 дюйма");
        InfoOut infoout = new InfoOut(hdd, videocard, processor, ram);

        infoout.printinfo(processor);
        infoout.printinfo(ram);
        infoout.printinfo(videocard);
        infoout.printinfo(hdd);

    }
}