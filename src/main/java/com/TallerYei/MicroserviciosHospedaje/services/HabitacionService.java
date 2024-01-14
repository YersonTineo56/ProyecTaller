package com.TallerYei.MicroserviciosHospedaje.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TallerYei.MicroserviciosHospedaje.dto.HabitacionDTO;
import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.repository.IHabitacionRepository;

@Service
public class HabitacionService {

    @Autowired
    private IHabitacionRepository habitacionRepository;

    public List<Habitacion> obtenerTodasLasHabitaciones() {
        return (List<Habitacion>) habitacionRepository.findAll();
    }

    public Optional<Habitacion> obtenerHabitacionPorId(Long id) {
        return habitacionRepository.findById(id);
    }

    public Habitacion crearHabitacion(HabitacionDTO nuevaHabitacionDTO) {
        Habitacion nuevaHabitacion = convertirDTOaEntidad(nuevaHabitacionDTO);
        return habitacionRepository.save(nuevaHabitacion);
    }

    public Optional<Habitacion> actualizarHabitacion(Long id, HabitacionDTO habitacionActualizadaDTO) {
        return habitacionRepository.findById(id).map(habitacion -> {
            actualizarEntidadDesdeDTO(habitacion, habitacionActualizadaDTO);
            return habitacionRepository.save(habitacion);
        });
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }

    // Métodos adicionales según tus necesidades

    private Habitacion convertirDTOaEntidad(HabitacionDTO habitacionDTO) {
        return new Habitacion(
                habitacionDTO.getNumeroHabitacion(),
                habitacionDTO.getTipoHabitacion(),
                habitacionDTO.getPrecio(),
                habitacionDTO.getEstado()
        );
    }

    private void actualizarEntidadDesdeDTO(Habitacion habitacion, HabitacionDTO habitacionDTO) {
        habitacion.setNumeroHabitacion(habitacionDTO.getNumeroHabitacion());
        habitacion.setTipoHabitacion(habitacionDTO.getTipoHabitacion());
        habitacion.setPrecio(habitacionDTO.getPrecio());
        habitacion.setEstado(habitacionDTO.getEstado());
        // Puedes agregar más actualizaciones según tus necesidades
    }
}
