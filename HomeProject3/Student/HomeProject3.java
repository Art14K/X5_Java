import java.util.*;
//------------------------------------------------
public class HomeProject3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название класса (для выхода введите exit) : ");
        String set = scan.nextLine();
        switch (set) {
            case "Phone":
                Phone telephone1 = new Phone("891056693", "Nokia", "120 г.");
                Phone telephone2 = new Phone("89045669122", "Samsung", "190 г.");
                Phone telephone3 = new Phone("89013905499", "IPhone", "156 г.");

                telephone1.out_date2();
                telephone2.out_date2();
                telephone3.out_date2();



                telephone1.receive_call("89140034590", "Иван");
                telephone1.receive_call("89037775490", "Татьяна");
                telephone3.receive_call("89056779021", "Виктор");

                System.out.println("Номера телефонов, которым будет отправлено сообщение: ");

                telephone1.SendMessage("890128644", "89013458864", "843200035", "8566007777", "89105431200", "89156667021");
                break;
//----------------------------------------------------------------------------------------------------------------------------------------------

            case "Animal":
                Veterinar doc = new Veterinar();
                Dog dog = new Dog("Собычий корм", "Тверь", "Палкан");
                Cat cat = new Cat("Кошачий корм Whiskas", "Москва", "Соня");
                Horse horse = new Horse("Сено", "Деревня Петровка", "Зорька");
                Animal [] massive = {dog, cat, horse};

                for (int i = 0; i < massive.length; i++) {
                    System.out.println();
                    massive[i].out_name();
                    doc.threatAnimal(massive[i]);
                    massive[i].makeNoise();
                    massive[i].sleep();
                    massive[i].eat();
                }
                break;
            //-----------------------------------------------------------------------------
            case "Student":
                Student stud  = new Student("Иван", "Максимво", "3", 5);
                Student stud1 = new Student("Николай", "Иванов", "3", 4.6);
                Aspirant asp = new Aspirant("Микропроцессоры", "Петр", "Прокопенко", "4", 4.2);
                Student [] std = {stud1, asp};

                for (int i = 0; i < std.length; i++) {
                    double stipendia = std[i].getScholarship();
                    std[i].who();
                    System.out.println("Стипендия составляет: " + stipendia);
                }
        }
    }
}

