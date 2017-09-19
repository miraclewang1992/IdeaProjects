package com;

/**
 * Created by doshest on 2017/7/14.
 */
public enum CompanyEnum {
    SF("顺丰速运", 1001,100), YTO("圆通速递", 1002,100),STO("申通物流",1003,100),YD("韵达快运",1004,100),YZPY("中国邮政",1005,100);
    private CompanyEnum(String company, int code,int status) {
        this.company = company;
        this.code = code;
        this.status = status;
    }
    private String company; // 公司名称
    private int code; // 公司编码
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}
