package seller;/*
 * @author atulyadav on 2019-08-27 18:43
 *
 * in case a particular vendor, may sellers also appears,
 * ordering can be changed because of them also
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Seller {
    private String pincode;
    private String sailorName;
    private Double sailorCharge;
    private List<String> serviceableAreas;

    @Id
    private String sailorId;

    public Seller(String pincode, String sailorName, Double sailorCharge, List<String> serviceableAreas) {
        this.pincode = pincode;
        this.sailorName = sailorName;
        this.sailorCharge = sailorCharge;
        this.serviceableAreas = serviceableAreas;
    }

    public void setSailorId(String sailorId) {
        this.sailorId = sailorId;
    }

    public String getSailorId() {
        return sailorId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSailorName() {
        return sailorName;
    }

    public void setSailorName(String sailorName) {
        this.sailorName = sailorName;
    }

    public Double getSailorCharge() {
        return sailorCharge;
    }

    public void setSailorCharge(Double sailorCharge) {
        this.sailorCharge = sailorCharge;
    }

    public List<String> getServiceableAreas() {
        return serviceableAreas;
    }

    public void setServiceableAreas(List<String> serviceableAreas) {
        this.serviceableAreas = serviceableAreas;
    }

}
