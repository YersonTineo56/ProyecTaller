package com.TallerYei.MicroserviciosHospedaje.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;
import com.TallerYei.MicroserviciosHospedaje.repository.IAuthRepository;

@Service
public class AuthUsuarioService {

    @Autowired
    private IAuthRepository authRepository;

    public Iterable<modelUsuario> getAllUsers() {
        return authRepository.findAll();
    }

    public modelUsuario getUserById(int id) {
        return authRepository.findById(id).orElse(null);
    }

    public modelUsuario createUser(modelUsuario nuevoUsuario) {
        return authRepository.save(nuevoUsuario);
    }

    public modelUsuario updateUser(int id, modelUsuario usuarioActualizado) {
        modelUsuario usuarioExistente = authRepository.findById(id).orElse(null);

        if (usuarioExistente != null) {
            usuarioExistente.setUsuario(usuarioActualizado.getUsuario());
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setClave(usuarioActualizado.getClave());
            return authRepository.save(usuarioExistente);
        } else {
            // Puedes lanzar una excepción o devolver un valor indicando que el usuario no existe
            return null;
        }
    }

    public void deleteUser(int id) {
        authRepository.deleteById(id);
    }
}
