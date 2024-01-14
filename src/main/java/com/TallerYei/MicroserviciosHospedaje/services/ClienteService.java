package com.TallerYei.MicroserviciosHospedaje.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TallerYei.MicroserviciosHospedaje.dto.ClienteDTO;
import com.TallerYei.MicroserviciosHospedaje.model.Cliente;
import com.TallerYei.MicroserviciosHospedaje.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente crearCliente(ClienteDTO nuevoClienteDTO) {
        Cliente nuevoCliente = convertirDTOaEntidad(nuevoClienteDTO);
        return clienteRepository.save(nuevoCliente);
    }

    public Optional<Cliente> actualizarCliente(Long id, ClienteDTO clienteActualizadoDTO) {
        return clienteRepository.findById(id).map(cliente -> {
            actualizarEntidadDesdeDTO(cliente, clienteActualizadoDTO);
            return clienteRepository.save(cliente);
        });
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente convertirDTOaEntidad(ClienteDTO clienteDTO) {
        // Implementa la conversión según tus necesidades
        return new Cliente(
            clienteDTO.getNombre(),
            clienteDTO.getApellido(),
            clienteDTO.getDireccion(),
            clienteDTO.getTelefono(),
            clienteDTO.getCorreoElectronico()
        );
    }

    private void actualizarEntidadDesdeDTO(Cliente cliente, ClienteDTO clienteDTO) {
        // Implementa la actualización según tus necesidades
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setCorreoElectronico(clienteDTO.getCorreoElectronico());
    }
}
