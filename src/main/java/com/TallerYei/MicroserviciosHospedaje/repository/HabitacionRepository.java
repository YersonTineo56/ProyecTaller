package com.TallerYei.MicroserviciosHospedaje.repository;

import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    // Puedes agregar métodos personalizados según tus necesidades
}
