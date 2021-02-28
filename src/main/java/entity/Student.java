package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String lastName;
    private String pesel;
    private Sex sex;
    private Classes classes;
    private String address;
    private String phoneNumber;
    private String eMail;
    private int cost;
    private int payment;
    private int debt;

    //String name, String lastName, String pesel, Sex sex, Classes classes, String address, String phoneNumber, String eMail, int cost, int payment, int debt
    //name, lastName, pesel, sex, classes, address, phoneNumber, eMail, cost, payment, debt

    public int getDebt() {
        return cost - payment;
    }

    public void setDebt(int debt) {
        this.debt = cost - payment;
    }
}
