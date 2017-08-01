package qrok.security.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qrok.security.jwt.model.User;
import qrok.security.jwt.service.TokenService;
import qrok.security.jwt.service.UserService;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) throws ServletException {
        return tokenService.getToken(user);
    }



}
