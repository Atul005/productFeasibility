package orderingLogic;
/*
 * @author atulyadav on 2019-08-28 01:08
 *
 * class where all of the ordering logic will be implemented
 */

import product.Product;

import java.util.List;

public interface OrderingLogic {
    List<Product> mostRelevantProducts(List<Product> products);
}
