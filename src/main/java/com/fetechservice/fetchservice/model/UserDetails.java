package com.fetechservice.fetchservice.model;


public class UserDetails {
//patientid,rxNumber,storenum,daysSupply
    private String patientid;
    private String rxNumber;
    private String storenum;
    private String daysSupply;

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getRxNumber() {
        return rxNumber;
    }

    public void setRxNumber(String rxNumber) {
        this.rxNumber = rxNumber;
    }

    public String getStorenum() {
        return storenum;
    }

    public void setStorenum(String storenum) {
        this.storenum = storenum;
    }

    public String getDaysSupply() {
        return daysSupply;
    }

    public void setDaysSupply(String daysSupply) {
        this.daysSupply = daysSupply;
    }
}
