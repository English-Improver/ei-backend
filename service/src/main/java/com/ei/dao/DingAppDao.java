package com.ei.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ei.mapper.dingTalk.DingAppMapper;
import org.springframework.stereotype.Repository;
import pojo.model.dingding.DingApp;

/**
 * @author yitiansong
 * @since 11/14/24
 */
@Repository
public class DingAppDao extends ServiceImpl<DingAppMapper, DingApp> {

}
