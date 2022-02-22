package com.duvalhub.dummy.artifact2;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application implements ApplicationProfiles {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class)
                .profiles(new String[] {
                        DEFAULT_PROFILE
                })
                .web(WebApplicationType.SERVLET)
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

    }

}
