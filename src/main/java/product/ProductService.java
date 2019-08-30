package product;
/*
 * @author atulyadav on 2019-08-27 14:37
 *
 * product related operations
 */

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    List<Product> getProducts(Query query);

    boolean editProduct(String productId);
    // we can write other features also

}
