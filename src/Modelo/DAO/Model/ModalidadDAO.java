package Modelo.DAO.Model;

import Modelo.Entidades.Modalidad;
import Modelo.Interfaces.Model.IModalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModalidadDAO extends BaseDAO implements IModalidad{

     private final String INSERT = "INSERT INTO modalidades (id_modalidad, descripcion) VALUES (?,?);";
    private final String UPDATE = "UPDATE modalidades SET descripcion = ? WHERE id_modalidad = ?;";
    private final String DELETE = "DELETE FROM modalidades WHERE id_modalidad = ?;";
    private final String GETALL = "SELECT * FROM modalidades;";
    private final String GETONE = "SELECT * FROM modalidades WHERE id_modalidad = ?;";

    public Modalidad Data(ResultSet resultado_data) throws SQLException {
        return new Modalidad(
                resultado_data.getString("id_modalidad"),
                resultado_data.getString("descripcion")
        );
    }

    @Override
    public List<Modalidad> findAll() {
        List<Modalidad> lista = new ArrayList<>();
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
    public void create(Modalidad modalidad) {
        try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
            prepared.setString(1, modalidad.getId());
            prepared.setString(2, modalidad.getDescripcion());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }
    }

    @Override
    public void update(Modalidad modalidad) {
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE)) {
            prepared.setString(1, modalidad.getDescripcion());
            prepared.setString(2, modalidad.getId());
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
    public Modalidad findById(String id) {
        Modalidad modalidad = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    modalidad = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return modalidad;
    }
    
}
