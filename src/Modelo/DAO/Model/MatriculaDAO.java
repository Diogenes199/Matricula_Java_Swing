package Modelo.DAO.Model;

import Modelo.Entidades.Cliente;
import Modelo.Entidades.Curso;
import Modelo.Entidades.Horario;
import Modelo.Entidades.Matricula;
import Modelo.Entidades.Modalidad;
import Modelo.Interfaces.Model.IMatricula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO extends BaseDAO implements IMatricula{

    private final String INSERT = "INSERT INTO matriculas (id_matricula, id_cliente, id_curso, id_modalidad,id_horario,fecha_inicio, costo_total) VALUES (?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE matriculas SET id_cliente = ?, id_curso = ?, id_modalidad =  ?, id_horario = ?, fecha_inicio = ?, costo_total = ? ";
    private final String DELETE = "DELETE FROM matriculas ";
    private final String GETALL = "SELECT id_matricula, id_cliente, id_curso, id_modalidad,id_horario,fecha_inicio, costo_total FROM matriculas ";
    private final String GETONE = "WHERE id_matricula = ?;";

    public Matricula Data(ResultSet resultado_data) throws SQLException {
        return new Matricula(
                resultado_data.getString("id_matricula"),
                new Cliente(resultado_data.getString("id_cliente")),
                new Curso(resultado_data.getString("id_curso")),
                new Modalidad(resultado_data.getString("id_modalidad")),
                new Horario(resultado_data.getString("id_curso")),                
                resultado_data.getDate("fecha_inscripcion").toLocalDate(),
                resultado_data.getDouble("costo_total")
        );
    }

    @Override
    public List<Matricula> findAll() {
        List<Matricula> lista = new ArrayList<>();
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL);
             ResultSet resultado_data = prepared.executeQuery()) {

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public void create(Matricula matricula) {
        try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
            prepared.setString(1, matricula.getId());
            prepared.setString(2, matricula.getCliente().getId());
            prepared.setString(3, matricula.getCurso().getId());
            prepared.setString(4, matricula.getModalidad().getId());
            prepared.setString(5, matricula.getHorario().getId());
            prepared.setDate(6, java.sql.Date.valueOf(matricula.getFechaInicio()));
            prepared.setDouble(7, matricula.getCostoTotal());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }
    }

    @Override
    public void update(Matricula matricula) {
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE + GETONE)) {
            prepared.setString(1, matricula.getCliente().getId());
            prepared.setString(2, matricula.getCurso().getId());
            prepared.setString(3, matricula.getModalidad().getId());
            prepared.setString(4, matricula.getHorario().getId());
            prepared.setDate(5,java.sql.Date.valueOf(matricula.getFechaInicio()));
            prepared.setDouble(6, matricula.getCostoTotal());
            prepared.setString(7, matricula.getId());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR UPDATE " + ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement prepared = getConnection().prepareStatement(DELETE + GETONE)) {
            prepared.setString(1, id);
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR DELETE " + ex.getMessage());
        }
    }

    @Override
    public Matricula findById(String id) {
        Matricula matricula = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    matricula = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return matricula;
    }
    
}
