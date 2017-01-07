package com.example.danielspeixoto.meufinanceiro.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/7/17.
 */

@Data
public class Frequency {
    private String name;
    private int value;

    public Frequency(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
