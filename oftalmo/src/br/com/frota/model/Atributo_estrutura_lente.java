package br.com.frota.model;

public class Atributo_estrutura_lente extends GenericModel{
    private String descricao;

    private String lado_olho;

    public Atributo_estrutura_lente(String descricao, String lado_olho) {
        this.descricao = descricao;
        this.lado_olho = lado_olho;
    }

    public Atributo_estrutura_lente(Integer id, String descricao, String lado_olho){
        super.setId(id);
        this.descricao = descricao;
        this.lado_olho = lado_olho;
    }
    
    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLado_olho() { return lado_olho; }

    public void setLado_olho(String lado_olho) { this.lado_olho = lado_olho; }

    public String toString() {
        return "Atributo_estrutura_lente {" +
                "id='" + this.getId() + "\'" +
                " | descricao='" + descricao + "\'" +
                " | lado_olho='" + lado_olho + "\'" +
                '}';
    }
}
