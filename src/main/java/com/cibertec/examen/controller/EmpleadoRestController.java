package com.cibertec.examen.controller;

import com.cibertec.examen.model.Empleado;
import com.cibertec.examen.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestController {

    private final EmpleadoService empleadoService;

    public EmpleadoRestController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }

    @PostMapping
    public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado) {
        Empleado registrado = empleadoService.registrarEmpleado(
                empleado.getDni(),
                empleado.getNombres(),
                empleado.getArea(),
                empleado.getSueldo(),
                empleado.getFechaIngreso()
        );

        return registrado != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(registrado)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Empleado> buscarPorId(@PathVariable long id) {
        Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Empleado> buscarPorDni(@PathVariable String dni) {
        Empleado empleado = empleadoService.buscarEmpleadoPorDni(dni);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEmpleado(@PathVariable long id, @RequestBody Empleado empleado) {
        boolean actualizado = empleadoService.actualizarEmpleado(
                id,
                empleado.getDni(),
                empleado.getNombres(),
                empleado.getArea(),
                empleado.getSueldo(),
                empleado.getFechaIngreso()
        );

        return actualizado
                ? ResponseEntity.ok("Empleado actualizado correctamente.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el empleado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable long id) {
        boolean eliminado = empleadoService.eliminarEmpleado(id);

        return eliminado
                ? ResponseEntity.ok("Empleado eliminado correctamente.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el empleado.");
    }
}
