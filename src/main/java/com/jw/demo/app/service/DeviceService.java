package com.jw.demo.app.service;

import com.jw.demo.app.request.device.CertificateGetRequest;
import com.jw.demo.app.request.device.PropertyGetRequest;
import com.jw.demo.app.request.device.ShadowUpdateRequest;
import com.jw.demo.common.response.Response;

public interface DeviceService {

    Response certificateGet(CertificateGetRequest request) throws Exception;

    Response propertyGet(PropertyGetRequest request) throws Exception;

    Response updateShadow(ShadowUpdateRequest request) throws Exception;

}
