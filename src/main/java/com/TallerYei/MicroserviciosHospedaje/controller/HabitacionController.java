package com.TallerYei.MicroserviciosHospedaje.controller;

import com.TallerYei.MicroserviciosHospedaje.dto.HabitacionDTO;
import com.TallerYei.MicroserviciosHospedaje.exception.NotFoundException;
import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public ResponseEntity<List<Habitacion>> obtenerTodasLasHabitaciones() {
        try {
            List<Habitacion> habitaciones = habitacionService.obtenerTodasLasHabitaciones();
            return new ResponseEntity<>(habitaciones, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacionPorId(@PathVariable Long id) {
        try {
            Optional<Habitacion> habitacion = habitacionService.obtenerHabitacionPorId(id);
            return habitacion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody HabitacionDTO nuevaHabitacionDTO) {
        try {
            Habitacion nuevaHabitacion = habitacionService.crearHabitacion(nuevaHabitacionDTO);
            return new ResponseEntity<>(nuevaHabitacion, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Long id, @RequestBody HabitacionDTO habitacionActualizadaDTO) {
        try {
            Optional<Habitacion> habitacionActualizada = habitacionService.actualizarHabitacion(id, habitacionActualizadaDTO);
            return habitacionActualizada.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NotFoundException e) {
            // NotFoundException is a custom exception (you can define your own)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Long id) {
        try {
            habitacionService.eliminarHabitacion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
