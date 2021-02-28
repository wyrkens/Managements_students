package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private String lastName;
    private String PESEL;
    private Sex sex;
    private Classes classes;
    private String address;
    private String phoneNumber;
    private String eMail;
    private int cost;
    private int payment;
    private int debt;

    //String name, String lastName, String PESEL, char sex, String classes, String address, String phoneNumber, String eMail, int cost, int payment, int debt
    //name, lastName, PESEL, sex, classes, address, phoneNumber, eMail, cost, payment, debt

    public int getDebt() {
        return cost - payment;
    }

    public void setDebt(int debt) {
        this.debt = cost - payment;
    }
}
