package sequence;/*
 * @author atulyadav on 2019-08-27 22:51
 */

public enum IdTypeEnum {

    SELLER("seller"),
    PRODUCT("product");

    private String idType;

    public String getIdType() {
        return idType;
    }

    IdTypeEnum(String idType){
        this.idType = idType;
    }
}
