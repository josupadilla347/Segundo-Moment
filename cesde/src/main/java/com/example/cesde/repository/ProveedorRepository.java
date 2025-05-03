package com.example.cesde.repository;

import com.example.cesde.model.proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<proveedor, Long> {
}
