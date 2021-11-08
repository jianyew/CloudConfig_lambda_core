package com.jw.demo.app.util;

import com.jw.demo.common._enum.DeletedEnum;
import com.jw.demo.common.entity.base.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * token与对象的管理
 */
public class AppTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppTokenUtil.class);

    /**
     * 获取App用户, mock
     * @param token
     * @return
     */

    public static AppUser getAppUser(String token)throws Exception{
        AppUser appUserInfo = new AppUser();
        appUserInfo.setId(1L);
        appUserInfo.setName("TEST");
        appUserInfo.setAccount("807915e2-b597-440a-8417-cee4927d3d06");
        appUserInfo.setDeleted(DeletedEnum.F.getId());
        return  appUserInfo;
    }

}
