package com.TallerYei.MicroserviciosHospedaje.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TallerYei.MicroserviciosHospedaje.model.modelCliente;
import com.TallerYei.MicroserviciosHospedaje.repository.IClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public List<modelCliente> getAllClientes() {
        return (List<modelCliente>) clienteRepository.findAll();
    }

    public modelCliente getClienteById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public modelCliente createCliente(modelCliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    public modelCliente updateCliente(int id, modelCliente clienteActualizado) {
        modelCliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setDireccion(clienteActualizado.getDireccion());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setCorreoElectronico(clienteActualizado.getCorreoElectronico());

            return clienteRepository.save(clienteExistente);
        } else {
            return null; // Puedes manejar este caso según tus necesidades
        }
    }

    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
