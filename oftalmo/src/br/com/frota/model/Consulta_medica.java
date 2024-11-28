package br.com.frota.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Consulta_medica extends GenericModel{
    private Date dt_consulta;
    private int paciente_id;
    private int medico_id;
    private String assinatura;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public Consulta_medica(String dt_consulta, int paciente_id, int medico_id, String assinatura) throws ParseException {
        this.dt_consulta = new Date(DATE_FORMAT.parse(dt_consulta).getTime());
        this.paciente_id = paciente_id;
        this.medico_id = medico_id;
        this.assinatura = assinatura;
    }

    public Consulta_medica(Integer id, String dt_consulta, int paciente_id, int medico_id, String assinatura) throws ParseException {
        super.setId(id);
        this.dt_consulta = new Date(DATE_FORMAT.parse(dt_consulta).getTime());
        this.paciente_id = paciente_id;
        this.medico_id = medico_id;
        this.assinatura = assinatura;
    }

    public java.sql.Date getDt_consulta() { return dt_consulta; }

    public void setDt_consulta(String dt_consulta) throws ParseException {
        this.dt_consulta = new Date(DATE_FORMAT.parse(dt_consulta).getTime());
    }

    public String getFormattedDt_consulta() {
        return DATE_FORMAT.format(dt_consulta);
    }

    public int getPaciente_id() { return paciente_id; }

    public void setPaciente_id(int paciente_id) { this.paciente_id = paciente_id; }

    public int getMedico_id() { return medico_id; }

    public void setMedico_id(int medico_id) { this.medico_id = medico_id; }

    public String getAssinatura() { return assinatura; }

    public void setAssinatura(String assinatura) { this.assinatura = assinatura; }

    public String toString() {
        return "Consulta_medica {" +
                "id='" + this.getId() + "\'" +
                " | assinatura='" + assinatura + "\'" +
                " | dt_consulta='" + getFormattedDt_consulta() + "\'" +
                " | id_paciente='" + paciente_id + "\'" +
                " | id_medico='" + medico_id + "\'" +
                '}';
    }
}
