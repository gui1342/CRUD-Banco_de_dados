package br.com.frota.DAO;

import br.com.frota.model.Estrutura_lente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estrutura_lenteDAO extends ConexaoDB{
    private static final String INSERT_ESTRUTURA_LENTE_SQL = "INSERT INTO estrutura_lente (tipo_correcao, id_receita_oculos, distancia_pupilar) VALUES (?, ?, ?);";
    private static final String SELECT_ESTRUTURA_LENTE_BY_ID = "SELECT * FROM estrutura_lente WHERE id = ?";
    private static final String SELECT_ALL_ESTRUTURA_LENTE = "SELECT * FROM estrutura_lente;";
    private static final String DELETE_ESTRUTURA_LENTE_SQL = "DELETE FROM estrutura_lente WHERE id = ?;";
    private static final String UPDATE_ESTRUTURA_LENTE_SQL = "UPDATE estrutura_lente SET tipo_correcao = ?, id_receita_oculos = ?, distancia_pupilar = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM estrutura_lente;";

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

    public void insertEstrutura_lente(Estrutura_lente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESTRUTURA_LENTE_SQL)) {
            preparedStatement.setString(1, entidade.getTipo_correcao());
            preparedStatement.setInt(2, entidade.getReceita_oculos_id());
            preparedStatement.setInt(3, entidade.getDistancia_pupilar());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Estrutura_lente selectEstrutura_lente(int id) {
        Estrutura_lente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESTRUTURA_LENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                int receita_oculos_id = rs.getInt("id_receita_oculos");
                int distancia_pupilar = rs.getInt("distancia_pupilar");
                entidade = new Estrutura_lente(id, tipo_correcao, distancia_pupilar, receita_oculos_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Estrutura_lente> selectAllEstrutura_lente() {
        List<Estrutura_lente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESTRUTURA_LENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo_correcao = rs.getString("tipo_correcao");
                int receita_oculos_id = rs.getInt("id_receita_oculos");
                int distancia_pupilar = rs.getInt("distancia_pupilar");
                entidades.add(new Estrutura_lente(id, tipo_correcao, distancia_pupilar, receita_oculos_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEstrutura_lente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESTRUTURA_LENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEstrutura_lente(Estrutura_lente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESTRUTURA_LENTE_SQL)) {
            statement.setString(1, entidade.getTipo_correcao());
            statement.setInt(2, entidade.getReceita_oculos_id());
            statement.setInt(3, entidade.getDistancia_pupilar());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
