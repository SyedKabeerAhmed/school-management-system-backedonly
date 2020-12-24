package school.SchoolManagementSystem.model;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roll_no")
    private int rollNo;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "class")
    private int clas;
    @Column(name = "edu_group")
   private String group;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "contact")
    private String contact;
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_result", joinColumns = @JoinColumn(name ="roll_no"), inverseJoinColumns = @JoinColumn(name = "roll_no_result"))
    private Set<Result> results;

    public Students() {
    }

    public Students (Students students){

        this.lastName = students.getLastName();
        this.firstName = students.getFirstName();
        this.fatherName = students.getFatherName();
        this.clas = students.getClas();
        this.group = students.getGroup();
        this.dateOfBirth = students.getDateOfBirth();
        this.contact = students.getContact();
        this.address = students.getAddress();
        this.results = students.getResults();
        this.rollNo = students.getRollNo();

    }



    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }


}