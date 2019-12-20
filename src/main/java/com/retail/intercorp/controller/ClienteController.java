package com.retail.intercorp.controller;

import com.retail.intercorp.controller.response.ClientesKpiResponse;
import com.retail.intercorp.controller.response.ClientesResponse;
import com.retail.intercorp.domain.Cliente;
import com.retail.intercorp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("kpideclientes")
    public ResponseEntity<?> findKpiClientes() {

        float div = (float) 15 / 2;
        System.out.println(div);

        int edad = 0;
        double numero;
        double numerocuadrado;
        double sumatoria = 0;
        double desviacionEstandar;
        List<Cliente> clienteList = clienteService.findAll();
        for (int i = 0; i < clienteList.size(); i++) {
            edad = edad + clienteList.get(i).getEdad();
        }
        float prom = (float) edad / clienteList.size();

        for (int i = 0; i < clienteList.size(); i++) {
            numero = clienteList.get(i).getEdad() - prom;
            numerocuadrado = Math.pow(numero, 2);
            sumatoria = sumatoria + numerocuadrado;
        }
        desviacionEstandar = sumatoria / (clienteList.size() - 1);
        double desviacion = (double) Math.sqrt(desviacionEstandar);

        ClientesKpiResponse clientesKpiResponse = new ClientesKpiResponse();
        clientesKpiResponse.setPromedioEdad((double) Math.round(prom * 1d) / 1d);
        clientesKpiResponse.setDesviacionEstandar((double) Math.round(desviacion * 100d) / 100d);

        return new ResponseEntity<>(clientesKpiResponse, HttpStatus.OK);
    }

    @GetMapping("listclientes")
    public ResponseEntity<?> findAllClientes() throws ParseException {

        List<Cliente> clienteList = clienteService.findAll();

        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        for (int i = 0; i < clienteList.size(); i++) {
            ClientesResponse clientesResponse = new ClientesResponse();
            clientesResponse.setId(clienteList.get(i).getId());
            clientesResponse.setNombre(clienteList.get(i).getNombre());
            clientesResponse.setApellido(clienteList.get(i).getApellido());
            clientesResponse.setEdad(clienteList.get(i).getEdad());
            clientesResponse.setFechaNac(clienteList.get(i).getFechaNac());
            clientesResponse.setFechaMuerteAprox(clienteService.getDateEnd(clienteList.get(i).getFechaNac()));

            clientesResponseList.add(clientesResponse);
        }

        return new ResponseEntity<>(clientesResponseList, HttpStatus.OK);
    }

    @PostMapping("creacliente")
    public ResponseEntity<?> insert(@RequestBody Cliente cliente) {

        Map<String, Object> response = new HashMap<>();
        try {
            clienteService.insert(cliente);
        } catch (DataAccessException e) {
            response.put("Error al insertar cliente ", e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Guardado Correctamente ...", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        clienteService.delete(id);
        return new ResponseEntity<>("Eliminado Correctamente ...", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Cliente cliente) {
        clienteService.update(cliente);
        return new ResponseEntity<>("Actualizado Correctamente ...", HttpStatus.OK);
    }

}
