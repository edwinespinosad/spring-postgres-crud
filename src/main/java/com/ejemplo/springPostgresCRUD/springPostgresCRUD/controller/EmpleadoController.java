package com.ejemplo.springPostgresCRUD.springPostgresCRUD.controller;

import com.ejemplo.springPostgresCRUD.springPostgresCRUD.entity.Empleado;
import com.ejemplo.springPostgresCRUD.springPostgresCRUD.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Empleado>> obtenerTodosLosEmpleados(){
        return ResponseEntity.ok().body(empleadoService.obtenerTodosLosEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(empleadoService.obtenerEmpleadoPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.ok().body(empleadoService.guardarEmpleado(empleado));
    }

    @PutMapping("/")
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.ok().body(empleadoService.actualizarEmpleado(empleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleadoPorId(@PathVariable Integer id){
        empleadoService.eliminarEmpleadoPorId(id);
        return ResponseEntity.ok().body("Empleado eliminado");
    }

}