package com.TallerYei.MicroserviciosHospedaje.repository;

import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepository extends JpaRepository<modelUsuario, Integer> {
    // Puedes agregar métodos personalizados del repositorio si es necesario
}
