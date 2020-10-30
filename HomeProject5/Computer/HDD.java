import java.util.*;

public class HDD {
    public String manufacture; // Производитель
    public String volumememory; // Объём памяти
    public HDDType hddtype;
    public String hddformfacture;

        public HDD(String manufacture, String volumememory, HDDType hddtype, String hddformfacture) {
            this.manufacture = manufacture;
            this.volumememory = volumememory;
            this.hddtype = hddtype;
            this.hddformfacture = hddformfacture;
        }


}