package com.driver;

public class Main {
    public static void main(String[] args){

        SavingsAccount obj = new SavingsAccount("jithin", 10000, 6000, 10);

        try{
            obj.withdraw(7000);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(obj.getSimpleInterest(2));
        System.out.println(obj.getCompoundInterest(1, 2));

    }
}