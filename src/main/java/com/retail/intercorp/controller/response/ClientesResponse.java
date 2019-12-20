package com.retail.intercorp.controller.response;

import lombok.Data;

import java.util.Date;

@Data
public class ClientesResponse {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNac;
    private String fechaMuerteAprox;
}
