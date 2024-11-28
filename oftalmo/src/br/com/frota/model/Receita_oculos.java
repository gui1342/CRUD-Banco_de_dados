package br.com.frota.model;

public class Receita_oculos extends GenericModel{
    private String detalhamento;
    private int consulta_medica_id;

    public Receita_oculos(String detalhamento, int consulta_medica_id) {
        this.detalhamento = detalhamento;
        this.consulta_medica_id = consulta_medica_id;
    }

    public Receita_oculos(Integer id, String detalhamento, int consulta_medica_id) {
        super.setId(id);
        this.detalhamento = detalhamento;
        this.consulta_medica_id = consulta_medica_id;
    }

    public String getDetalhamento() { return detalhamento; }

    public void setDetalhamento(String detalhamento) { this.detalhamento = detalhamento; }

    public int getConsulta_medica_id() { return consulta_medica_id; }

    public void setConsulta_medica_id(int consulta_medica_id) { this.consulta_medica_id = consulta_medica_id; }

    public String toString() {
        return "Receita_oculos {" +
                "id='" + this.getId() + "\'" +
                " | detalhamento='" + detalhamento + "\'" +
                " | id_consulta_medica='" + consulta_medica_id + "\'" +
                '}';
    }
}
