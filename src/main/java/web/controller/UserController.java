package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userService.getList();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }


    @GetMapping("/askDetails")
    public String askUserDetails(Model model) {
        model.addAttribute("user", new User());
        return "user-view";
    }


    @PostMapping("/showDetails")
    public String showUserDetails(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.delete(user);
        return "redirect:/";
    }

    @RequestMapping("/viewUser")
    public String viewUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "show-user-view";
    }


    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }






/*    @GetMapping
    public List<User> getUsers() {
        return userService.getList();
    }*/
}