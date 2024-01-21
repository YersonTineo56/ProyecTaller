package com.TallerYei.MicroserviciosHospedaje.MicroservicioUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TallerYei.MicroserviciosHospedaje.MicroservicioUsuario.model.modelUsuario;

public interface IAuthRepository extends JpaRepository<modelUsuario, Integer> {
    // Puedes agregar métodos personalizados del repositorio si es necesario
}
