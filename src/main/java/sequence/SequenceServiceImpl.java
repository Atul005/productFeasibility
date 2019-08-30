package sequence;/*
 * @author atulyadav on 2019-08-27 21:02
 */

import ExceptionTranslator.SequenceException;
import mongo.Database;
import mongo.MongoTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService {

    private final MongoTemplateFactory mongoTemplateFactory;

    @Autowired
    public SequenceServiceImpl(MongoTemplateFactory mongoTemplateFactory) {
        this.mongoTemplateFactory = mongoTemplateFactory;
    }

    @Override
    public long getNextSequenceId(String key) {
        Criteria criteria = Criteria.where("_id").is(key);
        Update update = new Update();
        update.inc("nextId",1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        SequenceId newSeqId = mongoTemplateFactory.getMongoConnction(Database.GLOBAL_STORE.getDbName()).findAndModify(Query.query(criteria), update, options, SequenceId.class);
        if(null == newSeqId ){
            throw new SequenceException("[ERROR] Sequence Id not found");
        }
        return newSeqId.getNextId();
    }
}
