package com.retail.intercorp.repository.impl;

import com.retail.intercorp.domain.Cliente;
import com.retail.intercorp.repository.ClienteRepository;
import com.retail.intercorp.repository.mapper.ClienteMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClienteRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cliente> findAll() {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
                .withProcedureName("cliente__find_all")
                .returningResultSet("result",new ClienteMapper());

        Map<String,Object> parameters=new HashMap<>();
        Map<String,Object> result= simpleJdbcCall.execute(parameters);

        List<Cliente> clientes = (List<Cliente>) result.get("result");

        return clientes;
    }

    @Override
    public void insert(Cliente cliente) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
                .withProcedureName("cliente__insert");

        Map<String,Object> parameters=new HashMap<>();
        parameters.put("p_nombre",cliente.getNombre());
        parameters.put("p_apellido",cliente.getApellido());
        parameters.put("p_edad",cliente.getEdad());
        parameters.put("p_fecha_nacimiento",cliente.getFechaNac());
        Map<String,Object> result= simpleJdbcCall.execute(parameters);
    }

    @Override
    public void delete(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
                .withProcedureName("cliente__delete");

        Map<String,Object> parameters=new HashMap<>();
        parameters.put("p_id",id);
        Map<String,Object> result= simpleJdbcCall.execute(parameters);
    }

    @Override
    public void update(Cliente cliente) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource())
                .withProcedureName("cliente__update");

        Map<String,Object> parameters=new HashMap<>();
        parameters.put("p_id",cliente.getId());
        parameters.put("p_nombre",cliente.getNombre());
        parameters.put("p_apellido",cliente.getApellido());
        parameters.put("p_edad",cliente.getEdad());
        parameters.put("p_fecha_nac",cliente.getFechaNac());
        Map<String,Object> result= simpleJdbcCall.execute(parameters);
    }

}
