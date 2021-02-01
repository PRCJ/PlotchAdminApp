package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WalletDataForChat {

    @SerializedName("totalBalance")
    private int totalWalletAmount;
    @SerializedName("totalCoin")
    private int coinAmount;
    @SerializedName("totalMoney")
    private int moneyAmount;
    @SerializedName("lastTransaction")
    private ArrayList<TransactionList> recentTransactions;

    public int getTotalWalletAmount() {
        return totalWalletAmount;
    }

    public void setTotalWalletAmount(int totalWalletAmount) {
        this.totalWalletAmount = totalWalletAmount;
    }

    public int getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(int coinAmount) {
        this.coinAmount = coinAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public ArrayList<TransactionList> getRecentTransactions() {
        return recentTransactions;
    }

    public void setRecentTransactions(ArrayList<TransactionList> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }



}


