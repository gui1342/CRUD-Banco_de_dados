package br.com.frota.model;

public class Observacao_laudo extends GenericModel{
    private String descricao;
    private int receita_oculos_id;

    public Observacao_laudo(String descricao, int receita_oculos_id) {
        this.descricao = descricao;
        this.receita_oculos_id = receita_oculos_id;
    }

    public Observacao_laudo(Integer id, String descricao, int receita_oculos_id) {
        super.setId(id);
        this.descricao = descricao;
        this.receita_oculos_id = receita_oculos_id;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getReceita_oculos_id() { return receita_oculos_id; }

    public void setReceita_oculos_id(int receita_oculos_id) { this.receita_oculos_id = receita_oculos_id; }

    public String toString() {
        return "Observacao_laudo {" +
                "id='" + this.getId() + "\'" +
                " | descricao='" + descricao + "\'" +
                " | id_receita_oculos='" + receita_oculos_id + "\'" +
                '}';
    }
}
