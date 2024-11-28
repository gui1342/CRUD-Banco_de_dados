package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.*;
import br.com.frota.servico.ServicoMarca;

import java.sql.SQLException;
import java.text.ParseException;

public class Teste {
    static MarcaDAO marcaDAO = new MarcaDAO();

    static ServicoMarca servicoMarca = new ServicoMarca();

    public static void main(String[] args) throws SQLException, ParseException {
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


        //especialidade.insertEspecialidade(new Especialidade("especialidade1", "conselho1"));
        //medico.insertMedico(new Medico("medico1", "012345"));
        //paciente.insertPaciente(new Paciente("paciente1", "00000000000","18/02/1979"));
        //atributo_estrutura_lente.insertAtributo_estrutura_lente(new Atributo_estrutura_lente("descrição2", "direito"));
        //especialidadeMedica.insertEspecialidade_medica(new Especialidade_medica("obs1", "02/09/2014", 1, 1));
        //consultaMedica.insertConsulta_medica(new Consulta_medica("04/12/2023", 2, 1, "medico1"));
        //receitaOculos.insertReceita_oculos(new Receita_oculos("detalhamento1", 2));
        //observacaoLaudo.insertObservacao_laudo(new Observacao_laudo("descrição1", 1));
        //estruturaLente.insertEstrutura_lente(new Estrutura_lente("correcao", 2, 2));
        //especificacaoLente.insertEspecificacao_lente(new Especificacao_lente(2.7, 2, 4));

        //count
        //System.out.println(marcaDAO.count());

//        //salvar
//        Marca marca = new Marca("Citroen");
//        servicoMarca.insertMarca(marca);

//        //buscar por ID
//        marca = marcaDAO.selectMarca(4);
//        System.out.println(marca);
//
//        //Update
//        marca.setDescricao("Peugeot");
//        marcaDAO.updateMarca(marca);
//        marca = marcaDAO.selectMarca(4);
//        System.out.println(marca);
//
//        //Select all
//        List<Marca> marcas = marcaDAO.selectAllMarcas();
//        marcas.forEach(System.out::println);
//
//        //Delete
//        marcaDAO.deleteMarca(1);
//        marcaDAO.selectAllMarcas().forEach(System.out::println);
    }
}
