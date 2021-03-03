package service;

import entity.Accountant;
import interfaces.AccountantDbo;
import interfaces.AccountantService;
import validator.AccountantValidator;

import java.util.List;

public class AccountantServiceImpl implements AccountantService {

    private static AccountantServiceImpl instance = null;
    private AccountantDbo accountantDbo = AccountantDboImpl.getInstance();
    private AccountantValidator accountantValidator = AccountantValidator.getInstance();

    private AccountantServiceImpl() {
    }

    public static AccountantServiceImpl getInstance() {
        if (instance == null) {
            return new AccountantServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean addAccountant(Accountant accountant) {
        if (isLoginExist(accountant.getLogin())) {
            throw new AccountantLoginExistException();
        }
        if (accountantValidator.isValidate(accountant)) {
            accountantDbo.addAccountant(accountant);
            return true;
        }
        return false;
    }

    private boolean isLoginExist(String login) {
        Accountant accountant = getAccountantByLogin(login);
        return accountant != null;
    }

    @Override
    public void removeAccountantById(int accountantId) {
        accountantDbo.removeAccountantById(accountantId);
    }

    @Override
    public void removeAccountantByLogin(String accountantLogin) {
        accountantDbo.removeAccountantByLogin(accountantLogin);
    }

    @Override
    public List<Accountant> getAllAccountants() {
        return accountantDbo.getAllAccountants();
    }

    @Override
    public int getAccountantCount() {
        return getAllAccountants().size();
    }

    @Override
    public Accountant getAccountantByLogin(String accountantLogin) {
        List<Accountant> accountantList = getAllAccountants();
        for (Accountant accountants : accountantList) {
            if (accountants.getLogin().equals(accountantLogin)) {
                return accountants;
            }
        }
        return null;
    }

    public boolean isValidLoginAndPassword(String login, String password) {
        Accountant accountant = getAccountantByLogin(login);
        if (accountant == null) {
            return false;
        }
        boolean isValidLogin = accountant.getLogin().equals(login);
        boolean isValidPassword = accountant.getPassword().equals(password);
        return isValidLogin && isValidPassword;

    }
}
