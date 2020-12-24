package school.SchoolManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import school.SchoolManagementSystem.model.Users;
import school.SchoolManagementSystem.repositories.UsersRepository;

@RequestMapping("/rest/school")
@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/all")
    public String welcomePage(){
        return ("Welcome To ABC School");
    }

    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    @GetMapping("/teacher/welcome")
    public String welcomeTeachers(){
        return ("Welcome To All Teachers Teacher are having the control on student section");

    }

    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping("/admin/welcome")
    public String WelcomeAdmin(){
     return ("Welcome Admin, Admin is having all the control on teacher and student section");

    }
//API ("/admin/add_users") is for adding new teacher as a user and generating username and password for them
    @PreAuthorize("hasAnyRole('admin')")
    @PostMapping("/admin/add_users")
    public Users save(@RequestBody Users users){
        usersRepository.save(users);
        return null;
    }
    //API ("/admin/add_users") this can be use as forget password and updating username and password for existing teacher/user
    @PreAuthorize("hasAnyRole('admin')")
    @PutMapping("/admin/update_users")
    public Users update(@RequestBody Users users){
        usersRepository.save(users);
        return null;
    }

  //  delete users will be performed through teachers controller

}
