package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.*;

import java.sql.SQLException;
import java.text.ParseException;

public class UpdateTest {
    public static void main(String[] args) throws ParseException, SQLException {
        //objects DAO
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

        //Objects model
//        Especialidade especialidade1 = especialidade.selectEspecialidade(1); System.out.println("antes: " + especialidade1);
//        Medico medico1 = medico.selectMedico(1); System.out.println("antes: " + medico1);
//        Paciente paciente1 = paciente.selectPaciente(1); System.out.println("antes: " + paciente1 );
//        Atributo_estrutura_lente atributo_estrutura_lente1 = atributo_estrutura_lente.selectAtributo_estrutura_lente(1); System.out.println("antes: " + atributo_estrutura_lente1);
//        Especialidade_medica especialidadeMedica1 = especialidadeMedica.selectEspecialidade_medica(1); System.out.println("antes: " + especialidadeMedica1);
//        Consulta_medica consultaMedica1 = consultaMedica.selectConsulta_medica(1); System.out.println("antes: " + consultaMedica1);
//        Receita_oculos receitaOculos1 = receitaOculos.selectReceita_oculos(1); System.out.println("antes: " + receitaOculos1);
//        Observacao_laudo observacaoLaudo1 = observacaoLaudo.selectObservacao_laudo(1); System.out.println("antes: " + observacaoLaudo1);
//        Estrutura_lente estruturaLente1 = estruturaLente.selectEstrutura_lente(1); System.out.println("antes: " + estruturaLente1);
//        Especificacao_lente especificacaoLente1 = especificacaoLente.selectEspecificacao_lente(1); System.out.println("antes: " + especificacaoLente1);

        //updates
//        especialidade1.setDescricao("teste_update"); especialidade.updateEspecialidade(especialidade1); System.out.println("agora: " + especialidade1);
//        medico1.setNome("update"); medico.updateMedico(medico1); System.out.println("agora: " + medico1);
//        paciente1.setNome("paciente_update"); paciente.updatePaciente(paciente1); System.out.println("agora: " + paciente1);
//        atributo_estrutura_lente1.setLado_olho("update_lado"); atributo_estrutura_lente.updateAtributo_estrutura_lente(atributo_estrutura_lente1); System.out.println("agora: " + atributo_estrutura_lente1);
//        especialidadeMedica1.setDt_conclusao("10/09/5000"); especialidadeMedica.updateEspecialidade_medica(especialidadeMedica1); System.out.println("agora: " + especialidadeMedica1);
//        consultaMedica1.setDt_consulta("10/12/2023"); consultaMedica.updateConsulta_medica(consultaMedica1); System.out.println("agora: " + consultaMedica1);
//        receitaOculos1.setDetalhamento("detalhe_update"); receitaOculos.updateReceita_oculos(receitaOculos1); System.out.println("agora: " + receitaOculos1);
//        observacaoLaudo1.setDescricao("update_test"); observacaoLaudo.updateObservacao_laudo(observacaoLaudo1); System.out.println("agora: " + observacaoLaudo1);
//        estruturaLente1.setDistancia_pupilar(27); estruturaLente.updateEstrutura_lente(estruturaLente1); System.out.println("agora: " + estruturaLente1);
//        especificacaoLente1.setValor(0.078); especificacaoLente.updateEspecificacao_lente(especificacaoLente1); System.out.println("agora: " + especificacaoLente1);

    }
}
