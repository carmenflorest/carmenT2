package com.cibertec.examen.config;

import com.cibertec.examen.service.EmpleadoService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CxfConfig {

    @Bean
    public EmpleadoService empleadoService(JdbcTemplate jdbcTemplate) {
        return new com.cibertec.examen.service.EmpleadoServiceImpl(jdbcTemplate);
    }

    @Bean
    public Endpoint endpointEmpleado(Bus bus, EmpleadoService empleadoService) {
        EndpointImpl endpoint = new EndpointImpl(bus, empleadoService);
        endpoint.publish("/empleado");
        return endpoint;
    }
}
