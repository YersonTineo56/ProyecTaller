package com.TallerYei.MicroserviciosHospedaje.MicroservicioUsuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TallerYei.MicroserviciosHospedaje.MicroservicioUsuario.dto.UsuarioDTO;
import com.TallerYei.MicroserviciosHospedaje.MicroservicioUsuario.model.modelUsuario;
import com.TallerYei.MicroserviciosHospedaje.MicroservicioUsuario.services.AuthUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthUsuarioService authUsuarioService;

    public AuthController(AuthUsuarioService authUsuarioService) {
        this.authUsuarioService = authUsuarioService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsuarioDTO>> getAllUsers() {
        List<modelUsuario> users = (List<modelUsuario>) authUsuarioService.getAllUsers();
        List<UsuarioDTO> userDTOs = users.stream()
                .map(user -> convertToDTO(user))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        modelUsuario nuevoUsuario = convertToEntity(usuarioDTO);
        modelUsuario usuarioCreado = authUsuarioService.createUser(nuevoUsuario);
        UsuarioDTO creadoDTO = convertToDTO(usuarioCreado);
        return new ResponseEntity<>(creadoDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        authUsuarioService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Métodos de conversión entre Entity y DTO
    private UsuarioDTO convertToDTO(modelUsuario usuario) {
        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getUsuario(),
                usuario.getCorreo(),
                usuario.getClave()
        );
    }

    private modelUsuario convertToEntity(UsuarioDTO usuarioDTO) {
        modelUsuario entity = new modelUsuario();
        entity.setNombre(usuarioDTO.getNombre());
        entity.setApellido(usuarioDTO.getApellido());
        entity.setUsuario(usuarioDTO.getUsuario());
        entity.setCorreo(usuarioDTO.getCorreo());
        entity.setClave(usuarioDTO.getClave());
        return entity;
    }
}
