package qrok.security.jwt.service;


import qrok.security.jwt.model.User;

public interface IUserService {
    User save(User user);
    User findByName(String userName);
    User findByEmail(String userEmail);
}
