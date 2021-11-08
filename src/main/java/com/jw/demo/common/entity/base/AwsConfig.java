package com.jw.demo.common.entity.base;

import java.util.Date;

/**
 * Database Table Remarks:
 *   base.t_aws_config: 亚马逊配置表
 *
 * @mbg.generated do_not_delete_during_merge 2021-10-22 12:01:49
 */
public class AwsConfig {
    /**
     * Database Column Remarks:
     *   base.t_aws_config.id: 亚马逊配置ID
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.iot_endpoint: IOT连接节点
     */
    private String iotEndpoint;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.region: 配置区域
     */
    private String region;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.access_key: 访问密钥
     */
    private String accessKey;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.secret_key: 访问密钥
     */
    private String secretKey;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.identity_pool_id: 身份池ID
     */
    private String identityPoolId;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.provider_name: 身份池开发者名称
     */
    private String providerName;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.remark: 备注
     */
    private String remark;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.merchant_id: 商户ID
     */
    private Long merchantId;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.merchant_name: 商户名称
     */
    private String merchantName;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.status: 状态：【1】启用、【2】禁用
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.create_time: 创建时间
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.create_by: 创建者ID
     */
    private Long createBy;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.update_time: 更新时间
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.update_by: 更新者ID
     */
    private Long updateBy;

    /**
     * Database Column Remarks:
     *   base.t_aws_config.deleted: 已删除：【0】否、【1】是
     */
    private Integer deleted;

    /**
     * @return the value of base.t_aws_config.id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the value for base.t_aws_config.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the value of base.t_aws_config.iot_endpoint
     */
    public String getIotEndpoint() {
        return iotEndpoint;
    }

    /**
     * @param iotEndpoint the value for base.t_aws_config.iot_endpoint
     */
    public void setIotEndpoint(String iotEndpoint) {
        this.iotEndpoint = iotEndpoint == null ? null : iotEndpoint.trim();
    }

    /**
     * @return the value of base.t_aws_config.region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the value for base.t_aws_config.region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return the value of base.t_aws_config.access_key
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * @param accessKey the value for base.t_aws_config.access_key
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey == null ? null : accessKey.trim();
    }

    /**
     * @return the value of base.t_aws_config.secret_key
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey the value for base.t_aws_config.secret_key
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    /**
     * @return the value of base.t_aws_config.identity_pool_id
     */
    public String getIdentityPoolId() {
        return identityPoolId;
    }

    /**
     * @param identityPoolId the value for base.t_aws_config.identity_pool_id
     */
    public void setIdentityPoolId(String identityPoolId) {
        this.identityPoolId = identityPoolId == null ? null : identityPoolId.trim();
    }

    /**
     * @return the value of base.t_aws_config.provider_name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * @param providerName the value for base.t_aws_config.provider_name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    /**
     * @return the value of base.t_aws_config.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the value for base.t_aws_config.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return the value of base.t_aws_config.merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId the value for base.t_aws_config.merchant_id
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return the value of base.t_aws_config.merchant_name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * @param merchantName the value for base.t_aws_config.merchant_name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * @return the value of base.t_aws_config.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for base.t_aws_config.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the value of base.t_aws_config.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for base.t_aws_config.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of base.t_aws_config.create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy the value for base.t_aws_config.create_by
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return the value of base.t_aws_config.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the value for base.t_aws_config.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the value of base.t_aws_config.update_by
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy the value for base.t_aws_config.update_by
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return the value of base.t_aws_config.deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * @param deleted the value for base.t_aws_config.deleted
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", iotEndpoint=").append(iotEndpoint);
        sb.append(", region=").append(region);
        sb.append(", accessKey=").append(accessKey);
        sb.append(", secretKey=").append(secretKey);
        sb.append(", identityPoolId=").append(identityPoolId);
        sb.append(", providerName=").append(providerName);
        sb.append(", remark=").append(remark);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}