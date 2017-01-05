package com.example.danielspeixoto.meufinanceiro.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/3/17.
 */
@Data
public class Transaction implements Comparable<Transaction>, Parcelable {

    private String id;
    private String institutionId; // A quem se vai pagar ou receber
    private String name;
    private long amount;
    private String launchedDate; // Dia em que a conta foi criada
    private String expirationDate;
    private String comments;
    private boolean isPayed;
    private boolean isDebt;

    public Transaction() {
    }

    protected Transaction(Parcel in) {
        id = in.readString();
        institutionId = in.readString();
        name = in.readString();
        amount = in.readLong();
        launchedDate = in.readString();
        expirationDate = in.readString();
        comments = in.readString();
        isPayed = in.readByte() != 0;
        isDebt = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(institutionId);
        dest.writeString(name);
        dest.writeLong(amount);
        dest.writeString(launchedDate);
        dest.writeString(expirationDate);
        dest.writeString(comments);
        dest.writeByte((byte) (isPayed ? 1 : 0));
        dest.writeByte((byte) (isDebt ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    @Override
    public int compareTo(Transaction o) {
        return o.getExpirationDate().compareTo(getExpirationDate());
    }
}