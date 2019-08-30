package sequence;/*
 * @author atulyadav on 2019-08-27 21:01
 */

import ExceptionTranslator.SequenceException;

public interface SequenceService {

    long getNextSequenceId(String key) throws SequenceException;
}
