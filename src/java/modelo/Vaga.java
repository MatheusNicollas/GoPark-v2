package modelo;

public class Vaga {

    public Vaga(int id, boolean especial, int status, Setor setor) {
        this.id = id;
        this.especial = especial;
        this.status = status;
        this.setor = setor;
    }
    public static final int LIVRE = 0;
    public static final int OCUPADA = 1;
    public static final int INTERDITADA = 2;
    
    private int id;
    private boolean especial;
    private int status;
    private Setor setor;

    public Vaga() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
