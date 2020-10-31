class Phone {
    private String number;
    private String model;
    private String weight;

    public Phone(String number, String model, String weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;

    }

    void out_date() {
        System.out.println("Данные телефона:");
        System.out.println("-----------------");
        System.out.println("Вес телефона: " + weight);
    }

    void out_date2() {
        System.out.println("Данные телефона:");
        System.out.println("-----------------");
        System.out.println("Номер телефона: " + number);
        System.out.println("Модель телефона: " + model);
        System.out.println("Вес телефона: " + weight);
    }

    void receive_call(String inv_number) { //Конструктор с именем звонящего
        System.out.println();
        System.out.println("Вам звонит: " + inv_number);
    }

    void receive_call(String out_number, String out_name) {
        System.out.println();
        System.out.println("Вам звонит: " + out_number + " " + out_name);
    }

    void SendMessage(String...input) {
        String [] inv = input;
        for (int i = 0; i < inv.length; i++) {
            System.out.println("Номер телефона: " + inv[i]);
        }
    }
}
//_________________________________________________________________________________