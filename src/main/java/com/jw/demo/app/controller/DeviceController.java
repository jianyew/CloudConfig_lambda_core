package com.jw.demo.app.controller;

import com.jw.demo.app.request.device.CertificateGetRequest;
import com.jw.demo.app.request.device.PropertyGetRequest;
import com.jw.demo.app.request.device.ShadowUpdateRequest;
import com.jw.demo.app.service.DeviceService;
import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/device")
public class DeviceController extends BaseController {
    private Logger log = LoggerFactory.getLogger(getClass());

    /** 获取设备证书 **/
    private static final String REGISTER = "/register";
    /** 获取设备属性 **/
    private static final String PROPERTY_GET = "/property/get";
    /** 更新设备影子 **/
    private static final String SHADOW_UPDATE = "/shadow/update";

    @Resource
    private DeviceService deviceService;

    @PostMapping(value = REGISTER, produces = { "application/json;charset=UTF-8" })
    public String certificateGet(HttpServletRequest request) {
        Response response;
        try {
            CertificateGetRequest certificateGetRequest = new CertificateGetRequest();
            response = certificateGetRequest.parse(request);
            if (response.getCode() == ApiResultEnum.SUCCESS.getId()) {
                response = deviceService.certificateGet(certificateGetRequest);
            }
        } catch (Exception e) {
            response = this.getFailResponse("获取设备证书失败", e, log,
                    Thread.currentThread().getStackTrace()[1].getMethodName(), request);
        }
        return response.toString();
    }

    @PostMapping(value = PROPERTY_GET, produces = { "application/json;charset=UTF-8" })
    public String propertyGet(HttpServletRequest request) {
        Response response;
        try {
            PropertyGetRequest propertyGetRequest = new PropertyGetRequest();
            response = propertyGetRequest.parse(request);
            if (response.getCode() == ApiResultEnum.SUCCESS.getId()) {
                response = deviceService.propertyGet(propertyGetRequest);
            }
        } catch (Exception e) {
            response = this.getFailResponse("获取设备属性失败", e, log,
                    Thread.currentThread().getStackTrace()[1].getMethodName(), request);
        }
        return response.toString();
    }
    
    @PostMapping(value = SHADOW_UPDATE, produces = { "application/json;charset=UTF-8" })
    public String updateShadow(HttpServletRequest request) {
        Response response;
        try {
            ShadowUpdateRequest shadowUpdateRequest = new ShadowUpdateRequest();
            response = shadowUpdateRequest.parse(request);
            if (response.getCode() == ApiResultEnum.SUCCESS.getId()) {
                response = deviceService.updateShadow(shadowUpdateRequest);
            }
        } catch (Exception e) {
            response = this.getFailResponse("更新设备影子失败", e, log,
                    Thread.currentThread().getStackTrace()[1].getMethodName(), request);
        }
        return response.toString();
    }

}
