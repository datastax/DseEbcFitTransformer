package com.datastax.ebc.fit.pojos;


import org.apache.commons.lang.StringUtils;

public class Apps {
    private String app;
    private String imp;
    private String rflag;
    private String rcode;
    private String reasoncode;
    private String retcode;

    public Apps(String str) {
        String[] raw = str.split("\\|\\|");
        for (String entry : raw) {
            String[] keyvalue = entry.split(":");
            if (keyvalue[0].equalsIgnoreCase("apps_app")) {
                setApp(keyvalue[1]);
            }
            else if (keyvalue[0].equalsIgnoreCase("apps_imp")) {
                setImp(keyvalue[1]);
            }
            else if (keyvalue[0].equalsIgnoreCase("apps_rflag")) {
                setRflag(keyvalue[1]);
            }
            else if (keyvalue[0].equalsIgnoreCase("apps_rcode")) {
                setRcode(keyvalue[1]);
            }
            else if (keyvalue[0].equalsIgnoreCase("apps_reasoncode")) {
                setReasoncode(keyvalue[1]);
            }
            else if (keyvalue[0].equalsIgnoreCase("apps_retcode")) {
                setRetcode(keyvalue[1]);
            }
        }
    }

    public String getApp() {
        return app;
    }

    private void setApp(String app) {
        this.app = app;
    }

    public String getImp() {
        return imp;
    }

    private void setImp(String imp) {
        this.imp = imp;
    }

    public String getRflag() {
        return rflag;
    }

    private void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public String getRcode() {
        return rcode;
    }

    private void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getReasoncode() {
        return reasoncode;
    }

    private void setReasoncode(String reasoncode) {
        this.reasoncode = reasoncode;
    }

    public String getRetcode() {
        return retcode;
    }

    private void setRetcode(String retcode) {
        this.retcode = retcode;
    }
}