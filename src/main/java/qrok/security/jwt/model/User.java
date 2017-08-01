package qrok.security.jwt.model;

import lombok.Data;
import java.util.Date;

@Data
public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date created;
}