package com.datastax.ebc.fit.pojos;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppsTest {
    @Test
    public void getAppFromString() {
        Apps apps = new Apps("app:ics_bill||imp:N||rflag:DINVALIDDATA||rcode:0||reasoncode:102||retcode:1261009");
        System.out.println(apps.toString());
        assertEquals("ics_bill",apps.getApp());
        assertEquals("N", apps.getImp());
        assertEquals("DINVALIDDATA",apps.getRflag());
        assertEquals("0",apps.getRcode());
        assertEquals("102",apps.getReasoncode());
        assertEquals("1261009",apps.getRetcode());
    }
}