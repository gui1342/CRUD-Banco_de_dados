package br.com.frota.model;

import java.util.Locale;

public class Medico extends GenericModel{
    private String nome;
    private  String crm;

    public Medico(String nome, String crm){
        this.nome = nome;
        this.crm = crm;
    }

    public Medico(Integer id, String nome, String crm){
        super.setId(id);
        this.nome = nome;
        this.crm = crm;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCrm() { return crm; }

    public void setCrm(String crm) { this.crm = crm; }

    public String toString() {
        return "Medico {" +
                "id='" + this.getId() + "\'" +
                " | nome='" + nome + "\'" +
                " | crm='" + crm + "\'" +
                '}';
    }
}
