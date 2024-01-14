package com.TallerYei.MicroserviciosHospedaje.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TallerYei.MicroserviciosHospedaje.dto.ApiResponse;
import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;
import com.TallerYei.MicroserviciosHospedaje.repository.IAuthRepository;

import java.util.List;

@Service
public class AuthService {

    private final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private IAuthRepository authRepository;

    public ApiResponse<List<modelUsuario>> getAllUsers() {
        try {
            List<modelUsuario> users = (List<modelUsuario>) authRepository.findAll();
            return new ApiResponse<>(users, null);
        } catch (Exception e) {
            logger.error("Error al obtener todos los usuarios", e);
            return new ApiResponse<>(null, "Error al obtener todos los usuarios");
        }
    }

    public ApiResponse<modelUsuario> getUserById(int id) {
        try {
            modelUsuario user = authRepository.findById(id).orElse(null);
            return new ApiResponse<>(user, null);
        } catch (Exception e) {
            logger.error("Error al obtener el usuario con ID: " + id, e);
            return new ApiResponse<>(null, "Error al obtener el usuario con ID: " + id);
        }
    }

    public ApiResponse<modelUsuario> createUser(modelUsuario nuevoUsuario) {
        try {
            modelUsuario createdUser = authRepository.save(nuevoUsuario);
            return new ApiResponse<>(createdUser, null);
        } catch (Exception e) {
            logger.error("Error al crear el usuario", e);
            return new ApiResponse<>(null, "Error al crear el usuario");
        }
    }

    public ApiResponse<modelUsuario> updateUser(int id, modelUsuario usuarioActualizado) {
        try {
            modelUsuario usuarioExistente = authRepository.findById(id).orElse(null);

            if (usuarioExistente != null) {
                usuarioExistente.setUsuario(usuarioActualizado.getUsuario());
                usuarioExistente.setClave(usuarioActualizado.getClave());
                modelUsuario updatedUser = authRepository.save(usuarioExistente);
                return new ApiResponse<>(updatedUser, null);
            } else {
                return new ApiResponse<>(null, "Usuario no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            logger.error("Error al actualizar el usuario", e);
            return new ApiResponse<>(null, "Error al actualizar el usuario");
        }
    }

    public ApiResponse<Void> deleteUser(int id) {
        try {
            authRepository.deleteById(id);
            return new ApiResponse<>(null, null); // Éxito
        } catch (Exception e) {
            logger.error("Error al eliminar el usuario con ID: " + id, e);
            return new ApiResponse<>(null, "Error al eliminar el usuario con ID: " + id);
        }
    }
}
