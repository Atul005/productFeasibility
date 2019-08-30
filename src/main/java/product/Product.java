package product;/*
 * @author atulyadav on 2019-08-27 14:37
 *
 * product DTO
 */

import org.springframework.data.mongodb.core.mapping.Document;
import review.Review;

import java.util.List;
import java.util.Map;

@Document
public class Product {

    private String productId;
    private String vendor;
    private String productName;
    private String brandName;
    private String color;
    private double ratings;
    private List<Review> reviews;
    private double price;
    private Map<String, List<String>> additional;
    private List<String> deliverablePinCodes;

    public List<String> getDeliverablePinCodes() {
        return deliverablePinCodes;
    }

    public void setDeliverablePinCodes(List<String> deliverablePinCodes) {
        this.deliverablePinCodes = deliverablePinCodes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Map<String, List<String>> getAdditional() {
        return additional;
    }

    public void setAdditional(Map<String, List<String>> additional) {
        this.additional = additional;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
