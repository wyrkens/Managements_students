package interfaces;

import entity.Accountant;

import java.util.List;

public interface AccountantService {

    void addAccountant();

    void removeAccountantById(int accountantId);

    List<Accountant> getAllAccountant();

    int getAccountantCount();

    Accountant getAccountantByName(String accountantName);

    Accountant getAccountantByLastName(String accountantLastName);

}
