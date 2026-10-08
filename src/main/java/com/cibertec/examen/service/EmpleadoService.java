package com.cibertec.examen.service;

import com.cibertec.examen.model.Empleado;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface EmpleadoService {

    @WebMethod(operationName = "registrarEmpleado")
    Empleado registrarEmpleado(@WebParam(name = "dni") String dni,
                              @WebParam(name = "nombres") String nombres,
                              @WebParam(name = "area") String area,
                              @WebParam(name = "sueldo") double sueldo,
                              @WebParam(name = "fechaIngreso") String fechaIngreso);

    @WebMethod(operationName = "actualizarEmpleado")
    boolean actualizarEmpleado(@WebParam(name = "id") long id,
                              @WebParam(name = "dni") String dni,
                              @WebParam(name = "nombres") String nombres,
                              @WebParam(name = "area") String area,
                              @WebParam(name = "sueldo") double sueldo,
                              @WebParam(name = "fechaIngreso") String fechaIngreso);

    @WebMethod(operationName = "eliminarEmpleado")
    boolean eliminarEmpleado(@WebParam(name = "id") long id);

    @WebMethod(operationName = "listarEmpleados")
    List<Empleado> listarEmpleados();

    @WebMethod(operationName = "buscarEmpleadoPorId")
    Empleado buscarEmpleadoPorId(@WebParam(name = "id") long id);

    @WebMethod(operationName = "buscarEmpleadoPorDni")
    Empleado buscarEmpleadoPorDni(@WebParam(name = "dni") String dni);
}
