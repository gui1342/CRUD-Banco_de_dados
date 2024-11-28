package br.com.frota.util;

import br.com.frota.DAO.*;

import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        EspecialidadeDAO especialidade = new EspecialidadeDAO();
        MedicoDAO medico = new MedicoDAO();
        PacienteDAO paciente = new PacienteDAO();
        Atributo_estrutura_lenteDAO atributo_estrutura_lente = new Atributo_estrutura_lenteDAO();
        Especialidade_medicaDAO especialidadeMedica = new Especialidade_medicaDAO();
        Consulta_medicaDAO consultaMedica = new Consulta_medicaDAO();
        Receita_oculosDAO receitaOculos = new Receita_oculosDAO();
        Observacao_laudoDAO observacaoLaudo = new Observacao_laudoDAO();
        Estrutura_lenteDAO estruturaLente = new Estrutura_lenteDAO();
        Especificacao_lenteDAO especificacaoLente = new Especificacao_lenteDAO();

        //especialidade.deleteEspecialidade(2); especialidade.selectAllEspecialidade().forEach(System.out::println);
        //medico.deleteMedico(2); medico.selectAllMedico().forEach(System.out::println);
        //paciente.deletePaciente(2); paciente.selectAllPaciente().forEach(System.out::println);
        //atributo_estrutura_lente.deleteAtributo_estrutura_lente(2); atributo_estrutura_lente.selectAllAtributo_estrutura_lente().forEach(System.out::println);
        //especialidadeMedica.deleteEspecialidade_medica(2); especialidadeMedica.selectAllEspecialidade_medica().forEach(System.out::println);
        //consultaMedica.deleteConsulta_medica(2); consultaMedica.selectAllConsulta_medica().forEach(System.out::println);
        //receitaOculos.deleteReceita_oculos(2); receitaOculos.selectAllReceita_oculos().forEach(System.out::println);
        //observacaoLaudo.deleteObservacao_laudo(2); observacaoLaudo.selectAllObservacao_laudo().forEach(System.out::println);
        //estruturaLente.deleteEstrutura_lente(2); estruturaLente.selectAllEstrutura_lente().forEach(System.out::println);
        //especificacaoLente.deleteEspecificacao_lente(2); especificacaoLente.selectAllEspecificacao_lente().forEach(System.out::println);
    }
}
