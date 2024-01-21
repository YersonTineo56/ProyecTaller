package com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.controller;

import com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.model.Habitacion;
import com.TallerYei.MicroserviciosHospedaje.MicroservicioHabitacion.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/habitaciones")
    public ResponseEntity<List<Habitacion>> getAllHabitaciones() {
        List<Habitacion> habitaciones = habitacionService.getAllHabitaciones();
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/habitaciones/{id}")
    public ResponseEntity<Habitacion> getHabitacionById(@PathVariable Long id) {
        Habitacion habitacion = habitacionService.getHabitacionById(id);
        if (habitacion != null) {
            return new ResponseEntity<>(habitacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Habitacion> createHabitacion(@RequestBody Habitacion nuevaHabitacion) {
        Habitacion habitacionCreada = habitacionService.createHabitacion(nuevaHabitacion);
        return new ResponseEntity<>(habitacionCreada, HttpStatus.CREATED);
    }

    @PutMapping("/habitaciones/{id}")
    public ResponseEntity<Habitacion> updateHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacionActualizada) {
        Habitacion habitacionActualizadaResult = habitacionService.updateHabitacion(id, habitacionActualizada);
        if (habitacionActualizadaResult != null) {
            return new ResponseEntity<>(habitacionActualizadaResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/habitaciones/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteHabitacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
