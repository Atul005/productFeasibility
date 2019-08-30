package seller;/*
 * @author atulyadav on 2019-08-27 22:39
 */
import mongo.Database;
import mongo.MongoTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import sequence.IdTypeEnum;
import sequence.SequenceService;

import java.util.List;

import static utility.Utility.*;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private MongoTemplateFactory mongoTemplateFactory;

    @Autowired
    private SequenceService sequenceService;


    @Override
    public void saveSeller(Seller seller) {
        validateSeller(seller);
        final Long nextSequenceId = sequenceService.getNextSequenceId(IdTypeEnum.SELLER.getIdType());
        seller.setSailorId(nextSequenceId.toString());
        mongoTemplateFactory.getMongoConnction(Database.GLOBAL_STORE.name()).save(seller);
    }

    @Override
    public Boolean validateSeller(Seller seller) {
        return null != seller && !isEmptyString(seller.getPincode()) && !isEmptyString(seller.getSailorName())  && null != seller.getSailorCharge() && !isEmptyCollection(seller.getServiceableAreas());
    }

    @Override
    public Seller getSeller(String sellerId) {
        validateNotNull(sellerId);
        Criteria criteria = Criteria.where("_id").is(sellerId);
        return mongoTemplateFactory.getMongoConnction(Database.GLOBAL_STORE.name()).findOne(Query.query(criteria), Seller.class);
    }

    @Override
    public List<Seller> getAllSeller() {
        return mongoTemplateFactory.getMongoConnction(Database.GLOBAL_STORE.name()).findAll(Seller.class);
    }
}
