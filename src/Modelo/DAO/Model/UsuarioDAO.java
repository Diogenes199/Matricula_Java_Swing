package Modelo.DAO.Model;

import Modelo.Entidades.Rol;
import Modelo.Entidades.Usuario;
import Modelo.Interfaces.Model.IUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends BaseDAO implements IUsuario {

    private final String INSERT = "INSERT INTO usuarios(id_usuario,nombre,apellido_paterno, apellido_materno,dni,usuario, contra, celular1,celular2,direccion,id_rol) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE usuarios SET nombre = ? ,apellido_paterno = ?, apellido_materno = ?,dni = ?,usuario = ?, contra = ?, celular1 = ?,celular2 = ?,direccion = ?,id_rol= ? ";
    private final String DELETE = "DELETE FROM usuarios ";
    private final String GETALL = """
                                  SELECT U.id_usuario,U.nombre,U.apellido_paterno, U.apellido_materno,U.dni,U.usuario, U.contra, U.celular1,U.celular2,U.direccion,R.nombre_rol FROM usuarios as U 
                                  inner join roles  as R  on U.id_rol = R.id_rol   """;
    private final String GETONE = " WHERE id_usuario = ?";

    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_usuario),3) FROM usuarios";

    public Usuario Data(ResultSet resultado_data) throws SQLException {
        String id = resultado_data.getString("id_usuario");
        String nombre = resultado_data.getString("nombre");
        String apellidoPaterno = resultado_data.getString("apellido_paterno");
        String apellidoMaterno = resultado_data.getString("apellido_materno");
        String dni = resultado_data.getString("dni");
        String usuario = resultado_data.getString("usuario");
        String contra = resultado_data.getString("contra");
        String celularone = resultado_data.getString("celular1");
        String celulartwo = resultado_data.getString("celular2");
        String direccion = resultado_data.getString("direccion");

        Rol rol = new Rol();
        rol.setRol(resultado_data.getString("nombre_rol"));

        Usuario getUsuario = new Usuario(id, nombre, apellidoPaterno, apellidoMaterno, dni, usuario, contra, celularone, celulartwo, direccion, rol);

        return getUsuario;
    }

    @Override
    public List<Usuario> findAll() {
        PreparedStatement prepared = null;
        List<Usuario> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL);
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR  : " + ex.getMessage());
        } finally {
            closeResources(prepared, resultado_data);
        }
        return lista;
    }

    @Override
    public void create(Usuario usuario) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(INSERT);

            prepared.setString(1, usuario.getId());
            prepared.setString(2, usuario.getNombre());
            prepared.setString(3, usuario.getPaterno());
            prepared.setString(4, usuario.getMaterno());
            prepared.setString(5, usuario.getDni());
            prepared.setString(6, usuario.getUsuario());
            prepared.setString(7, usuario.getContra());
            prepared.setString(8, usuario.getCelular1());
            prepared.setString(9, usuario.getCelular2());
            prepared.setString(10, usuario.getDireccion());
            prepared.setString(11, usuario.getRol().getId());

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR ");
            }

        } catch (SQLException ex) {

            System.out.println("ERROR CREATE " + ex.getMessage());

        } finally {
            closeResources(prepared);
        }
    }

    @Override
    public void update(Usuario usuario) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(UPDATE + GETONE);

            prepared.setString(1, usuario.getNombre());
            prepared.setString(2, usuario.getPaterno());
            prepared.setString(3, usuario.getMaterno());
            prepared.setString(4, usuario.getDni());
            prepared.setString(5, usuario.getUsuario());
            prepared.setString(6, usuario.getContra());
            prepared.setString(7, usuario.getCelular1());
            prepared.setString(8, usuario.getCelular2());
            prepared.setString(9, usuario.getDireccion());
            prepared.setString(10, usuario.getRol().getId());
            prepared.setString(11, usuario.getId());

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR UPDATE");
            }

        } catch (SQLException ex) {

            System.out.println("ERROR UPDATE" + ex.getMessage());

        } finally {
            closeResources(prepared);
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(DELETE + GETONE);

            prepared.setString(1, id);

            if (prepared.executeUpdate() == 0) {
                System.out.println("ERROR DELETE ");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR DELETE " + ex.getMessage());

        } finally {
            closeResources(prepared);
        }
    }

    @Override
    public Usuario findById(String id) {
        PreparedStatement prepared = null;
        Usuario getUser = null;
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data = prepared.executeQuery();

            if (resultado_data.next()) {
                getUser = Data(resultado_data);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR SEARCH : " + ex.getMessage());
        } finally {
            closeResources(prepared, resultado_data);
        }
        return getUser;
    }

    @Override
    public boolean findByUser(Usuario usuario) {

        String sql = "SELECT usuario FROM usuarios WHERE usuario = ? AND contra = ?";
        PreparedStatement prepared = null;
        connection = getConnection();

        try {
            prepared = connection.prepareStatement(sql);
            prepared.setString(1, usuario.getUsuario());
            prepared.setString(2, usuario.getContra());
            ResultSet rs = prepared.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
            return false;
        } finally {
            closeResources(prepared);
        }
    }

    @Override
    public String newCode() {
        String cod = "U0001";
        PreparedStatement prepare_new_code = null;
        connection = getConnection();
        ResultSet result_data = null;
        try {
            prepare_new_code = connection.prepareStatement(NEWCOD);
            result_data = prepare_new_code.executeQuery();

            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "U" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        } finally {
            closeResources(prepare_new_code);
        }
        return cod;
    }

    @Override
    public List<Usuario> findByNameAndLastName(String id) {
        PreparedStatement prepared = null;
        List<Usuario> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + "WHERE CONCAT(U.nombre, ' ', U.apellido_paterno, ' ', U.apellido_materno)like   ?");
            prepared.setString(1, "%" + id + "%");
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR  : " + ex.getMessage());
        } finally {
            closeResources(prepared, resultado_data);
        }

        return lista;
    }

    @Override
    public List<Usuario> findByIdAll(String id) {
        PreparedStatement prepared = null;
        List<Usuario> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR  : " + ex.getMessage());
        } finally {
            closeResources(prepared, resultado_data);
        }

        return lista;
    }

    @Override
    public List<Usuario> findByRol(String id) {
        PreparedStatement prepared = null;
        List<Usuario> lista = new ArrayList<>();
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + "WHERE R.nombre_rol = ? ");
            prepared.setString(1, id);
            resultado_data = prepared.executeQuery();

            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR  : " + ex.getMessage());
        } finally {
            closeResources(prepared, resultado_data);
        }

        return lista;
    }
}
