package product;
/*
 * @author atulyadav on 2019-08-27 14:37
 */
import mongo.Database;
import mongo.MongoTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import search.SearchService;
import sequence.IdTypeEnum;
import sequence.SequenceService;
import java.util.List;
import static utility.Utility.validateNotNull;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    MongoTemplateFactory mongoTemplateFactory;
    @Autowired
    SearchService searchService;
    @Autowired
    SequenceService sequenceService;

    @Override
    public void saveProduct(Product product) {
        final Long nextSequenceId = sequenceService.getNextSequenceId(IdTypeEnum.PRODUCT.getIdType());
        product.setProductId(nextSequenceId.toString());
        validateProduct(product);
        mongoTemplateFactory.getMongoConnction(Database.PRODUCT_STORE.name()).save(product);
    }

    @Override
    public List<Product> getProducts(Query query) {
        return searchService.searchProducts(query);
    }

    @Override
    public boolean editProduct(String productId) {
        return false;
    }

    private void validateProduct(Product product) {
        validateNotNull(product.getProductId());
        validateNotNull(product.getProductName());
        validateNotNull(product.getPrice());
        validateNotNull(product.getRatings());
    }
}