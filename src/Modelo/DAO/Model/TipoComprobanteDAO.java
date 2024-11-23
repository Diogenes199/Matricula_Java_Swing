package Modelo.DAO.Model;

import Modelo.Entidades.TipoComprobante;
import Modelo.Interfaces.Model.ITipoComprobante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoComprobanteDAO extends BaseDAO implements ITipoComprobante{

     private final String INSERT = "INSERT INTO tipo_comprobante (id_tipo_comprobante, descripcion) VALUES (?,?);";
    private final String UPDATE = "UPDATE tipo_comprobante SET descripcion = ? WHERE id_tipo_comprobante = ?;";
    private final String DELETE = "DELETE FROM tipo_comprobante WHERE id_tipo_comprobante = ?;";
    private final String GETALL = "SELECT * FROM tipo_comprobante;";
    private final String GETONE = "SELECT * FROM tipo_comprobante WHERE id_tipo_comprobante = ?;";

    public TipoComprobante Data(ResultSet resultado_data) throws SQLException {
        return new TipoComprobante(
                resultado_data.getString("id_tipo_comprobante"),
                resultado_data.getString("descripcion")
        );
    }

    @Override
    public List<TipoComprobante> findAll() {
        List<TipoComprobante> lista = new ArrayList<>();
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
    public void create(TipoComprobante tipoComprobante) {
        try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
            prepared.setString(1, tipoComprobante.getId());
            prepared.setString(2, tipoComprobante.getDescripcion());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }
    }

    @Override
    public void update(TipoComprobante tipoComprobante) {
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE)) {
            prepared.setString(1, tipoComprobante.getDescripcion());
            prepared.setString(2, tipoComprobante.getId());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR UPDATE " + ex.getMessage());
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
    public TipoComprobante findById(String id) {
        TipoComprobante tipoComprobante = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    tipoComprobante = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return tipoComprobante;
     }
    
}
