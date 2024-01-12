package com.TallerYei.MicroserviciosHospedaje.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TallerYei.MicroserviciosHospedaje.dto.HabitacionDTO;
import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.services.HabitacionService;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public ResponseEntity<List<Habitacion>> obtenerTodasLasHabitaciones() {
        List<Habitacion> habitaciones = habitacionService.obtenerTodasLasHabitaciones();
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacionPorId(@PathVariable Long id) {
        Optional<Habitacion> habitacion = habitacionService.obtenerHabitacionPorId(id);
        return habitacion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody HabitacionDTO nuevaHabitacionDTO) {
        Habitacion nuevaHabitacion = habitacionService.crearHabitacion(nuevaHabitacionDTO);
        return new ResponseEntity<>(nuevaHabitacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Long id, @RequestBody HabitacionDTO habitacionActualizadaDTO) {
        Optional<Habitacion> habitacionActualizada = habitacionService.actualizarHabitacion(id, habitacionActualizadaDTO);
        return habitacionActualizada.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
