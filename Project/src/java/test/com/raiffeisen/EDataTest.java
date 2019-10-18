package com.raiffeisen;

public enum EDataTest {
    data1 ("4567", "4567"),
    data2 ("7549", "1594"),
    data3 ("1121", "2222");

    String att;
    String hid;

    //контруктор
    EDataTest(String att, String hid){
        this.att=att;
        this.hid=hid;
    }

    public String getHid() {
        return hid;
    }

    public String getAtt() {
        return att;
    }

}
