package com.datastax.ebc.fit.pojos;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppsTest {
    @Test
    public void getAppFromString() {
        Apps apps = new Apps("apps_app:ics_bill||apps_imp:N||apps_rflag:DINVALIDDATA||apps_rcode:0||apps_reasoncode:102||apps_retcode:1261009");
        assertEquals("ics_bill",apps.getApp());
        assertEquals("N", apps.getImp());
        assertEquals("DINVALIDDATA",apps.getRflag());
        assertEquals("0",apps.getRcode());
        assertEquals("102",apps.getReasoncode());
        assertEquals("1261009",apps.getRetcode());
    }
}