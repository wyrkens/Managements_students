package validator;

import entity.Accountant;

public class AccountantValidator {

    private static AccountantValidator instance = null;
    private final int LOGIN_MIN_LENGTH = 5;
    private final int PASSWORD_MIN_LENGTH = 8;

    private AccountantValidator() {
    }

    public static AccountantValidator getInstance() {
        if (instance == null) {
            return new AccountantValidator();
        }
        return instance;
    }

    public boolean isValidate(Accountant accountant) {
        if (isLoginEnough(accountant.getLogin())) {
            throw new accountantLoginToShortException("Login jest za krótki.");
        }
        if (isPasswordEnough(accountant.getPassword())) {
            throw new accountantPasswordToShortException("Hasło jest za krótke.");
        }
        if (isNameEmpty(accountant.getName())) {
            throw new accountantNameIsNullException("Imię jest puste.");
        }
        if (isLastNameEmpty(accountant.getLastName())) {
            throw new accountantLastNameIsNullException("Nazwisko jest puste.");
        }
        return true;
    }

    private boolean isLoginEnough(String login) {
        return login.length() < LOGIN_MIN_LENGTH;
    }

    private boolean isPasswordEnough(String password) {
        return password.length() < PASSWORD_MIN_LENGTH;
    }

    private boolean isNameEmpty(String studentName) {
        return studentName.length() == 0;
    }

    private boolean isLastNameEmpty(String studentLastName) {
        return studentLastName.length() == 0;
    }
}
