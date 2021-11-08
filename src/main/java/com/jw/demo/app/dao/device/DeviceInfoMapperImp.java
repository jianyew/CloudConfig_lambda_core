package com.jw.demo.app.dao.device;

import com.jw.demo.common.entity.device.DeviceInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 模拟数据库
 *
 *
 */

@Service
public class DeviceInfoMapperImp implements DeviceInfoMapper {

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(DeviceInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(DeviceInfo record) {
        return 0;
    }

    @Override
    public DeviceInfo selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<DeviceInfo> selectByMap(Map<String, Object> params) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DeviceInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DeviceInfo record) {
        return 0;
    }

    @Override
    public int updateByMap(Map<String, Object> params) {
        return 0;
    }
}
