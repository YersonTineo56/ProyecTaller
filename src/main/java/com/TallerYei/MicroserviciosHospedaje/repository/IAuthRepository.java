package com.TallerYei.MicroserviciosHospedaje.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;

@Repository
public interface IAuthRepository extends CrudRepository<modelUsuario, Integer> {
   
}