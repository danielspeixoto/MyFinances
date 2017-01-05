package com.example.danielspeixoto.meufinanceiro.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/3/17.
 */
@Data
public class Transaction {

    private String id;
    private String institutionId; // A quem se vai pagar ou receber
    private String name;
    private long amount;
    private String launchedDate; // Dia em que a conta foi criada
    private String expirationDate;
    private String comments;
    private boolean isPayed;
    private boolean isDebt;

}
