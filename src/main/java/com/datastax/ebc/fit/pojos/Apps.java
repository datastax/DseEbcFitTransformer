package com.datastax.ebc.fit.pojos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "app",
        "imp",
        "rflag",
        "rcode",
        "reasoncode",
        "retcode"
})

*/


public class Apps {

    // @JsonProperty("app")
    private String app;

    // @JsonProperty("imp")
    private String imp;

    // @JsonProperty("rflag")
    private String rflag;

    // @JsonProperty("rcode")
    private String rcode;

    // @JsonProperty("reasoncode")
    private String reasoncode;

    // @JsonProperty("retcode")
    private String retcode;


// {'app:ics_bill||imp:N||rflag:DINVALIDDATA||rcode:0||reasoncode:102||retcode:1261009'}

    // @JsonProperty("app")
    public String getApp() {
        return app;
    }

    // @JsonProperty("app")
    public void setApp(String app) {
        this.app = app;
    }

    // @JsonProperty("imp")
    public String getImp() {
        return imp;
    }

    // @JsonProperty("imp")
    public void setImp(String imp) {
        this.imp = imp;
    }

    // @JsonProperty("rflag")
    public String getRflag() {
        return rflag;
    }

    // @JsonProperty("rflag")
    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    // @JsonProperty("rcode")
    public String getRcode() {
        return rcode;
    }

    // @JsonProperty("rcode")
    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    // @JsonProperty("reasoncode")
    public String getReasoncode() {
        return reasoncode;
    }

    // @JsonProperty("reasoncode")
    public void setReasoncode(String reasoncode) {
        this.reasoncode = reasoncode;
    }

    // @JsonProperty("retcode")
    public String getRetcode() {
        return retcode;
    }

    // @JsonProperty("retcode")
    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }
}