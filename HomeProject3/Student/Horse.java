class Horse extends Animal {
    private String name;
    public Horse(String food, String location, String name) {
        this.food = food;
        this.location = location;
        this.name = name;
    }

    void out_name() {
        System.out.println("Лошадь зовут " + name);
    }

    void makeNoise() {
        System.out.println("Животное нуждается в медицинской помощи");
    }

    void sleep() {
        System.out.println("Животное не хочет спать");
    }

    void eat() {
        System.out.println("Животное устало и голодно");
    }
}