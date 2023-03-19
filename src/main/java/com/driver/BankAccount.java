package com.driver;
class MaxWithdrawLimitException extends Exception{

    public MaxWithdrawLimitException(String str){
        super(str);
    }
}
class AccountNumberException extends Exception{
    public AccountNumberException(String str){
        super(str);
    }
}
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String str) {

        super(str);
    }
}
public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int tempDigits = digits;
        int tempSum = 0;
        while(tempDigits != 0){
            tempSum += (tempDigits % 10);
            tempDigits /= 10;
        }
        if(tempSum != sum){

            throw new AccountNumberException("Account Number can not be generated");
        }

        return null;
    }

    public void deposit(double amount) {

        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance -= amount;

    }

}