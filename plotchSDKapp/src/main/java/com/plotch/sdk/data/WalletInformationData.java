package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WalletInformationData implements Serializable {

    @SerializedName("totalWalletAmount")
    private int totalWalletAmount;
    @SerializedName("totalUsableWalletAmount")
    private int totalUsableWalletAmount;
    @SerializedName("isWalletBalanceUsed")
    private boolean isWalletBalanceUsed;
    @SerializedName("coinsUsed")
    private int coinsUsed;
    @SerializedName("moneyUsed")
    private int moneyUsed;

    public int getCoinsUsed() {
        return coinsUsed;
    }

    public void setCoinsUsed(int coinsUsed) {
        this.coinsUsed = coinsUsed;
    }

    public int getMoneyUsed() {
        return moneyUsed;
    }

    public void setMoneyUsed(int moneyUsed) {
        this.moneyUsed = moneyUsed;
    }

    public int getTotalWalletAmount() {
        return totalWalletAmount;
    }

    public void setTotalWalletAmount(int totalWalletAmount) {
        this.totalWalletAmount = totalWalletAmount;
    }

    public int getTotalUsableWalletAmount() {
        return totalUsableWalletAmount;
    }

    public void setTotalUsableWalletAmount(int totalUsableWalletAmount) {
        this.totalUsableWalletAmount = totalUsableWalletAmount;
    }

    public boolean isWalletBalanceUsed() {
        return isWalletBalanceUsed;
    }

    public void setWalletBalanceUsed(boolean walletBalanceUsed) {
        isWalletBalanceUsed = walletBalanceUsed;
    }

}
