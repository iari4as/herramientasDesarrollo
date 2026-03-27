package com.example.boletas_spring.service;

import org.springframework.stereotype.Service;

@Service
public class BoletaService {
    private static final double MULTI_NETO = 0.8475;
    public double calcularNeto(double val){

        return val * MULTI_NETO;
    }

    public double calcularBruto(double val){

        return val / MULTI_NETO;
    }
}
