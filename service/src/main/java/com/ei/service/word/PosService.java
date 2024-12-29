package com.ei.service.word;

/**
 * @author: songrunqi
 * @since 11:20
 **/
public interface PosService {
    /**
     * 根据posId获取posName
     * @param id
     * @return
     */
    String getPosName(Integer id);

    /**
     * 根据posName获取posId
     * @param posName 词性名称
     * @return 词性id
     */
    Integer getPosId(String posName);

}
