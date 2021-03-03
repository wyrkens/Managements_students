package validator;

import entity.Student;

public class StudentValidator {

    private static StudentValidator instance = null;
    private final int PESEL_LENGTH = 11;

    private StudentValidator() {
    }

    public static StudentValidator getInstance() {
        if (instance == null) {
            return new StudentValidator();
        }
        return instance;
    }

    public boolean isValidate(Student student) {
        if (isNameEmpty(student.getName())) {
            throw new studentNameIsNullException("Imię jest puste.");
        }
        if (isLastNameEmpty(student.getLastName())) {
            throw new studentLastNameIsNullException("Nazwisko jest puste.");
        }
        if (isValidPesel(student.getPesel())) {
            throw new studentPeselIsNullException("Pesel musi mieć 11 znaków.");
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
