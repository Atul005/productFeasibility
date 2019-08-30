package ExceptionTranslator;/*
 * @author atulyadav on 2019-08-27 23:20
 *
 *
 * custom Exception for error occured while validating
 */

public class ValidationFailedException extends RuntimeException {
    private String errorMessage;

    public ValidationFailedException(String errorMessage) {
        super(errorMessage);
    }
}
