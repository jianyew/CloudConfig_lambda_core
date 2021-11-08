package com.jw.demo.common.entity.dynamodb;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Map;

@DynamoDBTable(tableName = "devicePropertyLog")
public class DevicePropertyLog {

    @DynamoDBHashKey(attributeName = "mac")
    private String mac; // MAC，分区键

    @DynamoDBRangeKey(attributeName = "create_time")
    private Long createTime; // 创建时间，排序键

    @DynamoDBAttribute(attributeName = "reported_data")
    private Map<String, String> reportedData; // 上报内容

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Map<String, String> getReportedData() {
        return reportedData;
    }

    public void setReportedData(Map<String, String> reportedData) {
        this.reportedData = reportedData;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("mac", mac);
        json.put("createTime", createTime);
        json.put("reported_data", reportedData);
        return json;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }

}
