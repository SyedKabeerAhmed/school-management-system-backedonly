package school.SchoolManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import school.SchoolManagementSystem.model.Students;
import school.SchoolManagementSystem.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rest/user/students")
@RestController
public class StudentsController {


    @Autowired
    private StudentsRepository studentsRepository;
    // student Bio data form page only Admin is having the right to add new students data
    @PreAuthorize("hasAnyRole('admin')")
    @PostMapping(value = "/student/registration")
    public String addNewStudent( @RequestParam String studentLastName, @RequestParam String studentFirstName, @RequestParam String studentFatherName, @RequestParam int studentClas, @RequestParam String studentGroup, @RequestParam String studentDateOfBirth, @RequestParam String studentContact, @RequestParam String studentAddress) {
        Students s = new Students();
        s.setLastName(studentLastName);
        s.setFirstName(studentFirstName);
        s.setFatherName(studentFatherName);
        s.setClas(studentClas);
        s.setGroup(studentGroup);
        s.setDateOfBirth(studentDateOfBirth);
        s.setContact(studentContact);
        s.setAddress(studentAddress);
        studentsRepository.save(s);
        return "save";
    }
//student update form page only admin is having rights to update student data
    @PreAuthorize("hasAnyRole('admin')")
    @PutMapping(value = "/student/update")
    public String updateStudentData(@RequestParam int studentRollNo, @RequestParam String studentLastName, @RequestParam String studentFirstName, @RequestParam String studentFatherName, @RequestParam int studentClas, @RequestParam String studentGroup, @RequestParam String studentDateOfBirth, @RequestParam String studentContact, @RequestParam String studentAddress) {
        Students s = new Students();
        s.setRollNo(studentRollNo);
        s.setLastName(studentLastName);
        s.setFirstName(studentFirstName);
        s.setFatherName(studentFatherName);
        s.setClas(studentClas);
        s.setGroup(studentGroup);
        s.setDateOfBirth(studentDateOfBirth);
        s.setContact(studentContact);
        s.setAddress(studentAddress);
        studentsRepository.save(s);
        return "save";
    }
    //details of all the students, teacher and admin both are having the right to view the student details
    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @GetMapping(value = "/student/all_students")
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @GetMapping(value = "/students/select_by/student/{rollNo}")
    public Students get(@PathVariable int rollNo){
        Optional<Students> all = studentsRepository.findById(rollNo);
        if (all.isPresent()){
            return all.get();
        }else{
            throw new RuntimeException("Student not found for the roll no");
        }
    }

    @PreAuthorize("hasAnyRole('admin')")
    @DeleteMapping(value = "/student/delete/{rollNo}")
    public String dltStudent(@PathVariable int rollNo){
        Students delete = studentsRepository.getOne(rollNo);
        studentsRepository.delete(delete);
                return "deleted";
    }


}

