package com.raiffeisen;

public enum ENumber {
    data1 (1000, 2,500),
    data2 (6, 3,2);

    int num1;
    int num2;
    int result;

    ENumber(int num1, int num2, int result){
        this.num1=num1;
        this.num2=num2;
        this.result=result;
    }
}
