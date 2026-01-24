import java.util.ArrayList;
import java.util.Scanner;

// Manages a list of contacts and provides menu interactions for searching adding and displaying those contacts.
public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        // Stores all contacts (Person, Student, or Worker) in newly initialize contact list.
        contacts = new ArrayList<>();

    }
    // Returns the full list of contacts
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds a new contact to the List
    public void addContact(Person n) {
        contacts.add(n);
    }

    // Prints all contacts in the list
    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    //Sorts the contacts using bubble sort
    public void sort(int sortBy) {
        int num = contacts.size();

        // Bubble sort algorithm
        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - i - 1; j++) {

                // Compare adjacent contacts and swap if out of order
                if (compare(contacts.get(j), contacts.get(j + 1), sortBy) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    // Compares two Person objects based on selected field.
    private int compare(Person a, Person b, int sortBy) {
        if (sortBy == 0) {
            return compareStrings(a.getFirstName(), (b.getFirstName()));
        }
        if (sortBy == 1) {
            return compareStrings(a.getLastName(), (b.getLastName()));
        }
            // Default: compare by phone number
            return compareStrings(a.getPhoneNumber(), (b.getPhoneNumber()));
    }

   // Compares two strings charecter by charecter
    private int compareStrings(String s1, String s2) {
        int len = Math.min(s1.length(),s2.length());

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        return s1.length() - s2.length();
    }

    // Searches for a contact by first name
    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }

    // Searches for a contact by last name
    public Person searchByLastName(String lastName) {
        for (Person contact: contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    // Searches for a contact by phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    // Prints only contacts that are Students
    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    // Runs the menu-driven contact page
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        // Loop untill user chooses to exit
        do {
            System.out.println("Menu: " + "\n 1. Add Contact " + "\n 2. List Contacts" + "\n 3. Search by First Name"
                    + "\n 4. Search by Last Name" + "\n 5. Search by Phone Number" + "\n 6. List Students" +
                    "\n 7. Sort Contacts" + "\n 0. Exit" + "\n Enter your choice: ");
            choice = scanner.nextInt(); // Get user's choice
            scanner.nextLine();
            // Perform action based on user's choice
            switch(choice) {
                case 1 -> {
                    // Adding a new contact and getting contact information
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Is the contact a Student or Worker (S/E) ");
                    char type = scanner.next().charAt(0);
                    scanner.nextLine();
                    // Checking if the new contcact is a student or worker
                    if (type == 'S' || type == 'S') {
                        System.out.print("Enter grade: ");
                        int grade = scanner.nextInt();
                        scanner.nextLine();
                        addContact(new Student(firstName, lastName, phoneNumber, grade));
                    } else if (type == 'w' || type == 'W') {
                        System.out.print("Enter job: ");
                        String job = scanner.nextLine();
                        addContact(new Worker(firstName, lastName, phoneNumber, job));
                    }
                }
                case 2 -> printContacts();
                case 3 -> {
                    System.out.print("Enter first name to search: ");
                    String firstName = scanner.nextLine();
                    Person result = searchByFirstName(firstName);
                    if (result == null) {
                        System.out.println(firstName + " is not in the list");
                    } else {
                        System.out.println(result);
                    }
                }
                case 4 -> {
                    System.out.print("Enter last name to search: ");
                    String lastName = scanner.nextLine();
                    Person result = searchByLastName(lastName);
                    if (result == null) {
                        System.out.println(lastName + " is not in the list");
                    } else {
                        System.out.println(result);
                    }
                }
                case 5 -> {
                    System.out.print("Enter phone number to search: ");
                    String phoneNumber = scanner.nextLine();
                    Person result = searchByPhoneNumber(phoneNumber);
                    if (result == null) {
                        System.out.println(phoneNumber + " is not in the list");
                    } else {
                        System.out.println(result);
                    }
                }
                case 6 -> listStudents();
                case 7 -> {
                    System.out.print("Sort by (0: First Name, 1: Last Name, 2: Phone Number): ");
                    int sortBy = scanner.nextInt();
                    scanner.nextLine();
                    sort(sortBy);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
