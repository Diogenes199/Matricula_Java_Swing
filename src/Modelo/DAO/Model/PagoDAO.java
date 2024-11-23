package Modelo.DAO.Model;

import Modelo.Entidades.Matricula;
import Modelo.Entidades.Pago;
import Modelo.Entidades.TipoComprobante;
import Modelo.Entidades.Usuario;
import Modelo.Interfaces.Model.IPago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PagoDAO extends BaseDAO implements IPago{

    private final String INSERT = "INSERT INTO pagos (id_pago, id_matricula, fecha_pago, monto, detalle, id_tipo_comprobante, numero_comprobante, id_usuario_registro, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE pagos SET id_matricula = ?, fecha_pago = ?, monto = ?, detalle = ?, id_tipo_comprobante = ?, numero_comprobante = ?, id_usuario_registro = ?, observaciones = ? WHERE id_pago = ?;";
    private final String DELETE = "DELETE FROM pagos WHERE id_pago = ?;";
    private final String GETALL = "SELECT * FROM pagos;";
    private final String GETONE = "SELECT * FROM pagos WHERE id_pago = ?;";

    public Pago Data(ResultSet resultado_data) throws SQLException {
    return new Pago(
        resultado_data.getString("id_pago"),
        new Matricula(resultado_data.getString("id_matricula")),
        resultado_data.getDate("fecha_pago").toLocalDate(),
        resultado_data.getDouble("monto"),
        resultado_data.getString("detalle"),
        new TipoComprobante(resultado_data.getString("id_tipo_comprobante")),
        resultado_data.getString("numero_comprobante"),
        new Usuario(resultado_data.getString("id_usuario_registro")),
        resultado_data.getString("observaciones")
    );
}

    @Override
    public List<Pago> findAll() {
        List<Pago> lista = new ArrayList<>();
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
    public void create(Pago pago) {
    try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
        prepared.setString(1, pago.getId());
        prepared.setString(2, pago.getMatricula().getId());
        prepared.setDate(3, java.sql.Date.valueOf(pago.getFechaPago()));
        prepared.setDouble(4, pago.getMonto());
        prepared.setString(5, pago.getDetalle());
        prepared.setString(6, pago.getComprobante().getId());
        prepared.setString(7, pago.getNumeroComprobante());
        prepared.setString(8, pago.getUsuario().getId());
        prepared.setString(9, pago.getObservaciones());
        prepared.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("ERROR CREATE: " + ex.getMessage());
    }
}

   @Override
public void update(Pago pago) {
    try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE)) {
        prepared.setString(1, pago.getMatricula().getId());
        prepared.setDate(2, java.sql.Date.valueOf(pago.getFechaPago()));
        prepared.setDouble(3, pago.getMonto());
        prepared.setString(4, pago.getDetalle());
        prepared.setString(5, pago.getComprobante().getId());
        prepared.setString(6, pago.getNumeroComprobante());
        prepared.setString(7, pago.getUsuario().getId());
        prepared.setString(8, pago.getObservaciones());
        prepared.setString(9, pago.getId());
        prepared.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("ERROR UPDATE: " + ex.getMessage());
    }
}

    @Override
    public void delete(String id) {
        try (PreparedStatement prepared = getConnection().prepareStatement(DELETE)) {
            prepared.setString(1, id);
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR DELETE " + ex.getMessage());
        }
    }

    @Override
    public Pago findById(String id) {
        Pago pago = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    pago = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return pago;
    }
    
}
