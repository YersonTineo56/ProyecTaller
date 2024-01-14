package com.TallerYei.MicroserviciosHospedaje.services;

import com.TallerYei.MicroserviciosHospedaje.dto.HabitacionDTO;
import com.TallerYei.MicroserviciosHospedaje.exception.NotFoundException;
import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.repository.IHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private IHabitacionRepository habitacionRepository;

    public List<Habitacion> obtenerTodasLasHabitaciones() {
        try {
            return (List<Habitacion>) habitacionRepository.findAll();
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            throw new RuntimeException("Error al obtener todas las habitaciones", e);
        }
    }

    public Optional<Habitacion> obtenerHabitacionPorId(Long id) {
        try {
            return habitacionRepository.findById(id);
        } catch (Exception e) {
           
            throw new RuntimeException("Error al obtener la habitación con ID: " + id, e);
        }
    }

    public Habitacion crearHabitacion(HabitacionDTO nuevaHabitacionDTO) {
        try {
            Habitacion nuevaHabitacion = convertirDTOaEntidad(nuevaHabitacionDTO);
            return habitacionRepository.save(nuevaHabitacion);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            throw new RuntimeException("Error al crear la habitación", e);
        }
    }

    public Optional<Habitacion> actualizarHabitacion(Long id, HabitacionDTO habitacionActualizadaDTO) {
        try {
            return habitacionRepository.findById(id).map(habitacion -> {
                actualizarEntidadDesdeDTO(habitacion, habitacionActualizadaDTO);
                return habitacionRepository.save(habitacion);
            });
        } catch (NotFoundException e) {
            // NotFoundException is a custom exception (you can define your own)
            throw e;
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            throw new RuntimeException("Error al actualizar la habitación", e);
        }
    }

    public void eliminarHabitacion(Long id) {
        try {
            habitacionRepository.deleteById(id);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            throw new RuntimeException("Error al eliminar la habitación con ID: " + id, e);
        }
    }

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
