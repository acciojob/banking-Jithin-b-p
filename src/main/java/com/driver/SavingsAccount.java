package com.driver;


public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > super.getBalance()){

            throw new InsufficientBalanceException("Insufficient Balance");

        }else if(amount > maxWithdrawalLimit){

            throw new MaxWithdrawLimitException("Maximum Withdraw Limit Exceed");

        }
        super.setBalance(super.getBalance() - amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double amount = super.getBalance();
        double simpleInterest = 0.0;
        simpleInterest = amount * rate * years / 100;
        return amount + simpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double amount = super.getBalance();
        double compoundInterest = 0.0;
        compoundInterest = (amount * (Math.pow(1 +(rate / 100), times * years))) - amount;

        return amount + compoundInterest;
    }

}
