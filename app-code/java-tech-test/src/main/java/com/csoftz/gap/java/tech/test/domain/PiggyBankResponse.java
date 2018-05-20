/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKRESPONSE.JAVA                                      */
/* Description:   Defines the Piggy Bank Operation Response Object.           */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: May.20/2018                                                 */
/* Version:       1.2                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.domain;

import lombok.Builder;
import lombok.Data;

/**
 * Defines the Piggy Bank Operation Response Object.
 * It holds the information result for any operation in the Piggy Bank System.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
@Data
public class PiggyBankResponse {
    private int error;
    private String msg;

    /**
     * Internal constructor to use in Builder itself.
     *
     * @param error Value to set.
     * @param msg   Value to set.
     */
    @Builder
    private PiggyBankResponse(int error, String msg) {
        this.error = error;
        this.msg = msg;
    }
}
