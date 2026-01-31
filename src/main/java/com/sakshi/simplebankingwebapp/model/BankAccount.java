package com.sakshi.simplebankingwebapp.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    public BankAccount(String name, int accNo, double balance) {
        this.accountHolderName = name;
        this.accountNumber = accNo;
        this.balance = balance;
        transactions.add("Account created with balance ₹" + balance);
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Invalid deposit amount.";
        }
        balance += amount;
        transactions.add("Deposited ₹" + amount);
        return "₹" + amount + " deposited successfully.";
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid withdrawal amount.";
        }
        if (amount > balance) {
            return "Insufficient funds.";
        }
        balance -= amount;
        transactions.add("Withdrew ₹" + amount);
        return "₹" + amount + " withdrawn successfully.";
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
