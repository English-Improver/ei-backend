package pojo.model.word;

import pojo.model.BasePOJO;

/**
 * @author yitiansong
 * 暂时先不用了，和EIPosDo重复
 */
@Deprecated
public class EIPropertyDO extends BasePOJO {
    private String propertyC;
    private String propertyE;

    @Override
    public String toString() {
        return "EIPropertyDO{" +
                "propertyC='" + propertyC + '\'' +
                ", propertyE='" + propertyE + '\'' +
                '}';
    }

    public String getPropertyC() {
        return propertyC;
    }

    public void setPropertyC(String propertyC) {
        this.propertyC = propertyC;
    }

    public String getPropertyE() {
        return propertyE;
    }

    public void setPropertyE(String propertyE) {
        this.propertyE = propertyE;
    }
}
