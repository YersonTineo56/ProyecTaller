package com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.services;

import com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> getAllHabitaciones() {
        return (List<Habitacion>) habitacionRepository.findAll();
    }

    public Habitacion getHabitacionById(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    public Habitacion createHabitacion(Habitacion nuevaHabitacion) {
        return habitacionRepository.save(nuevaHabitacion);
    }

    public Habitacion updateHabitacion(Long id, Habitacion habitacionActualizada) {
        Habitacion habitacionExistente = habitacionRepository.findById(id).orElse(null);

        if (habitacionExistente != null) {
            habitacionExistente.setNumeroHabitacion(habitacionActualizada.getNumeroHabitacion());
            habitacionExistente.setTipoHabitacion(habitacionActualizada.getTipoHabitacion());
            habitacionExistente.setPrecio(habitacionActualizada.getPrecio());
            habitacionExistente.setOcupada(habitacionActualizada.isOcupada());

            return habitacionRepository.save(habitacionExistente);
        } else {
            return null;
        }
    }

    public void deleteHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }
}
