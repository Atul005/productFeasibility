package search;
/*
 * @author atulyadav on 2019-08-28 01:19
 */

import com.example.demo.InputDTO;
import orderingLogic.OrderingLogic;
import org.springframework.beans.factory.annotation.Autowired;
import product.Product;
import utility.ServiceFactory;
import utility.Utility;

import java.util.List;
import java.util.stream.Collectors;

public class Search {

    public void getRecommendedProducts(InputDTO inputDTO) {
        final SearchService searchService = (SearchService) ServiceFactory.getService(SearchService.class.getName());
        List<Product> products = searchService.searchProducts(inputDTO);
        if (Utility.isEmptyCollection(products)) {
            System.out.println("No matching result found. :(");
        } else {
            final OrderingLogic orderingLogic = (OrderingLogic) ServiceFactory.getService(OrderingLogic.class.getName());
            final List<Product> orderedProduct = orderingLogic.mostRelevantProducts(products);
            List<Product> notDeliverableProducts = orderedProduct.stream().filter(product -> product.getDeliverablePinCodes().contains(inputDTO.getPincode())).collect(Collectors.toList());
            Collectors.toList();
            System.out.println("Showing Results  \n\n" + inputDTO.getProductName());
            for (Product product : orderedProduct) {
                System.out.printf("%s \t %s \t %f \t %f", product.getVendor(), product.getBrandName(), product.getPrice(), product.getRatings());
            }

            System.out.println("Products not available in your area -   \n\n" + inputDTO.getProductName());
            for (Product product : notDeliverableProducts) {
                System.out.printf("%s \t %s \t %f \t %f", product.getVendor(), product.getBrandName(), product.getPrice(), product.getRatings());
            }
        }
    }
}
