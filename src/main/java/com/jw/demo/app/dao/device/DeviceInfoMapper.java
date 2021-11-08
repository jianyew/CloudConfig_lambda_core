package com.jw.demo.app.dao.device;

import java.util.List;
import java.util.Map;

import com.jw.demo.common.entity.device.DeviceInfo;

public interface DeviceInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DeviceInfo record);

    int insertSelective(DeviceInfo record);

    DeviceInfo selectByPrimaryKey(Long id);

    List<DeviceInfo> selectByMap(Map<String, Object> params);

    int updateByPrimaryKeySelective(DeviceInfo record);

    int updateByPrimaryKey(DeviceInfo record);

    int updateByMap(Map<String, Object> params);

}