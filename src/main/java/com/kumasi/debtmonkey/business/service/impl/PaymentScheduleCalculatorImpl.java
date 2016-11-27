/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kumasi.debtmonkey.business.service.impl;

import com.kumasi.debtmonkey.business.service.PaymentScheduleCalculator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Service;


/**
 *
 * @author obasola
 */
@Service
public class PaymentScheduleCalculatorImpl implements PaymentScheduleCalculator {
    protected DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    private Calendar calendar;
    private final int THIRTY_DAYS = 30;
    
    public Date getNextPaymentDate(Date currDate) throws Exception {
    	if(currDate == null) {
    		currDate = Calendar.getInstance().getTime();
    	}
        calendar.setTime(currDate);
        calendar.add(Calendar.DATE, THIRTY_DAYS);
        return calendar.getTime();
    }
    
    public String getNextPaymentDate(String dateStr) throws Exception {
        return this.getNextPaymentDate(dateStr,THIRTY_DAYS);
    }
    
    public String getNextPaymentDate(String dateStr, int numberOfDays) throws Exception {
        String nextPymtDate = "";
        calendar = Calendar.getInstance();
        calendar.setTime(df.parse(dateStr));
        calendar.add(Calendar.DATE, numberOfDays);
        
        nextPymtDate= df.format(calendar.getTime());
        return nextPymtDate;
    }
}
