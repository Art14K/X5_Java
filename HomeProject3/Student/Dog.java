class Dog extends Animal {
    private String name;
    public Dog(String food, String location, String name) {
        this.food = food;
        this.location = location;
        this.name = name;
    }
    void out_name() {
        System.out.println("Собаку зовут " + name);

    }


    void makeNoise() {
        System.out.println("Животное не нуждается в медицинской помощи");
    }

    void sleep() {
        System.out.println("Животное не хочет спать");
    }

    void eat() {
        System.out.println("Животное не голодное");
    }
}
