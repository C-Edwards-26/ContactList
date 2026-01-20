public class Person {
    // Initialize the three base variables that every subclass will have: firstname, lastname, and phonenumber.
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor for these three variables, setting them to the input.
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //Getter methods for each variable.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //toString method that every subclass will use as it's base.
    public String toString() {
        return firstName + " " + lastName + " - " + phoneNumber;
    }
}
