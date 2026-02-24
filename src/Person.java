/**
 * Abstract base class for all persons in the university system.
 * Cannot be instantiated directly — must be extended by concrete classes.
 */
public abstract class Person {
    private String name;   // Full name of the person
    private String email;  // Email address

    /**
     * Constructs a new Person with the given name and email.
     * @param name the person's name
     * @param email the person's email address
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter for name
    public String getName() { return name; }

    // Setter for name
    public void setName(String name) { this.name = name; }

    // Getter for email
    public String getEmail() { return email; }

    // Setter for email
    public void setEmail(String email) { this.email = email; }

    /**
     * Abstract method to get a profile summary.
     * Must be implemented by all subclasses (e.g., Student, Instructor).
     * @return a formatted string with person details
     */
    public abstract String getProfile();
}