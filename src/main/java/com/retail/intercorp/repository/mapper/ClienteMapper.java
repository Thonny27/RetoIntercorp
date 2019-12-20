package com.retail.intercorp.repository.mapper;

import com.retail.intercorp.domain.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(resultSet.getInt("id"));
        cliente.setNombre(resultSet.getString("nombre"));
        cliente.setApellido(resultSet.getString("apellido"));
        cliente.setEdad(resultSet.getInt("edad"));
        cliente.setFechaNac(resultSet.getString("fecha_nacimiento"));
        return cliente;
    }
}
