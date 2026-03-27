package com.example.boletas_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoletaResponse implements Serializable {
    private int valorBruto;
    private int valorLiquido;

}
