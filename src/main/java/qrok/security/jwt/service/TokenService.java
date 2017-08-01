package qrok.security.jwt.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qrok.security.jwt.service.UserService;
import qrok.security.jwt.model.User;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private UserService userService;

    public String getToken(User user) throws ServletException {

        Map<String, Object> payload = new HashMap<>();

        if (user.getEmail() == null || user.getPassword() == null) {
            throw new ServletException("Username and password is empty");
        }

        String email = user.getEmail();
        String password = user.getPassword();

        User findUser = userService.findByEmail(email);

        if (findUser == null) {
            throw new ServletException("User not found");
        }

        String pass = findUser.getPassword();

        if (!password.equals(pass)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        payload.put("clientType", "user");
        payload.put("userID", user.getUserId());
        payload.put("username", user.getLastName() + " " + user.getFirstName());
        payload.put("token_create_date", new Date().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 100);
        payload.put("token_expiration_date", calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(payload);
        String key = "1111";
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS256, key).compact();

        return token;

    }

}
