package Modelo.DAO.Model;

import Modelo.Entidades.TipoDocumento;
import Modelo.Interfaces.Model.ITipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDAO extends BaseDAO implements ITipoDocumento {

    private final String INSERT = "INSERT INTO tipos_documentos(id_tipo_documento,descripcion) VALUES(?,?)";
    private final String UPDATE = "UPDATE tipos_documentos SET descripcion = ?  ";
    private final String DELETE = "DELETE FROM tipos_documentos ";
    private final String GETALL = "SELECT id_tipo_documento, descripcion FROM tipos_documentos ";
    private final String GETONE = " WHERE id_tipo_documento = ?";
    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_tipo_documento),3) FROM tipos_documentos";

    private TipoDocumento Data(ResultSet resultado_data) throws SQLException {
        String id = resultado_data.getString("id_tipo_documento");
        String nombre = resultado_data.getString("descripcion");

        TipoDocumento getTipoDocumento = new TipoDocumento(id, nombre);

        return getTipoDocumento;
    }

    @Override
    public List<TipoDocumento> findAll() {
        PreparedStatement prepared = null;
        List<TipoDocumento> lista = new ArrayList<>();
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
    public void create(TipoDocumento documento) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(INSERT);

            prepared.setString(1, documento.getId());
            prepared.setString(2, documento.getDescripcion());

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
    public void update(TipoDocumento documento) {
        PreparedStatement prepared = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(UPDATE + GETONE);

            prepared.setString(1, documento.getDescripcion());
            prepared.setString(2, documento.getId());

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
        connection = getConnection();
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
    public TipoDocumento findById(String id) {
        PreparedStatement prepared = null;
        TipoDocumento getTipoDocumento = null;
        ResultSet resultado_data = null;
        connection = getConnection();
        try {
            prepared = connection.prepareStatement(GETALL + GETONE);
            prepared.setString(1, id);
            resultado_data = prepared.executeQuery();

            if (resultado_data.next()) {
                getTipoDocumento = Data(resultado_data);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }finally{
            closeResources(prepared, resultado_data);
        }

        return getTipoDocumento;
    }

    @Override
    public String newCode() {
        String cod = "D0001";
        PreparedStatement prepare_new_code = null;
        connection = getConnection();
        ResultSet result_data = null;
        try {
            prepare_new_code = connection.prepareStatement(NEWCOD);
            result_data = prepare_new_code.executeQuery();

            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "D" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }finally{
            closeResources(prepare_new_code,result_data);
        }
        return cod;
    }
}
