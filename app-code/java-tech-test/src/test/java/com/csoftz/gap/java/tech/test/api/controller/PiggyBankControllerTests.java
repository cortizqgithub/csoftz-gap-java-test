/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKCONTROLLERTESTS.JAVA                               */
/* Description:   REST Api for Piggy Bank end-points (Tests).                 */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: Sep.11/2018                                                 */
/* Version:       1.2                                                         */
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

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_CANNOT_WITHDRAW_COIN;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_COIN_INVALID_DENOMINATION;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_CANNOT_WITHDRAW_COIN;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_COIN_INVALID_DENOMINATION;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * REST Api for Piggy Bank end-points (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Sep.11/2018
 * @since 1.8 (JDK), May.19/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PiggyBankControllerTests {
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
    public void givenPiggyBankControllerReturnsStatus() throws Exception {
        mockMvc.perform(get("/api/v1/piggy-bank/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.size").isNotEmpty())
                .andExpect(jsonPath("$.coinsStore").isMap());
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPiggyBankControllerReturnsSize() throws Exception {
        mockMvc.perform(get("/api/v1/piggy-bank/size"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPiggyBankControllerReturnsSavedCoin() throws Exception {
        mockMvc.perform(get("/api/v1/piggy-bank/saved/coins"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$").isMap());
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPiggyBankControllerWhenRemoveCoinReturnsNotAllowed() throws Exception {
        mockMvc.perform(get("/api/v1/piggy-bank/remove"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.error").value(ERROR_CODE_CANNOT_WITHDRAW_COIN))
                .andExpect(jsonPath("$.msg").value(ERROR_MSG_CANNOT_WITHDRAW_COIN));
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPiggyBankControllerWhenInsertCoinValidReturnsOK() throws Exception {
        mockMvc.perform(get("/api/v1/piggy-bank/insert/50"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.error").value(0))
                .andExpect(jsonPath("$.msg").isEmpty());
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPiggyBankControllerWhenInsertCoinNotValidReturnsErr() throws Exception {
        mockMvc.perform(get("/api/v1/piggy-bank/insert/150"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.error").value(ERROR_CODE_COIN_INVALID_DENOMINATION))
                .andExpect(jsonPath("$.msg").value(ERROR_MSG_COIN_INVALID_DENOMINATION));
    }
}
