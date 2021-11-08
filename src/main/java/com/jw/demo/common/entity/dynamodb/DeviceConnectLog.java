package com.jw.demo.common.entity.dynamodb;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "deviceConnectLog")
public class DeviceConnectLog {

    @DynamoDBHashKey(attributeName = "mac")
    private String mac; // MAC，分区键

    @DynamoDBRangeKey(attributeName = "create_time")
    private Long createTime; // 创建时间，排序键

    @DynamoDBAttribute(attributeName = "connect")
    private String connect; // 连接状态

    @DynamoDBAttribute(attributeName = "product_key")
    private String productKey; // 产品密钥

    @DynamoDBAttribute(attributeName = "region")
    private String region; // 地区

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

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("mac", mac);
        json.put("createTime", createTime);
        json.put("connect", connect);
        json.put("productKey", productKey);
        json.put("region", region);
        return json;
    }

    @Override
    public String toString() {
        return toJSON().toString();
    }

}
