package modelo;

import java.util.List;

public class Setor {

    public String toJsonString() {             
        return "{id: " + id + ", andar:'" + andar + "', descricao:'" + descricao + "', prefixo: '" + prefixo + "', vagas:" + vagas.size() + '}';
    }
    
    private int id;

    public Setor(int id, String andar, String descricao, Estacionamento estacionamento, String prefixo, List<Vaga> vagas) {
        this.id = id;
        this.andar = andar;
        this.descricao = descricao;
        this.estacionamento = estacionamento;
        this.prefixo = prefixo;
        this.vagas = vagas;
    }
    
    private String prefixo;
    private String andar;
    private String descricao;
    private Estacionamento estacionamento;
    private List<Vaga> vagas;

    Setor() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
}
