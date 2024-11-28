package br.com.frota.DAO;

import br.com.frota.model.Especialidade_medica;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Especialidade_medicaDAO extends ConexaoDB{
    private static final String INSERT_ESPECIALIDADE_MEDICA_SQL = "INSERT INTO especialidade_medica (observacao, id_medico, id_especialidade, dt_conclusao) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ESPECIALIDADE_MEDICA_BY_ID = "SELECT * FROM especialidade_medica WHERE id = ?";
    private static final String SELECT_ALL_ESPECIALIDADE_MEDICA = "SELECT * FROM especialidade_medica;";
    private static final String DELETE_ESPECIALIDADE_MEDICA_SQL = "DELETE FROM especialidade_medica WHERE id = ?;";
    private static final String UPDATE_ESPECIALIDADE_MEDICA_SQL = "UPDATE especialidade_medica SET observacao = ?, id_medico = ?, id_especialidade = ?, dt_conclusao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidade_medica;";

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

    public void insertEspecialidade_medica(Especialidade_medica entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIALIDADE_MEDICA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getMedico_id());
            preparedStatement.setInt(3, entidade.getEspecialidade_id());
            preparedStatement.setDate(4, entidade.getDt_conclusao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static final SimpleDateFormat DATABASE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public Especialidade_medica selectEspecialidade_medica(int id) {
        Especialidade_medica entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIALIDADE_MEDICA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                int medico_id = rs.getInt("id_medico");
                int especialidade_id = rs.getInt("id_especialidade");
                String dt_conclusao = rs.getString("dt_conclusao");
                Date data_conclusao = DATABASE_DATE_FORMAT.parse(dt_conclusao);
                entidade = new Especialidade_medica(id, observacao, DATE_FORMAT.format(data_conclusao), medico_id, especialidade_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Especialidade_medica> selectAllEspecialidade_medica() {
        List<Especialidade_medica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIALIDADE_MEDICA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                int medico_id = rs.getInt("id_medico");
                int especialidade_id = rs.getInt("id_especialidade");
                String dt_conclusao = rs.getString("dt_conclusao");
                Date data_conclusao = DATABASE_DATE_FORMAT.parse(dt_conclusao);
                entidades.add(new Especialidade_medica(id, observacao, DATE_FORMAT.format(data_conclusao), medico_id, especialidade_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidade_medica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIALIDADE_MEDICA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecialidade_medica(Especialidade_medica entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIALIDADE_MEDICA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getMedico_id());
            statement.setInt(3, entidade.getEspecialidade_id());
            statement.setDate(4, entidade.getDt_conclusao());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
