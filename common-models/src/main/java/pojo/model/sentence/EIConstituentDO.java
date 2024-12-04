package pojo.model.sentence;

import pojo.model.BasePOJO;

/**
 * @author yitiansong
 */
public class EIConstituentDO extends BasePOJO {
    /**
     * 句子成分
     */
    private String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "EIConstituentDO{" +
                "c='" + c + '\'' +
                '}';
    }
}
