package com.example.danielspeixoto.meufinanceiro.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/3/17.
 */
@Data public class Institution implements Comparable<Institution> {

    private String id;
    private String name;

    @Override
    public String toString() {
        return name;
    }


    @Override
    public int compareTo(Institution o) {
        return o.getName().compareTo(getName());
    }
}
