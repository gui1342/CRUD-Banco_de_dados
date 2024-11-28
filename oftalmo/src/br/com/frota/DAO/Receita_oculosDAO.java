package br.com.frota.DAO;

import br.com.frota.model.Receita_oculos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Receita_oculosDAO extends ConexaoDB{
    private static final String INSERT_RECEITA_OCULOS_SQL = "INSERT INTO receita_oculos (id_consulta_medica, detalhamento) VALUES (?, ?);";
    private static final String SELECT_RECEITA_OCULOS_BY_ID = "SELECT * FROM receita_oculos WHERE id = ?";
    private static final String SELECT_ALL_RECEITA_OCULOS = "SELECT * FROM receita_oculos;";
    private static final String DELETE_RECEITA_OCULOS_SQL = "DELETE FROM receita_oculos WHERE id = ?;";
    private static final String UPDATE_RECEITA_OCULOS_SQL = "UPDATE receita_oculos SET id_consulta_medica = ?, detalhamento = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM receita_oculos;";

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

    public void insertReceita_oculos(Receita_oculos entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RECEITA_OCULOS_SQL)) {
            preparedStatement.setInt(1, entidade.getConsulta_medica_id());
            preparedStatement.setString(2, entidade.getDetalhamento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Receita_oculos selectReceita_oculos(int id) {
        Receita_oculos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RECEITA_OCULOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int consulta_medica_id = rs.getInt("id_consulta_medica");
                String detalhamento = rs.getString("detalhamento");
                entidade = new Receita_oculos(id, detalhamento, consulta_medica_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Receita_oculos> selectAllReceita_oculos() {
        List<Receita_oculos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RECEITA_OCULOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int consulta_medica_id = rs.getInt("id_consulta_medica");
                String detalhamento = rs.getString("detalhamento");
                entidades.add(new Receita_oculos(id, detalhamento, consulta_medica_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteReceita_oculos(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RECEITA_OCULOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateReceita_oculos(Receita_oculos entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RECEITA_OCULOS_SQL)) {
            statement.setInt(1, entidade.getConsulta_medica_id());
            statement.setString(2, entidade.getDetalhamento());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}