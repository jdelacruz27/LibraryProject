package com.sparta.jian.libraryproject.controllers;

import com.sparta.jian.libraryproject.entities.UserEntity;
import com.sparta.jian.libraryproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountManagementController {

    private UserService userService;

    @Autowired
    public AccountManagementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/accountsPage")
    public String showAccounts(Model model) {
        model.addAttribute("accounts", userService.getAllUsersByArray());
        return "accountManager";
    }

    @GetMapping("/addAccount")
    public String showAddAccountPage(){
        return "addAccount";
    }

    @PostMapping("/addAccount")
    public String addAccount(@RequestParam(name="username") String username,
                             @RequestParam(name="password") String password,
                             @RequestParam(name="confirm") String confirm,
                             @RequestParam(name="role") String role){

        UserEntity userEntity = new UserEntity();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(password.equals(confirm)){
            userEntity.setUserName(username);
            userEntity.setUserEnabled(1);
            userEntity.setUserRole(role);
            userEntity.setUserPassword(encoder.encode(password));
            userService.addUser(userEntity);
        }
        return "redirect:/accountsPage";


    }

    @GetMapping("/changePassword/{id}")
    public String showEditPasswordPage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("account", userService.findUserById(id));
        return "editPassword";
    }

    @PostMapping("/changePassword/{id}")
    public String updatePassword(@PathVariable("id") Integer id,
                                 @RequestParam(name="newPassword") String password,
                                 @RequestParam(name="confirmNew") String confirm,
                                 @RequestParam(name="role") String role){

        UserEntity userEntity = new UserEntity();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(password.equals(confirm)) {
            userEntity.setUserId(id);
            userEntity.setUserName(userService.findUserById(id).getUserName());
            userEntity.setUserEnabled(1);
            userEntity.setUserRole(role);
            userEntity.setUserPassword(encoder.encode(password));
            userService.addUser(userEntity);
        }

        return "redirect:/accountsPage";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteAccount(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/accountsPage";
    }

}
