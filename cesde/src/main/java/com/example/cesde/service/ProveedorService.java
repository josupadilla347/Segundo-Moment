package com.example.cesde.service;

import com.example.cesde.model.proveedor;
import com.example.cesde.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public proveedor crearProveedor(proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public List<proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Optional<proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    public proveedor actualizarProveedor(Long id, proveedor proveedorActualizado) {
        return proveedorRepository.findById(id).map(proveedor -> {
            proveedor.setNombre(proveedorActualizado.getNombre());
            proveedor.setNumeroContacto(proveedorActualizado.getNumeroContacto());
            proveedor.setDireccion(proveedorActualizado.getDireccion());
            return proveedorRepository.save(proveedor);
        }).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
