package com.jw.demo.common.entity.dynamodb;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "appuserDevice")
public class AppUserDevice {
    /*** 分区键 */
    //主键appuser_id
    @DynamoDBHashKey(attributeName = "appuser_id")
    private String appuserId;

    /*** 创建时间 */
    @DynamoDBRangeKey(attributeName = "create_time")
    private Long createTime;
    @DynamoDBAttribute(attributeName = "device_id")
    private String deviceId;
    /*** 产品id */
    @DynamoDBAttribute(attributeName = "product_id")
    private String productId;
    /*** 产品密钥 */
    @DynamoDBAttribute(attributeName = "product_key")
    private String productKey;
    /*** mac */
    @DynamoDBAttribute(attributeName = "mac")
    private String mac;
    /*** 用户设备名称 */
    @DynamoDBAttribute(attributeName = "device_nickname")
    private String deviceNickname;
    /*** 用户角色 1所有者 2管理员 3成员 */
    @DynamoDBAttribute(attributeName = "u_type")
    private String uType;
    /*** 分享人 id 配网则是0 */
    @DynamoDBAttribute(attributeName = "sharer")
    private String sharer;
    /*** 更新时间 */
    @DynamoDBAttribute(attributeName = "update_time")
    private Long updateTime;



    public String getAppuserId() {
        return appuserId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductKey() {
        return productKey;
    }

    public String getMac() {
        return mac;
    }

    public String getDeviceNickname() {
        return deviceNickname;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setAppuserId(String appuserId) {
        this.appuserId = appuserId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setDeviceNickname(String deviceNickname) {
        this.deviceNickname = deviceNickname;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getuType() {
        return uType;
    }

    public String getSharer() {
        return sharer;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public void setSharer(String sharer) {
        this.sharer = sharer;
    }

    @Override
    public String toString() {
        JSONObject appUserDeviceJSON = new JSONObject();
        appUserDeviceJSON.put("appUserId", appuserId);
        appUserDeviceJSON.put("deviceId", deviceId);
        appUserDeviceJSON.put("productId", productId);
        appUserDeviceJSON.put("productKey", productKey);
        appUserDeviceJSON.put("mac",mac);
        appUserDeviceJSON.put("deviceNickName", deviceNickname);
        appUserDeviceJSON.put("type", uType);
        appUserDeviceJSON.put("sharer",sharer);
        appUserDeviceJSON.put("updateTime", updateTime);
        appUserDeviceJSON.put("createTime", createTime);
        return appUserDeviceJSON.toString();
    }

    public JSONObject toJSON() {
        JSONObject appUserDeviceJSON = new JSONObject();
        appUserDeviceJSON.put("appUserId", appuserId);
        appUserDeviceJSON.put("deviceId", deviceId);
        appUserDeviceJSON.put("productId", productId);
        appUserDeviceJSON.put("productKey", productKey);
        appUserDeviceJSON.put("mac",mac);
        appUserDeviceJSON.put("deviceNickName", deviceNickname);
        appUserDeviceJSON.put("uType", uType);
        appUserDeviceJSON.put("sharer",sharer);
        appUserDeviceJSON.put("updateTime", updateTime);
        appUserDeviceJSON.put("createTime", createTime);
        return appUserDeviceJSON;
    }
}
