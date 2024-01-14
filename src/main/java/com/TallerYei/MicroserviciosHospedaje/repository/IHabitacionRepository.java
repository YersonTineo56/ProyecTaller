package com.TallerYei.MicroserviciosHospedaje.repository;

import org.springframework.data.repository.CrudRepository;

import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;

public interface IHabitacionRepository extends CrudRepository<Habitacion, Long> {
    // Puedes agregar métodos adicionales según tus necesidades
}
