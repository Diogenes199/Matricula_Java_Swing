package Modelo.DAO.Model;

import Modelo.Entidades.Curso;
import Modelo.Interfaces.Model.ICurso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO extends BaseDAO implements ICurso{
    
    private final String INSERT = "INSERT INTO cursos (id_curso, nombre_curso, costo_inscripcion, costo_libro) VALUES (?,?,?,?);";
    private final String UPDATE = "UPDATE cursos SET nombre_curso = ?, costo_inscripcion = ?, costo_libro = ? ";
    private final String DELETE = "DELETE FROM cursos ";
    private final String GETALL = "SELECT id_curso, nombre_curso, costo_inscripcion, costo_libro FROM cursos ";
    private final String GETONE = "WHERE id_curso = ?";
    private final String GETCURSES = "WHERE nombre_curso LIKE ?";
    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_curso),4) FROM cursos";

    public Curso Data(ResultSet resultado_data) throws SQLException {
        return new Curso(
                resultado_data.getString("id_curso"),
                resultado_data.getString("nombre_curso"),
                resultado_data.getDouble("costo_inscripcion"),
                resultado_data.getDouble("costo_libro")
        );
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> lista = new ArrayList<>();
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
    public void create(Curso curso) {
        try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
            prepared.setString(1, curso.getId());
            prepared.setString(2, curso.getCurso());
            prepared.setDouble(3, curso.getInscripcion());
            prepared.setDouble(4, curso.getLibro());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }
    }

    @Override
    public void update(Curso curso) {
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE + GETONE)) {
            prepared.setString(1, curso.getCurso());
            prepared.setDouble(2, curso.getInscripcion());
            prepared.setDouble(3, curso.getLibro());
            prepared.setString(4, curso.getId());
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
    public Curso findById(String id) {
        Curso curso = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    curso = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return curso;
    }

    @Override
    public String newCode() {
        String cod = "CUR0001";
        try (
            PreparedStatement prepare_new_code = getConnection().prepareStatement(NEWCOD);
            ResultSet result_data = prepare_new_code.executeQuery();
                ){
            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "CUR" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        } 
        return cod;
    }

    @Override
    public List<Curso> findByCurses(String curse) {
        List<Curso> lista = new ArrayList<>();
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETCURSES);) {
               prepared.setString(1,"%" + curse + "%");
               try(ResultSet resultado_data = prepared.executeQuery()){
            while (resultado_data.next()) {
                lista.add(Data(resultado_data));
            }
         }
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
        return lista.isEmpty()?null:lista;
    }
}
