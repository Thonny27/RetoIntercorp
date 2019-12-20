package com.retail.intercorp.service.impl;

import com.retail.intercorp.domain.Cliente;
import com.retail.intercorp.repository.ClienteRepository;
import com.retail.intercorp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void insert(Cliente cliente) {
        clienteRepository.insert(cliente);
    }

    @Override
    public void delete(int id) {
        clienteRepository.delete(id);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepository.update(cliente);
    }

    @Override
    public String getDateEnd(String fechaNac) throws ParseException {
        int age=84;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(fechaNac);
        Calendar cal2 = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        for(int i = 1;i<=age;i++){
            cal.add(Calendar.YEAR,1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaMuerte = formatter.format(cal.getTime());

        return fechaMuerte;

    }

}
