package com.ichong.zzy.mipush;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.facebook.react.bridge.*;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.util.List;

import static com.facebook.react.common.ReactConstants.TAG;

/**
 * Created by zzy on 16/8/11.
 * Date : 16/8/11 13:22
 */
public class MIPushModule extends ReactContextBaseJavaModule {
    public MIPushModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "MIPushModule";
    }


    @ReactMethod
    public void initMiPush() {

        try {
            final String appId = MIPushHelper.getMIPushValue(getReactApplicationContext(), "MIPUSH_APPID");
            final String appKey = MIPushHelper.getMIPushValue(getReactApplicationContext(), "MIPUSH_APPKEY");

            if (shouldInit(getReactApplicationContext().getApplicationContext())) {
              MiPushClient.registerPush(getReactApplicationContext().getApplicationContext(), appId, appKey);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean shouldInit(Context context) {
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = context.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }


    @ReactMethod
    public void setAlias(String text) {

        MiPushClient.setAlias(getReactApplicationContext(), text, null);
    }

    @ReactMethod
    public void unsetAlias(String text) {

        MiPushClient.unsetAlias(getReactApplicationContext(), text, null);
    }

    @ReactMethod
    public void getAllTopic(Promise promise) {
        WritableArray writableArray = new WritableNativeArray();
        List<String> topics =MiPushClient.getAllTopic(getReactApplicationContext());
        for(String topic:topics){
            writableArray.pushString(topic);
        }

        promise.resolve(writableArray);
    }

    @ReactMethod
    public void subscribe(String text) {

        MiPushClient.subscribe(getReactApplicationContext(), text, null);
    }

    @ReactMethod
    public void unsubscribe(String text) {

        MiPushClient.unsubscribe(getReactApplicationContext(), text, null);
    }

    @ReactMethod
    public void setAccount(String text) {

        MiPushClient.setUserAccount(getReactApplicationContext(), text, null);
    }

    @ReactMethod
    public void unsetAccount(String text) {

        MiPushClient.setAlias(getReactApplicationContext(), text, null);
    }


    @ReactMethod
    public void presentLocalNotification(ReadableMap notification) {

    }

    @ReactMethod
    public void getInitialNotification(
        Promise promise) {

        promise.resolve(MIPushHelper.parsePushMessage(MIPushPackage.sMiPushMessage));

        MIPushPackage.sMiPushMessage = null;
    }

    @ReactMethod
    public void clearNotification(int id) {

        MiPushClient.clearNotification(getReactApplicationContext(), id);
    }

    @ReactMethod
    public void clearAllNotification() {

        MiPushClient.clearNotification(getReactApplicationContext());
    }

}
