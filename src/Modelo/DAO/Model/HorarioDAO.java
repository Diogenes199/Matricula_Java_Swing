package Modelo.DAO.Model;

import Modelo.Entidades.Horario;
import Modelo.Interfaces.Model.IHorario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class HorarioDAO extends BaseDAO implements IHorario{

    private final String INSERT = "INSERT INTO horarios (id_horario,dia, hora_inicio, hora_fin) VALUES (?,?,?,?);";
    private final String UPDATE = "UPDATE horarios SET dia = ?, hora_inicio = ?, hora_fin = ? ";
    private final String DELETE = "DELETE FROM horarios ";
    private final String GETALL = "SELECT id_horario,dia, hora_inicio, hora_fin FROM horarios ";
    private final String GETONE = "WHERE id_horario = ?;";
    private final String GETHORA = "WHERE dia LIKE ?";
    private final String NEWCOD = "SELECT SUBSTRING(MAX(id_horario),3) FROM horarios";


    public Horario Data(ResultSet resultado_data) throws SQLException {
        return new Horario(
                resultado_data.getString("id_horario"),
                resultado_data.getString("dia"),
                resultado_data.getTime("hora_inicio").toLocalTime(),
                resultado_data.getTime("hora_fin").toLocalTime()
        );
    }

    @Override
    public List<Horario> findAll() {
        List<Horario> lista = new ArrayList<>();
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
    public void create(Horario horario) {
        try (PreparedStatement prepared = getConnection().prepareStatement(INSERT)) {
            prepared.setString(1, horario.getId());
            prepared.setString(2, horario.getDia());
            prepared.setTime(3, java.sql.Time.valueOf(horario.getHoraInicio()));
            prepared.setTime(4, java.sql.Time.valueOf(horario.getHoraFin()));
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR CREATE " + ex.getMessage());
        }
    }

    @Override
    public void update(Horario horario) {
        try (PreparedStatement prepared = getConnection().prepareStatement(UPDATE + GETONE)) {
            prepared.setString(1, horario.getDia());
            prepared.setTime(2, java.sql.Time.valueOf(horario.getHoraInicio()));
            prepared.setTime(3, java.sql.Time.valueOf(horario.getHoraFin()));
            prepared.setString(4, horario.getId());
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
    public Horario findById(String id) {
        Horario horario = null;
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETONE)) {
            prepared.setString(1, id);
            try (ResultSet resultado_data = prepared.executeQuery()) {
                if (resultado_data.next()) {
                    horario = Data(resultado_data);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR FIND : " + ex.getMessage());
        }
        return horario;
    }

    @Override
    public String newCode() {
        String cod = "H0001";
        try (
            PreparedStatement prepare_new_code = getConnection().prepareStatement(NEWCOD);
            ResultSet result_data = prepare_new_code.executeQuery();
                ){
            if (result_data.next()) {
                DecimalFormat formato_decimal = new DecimalFormat("0000");
                cod = "H" + formato_decimal.format(Integer.parseInt(result_data.getString(1)) + 1);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        } 
        return cod;
    }

    @Override
    public List<Horario> findByHorarios(String horario) {
        List<Horario> lista = new ArrayList<>();
        try (PreparedStatement prepared = getConnection().prepareStatement(GETALL + GETHORA);) {
               prepared.setString(1,"%" + horario + "%");
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
