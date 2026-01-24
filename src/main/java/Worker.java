public class Worker extends Person{
    // Instance variable job, specific to Worker subclass
    private String job;

    // Constructor for Worker. takes in all variables, and passes three through the superclass,
    // and sets job equal to input.
    public Worker(String firstName, String lastName, String phoneNumber, String job) {
        super(firstName, lastName, phoneNumber);
        this.job = job;
    }

    // Getter for job.
    public String getJob() {
        return job;
    }

    // toString using the superclasses toString as a base.
    public String toString() {
        return super.toString() + " Job: " + job;
    }
}
