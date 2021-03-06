package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accountant {

    private int id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String eMail;

    public Accountant(String name, String lastName, String login, String password, String eMail) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.eMail = eMail;
    }

    //int id, String name, String lastName, String login, String password, String eMail
    //id, name, lastName, login, password, eMail
}
