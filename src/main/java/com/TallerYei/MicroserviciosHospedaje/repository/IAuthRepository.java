package com.TallerYei.MicroserviciosHospedaje.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;

public interface IAuthRepository extends JpaRepository<modelUsuario, Integer> {
    // Puedes agregar métodos personalizados del repositorio si es necesario
}
