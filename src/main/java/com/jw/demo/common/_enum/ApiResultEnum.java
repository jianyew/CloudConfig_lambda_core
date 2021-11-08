package com.jw.demo.common._enum;

/**
 * 通用错误码枚举
 *
 * @author zyj
 * @version 0.0.1
 */
public enum ApiResultEnum {
    //写在前面：
    //       统一  0-9999 为系统状态码
    //      其余按业务划分， 如：用户相关功能状态码则是 10001-10999
    //      商户相关状态码为  11001 - 11999
    //     其余依次类推

    /**
     * 请求结果：成功
     */
    SUCCESS(0, "响应成功"),
    /**
     * 请求结果：失败
     */
    FAIL(1, "响应失败"), PARAM_ERROR(1001, "请求参数错误"),

    SYS_ERROR(1016, "系统错误"),



    /**
     * 通用错误码
     */
    COMMON_DATABASE_NOT_EXIST(2001, "数据不存在"),
    COMMON_DATABASE_ERROR(2002, "数据错误"),
    COMMON_USER_NOT_PERMISSION(2010, "当前用户无权限"),
    COMMON_REDIS_LOCK(2001, "正在处理"),

    /** 用户已存在 **/
    APP_USER_EXIST(10001, "用户已存在"),
    /** 用户不存在 **/
    APP_USER_NOT_EXIST(10002, "用户不存在"),
    /** 密码错误 **/
    APP_USER_PASSWORD_WRONG(10003, "密码错误"),
    /** 验证码错误 **/
    APP_CODE_WRONG(10004, "验证码错误"),
    /** 未受验证的用户请求 **/
    UNVERIFIED_USER_REQUEST(10005, "未受验证的用户请求"),
    /** 未登录 **/
    APP_USER_NOT_LOGIN(10006,"未登录或登录失效"),
    /** 未登录 **/
    APP_USER_NOT_TOKEN(10007,"token不存在"),

    /** 商户已存在 **/
    MERCHANT_EXIST(11001, "当前品牌已存在"),
    /** 产品已存在 **/
    PRODUCT_EXIST(11001, "当前产品已存在"),
    /** 产品下有绑定设备 **/
    PRODUCT_MERCHANT_EXIST(11006,"当前产品下有绑定设备，无法删除"),
    /** 商户不存在 **/
    MERCHANT_NOT_EXIST(11002, "品牌不存在"),
    /** 商户被禁用 **/
    MERCHANT_IS_DISABLE(11003, "当前品牌无效"),
    /** 产品不存在 **/
    PRODUCT_NOT_EXIST(10001, "产品不存在"),
    /** 亚马逊配置不存在 **/
    AWS_CONFIG_NOT_EXIST(10001, "AWS配置不存在"),
    /** 获取设备证书失败 **/
    DEVICE_CERTIFICATE_GET_FAIL(10001, "设备证书获取失败"),
    /** 更新设备影子失败 **/
    DEVICE_SHADOW_UPDATE_FAIL(10001, "设备影子更新失败"),


    /** 用户重复调用绑定设备 **/
    APP_USER_DEVICE_BIND_SINGLE(12001,"当前账号正在尝试绑定一台设备"),
    /** 当前设备正在建立绑定关系 **/
    APP_USER_DEVICE_SINGLE(12002,"当前设备正在绑定中..."),
    /** 您未绑定该设备 **/
    APP_USER_DEVICE_NO_BIND(12003,"您未绑定该设备"),
    /** **/
    /** **/
    /** **/
    /** **/
    /**
     * MerchantInfoService错误码
     */
    MERCHANT_INFO_NAME_ALREADY_EXISTED(3001, "商户名已经存在"),
    MERCHANT_INFO_NO_OPERATION_ALLOWED(3002, "不允许操作"),
    MERCHANT_INFO_PHONE_ALREADY_EXISTED(3003, "手机号已被绑定"),
    MERCHANT_INFO_ACCOUNT_ALREADY_EXISTED(3004, "该账号已存在"),
    MERCHANT_INFO_SYS_USER_NOT_MERCHANT(3005, "操作用户没有所属商户"),
    MERCHANT_INFO_SET_PARENT_ID_NOT_YOUR_SUB_MERCHANT(3006, "输入的商户并非你的子级"),
    MERCHANT_INFO_NOT_EXISTED(3007, "商户不存在"),
    MERCHANT_INFO_PARENT_MERCHANT_NOT_EXISTED(3008, "设定的上级商户不存在"),
    MERCHANT_INFO_PARENT_MERCHANT_FORBIDDEN(3009, "商户被禁用或删除了"),
    MERCHANT_INFO_HAS_SUB_MERCHANT(3009, "商户存在子商户"),
    MERCHANT_INFO_HAVE_RELATION_PRODUCT_TYPE(3010, "商户存在关联产品线管理数据"),

    /**
     * MerchantApikey错误码
     */
    MERCHANT_APIKEY_REDIS_LOCK(2001, "正在处理"),

    MERCHANT_APIKEY_USER_NOT_PERMISSION(2002, "当前用户无权限"),

    MERCHANT_APIKEY_DATA_IS_EXIST(2003, "已存在商户开发者密钥"),
    MERCHANT_APIKEY_DATA_NOT_EXIST(2004, "商户开发者密钥不存在"),
    MERCHANT_APIKEY_DATA_HAVING_MORE(2005, "存在多个商户开发者密钥"),

    MERCHANT_APIKEY_MERCHANT_NOT_EXIST(2006, "商户不存在"),
    MERCHANT_APIKEY_MERCHANT_IS_LOCK(2007, "商户已停用"),
    MERCHANT_APIKEY_MERCHANT_IS_DELETE(2008, "商户已删除"),
    MERCHANT_APIKEY_USER_NOT_EXIST(2009, "用户不存在"),
    MERCHANT_APIKEY_USER_TYPE_ERROR(2010, "用户类型不正确"),
    MERCHANT_APIKEY_USER_STATUS_ERROR(2011, "用户状态不正确"),
    MERCHANT_APIKEY_DATA_ERROR(2012, "数据错误"),

    /**
     * index 类错误码
     */
    USER_NOT_EXIST(1011, "用户不存在"),
    USER_LOGIN_TOMORROW(1024, "今天已不可登录，请明天再试"),
    USER_PASSWORD_ERROR(1025, "登录密码错误"),
    USER_DELETE(1026, "该账户被删除"),
    USER_NOT_ACTIVE(1027, "该账户未激活"),
    ROLE_NOT_EXIST(1028,"角色不存在"),
    ROLE_ALERADY_DELETE(1029,"角色已经删除"),
    ACCOUNT_ALREADY_EXISTED(1030,"该账户已经存在"),
    PHONE_ALREADY_BIND(1031,"手机号已经被绑定"),
    USER_NOT_DELETE(1032,"该账户不允许被删除"),
    NO_OPERATION_ALLOWED(1033,"不允许操作"),
    ACCOUNT_OR_PASSWORD_ERROR(1034,"用户名或者密码错误"),
    /**


    /** 设备不存在 **/
    DEVICE_NOT_EXIST(13001,"设备不存在"),
    /** **/
    DEVUCE_OFFLINE(13002,"设备离线"),
    /** **/
    DEVICE_INACTIVATED(13003,"设备未激活"),
    /** **/
    DEVICE_OCCUPIED(13004,"设备已被占用"),
    /** **/
    /** **/
    ;

    private int id;
    private String name;

    ApiResultEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        return this.id == ApiResultEnum.SUCCESS.getId();
    }

    public boolean isFail() {
        return this.id != ApiResultEnum.SUCCESS.getId();
    }
}
