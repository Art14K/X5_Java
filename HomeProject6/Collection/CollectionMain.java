import java.util.*;

public class CollectionMain {
    public static void main (String[] args) {
        String bmw = "bmw";
        String audi = "audi";
        String renault = "renault";
        String toyota = "toyota";
        String element;

        ArrayList<String> autoCollection = new ArrayList<>(Arrays.asList(bmw, audi, renault));
        ArrayCollection arraycollection = new ArrayCollection(autoCollection);
        System.out.println();
        System.out.println("Коллекция: " + autoCollection);
        System.out.println("Размер коллекции: " + arraycollection.size());
        System.out.println("Добавляем элемент " + toyota + " в коллекцию");
        arraycollection.add(toyota);
        System.out.println("Размер коллекции: " + arraycollection.size());
        System.out.println("Теперь коллекция выглядит так: " + autoCollection);
        System.out.println("Удаляем первый элемент из коллекции");
        arraycollection.remove(0);
        System.out.println("Теперь коллекция выглядит так: " + autoCollection);
        System.out.println("Удалим элемент renault");
        arraycollection.remove("renault");
        System.out.println("Теперь коллекция выглядит так: " + autoCollection);
        System.out.println("Получим первый элемент из коллекции");
        element = arraycollection.get(0);
        System.out.println("Получили элемент " + element);
        System.out.println("Полностью очищаем коллекцию ");
        arraycollection.clear();
        System.out.println("Теперь коллекция выглядит так: " + autoCollection);


        LinkedList<String> autocollection = new LinkedList<>();
        autocollection.add(bmw);
        autocollection.add(audi);
        autocollection.add(renault);
        LinkedCollection linkedcollection = new LinkedCollection(autocollection);
        System.out.println();
        System.out.println("Коллекция на основе связанного списка: " + autocollection);
        System.out.println("Размер коллекции: " + linkedcollection.size());
        System.out.println("Добавляем элемент " + toyota + " в коллекцию");
        linkedcollection.add(toyota);
        System.out.println("Размер коллекции: " + linkedcollection.size());
        System.out.println("Теперь коллекция выглядит так: " + autocollection);
        System.out.println("Удаляем второй элемент из коллекции");
        linkedcollection.remove(1);
        System.out.println("Теперь коллекция выглядит так: " + autocollection);
        System.out.println("Удалим элемент renault");
        linkedcollection.remove("renault");
        System.out.println("Теперь коллекция выглядит так: " + autocollection);
        System.out.println("Получим первый элемент из коллекции");
        element = linkedcollection.get(0);
        System.out.println("Получили элемент " + element);
        System.out.println("Полностью очищаем коллекцию ");
        linkedcollection.clear();
        System.out.println("Теперь коллекция выглядит так: " + autocollection);

    }

}