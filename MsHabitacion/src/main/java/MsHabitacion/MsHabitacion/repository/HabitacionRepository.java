package com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.repository;


import com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.model.Habitacion;
import org.springframework.data.repository.CrudRepository;

public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {
    // Puedes agregar métodos de consulta específicos si los necesitas
}
