package modelo;

import java.sql.Date;
import java.util.Calendar;

public class Mensalista {

    public String toJsonString() {
        Date dt = (Date) dataDeCadastro.clone();
        
        dt.setMonth(dt.getMonth() != 12? dt.getMonth() + 1 : 1);
        
        return "{id: " + id + ", CodCartao: " + codCartao + ", dataDeCadastro: " + dataDeCadastro + ", vencimento: " + dt + ", pagamento: " + pagamento + ", status: " + getStatus() + '}';
    }
        
    public Mensalista(int id, Date  dataDeCadastro, String CodCartao, Pagamento pagamento, int ultimoMesPago) {
        this.id = id;
        this.dataDeCadastro = dataDeCadastro;
        this.codCartao      = CodCartao;
        this.pagamento      = pagamento;
        this.ultimoMesPago  = ultimoMesPago;
    }
    public static final int STATUS_NOVO = 0;
    public static final int STATUS_OK   = 1;
    public static final int STATUS_VENCIDO  = 2;
    
    private int id;
    private String codCartao;
    private Date dataDeCadastro;
    private Pagamento pagamento;
    private int ultimoMesPago;    

    public Mensalista() {
        
    }

    public int getStatus() {
        java.util.Date dt = Calendar.getInstance().getTime();

        if (dataDeCadastro.getMonth() == dt.getMonth() && dataDeCadastro.getYear()== dt.getYear())
            return STATUS_NOVO;        
        
        if (dt.getMonth() > ultimoMesPago && dataDeCadastro.getDay() < dt.getDay())        
            return STATUS_VENCIDO;
        
        return STATUS_OK;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(String CodCartao) {
        this.codCartao = CodCartao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public int getUltimoMesPago() {
        return ultimoMesPago;
    }

    public void setUltimoMesPago(int ultimoMesPago) {
        this.ultimoMesPago = ultimoMesPago;
    }
    
    public Date getVencimento() {
        Date dt = (Date) dataDeCadastro.clone();
        
        dt.setMonth(dt.getMonth() != 12? dt.getMonth() + 1 : 1);
        
        return dt;
    }
}
