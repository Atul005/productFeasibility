package search;/*
 * @author atulyadav on 2019-08-27 16:42
 *
 *
 * class that will provide all searching options
 */
import com.example.demo.InputDTO;
import org.springframework.data.mongodb.core.query.Query;
import product.Product;
import java.util.List;

public interface SearchService {

    List<Product> searchProducts(InputDTO inputDTO);

    List<Product> searchProducts(Query query);

}
