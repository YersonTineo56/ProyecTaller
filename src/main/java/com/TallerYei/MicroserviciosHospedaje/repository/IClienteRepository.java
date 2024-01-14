package com.TallerYei.MicroserviciosHospedaje.repository;


import com.TallerYei.MicroserviciosHospedaje.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
