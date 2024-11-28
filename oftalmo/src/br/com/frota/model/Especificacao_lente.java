package br.com.frota.model;

public class Especificacao_lente extends GenericModel{
    private double valor;
    private int estrutura_lente_id;
    private int atributo_estrutura_lente_id;

    public Especificacao_lente(double valor, int estrutura_lente_id, int atributo_estrutura_lente_id) {
        this.valor = valor;
        this.estrutura_lente_id = estrutura_lente_id;
        this.atributo_estrutura_lente_id = atributo_estrutura_lente_id;
    }

    public Especificacao_lente(Integer id, double valor, int estrutura_lente_id, int atributo_estrutura_lente_id) {
        super.setId(id);
        this.valor = valor;
        this.estrutura_lente_id = estrutura_lente_id;
        this.atributo_estrutura_lente_id = atributo_estrutura_lente_id;
    }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }

    public int getEstrutura_lente_id() { return estrutura_lente_id; }

    public void setEstrutura_lente_id(int estrutura_lente_id) { this.estrutura_lente_id = estrutura_lente_id; }

    public int getAtributo_estrutura_lente_id() { return atributo_estrutura_lente_id; }

    public void setAtributo_estrutura_lente_id(int atributo_estrutura_lente_id) { this.atributo_estrutura_lente_id = atributo_estrutura_lente_id; }

    public String toString() {
        return "Especificacao_lente {" +
                "id='" + this.getId() + "\'" +
                " | valor='" + valor + "\'" +
                " | id_estrutura_lente='" + estrutura_lente_id + "\'" +
                " | id_atributo_estrutura_lente='" + atributo_estrutura_lente_id + "\'" +
                '}';
    }
}
