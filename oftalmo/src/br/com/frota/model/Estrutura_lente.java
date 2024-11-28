package br.com.frota.model;

public class Estrutura_lente extends GenericModel{
    private String tipo_correcao;
    private int distancia_pupilar;
    private int receita_oculos_id;

    public Estrutura_lente(String tipo_correcao, int distancia_pupilar, int receita_oculos_id) {
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.receita_oculos_id = receita_oculos_id;
    }

    public Estrutura_lente(Integer id, String tipo_correcao, int distancia_pupilar, int receita_oculos_id) {
        super.setId(id);
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.receita_oculos_id = receita_oculos_id;
    }

    public String getTipo_correcao() { return tipo_correcao; }

    public void setTipo_correcao(String tipo_correcao) { this.tipo_correcao = tipo_correcao; }

    public int getDistancia_pupilar() { return distancia_pupilar; }

    public void setDistancia_pupilar(int distancia_pupilar) { this.distancia_pupilar = distancia_pupilar; }

    public int getReceita_oculos_id() { return receita_oculos_id; }

    public void setReceita_oculos_id(int receita_oculos_id) { this.receita_oculos_id = receita_oculos_id; }

    public String toString() {
        return "Estrutura_lente {" +
                "id='" + this.getId() + "\'" +
                " | tipo_correcao='" + tipo_correcao + "\'" +
                " | distancia_pupilar='" + distancia_pupilar + "\'" +
                " | id_receita_oculos='" + receita_oculos_id + "\'" +
                '}';
    }
}
