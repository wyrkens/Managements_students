package exception;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StudentLastNameIsNullException extends Exception {

    private String message;
}
