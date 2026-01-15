package com.vignesh.basics.debug;

import org.springframework.boot.ssl.SslBundles;
import org.springframework.stereotype.Component;

@Component
public class MyDebugComponent {
    public MyDebugComponent(SslBundles bundles) {
        System.out.println("BUNDLE = " + bundles.getBundle("kafka-client"));
    }
}
