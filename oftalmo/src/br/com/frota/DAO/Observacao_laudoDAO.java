package br.com.frota.DAO;

import br.com.frota.model.Observacao_laudo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Observacao_laudoDAO extends  ConexaoDB{
    private static final String INSERT_OBSERVACAO_LAUDO_SQL = "INSERT INTO observacao_laudo (descricao, id_receita_oculos) VALUES (?, ?);";
    private static final String SELECT_OBSERVACAO_LAUDO_BY_ID = "SELECT * FROM observacao_laudo WHERE id = ?";
    private static final String SELECT_ALL_OBSERVACAO_LAUDO = "SELECT * FROM observacao_laudo;";
    private static final String DELETE_OBSERVACAO_LAUDO_SQL = "DELETE FROM observacao_laudo WHERE id = ?;";
    private static final String UPDATE_OBSERVACAO_LAUDO_SQL = "UPDATE observacao_laudo SET descricao = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM observacao_laudo;";

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

    public void insertObservacao_laudo(Observacao_laudo entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_OBSERVACAO_LAUDO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getReceita_oculos_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Observacao_laudo selectObservacao_laudo(int id) {
        Observacao_laudo entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_OBSERVACAO_LAUDO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int receita_oculos_id = rs.getInt("id_receita_oculos");
                entidade = new Observacao_laudo(id, descricao, receita_oculos_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Observacao_laudo> selectAllObservacao_laudo() {
        List<Observacao_laudo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_OBSERVACAO_LAUDO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int receita_oculos_id = rs.getInt("id_receita_oculos");
                entidades.add(new Observacao_laudo(id, descricao, receita_oculos_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteObservacao_laudo(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_OBSERVACAO_LAUDO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateObservacao_laudo(Observacao_laudo entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_OBSERVACAO_LAUDO_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getReceita_oculos_id());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}