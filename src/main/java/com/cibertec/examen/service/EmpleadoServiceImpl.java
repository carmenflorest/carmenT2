package com.cibertec.examen.service;

import com.cibertec.examen.model.Empleado;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final JdbcTemplate jdbcTemplate;

    public EmpleadoServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Empleado registrarEmpleado(String dni, String nombres, String area, double sueldo, String fechaIngreso) {
        String sql = "INSERT INTO empleado (dni, nombres, area, sueldo, fecha_ingreso) VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, new String[]{"id"});
            statement.setString(1, dni);
            statement.setString(2, nombres);
            statement.setString(3, area);
            statement.setDouble(4, sueldo);
            statement.setDate(5, Date.valueOf(LocalDate.parse(fechaIngreso)));
            return statement;
        }, keyHolder);

        Long idGenerado = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
        if (idGenerado == null) {
            return null;
        }

        return buscarEmpleadoPorId(idGenerado);
    }

    @Override
    public boolean actualizarEmpleado(long id, String dni, String nombres, String area, double sueldo, String fechaIngreso) {
        String sql = "UPDATE empleado SET dni = ?, nombres = ?, area = ?, sueldo = ?, fecha_ingreso = ? WHERE id = ?";
        int filas = jdbcTemplate.update(sql,
                dni,
                nombres,
                area,
                sueldo,
                Date.valueOf(LocalDate.parse(fechaIngreso)),
                id);
        return filas > 0;
    }

    @Override
    public boolean eliminarEmpleado(long id) {
        String sql = "DELETE FROM empleado WHERE id = ?";
        int filas = jdbcTemplate.update(sql, id);
        return filas > 0;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        String sql = "SELECT id, dni, nombres, area, sueldo, fecha_ingreso AS fechaIngreso FROM empleado ORDER BY id";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Empleado.class));
    }

    @Override
    public Empleado buscarEmpleadoPorId(long id) {
        String sql = "SELECT id, dni, nombres, area, sueldo, fecha_ingreso AS fechaIngreso FROM empleado WHERE id = ?";
        List<Empleado> resultado = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Empleado.class), id);
        return resultado.isEmpty() ? null : resultado.get(0);
    }

    @Override
    public Empleado buscarEmpleadoPorDni(String dni) {
        String sql = "SELECT id, dni, nombres, area, sueldo, fecha_ingreso AS fechaIngreso FROM empleado WHERE dni = ?";
        List<Empleado> resultado = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Empleado.class), dni);
        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
