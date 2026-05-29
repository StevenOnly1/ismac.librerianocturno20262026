package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.AutoConfigureDataJpa;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ClienteTestIntegracion {

    @Autowired
    private ClienteDAO clienteDAO;

    @Test
    public void findAll() {
        List<Cliente> clientes = clienteDAO.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for (Cliente item : clientes) {
            System.out.println(item.toString());
        }
    }


    @Test
    public void findOne() {
        Optional<Cliente> cliente = clienteDAO.findById(1);
        assertTrue(cliente.isPresent(), "El cliente con id = 1, deberia existir");
        System.out.println(cliente.toString());
    }

    @Test
    public void save() {
        Cliente cliente = new Cliente(
                0, "1728602515", "Emerson", "Perugachi", "AV, naciones Unidas", "0999972887", "perugachi@correo.com"
        );
        Cliente clienteGuardado = clienteDAO.save(cliente);
        assertNotNull(clienteGuardado.getIdCliente(), "El cliente guardado debe tener id");
        assertEquals("1728602515", clienteGuardado.getCedula());
        assertEquals("Emerson", clienteGuardado.getNombre());


    }

    @Test
    public void update() {
        Optional<Cliente> cliente = clienteDAO.findById(47);
        assertTrue(cliente.isPresent(), "El cliente con id=44 debe de existir para ser autorizado");

        cliente.orElse(null).setCedula("17286025152");
        cliente.orElse(null).setNombre("Emerson2");
        cliente.orElse(null).setApellido("Perugachi2");
        cliente.orElse(null).setDireccion("AV, naciones Unidas2");
        cliente.orElse(null).setTelefono("09999728872");
        cliente.orElse(null).setCorreo("perugachi@correo.com2");

        Cliente clienteActualizado = clienteDAO.save(cliente.orElse(null));

        assertEquals("Emerson2", clienteActualizado.getNombre());
        assertEquals("Perugachi2", clienteActualizado.getApellido());

    }


    @Test
    public void delete() {
        if (clienteDAO.existsById(46)) {
            clienteDAO.deleteById(46);
        }
        assertFalse(clienteDAO.existsById(46), "El id=44 deberia haberse eliminado");
    }

}