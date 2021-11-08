package com.jw.demo.app.service;


import com.jw.demo.app.request.appdevice.AppBindDeviceRequest;
import com.jw.demo.app.request.appdevice.AppListDeivceRequest;
import com.jw.demo.common.entity.base.AppUser;
import com.jw.demo.common.response.Response;

public interface AppUserDeviceService {
    /**
     * 绑定设备
     * @param appuser
     * @param request
     * @return
     * @throws Exception
     */
    Response bindAppUserDevice(AppUser appuser, AppBindDeviceRequest request)throws Exception;

    /**
     * 用户查询设备
     * @param appUser
     * @param request
     * @return
     * @throws Exception
     */
    Response listAppUserDevice(AppUser appUser, AppListDeivceRequest request)throws Exception;


}
