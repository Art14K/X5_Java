class Aspirant extends Student {
    private String work;
    public Aspirant(String work, String FirstName, String LastName, String group, double averageMark) {
        super(FirstName, LastName, group, averageMark);
        this.work = work;
    }

    void who() {
        System.out.println("Аспирант");
        System.out.println();
    }



    double getScholarship() {
        if (averageMark == 5) {
            return 200;
        } else {
            return 180;
        }
    }
}