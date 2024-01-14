package com.TallerYei.MicroserviciosHospedaje.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.TallerYei.MicroserviciosHospedaje.dto.ApiResponse;
import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;
import com.TallerYei.MicroserviciosHospedaje.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // ... Otros métodos ...

    @GetMapping
    public ResponseEntity<ApiResponse<List<modelUsuario>>> getAllUsers() {
        ApiResponse<List<modelUsuario>> response = authService.getAllUsers();
        HttpStatus status = (response.getError() != null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<modelUsuario>> getUserById(@PathVariable int id) {
        ApiResponse<modelUsuario> response = authService.getUserById(id);
        HttpStatus status = (response.getError() != null) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<modelUsuario>> createUser(@RequestBody modelUsuario nuevoUsuario) {
        ApiResponse<modelUsuario> response = authService.createUser(nuevoUsuario);
        HttpStatus status = (response.getError() != null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.CREATED;
        return new ResponseEntity<>(response, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<modelUsuario>> updateUser(@PathVariable int id, @RequestBody modelUsuario usuarioActualizado) {
        ApiResponse<modelUsuario> response = authService.updateUser(id, usuarioActualizado);
        HttpStatus status = (response.getError() != null) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(response, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable int id) {
        ApiResponse<Void> response = authService.deleteUser(id);
        HttpStatus status = (response.getError() != null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(response, status);
    }

  
}
