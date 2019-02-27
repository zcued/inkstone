package com.zcool.inkstone.processor;

public interface Constants {

    String ANNOTATION_TYPE_APPLICATION_DELEGATE = "com.zcool.inkstone.annotation.ApplicationDelegate";
    String ANNOTATION_TYPE_SERVICES_PROVIDER = "com.zcool.inkstone.annotation.ServicesProvider";

    String OPTION_MODULE_MANIFEST_PACKAGE = "INKSTONE_MODULE_MANIFEST_PACKAGE";

    String TIP_NO_OPTION_MODULE_MANIFEST_PACKAGE = "miss option " + OPTION_MODULE_MANIFEST_PACKAGE + ", at module 'build.gradle', like :\n" +
            "android {\n" +
            "    defaultConfig {\n" +
            "        ...\n" +
            "        javaCompileOptions {\n" +
            "            annotationProcessorOptions {\n" +
            "                arguments = ['" + OPTION_MODULE_MANIFEST_PACKAGE + "': \"com.example.appmodule2\"]\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}\n";

}
