package com.jw.demo.common.entity.device;

import java.util.Date;

/**
 * Database Table Remarks:
 *   device.t_device_info:
 *
 * @mbg.generated do_not_delete_during_merge 2021-10-15 17:04:35
 */
public class DeviceInfo {
    /**
     * Database Column Remarks:
     *   device.t_device_info.id: �豸ID
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   device.t_device_info.name: �豸����
     */
    private String name;

    /**
     * Database Column Remarks:
     *   device.t_device_info.mac: �豸MAC
     */
    private String mac;

    /**
     * Database Column Remarks:
     *   device.t_device_info.country_id: ���ұ��
     */
    private String countryId;

    /**
     * Database Column Remarks:
     *   device.t_device_info.country: ��������
     */
    private String country;

    /**
     * Database Column Remarks:
     *   device.t_device_info.province_id: ʡ�ݱ��
     */
    private String provinceId;

    /**
     * Database Column Remarks:
     *   device.t_device_info.province: ʡ������
     */
    private String province;

    /**
     * Database Column Remarks:
     *   device.t_device_info.city_id: ���б��
     */
    private String cityId;

    /**
     * Database Column Remarks:
     *   device.t_device_info.city: ��������
     */
    private String city;

    /**
     * Database Column Remarks:
     *   device.t_device_info.area_id: �������
     */
    private String areaId;

    /**
     * Database Column Remarks:
     *   device.t_device_info.area: ��������
     */
    private String area;

    /**
     * Database Column Remarks:
     *   device.t_device_info.address: ��ϸ��ַ
     */
    private String address;

    /**
     * Database Column Remarks:
     *   device.t_device_info.remark: ��ע
     */
    private String remark;

    /**
     * Database Column Remarks:
     *   device.t_device_info.merchant_id: �̻�ID
     */
    private Long merchantId;

    /**
     * Database Column Remarks:
     *   device.t_device_info.merchant_name: �̻�����
     */
    private String merchantName;

    /**
     * Database Column Remarks:
     *   device.t_device_info.product_id: ��ƷID
     */
    private Long productId;

    /**
     * Database Column Remarks:
     *   device.t_device_info.product_name: ��Ʒ����
     */
    private String productName;

    /**
     * Database Column Remarks:
     *   device.t_device_info.status: ״̬����1�����á���2������
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   device.t_device_info.create_time: ����ʱ��
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   device.t_device_info.create_by: ������ID
     */
    private Long createBy;

    /**
     * Database Column Remarks:
     *   device.t_device_info.update_time: ����ʱ��
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   device.t_device_info.deleted: ��ɾ������0���񡢡�1����
     */
    private Integer deleted;

    /**
     * @return the value of device.t_device_info.id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the value for device.t_device_info.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the value of device.t_device_info.name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for device.t_device_info.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of device.t_device_info.mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the value for device.t_device_info.mac
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * @return the value of device.t_device_info.country_id
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the value for device.t_device_info.country_id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    /**
     * @return the value of device.t_device_info.country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the value for device.t_device_info.country
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * @return the value of device.t_device_info.province_id
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId the value for device.t_device_info.province_id
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    /**
     * @return the value of device.t_device_info.province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the value for device.t_device_info.province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return the value of device.t_device_info.city_id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId the value for device.t_device_info.city_id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * @return the value of device.t_device_info.city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the value for device.t_device_info.city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return the value of device.t_device_info.area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId the value for device.t_device_info.area_id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * @return the value of device.t_device_info.area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the value for device.t_device_info.area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * @return the value of device.t_device_info.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the value for device.t_device_info.address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return the value of device.t_device_info.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the value for device.t_device_info.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return the value of device.t_device_info.merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId the value for device.t_device_info.merchant_id
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return the value of device.t_device_info.merchant_name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * @param merchantName the value for device.t_device_info.merchant_name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * @return the value of device.t_device_info.product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the value for device.t_device_info.product_id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return the value of device.t_device_info.product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the value for device.t_device_info.product_name
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * @return the value of device.t_device_info.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for device.t_device_info.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the value of device.t_device_info.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for device.t_device_info.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of device.t_device_info.create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy the value for device.t_device_info.create_by
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return the value of device.t_device_info.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the value for device.t_device_info.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the value of device.t_device_info.deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * @param deleted the value for device.t_device_info.deleted
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
        sb.append(", name=").append(name);
        sb.append(", mac=").append(mac);
        sb.append(", countryId=").append(countryId);
        sb.append(", country=").append(country);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", province=").append(province);
        sb.append(", cityId=").append(cityId);
        sb.append(", city=").append(city);
        sb.append(", areaId=").append(areaId);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", remark=").append(remark);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}