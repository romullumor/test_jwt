package qrok.security.jwt.service;


import org.springframework.beans.factory.annotation.Autowired;
import qrok.security.jwt.model.User;
import qrok.security.jwt.repository.IRepositoryUserService;

public class UserService implements IUserService{

    @Autowired
    private IRepositoryUserService iRepositoryUserService;

    @Override
    public User save(User user) {
        return iRepositoryUserService.save(user);
    }

    @Override
    public User findByName(String userName) {
        return iRepositoryUserService.findByName(userName);
    }

    @Override
    public User findByEmail(String userEmail) {
        return iRepositoryUserService.findByEmail(userEmail);
    }
}
