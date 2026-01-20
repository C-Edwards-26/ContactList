public class Worker extends Person{
    private String job;

    public Worker(String firstName, String lastName, String phoneNumber, String job) {
        super(firstName, lastName, phoneNumber);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public String toString() {
        return super.toString() + "Job: " + job;
    }
}
