package mongo;/*
 * @author atulyadav on 2019-08-27 16:01
 */
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Service;

@Service
public class MongoTemplateFactoryImpl implements MongoTemplateFactory{
    @Override
    public MongoTemplate getMongoConnction(String dbName) {
        MongoClient mongoClient = new MongoClient();
        MongoTemplate mongoTemplate = new MongoTemplate(new SimpleMongoDbFactory(mongoClient, dbName));
        return mongoTemplate;
    }
}
