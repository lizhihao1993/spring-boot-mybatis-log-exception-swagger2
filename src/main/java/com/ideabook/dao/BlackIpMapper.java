package com.ideabook.dao;

import com.ideabook.entity.BlackIp;

import java.util.List;

public interface BlackIpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlackIp record);

    int insertSelective(BlackIp record);

    BlackIp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlackIp record);

    int updateByPrimaryKey(BlackIp record);

    List<BlackIp> findByIp(String ip);
}