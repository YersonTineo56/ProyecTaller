package com.TallerYei.MicroserviciosHospedaje.services;
import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
@Autowired
    private final HabitacionRepository habitacionRepository;

    
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> obtenerTodasLasHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> obtenerHabitacionPorId(Long id) {
        return habitacionRepository.findById(id);
    }

    public Habitacion crearHabitacion(Habitacion nuevaHabitacion) {
        return habitacionRepository.save(nuevaHabitacion);
    }

    public Optional<Habitacion> actualizarHabitacion(Long id, Habitacion habitacionActualizada) {
        Optional<Habitacion> habitacionExistente = habitacionRepository.findById(id);

        if (habitacionExistente.isPresent()) {
            Habitacion habitacion = habitacionExistente.get();
            habitacion.setNumeroHabitacion(habitacionActualizada.getNumeroHabitacion());
            habitacion.setTipoHabitacion(habitacionActualizada.getTipoHabitacion());
            habitacion.setPrecio(habitacionActualizada.getPrecio());
            habitacion.setEstado(habitacionActualizada.getEstado());

            return Optional.of(habitacionRepository.save(habitacion));
        } else {
            return Optional.empty();
        }
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }
}
