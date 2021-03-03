package interfaces;

import entity.Accountant;
import exception.*;

import java.util.List;

public interface AccountantService {

    boolean addAccountant(Accountant accountant) throws AccountantLoginExistException, AccountantLoginToShortException,
            AccountantPasswordToShortException, StudentNameIsNullException, StudentLastNameIsNullException;

    void removeAccountantById(int accountantId);

    void removeAccountantByLogin(String accountantLogin);

    List<Accountant> getAllAccountants();

    int getAccountantCount();

    Accountant getAccountantByLogin(String accountantLogin);

    boolean isValidLoginAndPassword(String login, String password);

}
