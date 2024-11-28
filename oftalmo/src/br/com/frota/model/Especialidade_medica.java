package br.com.frota.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Especialidade_medica extends GenericModel{
    private String observacao;
    private Date dt_conclusao;
    private int medico_id;
    private int especialidade_id;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Especialidade_medica(String observacao, String dt_conclusao, int medico_id, int especialidade_id) throws ParseException {
        this.observacao = observacao;
        this.dt_conclusao = new Date(DATE_FORMAT.parse(dt_conclusao).getTime());
        this.medico_id = medico_id;
        this.especialidade_id = especialidade_id;
    }

    public Especialidade_medica(Integer id, String observacao, String dt_conclusao, int medico_id, int especialidade_id) throws ParseException {
        super.setId(id);
        this.observacao = observacao;
        this.dt_conclusao = new Date(DATE_FORMAT.parse(dt_conclusao).getTime());
        this.medico_id = medico_id;
        this.especialidade_id = especialidade_id;
    }

    public String getObservacao() { return observacao; }

    public void setObservacao(String observacao) { this.observacao = observacao; }

    public Date getDt_conclusao() { return dt_conclusao; }

    public void setDt_conclusao(String dt_conclusao) throws ParseException{
        this.dt_conclusao = new Date(DATE_FORMAT.parse(dt_conclusao).getTime());
    }

    public String getFormattedDt_conclusao() {
        return DATE_FORMAT.format(dt_conclusao);
    }

    public int getMedico_id() { return medico_id; }

    public void setMedico_id(int medico_id) { this.medico_id = medico_id; }

    public int getEspecialidade_id() { return especialidade_id; }

    public void setEspecialidade_id(int especialidade_id) { this.especialidade_id = especialidade_id; }

    public String toString() {
        return "Especialidade_medica {" +
                "id='" + this.getId() + "\'" +
                " | observacao='" + observacao + "\'" +
                " | dt_conclusao='" + getFormattedDt_conclusao() + "\'" +
                " | id_especialidade='" + especialidade_id + "\'" +
                " | id_medico='" + medico_id + "\'" +
                '}';
    }
}
