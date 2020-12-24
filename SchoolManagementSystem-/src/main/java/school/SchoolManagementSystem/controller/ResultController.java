package school.SchoolManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import school.SchoolManagementSystem.model.Result;
import school.SchoolManagementSystem.model.Students;
import school.SchoolManagementSystem.repositories.ResultRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rest/user/student/result")
@RestController
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;
    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @PostMapping(value = "/student/result/post")
    public String enterStudentResult( @RequestParam String resultSubject, @RequestParam String resultTeacher, @RequestParam int resultMarksObtained, @RequestParam int resultClas, @RequestParam int resultMarksTotal, @RequestParam String studentDateOfBirth, @RequestParam String studentContact, @RequestParam String studentAddress) {
        Result result = new Result();
        result.setSubject(resultSubject);
        result.setTeacher(resultTeacher);
        result.setMarksObtained(resultMarksObtained);
        result.setClas(resultClas);
        result.setMarksTotal(resultMarksTotal);
        resultRepository.save(result);
        return "save";
    }
    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @PutMapping(value = "/student/result/update")
    public String updateStudentResult(@RequestParam int resultRollNo, @RequestParam String resultSubject, @RequestParam String resultTeacher, @RequestParam int resultMarksObtained, @RequestParam int resultClas, @RequestParam int resultMarksTotal, @RequestParam String studentDateOfBirth, @RequestParam String studentContact, @RequestParam String studentAddress) {
        Result result = new Result();
        result.setRollNo(resultRollNo);
        result.setSubject(resultSubject);
        result.setTeacher(resultTeacher);
        result.setMarksObtained(resultMarksObtained);
        result.setClas(resultClas);
        result.setMarksTotal(resultMarksTotal);
        resultRepository.save(result);
        return "save";
    }
    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @GetMapping(value = "/student/result/all")
    public List<Result> getAllResult(){
        return resultRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @GetMapping(value = "/student/result/select_by/student/{rollNo}")
    public Result getByRollNo(@PathVariable int rollNo){
        Optional<Result> all = resultRepository.findById(rollNo);
        if (all.isPresent()){
            return all.get();
        }else{
            throw new RuntimeException("Student's result not found for the roll no");
        }
    }
    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @DeleteMapping(value = "/student/result/delete/{rollNo}")
    public String dltStudent(@PathVariable int rollNo){
        Result delete = resultRepository.getOne(rollNo);
        resultRepository.delete(delete);
        return "deleted";
    }
}
