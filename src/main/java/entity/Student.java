package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    private String PESEL;
    private char sex;
    private String classes;
    private String address;
    private String phoneNumber;
    private String eMail;
    private int cost;
    private int payment;
    private int debt;

}
