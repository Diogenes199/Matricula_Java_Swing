package Modelo.DAO.Model;

import Modelo.Entidades.Rol;
import Modelo.Interfaces.Model.IRol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RolDAO extends BaseDAO implements IRol {

    private final String INSERT = "INSERT INTO roles(id_rol,nombre_rol) VALUES(?,?)";
    private final String UPDATE = "UPDATE roles SET nombre_rol = ?  ";
    private final String DELETE = "DELETE FROM roles ";
    private final String GETALL = "SELECT id_rol, nombre_rol FROM roles ";
    private final String GETONE = " WHERE id_rol = ?";
    private final String GETROLES = " WHERE nombre_rol = ?";
    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_rol),3) FROM roles";

    private Rol Data(ResultSet resultado_data) throws SQLException {
        String id = resultado_data.getString("id_rol");
        String nombre = resultado_data.getString("nombre_rol");

        Rol getRol = new Rol(id, nombre);

        return getRol;
    }

    @Override
    public List<Rol> findAll() {
        PreparedStatement prepared = null;
        List<Rol> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL);
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }finally{
            closeResources(prepared, resultado_data);
        }

        return lista;
    }

    @Override
    public void create(Rol rol) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(INSERT);

            prepared.setString(1, rol.getId());
            prepared.setString(2, rol.getRol());

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR ");
            }

        } catch (SQLException ex) {

            System.out.println("ERROR " + ex.getMessage());

        }finally{
            closeResources(prepared);
        }
    }

    @Override
    public void update(Rol rol) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(UPDATE + GETONE);

            prepared.setString(1, rol.getRol());
            prepared.setString(2, rol.getId());

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR ");
            }

        } catch (SQLException ex) {

            System.out.println("ERROR " + ex.getMessage());
        }finally{
            closeResources(prepared);
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement prepared = null;
        connection = getConnection();;
        try {
            prepared = connection.prepareStatement(DELETE + GETONE);

            prepared.setString(1, id);

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR ");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR ");

        }finally{
            closeResources(prepared);
        }
    }

    @Override
    public Rol findById(String id) {
        PreparedStatement prepared = null;
        Rol getRol = null;
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data = prepared.executeQuery();

            if (resultado_data.next()) {
                getRol = Data(resultado_data);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }finally{
            closeResources(prepared, resultado_data);
        }

        return getRol;
    }

    @Override
    public List<Rol> findNames(String role) {
        PreparedStatement prepared = null;
        List<Rol> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + GETROLES);
            prepared.setString(1, role);
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }finally{
            closeResources(prepared, resultado_data);
        }

        return lista;
    }

    @Override
    public String newCode() {
        String cod = "R0001";
        PreparedStatement prepare_new_code = null;
        connection = getConnection();;
        ResultSet result_data = null;
        try {
            prepare_new_code = connection.prepareStatement(NEWCOD);
            result_data = prepare_new_code.executeQuery();

            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "R" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }finally{
            closeResources(prepare_new_code);
        }
        return cod;
    }

}
