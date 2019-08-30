package search;/*
 * @author atulyadav on 2019-08-27 16:43
 */

import com.example.demo.InputDTO;
import mongo.Database;
import mongo.MongoTemplateFactory;
import orderingLogic.OrderingLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import product.Product;
import utility.Utility;

import java.util.Collections;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private static final String PRODUCT = "product";

    @Autowired
    MongoTemplateFactory mongoTemplateFactory;

    @Autowired
    OrderingLogic orderingLogic;

    @Override
    public List<Product> searchProducts(InputDTO inputDTO) {
        Criteria criteria = Criteria.where("productName").regex(inputDTO.getProductName());
        return searchProducts(Query.query(criteria));
    }

    @Override
    public List<Product> searchProducts(Query query) {
        List<Product> products = mongoTemplateFactory.getMongoConnction(Database.PRODUCT_STORE.name()).find(query, Product.class);
        if (Utility.isEmptyCollection(products)) {
            return Collections.emptyList();
        } else {
            return generateFeasibleProductList(products);
        }
    }

    private List<Product> generateFeasibleProductList(List<Product> products) {
        return orderingLogic.mostRelevantProducts(products);
    }
}
