package exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AccountantPasswordToShortException extends Exception{

    private String message;
}
