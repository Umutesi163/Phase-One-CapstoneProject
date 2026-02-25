public class Instructor extends Person {
    private String department;
    private String officeNumber;

    public Instructor(String name, String email, String department, String officeNumber) {
        super(name, email);
        this.department = department;
        this.officeNumber = officeNumber;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getOfficeNumber() { return officeNumber; }
    public void setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; }

    @Override
    public String getProfile() {
        return "Instructor{" +
                "Name='" + getName() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Department='" + department + '\'' +
                ", Office='" + officeNumber + '\'' +
                '}';
    }
}