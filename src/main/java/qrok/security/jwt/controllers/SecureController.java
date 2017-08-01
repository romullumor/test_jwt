package qrok.security.jwt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qrok.security.jwt.model.User;
import qrok.security.jwt.service.UserService;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/users")
    public String loginSuccess() {
        return "Login Successful!";
    }

    @RequestMapping(value = "/user/email", method = RequestMethod.POST)
    public User findByEmail(@RequestBody String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/user/name", method = RequestMethod.POST)
    public User findByName(@RequestBody String name) {
        return userService.findByName(name);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
}