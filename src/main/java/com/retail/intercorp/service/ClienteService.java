package com.retail.intercorp.service;

import com.retail.intercorp.domain.Cliente;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    void insert(Cliente cliente);
    void delete(int id);
    void update(Cliente cliente);
    String getDateEnd(String fechaNac) throws ParseException;

}
