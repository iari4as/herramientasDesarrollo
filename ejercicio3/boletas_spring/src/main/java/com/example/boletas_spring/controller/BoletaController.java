package com.example.boletas_spring.controller;

import com.example.boletas_spring.entities.BoletaRequest;
import com.example.boletas_spring.entities.BoletaResponse;
import com.example.boletas_spring.service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BoletaController {
    @Autowired
    private BoletaService boletaService;

    @PostMapping("/calcular-neto")
    public ResponseEntity<?> CalcularNeto (@RequestBody BoletaRequest request){
        if(request.getVal() <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        double resul = boletaService.calcularNeto(request.getVal());
        BoletaResponse response = new BoletaResponse(request.getVal(), (int)resul);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/calcular-bruto")
    public ResponseEntity<?> CalcularBruto (@RequestBody BoletaRequest request){
        if(request.getVal() <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        double resul = boletaService.calcularNeto(request.getVal());
        //dio buelta v
        BoletaResponse response = new BoletaResponse((int)resul,request.getVal());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
