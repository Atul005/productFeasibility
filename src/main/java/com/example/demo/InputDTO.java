package com.example.demo;/*
 * @author atulyadav on 2019-08-27 16:40
 */

/*
* DTO class that will provide data from client facing classes to server facing classes
*
* */

import org.springframework.beans.factory.annotation.Autowired;
import search.SearchService;

public class InputDTO {

    private String productName;
    private String pincode;

    @Autowired
    private SearchService searchService;

    InputDTO(String productName, String pincode) {
        this.productName = productName;
        this.pincode = pincode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
