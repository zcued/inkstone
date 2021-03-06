package com.example.appmodule;

import android.content.Context;

import com.zcool.inkstone.ModuleApplicationDelegate;
import com.zcool.inkstone.annotation.ApplicationDelegate;

import timber.log.Timber;

@ApplicationDelegate(priority = 1)
public class AppModuleApplicationDelegate implements ModuleApplicationDelegate {

    @Override
    public void onCreate(Context context) {
        Timber.v("[priority 1] onCreate");
    }

    @Override
    public void onStartBackgroundService() {
        Timber.v("[priority 1] onStartBackgroundService");
    }

}
