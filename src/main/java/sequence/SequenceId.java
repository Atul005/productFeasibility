package sequence;/*
 * @author atulyadav on 2019-08-27 19:19
 *
 *
 * class for unique id while saving product and seller
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SequenceId {

    @Id
    private String id;
    private long nextId;

    public SequenceId(String id, long nextId) {
        this.id = id;
        this.nextId = nextId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNextId() {
        return nextId;
    }

    public void setNextId(long nextId) {
        this.nextId = nextId;
    }
}
