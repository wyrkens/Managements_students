package service;

import entity.Accountant;
import exception.*;
import interfaces.AccountantFacade;
import interfaces.AccountantService;

public class AccountantFacadeImpl implements AccountantFacade {

    private static AccountantFacade instance = null;
    private AccountantService accountantService = AccountantServiceImpl.getInstance();

    private AccountantFacadeImpl() {
    }

    public static AccountantFacade getInstance() {
        if (instance == null) {
            instance = new AccountantFacadeImpl();
        }
        return instance;
    }

    @Override
    public String addAccountant(Accountant accountant) {
        try {
            accountantService.addAccountant(accountant);
            return "Dodano księgowego.";
        } catch (AccountantLoginExistException
                | AccountantLoginToShortException
                | AccountantPasswordToShortException
                | StudentNameIsNullException
                | StudentLastNameIsNullException e) {
            return e.getMessage();
        }
    }


    @Override
    public boolean logInAccountant(String login, String password) {
        if (accountantService.isValidLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }

    @Override
    public String removeAccountantById(int accountantId) {
        accountantService.removeAccountantById(accountantId);
        return "Usunięto księgowego.";
    }

    @Override
    public String removeAccountantByLogin(String accountantLogin) {
        accountantService.removeAccountantByLogin(accountantLogin);
        return "Usunięto księgowego.";
    }
}
