package com.zcool.sample;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.zcool.inkstone.SubApplicationDelegate;
import com.zcool.inkstone.annotation.ApplicationDelegate;
import com.zcool.inkstone.ext.share.ShareConfig;

import androidx.annotation.Keep;

@Keep
@ApplicationDelegate
public class MainApplicationDelegate implements SubApplicationDelegate {

    @Override
    public void onCreate(Context context) {
        // App 启动入口, 在此处配置自定义初始化内容

        // 示例：配置 LeakCanary
        if (!LeakCanary.isInAnalyzerProcess(context)) {
            LeakCanary.install((Application) context.getApplicationContext());
        }

        // 示例：配置分享参数
        new ShareConfig.Builder()
                .setQQ(BuildConfig.QQ_APP_ID)
                .setWeixin(BuildConfig.WX_APP_KEY, BuildConfig.WX_APP_SECRET)
                .setWeibo(BuildConfig.WEIBO_APP_KEY)
                .setWeiboRedirectUrl(BuildConfig.WEIBO_REDIRECT_URL)
                .init();
    }

    @Override
    public void onStartBackgroundService() {
    }

}
