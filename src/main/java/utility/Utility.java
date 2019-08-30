package utility;/*
 * @author atulyadav on 2019-08-27 16:58
 *
 * utility methods
 */

import ExceptionTranslator.ValidationFailedException;

import java.util.Collection;

public class Utility {

    public static boolean isEmptyCollection(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmptyCollection(Collection collection) {
        return !isEmptyCollection(collection);
    }

    public static boolean isEmptyString(String str){
        return null == str || "".equals(str);
    }

    public static boolean isNotEmptyString(String str){
        return !isEmptyString(str);
    }

    public static void validateNotNull(Object object){
        if(null == object){
            throw  new ValidationFailedException("[ERROR] field can not be null");
        }
    }

}
