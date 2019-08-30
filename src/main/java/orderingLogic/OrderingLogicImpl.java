package orderingLogic;
/*
 * @author atulyadav on 2019-08-28 01:10
 */

import org.springframework.stereotype.Service;
import product.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderingLogicImpl implements OrderingLogic {

    @Override
    public List<Product> mostRelevantProducts(List<Product> products) {
        /*
        * here, I am considering products acc to their ratings and difference in their ratings is
        * less or equal t0 .2.then I am prefering price criteria, I am prefering the  one with low price.
        * I used only 2 criteria, we can use others also, like review count.
        *
        * */

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                final double ratingsP1 = p1.getRatings();
                final double ratingsP2 = p2.getRatings();
                final double priceP1 = p1.getPrice();
                final double priceP2 = p2.getPrice();

                double ratingDiff = Math.abs(ratingsP1 - ratingsP2);
                if (ratingsP1 < ratingsP2) {
                    if (ratingDiff <= 0.3) {
                        return checkPriceDiffCriteria(priceP1, priceP2);
                    } else {
                        return 1;
                    }
                } else if (ratingsP1 == ratingsP2) {
                    if (priceP1 >= priceP2) {
                        return 1;
                    } else {
                        return -1;
                    }
                } return -1;
            }
        });
        return products;
    }

    private int checkPriceDiffCriteria(double priceP1, double priceP2) {
        if (priceP1 > priceP2) {
            double priceDiff = priceP1 - priceP2;
            final double diffPercentage = calculatePriceDiffPercentage(priceDiff, priceP1);
            if (diffPercentage > 15.0) {
                return -1;
            }
        }
        return 1;
    }

    private double calculatePriceDiffPercentage(double priceDiff, double price) {
        return priceDiff * 100 / price;
    }


}
