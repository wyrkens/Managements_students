package interfaces;

import entity.Accountant;
import entity.Student;

import java.util.List;

public interface AccountantDbo {

    void addAccountant(Accountant accountant);

    void removeAccountantById(int accountantId);

    void removeAccountantByLogin(String accountantLogin);

    List<Accountant> getAllAccountants();

    void modifyAccountant(Accountant accountant);
}
