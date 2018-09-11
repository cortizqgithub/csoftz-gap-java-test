/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMECONTROLLERTETS.JAVA                               */
/* Description:   REST Api for Palindrome end-points. (Tests)                 */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: Sep.11/2018                                                 */
/* Version:       1.3                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * REST Api for Palindrome end-points. (Tests)
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.11/2018
 * @since 1.8 (JDK), May.19/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PalindromeControllerTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    /**
     * Configure all tests initial settings.
     */
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPalindromeControllerWhenSettingAPalindromeTextReturnsTrue() throws Exception {
        mockMvc.perform(get("/api/v1/palindrome/check?t=A nut for a jar of tuna"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$").isBoolean())
                .andExpect(jsonPath("$").value(true));
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPalindromeControllerWhenSettingANonPalindromeTextReturnsTrue() throws Exception {
        mockMvc.perform(get("/api/v1/palindrome/check?t=Car"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$").isBoolean())
                .andExpect(jsonPath("$").value(false));
    }
}
