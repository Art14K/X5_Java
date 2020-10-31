class Student {
    protected String FirstName;
    protected String LastName;
    protected String group;
    protected double averageMark;

    public Student(String FirstName, String LastName, String group, double averageMark) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    void who() {
        System.out.println("Студент");
        System.out.println();
    }


    double getScholarship() {
        if (averageMark == 5) {
            return 100;
        } else {return 80;}
    }
}