package br.com.frota.util;
import br.com.frota.DAO.*;
import br.com.frota.model.*;

import java.util.List;

public class SelectAllTest {
    public static void main(String[] args) {
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


        List<Especialidade> especialidades = especialidade.selectAllEspecialidade(); especialidades.forEach(System.out::println);
        List<Medico> medicos = medico.selectAllMedico(); medicos.forEach(System.out::println);
        List<Paciente> pacientes = paciente.selectAllPaciente(); pacientes.forEach(System.out::println);
        List<Atributo_estrutura_lente> atributoEstruturaLentes = atributo_estrutura_lente.selectAllAtributo_estrutura_lente(); atributoEstruturaLentes.forEach(System.out::println);
        List<Especialidade_medica> especialidadeMedicas = especialidadeMedica.selectAllEspecialidade_medica(); especialidadeMedicas.forEach(System.out::println);
        List<Consulta_medica> consultaMedicas = consultaMedica.selectAllConsulta_medica(); consultaMedicas.forEach(System.out::println);
        List<Receita_oculos> receita_oculos = receitaOculos.selectAllReceita_oculos(); receita_oculos.forEach(System.out::println);
        List<Observacao_laudo> observacaoLaudos = observacaoLaudo.selectAllObservacao_laudo(); observacaoLaudos.forEach(System.out::println);
        List<Estrutura_lente> estruturaLentes = estruturaLente.selectAllEstrutura_lente(); estruturaLentes.forEach(System.out::println);
        List<Especificacao_lente> especificacaoLentes = especificacaoLente.selectAllEspecificacao_lente(); especificacaoLentes.forEach(System.out::println);
    }
}
