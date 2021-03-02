package interfaces;

import entity.Accountant;

import java.util.List;

public interface AccountantService {

    void addAccountant();

    void removeAccountantById(int accountantId);

    void removeAccountantByLogin(String accountantLogin);

    List<Accountant> getAllAccountants();

    int getAccountantCount();

    Accountant getAccountantByLogin(String accountantLogin);

    boolean isCorrectLoginAndPassword(String login, String password);

}
