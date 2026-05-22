package com.distribuida.dao;

import com.distribuida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {


    //hola mi nombre es Emerson, actualmente estudio en el ISMAC, tengo 23 años
}
