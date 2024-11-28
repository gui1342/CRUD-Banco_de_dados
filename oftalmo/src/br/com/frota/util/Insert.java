package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.*;

import java.text.ParseException;

public class Insert {
    public static void main(String[] args) throws ParseException {

        //Objects DAO
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

        //inserts
//        especialidade.insertEspecialidade(new Especialidade("especialidade4", "conselho4"));
//        medico.insertMedico(new Medico("medico3", "123453"));
//        paciente.insertPaciente(new Paciente("paciente4", "00000000004","18/03/2005"));
//        atributo_estrutura_lente.insertAtributo_estrutura_lente(new Atributo_estrutura_lente("descrição4", "esquerdo"));
//        especialidadeMedica.insertEspecialidade_medica(new Especialidade_medica("obs4", "01/05/2023", 1, 1));
//        consultaMedica.insertConsulta_medica(new Consulta_medica("07/12/2023", 1, 1, "medico4"));
//        receitaOculos.insertReceita_oculos(new Receita_oculos("detalhamento5", 1));
//        observacaoLaudo.insertObservacao_laudo(new Observacao_laudo("descrição4", 1));
//        estruturaLente.insertEstrutura_lente(new Estrutura_lente("correcao4", 1, 1));
//        especificacaoLente.insertEspecificacao_lente(new Especificacao_lente(1.4, 1, 1));

        //search for id
        Especialidade especialidade1 = especialidade.selectEspecialidade(1); System.out.println(especialidade1);
//        Medico medico1 = medico.selectMedico(1); System.out.println(medico1);
//        Paciente paciente1 = paciente.selectPaciente(1); System.out.println(paciente1);
//        Atributo_estrutura_lente atributo_estrutura_lente1 = atributo_estrutura_lente.selectAtributo_estrutura_lente(1); System.out.println(atributo_estrutura_lente1);
//        Especialidade_medica especialidadeMedica1 = especialidadeMedica.selectEspecialidade_medica(1); System.out.println(especialidadeMedica1);
//        Consulta_medica consultaMedica1 = consultaMedica.selectConsulta_medica(1); System.out.println(consultaMedica1);
//        Receita_oculos receita_oculos = receitaOculos.selectReceita_oculos(1); System.out.println(receita_oculos);
//        Observacao_laudo observacaoLaudo1 = observacaoLaudo.selectObservacao_laudo(1); System.out.println(observacaoLaudo1);
//        Estrutura_lente estruturaLente1 = estruturaLente.selectEstrutura_lente(1); System.out.println(estruturaLente1);
//        Especificacao_lente especificacaoLente1 = especificacaoLente.selectEspecificacao_lente(1); System.out.println(especificacaoLente1);
    }
}
