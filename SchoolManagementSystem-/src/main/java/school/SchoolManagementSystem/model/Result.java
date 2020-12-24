package school.SchoolManagementSystem.model;


import javax.persistence.*;

@Entity
@Table(name = "result")
public class Result {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roll_no_result")
    private int rollNo;
    @Column(name = "subject")
    private String subject;
    @Column(name = "class")
    private int clas;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "marks_total")
    private int marksTotal;
    @Column(name = "marks_obtained")
    private int marksObtained;

    public Result() {
    }
    public Result(Result result){
        this.rollNo = result.getRollNo();
        this.subject = result.getSubject();
        this.clas = result.getClas();
        this.teacher = result.getTeacher();
        this.marksObtained = result.getMarksObtained();
        this.marksTotal = result.getMarksTotal();
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getMarksTotal() {
        return marksTotal;
    }

    public void setMarksTotal(int marksTotal) {
        this.marksTotal = marksTotal;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }
}
