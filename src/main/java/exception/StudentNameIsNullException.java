package exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class StudentNameIsNullException extends Exception {

    private String message;
}
