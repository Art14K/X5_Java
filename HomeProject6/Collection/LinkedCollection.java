import java.util.*;

public class LinkedCollection {
    private LinkedList<String> linkedlist;
    private String item;
    private int index;

    LinkedCollection(LinkedList<String> linkedlist) {
        this.linkedlist = linkedlist;
    }

    public int size() {
        return linkedlist.size();
    }

    public void add(String item) {
        linkedlist.add(item);
    }

    public void remove(int index) {
        linkedlist.remove(index);
    }

    public void remove(String item) {
        linkedlist.remove(item);
    }

    public String get(int index) {
        return linkedlist.get(index);
    }

    public void clear() {
        linkedlist.clear();
    }
}