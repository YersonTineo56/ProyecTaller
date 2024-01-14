package com.TallerYei.MicroserviciosHospedaje.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TallerYei.MicroserviciosHospedaje.dto.ApiResponse;
import com.TallerYei.MicroserviciosHospedaje.model.modelUsuario;
import com.TallerYei.MicroserviciosHospedaje.repository.IAuthRepository;

@Service
public class AuthService {

    @Autowired
    private IAuthRepository authRepository;

    public ApiResponse<List<modelUsuario>> getAllUsers() {
        try {
            List<modelUsuario> users = (List<modelUsuario>) authRepository.findAll();
            return new ApiResponse<>(users, null);
        } catch (Exception e) {
         
            return new ApiResponse<>(null, "Error al obtener todos los usuarios");
        }
    }

    public ApiResponse<modelUsuario> getUserById(int id) {
        try {
            modelUsuario user = authRepository.findById(id).orElse(null);
            return new ApiResponse<>(user, null);
        } catch (Exception e) {
         
            return new ApiResponse<>(null, "Error al obtener el usuario con ID: " + id);
        }
    }

    public ApiResponse<modelUsuario> createUser(modelUsuario nuevoUsuario) {
        try {
            modelUsuario createdUser = authRepository.save(nuevoUsuario);
            return new ApiResponse<>(createdUser, null);
        } catch (Exception e) {
            
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
           
            return new ApiResponse<>(null, "Error al actualizar el usuario");
        }
    }

    public ApiResponse<Void> deleteUser(int id) {
        try {
            // Elimina el usuario con el ID proporcionado, si existe
            authRepository.deleteById(id);
            return new ApiResponse<>(null, null); // Éxito
        } catch (Exception e) {
            // Log the exception or handle it according to your needs
            return new ApiResponse<>(null, "Error al eliminar el usuario con ID: " + id);
        }
    }

    // Resto del código...
}
