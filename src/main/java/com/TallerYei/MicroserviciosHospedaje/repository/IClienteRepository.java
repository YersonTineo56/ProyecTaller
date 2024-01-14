package com.TallerYei.MicroserviciosHospedaje.repository;

import org.springframework.data.repository.CrudRepository;

import com.TallerYei.MicroserviciosHospedaje.model.modelCliente;

public interface IClienteRepository extends CrudRepository<modelCliente, Integer> {

    // Puedes agregar métodos específicos de consulta si es necesario

}
