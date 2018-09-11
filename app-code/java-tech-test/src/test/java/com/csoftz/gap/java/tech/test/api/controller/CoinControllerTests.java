/*----------------------------------------------------------------------------*/
/* Source File:   COINCONTROLLERTESTS.JAVA                                    */
/* Description:   REST Api for Coin end-points (Tests).                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.20/2018                                                 */
/* Last Modified: Sep.11/2018                                                 */
/* Version:       1.2                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.api.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_FIFTY;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_FIVE_HUNDRED;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_ONE_HUNDRED;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_ONE_THOUSAND;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_TWO_HUNDRED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * REST Api for Coin end-points (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Sep.11/2018
 * @since 1.8 (JDK), May.20/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoinControllerTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    /**
     * Configure all tests initial settings.
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenCoinControllerReturnsList() throws Exception {
        mockMvc.perform(get("/api/v1/coin/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$").value(Matchers.hasSize(5)))
                .andExpect(jsonPath("$[0]").value(COIN_VALUE_FIFTY))
                .andExpect(jsonPath("$[1]").value(COIN_VALUE_ONE_HUNDRED))
                .andExpect(jsonPath("$[2]").value(COIN_VALUE_TWO_HUNDRED))
                .andExpect(jsonPath("$[3]").value(COIN_VALUE_FIVE_HUNDRED))
                .andExpect(jsonPath("$[4]").value(COIN_VALUE_ONE_THOUSAND));
    }
}
