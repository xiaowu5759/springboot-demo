package com.xiaowu.springbootdemo.domain;

import org.springframework.stereotype.Repository;

public class AccountInfo {

    private Long accountId;
    private String name;
    private String pwd;
    private String balance;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
