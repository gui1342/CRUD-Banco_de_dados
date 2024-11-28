package br.com.frota.DAO;

import br.com.frota.model.Especificacao_lente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Especificacao_lenteDAO extends ConexaoDB{
    private static final String INSERT_ESPECIFICACAO_LENTE_SQL = "INSERT INTO especificacao_lente (valor, id_estrutura_lente, id_atributo_estrutura_lente) VALUES (?, ?, ?);";
    private static final String SELECT_ESPECIFICACAO_LENTE_BY_ID = "SELECT * FROM especificacao_lente WHERE id = ?";
    private static final String SELECT_ALL_ESPECIFICACAO_LENTE = "SELECT * FROM especificacao_lente;";
    private static final String DELETE_ESPECIFICACAO_LENTE_SQL = "DELETE FROM especificacao_lente WHERE id = ?;";
    private static final String UPDATE_ESPECIFICACAO_LENTE_SQL = "UPDATE especificacao_lente SET valor = ?, id_estrutura_lente = ?, id_atributo_estrutura_lente = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especificacao_lente;";

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

    public void insertEspecificacao_lente(Especificacao_lente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIFICACAO_LENTE_SQL)) {
            preparedStatement.setDouble(1, entidade.getValor());
            preparedStatement.setInt(2, entidade.getEstrutura_lente_id());
            preparedStatement.setInt(3, entidade.getAtributo_estrutura_lente_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Especificacao_lente selectEspecificacao_lente(int id) {
        Especificacao_lente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIFICACAO_LENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                double valor = rs.getDouble("valor");
                int estrutura_lente_id = rs.getInt("id_estrutura_lente");
                int atributo_estrutura_lente_id = rs.getInt("id_atributo_estrutura_lente");
                entidade = new Especificacao_lente(id, valor, estrutura_lente_id, atributo_estrutura_lente_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Especificacao_lente> selectAllEspecificacao_lente() {
        List<Especificacao_lente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIFICACAO_LENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double valor = rs.getDouble("valor");
                int estrutura_lente_id = rs.getInt("id_estrutura_lente");
                int atributo_estrutura_lente_id = rs.getInt("id_atributo_estrutura_lente");
                entidades.add(new Especificacao_lente(id, valor, estrutura_lente_id, atributo_estrutura_lente_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecificacao_lente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIFICACAO_LENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecificacao_lente(Especificacao_lente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIFICACAO_LENTE_SQL)) {
            statement.setDouble(1, entidade.getValor());
            statement.setInt(2, entidade.getEstrutura_lente_id());
            statement.setInt(3, entidade.getAtributo_estrutura_lente_id());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
