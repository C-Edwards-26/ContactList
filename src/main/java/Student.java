public class Student extends Person{
    // Instance variable, grade, specific to Student subclass.
    private int grade;

    // Constructor for Student. takes in all variables, and passes three through the superclass,
    // and sets grade equal to input.
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter for grade.
    public int getGrade() {
        return grade;
    }

    // toString using the superclasses toString as a base.
    public String toString() {
        return super.toString() + "Grade: " + grade;
    }

}
