package school.SchoolManagementSystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Teacher")
public class Teachers {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_no")
    private int employeeNo;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "subject")
    private String subject;
    @Column(name = "period1")
    private String period1;
    @Column(name = "period2")
    private String period2;
    @Column(name = "period3")
    private String period3;
    @Column(name = "period4")
    private String period4;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "salary")
    private String salary;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_user", joinColumns = @JoinColumn(name = "employee_no"),inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Users> users;

    public Teachers() {
    }

    public Teachers(Teachers teachers) {
        this.employeeNo = teachers.getEmployeeNo();
        this.lastName = teachers.getLastName();
        this.firstName = teachers.getFirstName();
        this.subject = teachers.getSubject();
        this.period1 = teachers.getPeriod1();
        this.period2 = teachers.getPeriod2();
        this.period3 = teachers.getPeriod3();
        this.period4 = teachers.getPeriod4();
        this.contactNo = teachers.getContactNo();
        this.salary = teachers.getSalary();
        this.dateOfBirth = teachers.getDateOfBirth();
        this.address = teachers.getAddress();
        this.users = teachers.getUsers();
    }



    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPeriod1() {
        return period1;
    }

    public void setPeriod1(String period1) {
        this.period1 = period1;
    }

    public String getPeriod2() {
        return period2;
    }

    public void setPeriod2(String period2) {
        this.period2 = period2;
    }

    public String getPeriod3() {
        return period3;
    }

    public void setPeriod3(String period3) {
        this.period3 = period3;
    }

    public String getPeriod4() {
        return period4;
    }

    public void setPeriod4(String period4) {
        this.period4 = period4;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
