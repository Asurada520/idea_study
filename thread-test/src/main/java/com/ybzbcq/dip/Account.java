package com.ybzbcq.dip;

public class Account {
    private AccountType accountType;
    private AccountStatus accountStatus;

//    public Account() {
//    }

    public Account(AccountType accountType) {
        this.accountType = accountType;
        System.out.println("Constructor:Account(AccountType accountType), account type");
    }



    public void deposit(float amt){
        accountType.deposit(amt);
        System.out.println("Method:deposit(float amt), account operation: " + amt);
    }
}
