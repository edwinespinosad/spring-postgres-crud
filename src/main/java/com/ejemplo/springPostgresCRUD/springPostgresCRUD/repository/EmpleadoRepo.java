package com.ejemplo.springPostgresCRUD.springPostgresCRUD.repository;

import com.ejemplo.springPostgresCRUD.springPostgresCRUD.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepo extends JpaRepository<Empleado, Integer> {
}
