package Modelo.DAO.Model;

import Modelo.Entidades.Devolucion;
import Modelo.Entidades.Pago;
import Modelo.Entidades.Usuario;
import Modelo.Interfaces.Model.IDevolucion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevolucionDAO extends BaseDAO implements IDevolucion {

    private final String INSERT = "INSERT INTO matriculas (id_matricula, id_cliente, id_curso, id_modalidad,id_horario,fecha_inicio, costo_total) VALUES (?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE matriculas SET id_cliente = ?, id_curso = ?, id_modalidad =  ?, id_horario = ?, fecha_inicio = ?, costo_total = ? ";
    private final String DELETE = "DELETE FROM matriculas ";
    private final String GETALL = "SELECT id_matricula, id_cliente, id_curso, id_modalidad,id_horario,fecha_inicio, costo_total FROM matriculas ";
    private final String GETONE = "WHERE id_matricula = ?;";

    public Devolucion Data(ResultSet resultado_data) throws SQLException {
        return new Devolucion(
                resultado_data.getString("id_devolucion"),
                new Pago(resultado_data.getString("id_pago")),
                resultado_data.getDate("fecha_devolucion").toLocalDate(),
                resultado_data.getDouble("monto_devuelto"),
                resultado_data.getString("motivo"),
                new Usuario("id_usuario_autorizacion"),
                resultado_data.getDate("fecha_registro").toLocalDate().atStartOfDay()
        );
    }

    @Override
    public List<Devolucion> findAll() {
        List<Devolucion> lista = new ArrayList<>();
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL); ResultSet resultado_data = prepared.executeQuery()) {

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public void create(Devolucion devolucion) {
        try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
            prepared.setString(1, devolucion.getId());
            prepared.setString(2, devolucion.getPago().getId());
            prepared.setDate(3, java.sql.Date.valueOf(devolucion.getFechaDevolucion()));
            prepared.setDouble(4, devolucion.getMontoDevuelto());
            prepared.setString(5, devolucion.getMotivo());
            prepared.setString(6, devolucion.getUsuario().getId());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }
    }

    @Override
    public void update(Devolucion devolucion) {
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE + GETONE)) {
            prepared.setString(1, devolucion.getPago().getId());
            prepared.setDate(2, java.sql.Date.valueOf(devolucion.getFechaDevolucion()));
            prepared.setDouble(3, devolucion.getMontoDevuelto());
            prepared.setString(4, devolucion.getMotivo());
            prepared.setString(5, devolucion.getUsuario().getId());
            prepared.setString(6, devolucion.getId());
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
    public Devolucion findById(String id) {
        Devolucion devolucion = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    devolucion = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return devolucion;
    }

}
