package interfaces;

import entity.Accountant;

public interface AccountantFacade {

    String addAccountant(Accountant accountant);

    boolean logInAccountant(String login, String password);

    String removeAccountantById(int accountantId);

    String removeAccountantByLogin(String accountantLogin);

}
