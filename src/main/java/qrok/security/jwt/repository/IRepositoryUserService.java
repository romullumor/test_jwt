package qrok.security.jwt.repository;

import org.springframework.stereotype.Repository;
import qrok.security.jwt.model.User;

@Repository
public interface IRepositoryUserService {
    User save(User user);
    User findByName(String userName);
    User findByEmail(String userEmail);


}
