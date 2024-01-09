package com.TallerYei.MicroserviciosHospedaje.repository;

import org.springframework.data.repository.CrudRepository;

import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;

public interface IAuthRepository extends CrudRepository<modelUsuario, Integer> {
   
}