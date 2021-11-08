package com.jw.demo.app.controller;

import com.alibaba.fastjson.JSON;
import com.jw.demo.app.AppBaseException;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.Response;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class BaseController {


    public Response getFailResponse(String errorTip, Exception e, Logger log, String methodName, HttpServletRequest request) {
        Response response = new FailResponse();
        if (e instanceof AppBaseException) {
            response.setCode(((AppBaseException) e).getErrCode());
            response.setTip(e.getMessage());
            log.error("func[{}] parameterMap[{}] response[{}] desc[业务异常]", //
                    new Object[] { methodName, JSON.toJSONString(request.getParameterMap()), JSON.toJSONString(response) });
        } else {
            log.error("func[{}] parameterMap[{}] exception[{} - {}] desc[fail]", //
                    new Object[] { methodName, JSON.toJSONString(request.getParameterMap()), e.getMessage(), Arrays.deepToString(e.getStackTrace()) });
            response.setTip(errorTip);
        }
        return response;
    }
}
