package validator;

import entity.Student;
import exception.StudentLastNameIsNullException;
import exception.StudentNameIsNullException;
import exception.StudentPeselIsNullException;

public class StudentValidator {

    private static StudentValidator instance = null;
    private final int PESEL_LENGTH = 11;

    private StudentValidator() {
    }

    public static StudentValidator getInstance() {
        if (instance == null) {
            instance = new StudentValidator();
        }
        return instance;
    }

    public boolean isValidate(Student student) throws StudentNameIsNullException, StudentLastNameIsNullException,
            StudentPeselIsNullException {
        if (isNameEmpty(student.getName())) {
            throw new StudentNameIsNullException("Imię jest puste.");
        }
        if (isLastNameEmpty(student.getLastName())) {
            throw new StudentLastNameIsNullException("Nazwisko jest puste.");
        }
        if (isValidPesel(student.getPesel())) {
            throw new StudentPeselIsNullException("Pesel musi mieć 11 znaków.");
        }
        return true;
    }

    private boolean isNameEmpty(String studentName) {
        return studentName.length() == 0;
    }

    private boolean isLastNameEmpty(String studentLastName) {
        return studentLastName.length() == 0;
    }

    private boolean isValidPesel(String studentPesel) {
        return studentPesel.length() != PESEL_LENGTH;
    }
}
