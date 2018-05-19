/*----------------------------------------------------------------------------*/
/* Source File:   JAVATECHTESTAPPLICATION.JAVA                                */
/* Description:   Spring Boot Java Technical Test for GAP application         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: May.19/2018                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.APP_NAME;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.APP_VERSION;

/**
 * Spring Boot Java Technical Test for GAP application
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.19/2018
 * @since 1.8 (JDK), May.19/2018
 */
@SpringBootApplication
public class JavaTechTestApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(JavaTechTestApplication.class);

    /**
     * Application main entry point
     *
     * @param args Command line arguments passed for application.
     */
    public static void main(String[] args) {
        SpringApplication.run(JavaTechTestApplication.class, args);
    }

    /**
     * Execute the command line runner task.
     *
     * @param args Command line arguments.
     * @throws Exception Captures any exception when executiong.
     */
    @Override
    public void run(String... args) throws Exception {
        String appVersion = APP_NAME + " " + APP_VERSION;
        System.out.println(appVersion);
        log.info(appVersion);
    }
}
