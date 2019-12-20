package com.retail.intercorp.repository;

import com.retail.intercorp.domain.Cliente;

import java.util.List;

public interface ClienteRepository {

	  List<Cliente>findAll();
	  void insert(Cliente cliente);
	  void delete(int id);
	  void update(Cliente cliente);
}
