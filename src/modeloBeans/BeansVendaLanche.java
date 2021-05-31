package modeloBeans;

/**
 *
 * @author vinic
 */
public class BeansVendaLanche {
    private int vendaCod;
    private String vendaNomeCliente;
    private String vendaNomeVendedor;
    private String VendaNomeLanche;
    private double valorVenda;
    private String pesquisa;
    
    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public String getVendaNomeLanche() {
        return VendaNomeLanche;
    }

    public void setVendaNomeLanche(String VendaNomeLanche) {
        this.VendaNomeLanche = VendaNomeLanche;
    }
    
    public int getVendaCod() {
        return vendaCod;
    }

    public void setVendaCod(int vendaCod) {
        this.vendaCod = vendaCod;
    }

    public String getVendaNomeCliente() {
        return vendaNomeCliente;
    }

    public void setVendaNomeCliente(String vendaNomeCliente) {
        this.vendaNomeCliente = vendaNomeCliente;
    }

    public String getVendaNomeVendedor() {
        return vendaNomeVendedor;
    }

    public void setVendaNomeVendedor(String vendaNomeVendedor) {
        this.vendaNomeVendedor = vendaNomeVendedor;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
}
