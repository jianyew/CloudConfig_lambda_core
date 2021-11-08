package com.jw.demo.common.entity.base;

import java.util.Date;

/**
 * Database Table Remarks:
 *   base.t_app_user: APP�û���Ϣ��
 *
 * @mbg.generated do_not_delete_during_merge 2021-10-09 14:53:13
 */
public class AppUser {
    /**
     * Database Column Remarks:
     *   base.t_app_user.id: APP�û�ID
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   base.t_app_user.account: ��¼�˺�
     */
    private String account;

    /**
     * Database Column Remarks:
     *   base.t_app_user.password: ��¼����
     */
    private String password;

    /**
     * Database Column Remarks:
     *   base.t_app_user.salt: ������ֵ
     */
    private String salt;

    /**
     * Database Column Remarks:
     *   base.t_app_user.name: �û�����
     */
    private String name;

    /**
     * Database Column Remarks:
     *   base.t_app_user.avatar: �û�ͷ��
     */
    private String avatar;

    /**
     * Database Column Remarks:
     *   base.t_app_user.phone: �ֻ�����
     */
    private String phone;

    /**
     * Database Column Remarks:
     *   base.t_app_user.email: ��������
     */
    private String email;

    /**
     * Database Column Remarks:
     *   base.t_app_user.sex: �Ա𣺡�1���С���2��Ů
     */
    private Integer sex;

    /**
     * Database Column Remarks:
     *   base.t_app_user.age: ����
     */
    private Integer age;

    /**
     * Database Column Remarks:
     *   base.t_app_user.birthday: ����
     */
    private Date birthday;

    /**
     * Database Column Remarks:
     *   base.t_app_user.height: ��ߣ���λ��cm
     */
    private Float height;

    /**
     * Database Column Remarks:
     *   base.t_app_user.weight: ���أ���λ��kg
     */
    private Float weight;

    /**
     * Database Column Remarks:
     *   base.t_app_user.country_id: ���ұ��
     */
    private String countryId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.country: ��������
     */
    private String country;

    /**
     * Database Column Remarks:
     *   base.t_app_user.province_id: ʡ�ݱ��
     */
    private String provinceId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.province: ʡ������
     */
    private String province;

    /**
     * Database Column Remarks:
     *   base.t_app_user.city_id: ���б��
     */
    private String cityId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.city: ��������
     */
    private String city;

    /**
     * Database Column Remarks:
     *   base.t_app_user.area_id: ���ر��
     */
    private String areaId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.area: ��������
     */
    private String area;

    /**
     * Database Column Remarks:
     *   base.t_app_user.address: ��ϸ��ַ
     */
    private String address;

    /**
     * Database Column Remarks:
     *   base.t_app_user.identityId: ��ϸ��ַ
     */
    private String identityId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.identityPoolId: ��ϸ��ַ
     */
    private String identityPoolId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.merchant_id: �̻�ID
     */
    private Long merchantId;

    /**
     * Database Column Remarks:
     *   base.t_app_user.merchant_name: �̻�����
     */
    private String merchantName;

    /**
     * Database Column Remarks:
     *   base.t_app_user.status: ״̬����1�����á���2������
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   base.t_app_user.create_time: ����ʱ��
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   base.t_app_user.create_by: ������
     */
    private Long createBy;

    /**
     * Database Column Remarks:
     *   base.t_app_user.update_time: �޸�ʱ��
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   base.t_app_user.update_by: �޸���
     */
    private Long updateBy;

    /**
     * Database Column Remarks:
     *   base.t_app_user.deleted: ��ɾ������0���񡢡�1����
     */
    private Integer deleted;

    /**
     * @return the value of base.t_app_user.id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the value for base.t_app_user.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the value of base.t_app_user.account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the value for base.t_app_user.account
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return the value of base.t_app_user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the value for base.t_app_user.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return the value of base.t_app_user.salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the value for base.t_app_user.salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return the value of base.t_app_user.name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for base.t_app_user.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of base.t_app_user.avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the value for base.t_app_user.avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * @return the value of base.t_app_user.phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the value for base.t_app_user.phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return the value of base.t_app_user.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the value for base.t_app_user.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return the value of base.t_app_user.sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex the value for base.t_app_user.sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the value of base.t_app_user.age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the value for base.t_app_user.age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the value of base.t_app_user.birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the value for base.t_app_user.birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the value of base.t_app_user.height
     */
    public Float getHeight() {
        return height;
    }

    /**
     * @param height the value for base.t_app_user.height
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * @return the value of base.t_app_user.weight
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * @param weight the value for base.t_app_user.weight
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * @return the value of base.t_app_user.country_id
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the value for base.t_app_user.country_id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    /**
     * @return the value of base.t_app_user.country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the value for base.t_app_user.country
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * @return the value of base.t_app_user.province_id
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId the value for base.t_app_user.province_id
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    /**
     * @return the value of base.t_app_user.province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the value for base.t_app_user.province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return the value of base.t_app_user.city_id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId the value for base.t_app_user.city_id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * @return the value of base.t_app_user.city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the value for base.t_app_user.city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return the value of base.t_app_user.area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId the value for base.t_app_user.area_id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * @return the value of base.t_app_user.area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the value for base.t_app_user.area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * @return the value of base.t_app_user.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the value for base.t_app_user.address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdentityId() {
        return identityId;
    }

    public String getIdentityPoolId() {
        return identityPoolId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    public void setIdentityPoolId(String identityPoolId) {
        this.identityPoolId = identityPoolId == null ? null : identityPoolId.trim();
    }

    /**
     * @return the value of base.t_app_user.merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId the value for base.t_app_user.merchant_id
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return the value of base.t_app_user.merchant_name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * @param merchantName the value for base.t_app_user.merchant_name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * @return the value of base.t_app_user.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for base.t_app_user.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the value of base.t_app_user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for base.t_app_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of base.t_app_user.create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy the value for base.t_app_user.create_by
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return the value of base.t_app_user.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the value for base.t_app_user.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the value of base.t_app_user.update_by
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy the value for base.t_app_user.update_by
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return the value of base.t_app_user.deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * @param deleted the value for base.t_app_user.deleted
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
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", name=").append(name);
        sb.append(", avatar=").append(avatar);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", countryId=").append(countryId);
        sb.append(", country=").append(country);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", province=").append(province);
        sb.append(", cityId=").append(cityId);
        sb.append(", city=").append(city);
        sb.append(", areaId=").append(areaId);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
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