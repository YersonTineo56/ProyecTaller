package com.TallerYei.MicroserviciosHospedaje.controller;

import com.TallerYei.MicroserviciosHospedaje.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(id).orElse(null);
        if (habitacion != null) {
            return new ResponseEntity<>(habitacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion nuevaHabitacion) {
        Habitacion habitacionCreada = habitacionService.crearHabitacion(nuevaHabitacion);
        return new ResponseEntity<>(habitacionCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacionActualizada) {
        Habitacion habitacionActualizadaResponse = habitacionService.actualizarHabitacion(id, habitacionActualizada).orElse(null);
        if (habitacionActualizadaResponse != null) {
            return new ResponseEntity<>(habitacionActualizadaResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
