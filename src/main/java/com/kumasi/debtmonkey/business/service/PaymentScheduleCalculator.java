/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kumasi.debtmonkey.business.service;

import java.util.Date;

/**
 *
 * @author obasola
 */
public interface PaymentScheduleCalculator {
    public Date getNextPaymentDate(Date currDate) throws Exception;
    public String getNextPaymentDate(String dateStr) throws Exception;
    public String getNextPaymentDate(String dateStr, int numberOfDays) throws Exception;
}
