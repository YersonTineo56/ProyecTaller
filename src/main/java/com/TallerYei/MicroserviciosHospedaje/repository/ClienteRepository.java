package com.TallerYei.MicroserviciosHospedaje.repository;

import org.springframework.data.repository.CrudRepository;
import com.TallerYei.MicroserviciosHospedaje.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
