package seller;/*
 * @author atulyadav on 2019-08-27 22:36
 */

import java.util.List;

public interface SellerService {

    void saveSeller(Seller seller);
    Boolean validateSeller(Seller seller);
    Seller getSeller(String sellerId);
    List<Seller> getAllSeller();
}
