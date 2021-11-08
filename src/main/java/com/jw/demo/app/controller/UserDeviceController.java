package com.jw.demo.app.controller;

import com.jw.demo.app.request.appdevice.AppBindDeviceRequest;
import com.jw.demo.app.request.appdevice.AppListDeivceRequest;
import com.jw.demo.app.service.AppUserDeviceService;
import com.jw.demo.app.util.AppTokenUtil;
import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.entity.base.AppUser;
import com.jw.demo.common.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user/device")
public class UserDeviceController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeviceController.class);

    @Resource
    private AppUserDeviceService appUserDeviceService;

    @RequestMapping(value = "/bind",produces = "text/json;charset=utf-8")
    public String bindDevice(HttpServletRequest request){
        Response response;
        try {
            AppUser appUser = AppTokenUtil.getAppUser(request.getHeader("token"));
            AppBindDeviceRequest appBindDeviceRequest = new AppBindDeviceRequest();
            response = appBindDeviceRequest.parse(request);
            if (response.getCode() == ApiResultEnum.SUCCESS.getId()) {
                response = appUserDeviceService.bindAppUserDevice(appUser,appBindDeviceRequest);
            }
        } catch (Exception e) {
            response = this.getFailResponse("绑定失败", e, LOGGER, Thread.currentThread().getStackTrace()[1].getMethodName(),
                    request);
        }
        return response.toString();
    }

    @RequestMapping(value = "/list",produces = "text/json;charset=utf-8")
    public String listDevice(HttpServletRequest request){
        Response response;
        try {
            AppUser appUser = AppTokenUtil.getAppUser(request.getHeader("token"));
            AppListDeivceRequest appListDeivceRequest = new AppListDeivceRequest();
            response = appListDeivceRequest.parse(request);
            if (response.getCode() == ApiResultEnum.SUCCESS.getId()) {
                response = appUserDeviceService.listAppUserDevice(appUser,appListDeivceRequest);
            }
        } catch (Exception e) {
            response = this.getFailResponse("查询绑定", e, LOGGER, Thread.currentThread().getStackTrace()[1].getMethodName(),
                    request);
        }
        return response.toString();
    }

}
