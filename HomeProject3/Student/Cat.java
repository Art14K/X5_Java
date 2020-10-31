class Cat extends Animal {
    private String name;
    public Cat(String food, String location, String name) {
        this.food = food;
        this.location = location;
        this.name = name;
    }

    void out_name() {
        System.out.println("Кошку зовут " + name);

    }

    void makeNoise() {
        System.out.println("Животное не нуждается в медицинской помощи");
    }

    void sleep() {
        System.out.println("Животное хочет спать");
    }


    void eat() {
        System.out.println("Животное не голодное");
    }
}