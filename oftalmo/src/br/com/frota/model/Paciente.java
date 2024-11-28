package br.com.frota.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Paciente extends GenericModel{
    private String nome;
    private String cpf;
    private Date dt_nascimento;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Paciente(String nome, String cpf, String dt_nascimento) throws ParseException {
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = new Date(DATE_FORMAT.parse(dt_nascimento).getTime());
    }

    public Paciente(Integer id, String nome, String cpf, String dt_nascimento) throws ParseException {
        super.setId(id);
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = new Date(DATE_FORMAT.parse(dt_nascimento).getTime());
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Date getDt_nascimento() { return dt_nascimento; }

    public void setDt_nascimento(String dt_nascimento) throws ParseException {
        this.dt_nascimento = new Date(DATE_FORMAT.parse(dt_nascimento).getTime());
    }

    public String getFormattedDt_nascimento() {
        return DATE_FORMAT.format(dt_nascimento);
    }

    public String toString() {
        return "Paciente {" +
                "id='" + this.getId() + "\'" +
                " | nome='" + nome + "\'" +
                " | cpf='" + cpf + "\'" +
                " | data_nascimento='" + getFormattedDt_nascimento() + "\'" +
                '}';
    }
}
