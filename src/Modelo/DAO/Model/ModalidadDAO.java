package Modelo.DAO.Model;

import Modelo.Entidades.Modalidad;
import Modelo.Interfaces.Model.IModalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ModalidadDAO extends BaseDAO implements IModalidad{

    private final String INSERT = "INSERT INTO modalidades (id_modalidad, descripcion) VALUES (?,?);";
    private final String UPDATE = "UPDATE modalidades SET descripcion = ? ";
    private final String DELETE = "DELETE FROM modalidades ";
    private final String GETALL = "SELECT * FROM modalidades ";
    private final String GETONE = "WHERE id_modalidad = ?;";
    private final String GETMODALIDAD = "WHERE descripcion LIKE ?;";
    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_modalidad),4) FROM modalidades";

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
        return lista.isEmpty()?null:lista;
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
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE + GETONE)) {
            prepared.setString(1, modalidad.getDescripcion());
            prepared.setString(2, modalidad.getId());
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
    public Modalidad findById(String id) {
        Modalidad modalidad = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETONE)) {
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

  @Override
    public List<Modalidad> findNames(String role) {
        PreparedStatement prepared = null;
        List<Modalidad> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + GETMODALIDAD);
            prepared.setString(1,"%"+role+"%");
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }finally{
            closeResources(prepared, resultado_data);
        }

        return lista.isEmpty()?null:lista;
    }

    @Override
    public String newCode() {
        String cod = "MOD0001";
        PreparedStatement prepare_new_code = null;
        connection = getConnection();;
        ResultSet result_data = null;
        try {
            prepare_new_code = connection.prepareStatement(NEWCOD);
            result_data = prepare_new_code.executeQuery();

            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "MOD" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }finally{
            closeResources(prepare_new_code);
        }
        return cod;
    }

    
}
