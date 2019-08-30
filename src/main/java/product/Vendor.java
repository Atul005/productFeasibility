package product;/*
 * @author atulyadav on 2019-08-28 00:11
 */

public enum Vendor {

    AMAZON("amazon"),
    FLIPKART("flipkart"),
    SNAPDEAL("snapdeal"),
    PAYTM("paytm"),
    SHOPCLUES("shopclues");

    private String vendorName;

    Vendor(String vendorName) {
        this.vendorName = vendorName;
    }
}
