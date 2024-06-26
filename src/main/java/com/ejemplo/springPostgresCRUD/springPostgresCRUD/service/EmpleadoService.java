package com.ejemplo.springPostgresCRUD.springPostgresCRUD.service;


import com.ejemplo.springPostgresCRUD.springPostgresCRUD.entity.Empleado;
import com.ejemplo.springPostgresCRUD.springPostgresCRUD.repository.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepo empleadoRepo;

    public EmpleadoService(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoRepo.findAll();
    }

    public Empleado obtenerEmpleadoPorId(Integer id){
        Optional<Empleado> optionalEmpleado = empleadoRepo.findById(id);
        if(optionalEmpleado.isPresent()){
            return optionalEmpleado.get();
        }
        return null;
    }

    public Empleado guardarEmpleado(Empleado empleado){
        empleado.setFechaDeCreacion(LocalDateTime.now());
        empleado.setFechaDeModificacion(LocalDateTime.now());

        return empleadoRepo.save(empleado);
    }

    public Empleado actualizarEmpleado(Empleado empleado){
        Optional<Empleado> empleadoExistente = empleadoRepo.findById(empleado.getId());
        empleado.setFechaDeCreacion(empleadoExistente.get().getFechaDeCreacion());
        empleado.setFechaDeModificacion(LocalDateTime.now());
        return empleadoRepo.save(empleado);
    }

    public void eliminarEmpleadoPorId(Integer id){
        empleadoRepo.deleteById(id);
    }

}
