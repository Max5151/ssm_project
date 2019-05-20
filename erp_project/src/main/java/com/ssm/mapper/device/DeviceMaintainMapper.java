package com.ssm.mapper.device;


import java.util.List;

import com.ssm.bean.device.DeviceMaintain;
import com.ssm.bean.device.DeviceMaintainExample;
import org.apache.ibatis.annotations.Param;

public interface DeviceMaintainMapper {
    List<DeviceMaintain> queryAllDeviceMaintainByPage(@Param("offset") int offset,@Param("rows") int rows);

    int insertDeviceMaintain(DeviceMaintain deviceMaintain);

    //deviceMaintain的接口
    List<DeviceMaintain> queryAllDeviceMaintain();

    //根据id来查询
    DeviceMaintain queryDeviceMaintainById(int deviceMaintainId);

    int updateDeviceMaintain(DeviceMaintain deviceMaintain);

    int deleteDeviceMaintain(@Param("id") String ids);

    //差个数
    int queryAllDeviceMaintainRecord();


    /*long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);*/
}