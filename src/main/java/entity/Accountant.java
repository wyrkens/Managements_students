package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Accountant {

    private int id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String eMail;

}
