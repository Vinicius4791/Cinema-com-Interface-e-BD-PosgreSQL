package modeloBeans;

/**
 *
 * @author vinic
 */
public class BeansVendaIngresso {
    private int idVendaIngresso;
    private String nomeCliente;
    private String tituloFilme;
    private String nomeBilheteiro;
    private double valorIngresso;
    private String pesquisa;
    
    public int getIdVendaIngresso() {
        return idVendaIngresso;
    }

    public void setIdVendaIngresso(int idVendaIngresso) {
        this.idVendaIngresso = idVendaIngresso;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getNomeBilheteiro() {
        return nomeBilheteiro;
    }

    public void setNomeBilheteiro(String nomeBilheteiro) {
        this.nomeBilheteiro = nomeBilheteiro;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
}
