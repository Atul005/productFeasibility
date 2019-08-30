package ExceptionTranslator;
/*
 * @author atulyadav on 2019-08-27 21:52
 *
 *
 *
 * custom Exception for error occured while generating unique sequence for products
 */

public class SequenceException extends RuntimeException {

    private String errorMessage;

    public SequenceException(String errorMessage){
        super(errorMessage);
    }
}
