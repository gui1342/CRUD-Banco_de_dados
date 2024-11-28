package br.com.frota.DAO;

import br.com.frota.model.Consulta_medica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consulta_medicaDAO extends  ConexaoDB{
    private static final String INSERT_CONSULTA_MEDICA_SQL = "INSERT INTO consulta_medica (dt_consulta, id_paciente, id_medico, assinatura) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT * FROM consulta_medica WHERE id = ?";
    private static final String SELECT_ALL_CONSULTA_MEDICA = "SELECT * FROM consulta_medica;";
    private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM consulta_medica WHERE id = ?;";
    private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE consulta_medica SET dt_consulta = ?, id_paciente = ?, id_medico = ?, assinatura = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consulta_medica;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertConsulta_medica(Consulta_medica entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTA_MEDICA_SQL)) {
            preparedStatement.setDate(1, entidade.getDt_consulta());
            preparedStatement.setInt(2, entidade.getPaciente_id());
            preparedStatement.setInt(3, entidade.getMedico_id());
            preparedStatement.setString(4, entidade.getAssinatura());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static final SimpleDateFormat DATABASE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public Consulta_medica selectConsulta_medica(int id) {
        Consulta_medica entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTA_MEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String dt_consulta = rs.getString("dt_consulta");
                int paciente_id = rs.getInt("id_paciente");
                int medico_id = rs.getInt("id_medico");
                String assinatura = rs.getString("assinatura");
                Date data_consulta = DATABASE_DATE_FORMAT.parse(dt_consulta);
                entidade = new Consulta_medica(id, DATE_FORMAT.format(data_consulta), paciente_id, medico_id, assinatura);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Consulta_medica> selectAllConsulta_medica() {
        List<Consulta_medica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTA_MEDICA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String dt_consulta = rs.getString("dt_consulta");
                int paciente_id = rs.getInt("id_paciente");
                int medico_id = rs.getInt("id_medico");
                String assinatura = rs.getString("assinatura");
                Date data_consulta = DATABASE_DATE_FORMAT.parse(dt_consulta);
                entidades.add(new Consulta_medica(id, DATE_FORMAT.format(data_consulta), paciente_id, medico_id, assinatura));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsulta_medica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CONSULTA_MEDICA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsulta_medica(Consulta_medica entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTA_MEDICA_SQL)) {
            statement.setDate(1, entidade.getDt_consulta());
            statement.setInt(2, entidade.getPaciente_id());
            statement.setInt(3, entidade.getMedico_id());
            statement.setString(4, entidade.getAssinatura());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
