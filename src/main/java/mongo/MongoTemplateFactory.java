package mongo;/*
 * @author atulyadav on 2019-08-27 15:35
 *
 * class that will provide mongo connection
 */

import org.springframework.data.mongodb.core.MongoTemplate;

public interface MongoTemplateFactory {
    MongoTemplate getMongoConnction(String dbName);
}
