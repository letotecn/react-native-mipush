package com.ichong.zzy.mipush;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.mipush.sdk.MiPushMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzy on 16/8/13.
 * Date : 16/8/13 16:18
 */
public class MIPushHelper {

    public static WritableMap parsePushMessage(MiPushMessage miPushMessage) {

        if (miPushMessage == null) {

            return null;
        }
        try {

            WritableMap param = Arguments.createMap();
            param.putString("title", miPushMessage.getTitle());
            param.putString("description", miPushMessage.getDescription());
            param.putString("content", miPushMessage.getContent());
            Map hashMap=miPushMessage.getExtra();
            param.putString("uri", (String) hashMap.get("uri"));
            param.putString("event", (String) hashMap.get("event"));
            param.putString("route_name", (String) hashMap.get("route_name"));
            param.putString("route_params", (String) hashMap.get("route_params"));
            param.putString("category", miPushMessage.getCategory());
            param.putInt("notifyId", miPushMessage.getNotifyId());
            param.putInt("notifyType", miPushMessage.getNotifyType());
            return param;
        } catch (Exception e) {

            return null;
        }

    }


    public static String getMIPushValue(Context context, String key) throws Exception {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(key)) {
            return "";
        }

        ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);

        if (appInfo != null && appInfo.metaData != null && appInfo.metaData.containsKey(key)) {

            return appInfo.metaData.getString(key).replace(":", "");
        } else {
            return "";
        }
    }
}
