package com.raiffeisen;

public enum EData {
    data1 (1234, "4356","2"),
    data2 (5678, "4356","2"),
    data3 (1111, "2222","2");

    int att;
    String hid;
    String exp;

    //контруктор
    EData(int att, String hid, String exp){
        this.att=att;
        this.hid=hid;
        this.exp=exp;
    }

    public String getExp() {
        return exp;
    }

    public String getHid() {
        return hid;
    }

    public int getAtt() {
        return att;
    }

}
