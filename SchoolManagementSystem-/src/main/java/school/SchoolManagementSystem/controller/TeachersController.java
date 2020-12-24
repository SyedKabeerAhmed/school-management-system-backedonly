package school.SchoolManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import school.SchoolManagementSystem.model.Students;
import school.SchoolManagementSystem.model.Teachers;
import school.SchoolManagementSystem.repositories.TeachersRepository;

import java.util.List;
import java.util.Optional;
 //only admin will be having rights to update add delete or view the details of any teacher
@RequestMapping("/rest/teacher")
@RestController
public class TeachersController {

    @Autowired
    private TeachersRepository teachersRepository;
    @PreAuthorize("hasAnyRole('admin')")
    @PostMapping(value = "/teacher/new/data")
    public String postTeacherData( @RequestParam String teacherLastName, @RequestParam String teacherFirstName, @RequestParam String teacherSalary, @RequestParam String teacherPeriod1, @RequestParam String teacherPeriod2, @RequestParam String teacherPeriod3, @RequestParam String teacherPeriod4, @RequestParam String teacherSubject, @RequestParam String teacherDateOfBirth, @RequestParam String teacherContactNo, @RequestParam String teacherAddress) {
        Teachers teacher = new Teachers();
        teacher.setLastName(teacherLastName);
        teacher.setFirstName(teacherFirstName);
        teacher.setSalary(teacherSalary);
        teacher.setPeriod1(teacherPeriod1);
        teacher.setPeriod2(teacherPeriod2);
        teacher.setPeriod3(teacherPeriod3);
        teacher.setPeriod4(teacherPeriod4);
        teacher.setSubject(teacherSubject);
        teacher.setDateOfBirth(teacherDateOfBirth);
        teacher.setContactNo(teacherContactNo);
        teacher.setAddress(teacherAddress);
        teachersRepository.save(teacher);
        return "save";
    }
    @PreAuthorize("hasAnyRole('admin')")
    @PutMapping(value = "/teacher/update/data")
    public String updateTeacherData(@RequestParam int teacherEmployeeNo, @RequestParam String teacherLastName, @RequestParam String teacherFirstName, @RequestParam String teacherSalary, @RequestParam String teacherPeriod1, @RequestParam String teacherPeriod2, @RequestParam String teacherPeriod3, @RequestParam String teacherPeriod4, @RequestParam String teacherSubject, @RequestParam String teacherDateOfBirth, @RequestParam String teacherContactNo, @RequestParam String teacherAddress) {
        Teachers teacher = new Teachers();
        teacher.setEmployeeNo(teacherEmployeeNo);
        teacher.setLastName(teacherLastName);
        teacher.setFirstName(teacherFirstName);
        teacher.setSalary(teacherSalary);
        teacher.setPeriod1(teacherPeriod1);
        teacher.setPeriod2(teacherPeriod2);
        teacher.setPeriod3(teacherPeriod3);
        teacher.setPeriod4(teacherPeriod4);
        teacher.setSubject(teacherSubject);
        teacher.setDateOfBirth(teacherDateOfBirth);
        teacher.setContactNo(teacherContactNo);
        teacher.setAddress(teacherAddress);
        teachersRepository.save(teacher);
        return "save";
    }
    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping(value = "/teacher/all_teachers")
    public List<Teachers> getAllTeacher(){
        return teachersRepository.findAll();
    }
    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping(value = "/teacher/select_by/teachers/{employeeNo}")
    public Teachers getTeacherByEmployeeNo(@PathVariable int employeeNo){
        Optional<Teachers> all = teachersRepository.findById(employeeNo);
        if (all.isPresent()){
            return all.get();
        }else{
            throw new RuntimeException("Teacher not found for the roll no");
        }
    }
    @PreAuthorize("hasAnyRole('admin')")
    @DeleteMapping(value = "/teacher/delete/{employeeNo}")
    public String dltTeacher(@PathVariable int employeeNo){
        Teachers delete = teachersRepository.getOne(employeeNo);
        teachersRepository.delete(delete);
        return "deleted";
    }
}
