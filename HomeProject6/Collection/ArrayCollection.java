import java.util.*;

public class ArrayCollection {
    private ArrayList<String> arraylist;
    private String item;
    private int index;

    ArrayCollection(ArrayList<String> arraylist) {
        this.arraylist = arraylist;
    }

    public int size() {
        return arraylist.size();
    }

    public void add(String item) {
        arraylist.add(item);
    }

    public void remove(int index) {
        arraylist.remove(index);
    }

    public void remove(String item) {
        arraylist.remove(item);
    }

    public String get(int index) {
        return arraylist.get(index);
    }

    public void clear() {
        arraylist.clear();
    }
}