package com.zcool.inkstone;

import android.content.Context;

import com.zcool.inkstone.annotation.ApplicationDelegate;
import com.zcool.inkstone.service.InkstoneService;
import com.zcool.inkstone.util.ContextUtil;

import androidx.annotation.Keep;

@Keep
@ApplicationDelegate
public class InkstoneApplicationDelegate implements ModuleApplicationDelegate {

    @Override
    public void onCreate(Context context) {
    }

    @Override
    public void onStartBackgroundService() {
        InkstoneService.start(ContextUtil.getContext());
    }

}
