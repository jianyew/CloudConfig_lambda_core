package com.jw.demo.app.util.aws.dynamodb;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.*;
import com.jw.demo.common.entity.dynamodb.AppUserDevice;
import org.apache.commons.lang3.StringUtils;


import java.util.*;

public class AppUserDeviceDy {
    private static final String tableName = "appuserDevice";
    private static final String indexDevice = "device_id-create_time-index";

    private static AmazonDynamoDBClient dynamoDBClient = (AmazonDynamoDBClient) AmazonDynamoDBClient.builder().withRegion(Regions.AP_SOUTHEAST_1).build();
    public static void main(String[] args) {
//        QueryResult x = selectUserDeviceByID(222222L,31313131L);
//        QueryResult x = selectDeviceUserByIndex(31313131L);
//        QueryResult x = selectUserDevice(222222L);
//        System.err.println(x);
//        deleteItem("2222221");
//
//        System.err.println(deleteItem("","31313131",""));
//        System.err.println(getAppUserDeviceList(x.getItems()).get(0));
//        selectDeviceUserByIndex(31313131L);
//        AppUserDevice appUserDevice = new AppUserDevice();
//        appUserDevice.setAppuserId("11");
//        appUserDevice.setCreateTime(1634714051108L);
//        AppUserDevice appUserDevice1 = new AppUserDevice();
//        appUserDevice1.setAppuserId("22");
//        appUserDevice1.setCreateTime(1634714751858L);
//        List<AppUserDevice> appUserDevices = new ArrayList<>();
//        appUserDevices.add(appUserDevice);
//        appUserDevices.add(appUserDevice1);
//        deleteItems(appUserDevices);
        AppUserDevice putAppDevice = new AppUserDevice();
        putAppDevice.setAppuserId("1");
        putAppDevice.setMac("12345678");
        putAppDevice.setProductId("000");
        putAppDevice.setProductKey("abc");
        putAppDevice.setDeviceNickname("deviceNickName");
        putAppDevice.setuType("1");
        putAppDevice.setSharer("0");
        putAppDevice.setDeviceId("1");
        long time = new Date().getTime();
        putAppDevice.setUpdateTime(time);
        putAppDevice.setCreateTime(time);
        createAppUserDevice(putAppDevice);
    }
    /**
     * 查询用户所有设备
     * @param appUserId
     * @return
     */
    public static QueryResult selectUserDevice(Long appUserId){
        Map<String, String> expressionAttributeNames = new HashMap<>();
        expressionAttributeNames.put("#pk", "appuser_id");
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":pkValue", new AttributeValue().withS(String.valueOf(appUserId)));

        QueryRequest queryRequest = new QueryRequest()
                .withTableName(tableName)
                .withKeyConditionExpression("#pk = :pkValue")
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAttributeValues);
         return dynamoDBClient.query(queryRequest);
    }


    public static QueryResult selectUserDeviceByID(Long appUserId,Long deviceId){
        Map<String, String> expressionAttributeNames = new HashMap<>();
        expressionAttributeNames.put("#pk", "appuser_id");
        expressionAttributeNames.put("#did", "device_id");
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":pkValue", new AttributeValue().withS(String.valueOf(appUserId)));
        expressionAttributeValues.put(":deviceId", new AttributeValue().withS(String.valueOf(deviceId)));

        QueryRequest queryRequest = new QueryRequest()
                .withTableName(tableName)
                .withKeyConditionExpression("#pk = :pkValue and #did = :deviceId")
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAttributeValues);
        return dynamoDBClient.query(queryRequest);
    }

    /**
     * 根据设备查询到用户
     * @param deviceId
     * @return
     */
    public static QueryResult selectDeviceUserByIndex(Long deviceId){
        Map<String, String> expressionAttributeNames = new HashMap<>();
        expressionAttributeNames.put("#pk", "device_id");
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":pkValue", new AttributeValue().withS(String.valueOf(deviceId)));

        QueryRequest queryRequest = new QueryRequest()
                .withTableName(tableName)
                .withIndexName(indexDevice)
                .withKeyConditionExpression("#pk = :pkValue")
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAttributeValues);
        return dynamoDBClient.query(queryRequest);

    }

    /**
     * 新增app用户设备
     * @param appUserDevice
     * @return
     */
    public static PutItemResult createAppUserDevice(AppUserDevice appUserDevice){
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(tableName);
        Map<String, AttributeValue> items = new HashMap<>();
        items.put("appuser_id",new AttributeValue().withS(appUserDevice.getAppuserId()));
//        items.put("device_id",new AttributeValue().withS(appUserDevice.getDeviceId()));
        items.put("product_id",new AttributeValue().withS(appUserDevice.getProductId()));
        items.put("product_key",new AttributeValue().withS(appUserDevice.getProductKey()));
        items.put("mac",new AttributeValue().withS(appUserDevice.getMac()));
        items.put("device_nickname",new AttributeValue().withS(appUserDevice.getDeviceNickname()));
        items.put("u_type",new AttributeValue().withS(appUserDevice.getuType()));
        items.put("sharer",new AttributeValue().withS(appUserDevice.getSharer()));
        items.put("update_time",new AttributeValue().withN(String.valueOf(appUserDevice.getUpdateTime())));
        items.put("create_time",new AttributeValue().withN(String.valueOf(appUserDevice.getCreateTime())));
        System.out.println(items.toString());
        putItemRequest.setItem(items);
        return dynamoDBClient.putItem(putItemRequest);
    }

    /**
     * 删除app用户设备
     * @param appUserId
     * @return
     */
    public static DeleteItemResult deleteItem(String appUserId){
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("appuser_id",new AttributeValue().withS(appUserId));
        return dynamoDBClient.deleteItem(tableName,key);
    }

    public static List<DynamoDBMapper.FailedBatch>  deleteItems(List<AppUserDevice> appUserDevices ){
        DynamoDBMapper dbMapper = new DynamoDBMapper(dynamoDBClient);
        List<DynamoDBMapper.FailedBatch> result = dbMapper.batchDelete(appUserDevices);
        return  result;
    }

    /**
     * 修改App用户设备
     * @param appUserId
     * @param deviceId
     * @param mac
     * @param appUserDevice
     * @return
     * @throws Exception
     */
    public static UpdateItemResult updateItem(String appUserId,String deviceId,String mac, AppUserDevice appUserDevice)throws Exception{
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(tableName);

        //表达式中的变量和属性值定义
        Map<String,AttributeValue> attributeValueMap = new HashMap<>();
        StringBuffer itemString = new StringBuffer();

        attributeValueMap.put(":updateTime",new AttributeValue().withS(String.valueOf(new Date().getTime())));
        itemString.append("set update_time = :updateTime");

        if (!StringUtils.isEmpty(appUserDevice.getAppuserId())){
            attributeValueMap.put(":appUserId",new AttributeValue().withS(appUserDevice.getAppuserId()));
            itemString.append(",appuser_id = :appUserId");
        }
        if (!StringUtils.isEmpty(appUserDevice.getDeviceId())){
            attributeValueMap.put(":deviceId",new AttributeValue().withS(appUserDevice.getDeviceId()));
            itemString.append(",device_id = :deviceId");
        }
        if (!StringUtils.isEmpty(appUserDevice.getProductId())){
            attributeValueMap.put(":productId",new AttributeValue().withS(appUserDevice.getProductId()));
            itemString.append(",product_id = :productId");
        }
        if (!StringUtils.isEmpty(appUserDevice.getProductKey())){
            attributeValueMap.put(":productKey",new AttributeValue().withS(appUserDevice.getProductKey()));
            itemString.append(",product_key = :productKey");
        }
        if (!StringUtils.isEmpty(appUserDevice.getMac())){
            attributeValueMap.put(":macStr",new AttributeValue().withS(appUserDevice.getMac()));
            itemString.append(",mac = :macStr");
        }
        if (!StringUtils.isEmpty(appUserDevice.getDeviceNickname())){
            attributeValueMap.put(":deviceNickname",new AttributeValue().withS(appUserDevice.getDeviceNickname()));
            itemString.append(",device_nickname = :deviceNickname");
        }
        if (!StringUtils.isEmpty(appUserDevice.getuType())){
            attributeValueMap.put(":ty",new AttributeValue().withS(appUserDevice.getuType()));
            itemString.append(",u_type = :ty");
        }
        if (!StringUtils.isEmpty(appUserDevice.getSharer())){
            attributeValueMap.put(":share",new AttributeValue().withS(appUserDevice.getSharer()));
            itemString.append(",sharer = :share");
        }

        Map<String, AttributeValue> key = new HashMap<>();
        if (!StringUtils.isEmpty(appUserId)){
            key.put("appuser_id",new AttributeValue().withS(appUserId));
        }
        if (!StringUtils.isEmpty(deviceId)){
            key.put("device_id",new AttributeValue().withS(deviceId));
        }
        if (!StringUtils.isEmpty(mac)){
            key.put("mac",new AttributeValue().withS(mac));
        }
        updateItemRequest.setKey(key);
        updateItemRequest.setUpdateExpression(itemString.toString());

        updateItemRequest.setExpressionAttributeValues(attributeValueMap);
        updateItemRequest.setReturnValues("ALL_OLD");//返回旧的数据
        System.err.println("key:"+key);
        System.err.println("itemString:"+itemString.toString());
        UpdateItemResult updateItemResult = dynamoDBClient.updateItem(updateItemRequest);

        System.out.println(updateItemResult.toString());
        return updateItemResult;
    }


    //将查询结果转化为 对象
    public static AppUserDevice getAppUserDevice(Map<String,AttributeValue> item){
            AppUserDevice appUserDevice = new AppUserDevice();
            try {
                appUserDevice.setAppuserId(item.get("appuser_id").getS());
                appUserDevice.setDeviceId(item.get("device_id").getS());
                appUserDevice.setProductId(item.get("product_id").getS());
                appUserDevice.setProductKey(item.get("product_key").getS());
                appUserDevice.setMac(item.get("mac").getS());
                appUserDevice.setuType(item.get("u_type").getS());
                appUserDevice.setCreateTime(Long.valueOf(item.get("create_time").getN()));
                appUserDevice.setDeviceNickname(item.get("device_nickname").getS());
                appUserDevice.setUpdateTime(Long.valueOf(item.get("update_time").getN()));
                appUserDevice.setSharer(item.get("sharer").getS());
            }catch (Exception e){
                e.printStackTrace();
                System.err.println(e.getMessage());
//                continue;
            }
        return appUserDevice;
    }
    //将查询结果转化为 对象
    public static List<AppUserDevice> getAppUserDeviceList(List<Map<String,AttributeValue>> item){
        List<AppUserDevice> appUserDevices = new ArrayList<>();
        for (int i=0;i<item.size();i++){
            AppUserDevice appUserDevice = new AppUserDevice();
            try {
                appUserDevice.setAppuserId(item.get(i).get("appuser_id").getS());
//                appUserDevice.setDeviceId(item.get(i).get("device_id").getS());
                appUserDevice.setProductId(item.get(i).get("product_id").getS());
                appUserDevice.setProductKey(item.get(i).get("product_key").getS());
                appUserDevice.setMac(item.get(i).get("mac").getS());
                appUserDevice.setuType(item.get(i).get("u_type").getS());
                appUserDevice.setCreateTime(Long.valueOf(item.get(i).get("create_time").getN()));
                appUserDevice.setDeviceNickname(item.get(i).get("device_nickname").getS());
                appUserDevice.setUpdateTime(Long.valueOf(item.get(i).get("update_time").getN()));
                appUserDevice.setSharer(item.get(i).get("sharer").getS());
            }catch (Exception e){
                e.printStackTrace();
                System.err.println(e.getMessage());
//                continue;
            }
            appUserDevices.add(appUserDevice);
        }
        return appUserDevices;
    }
}
