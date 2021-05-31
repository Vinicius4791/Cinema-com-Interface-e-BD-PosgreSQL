package modeloBeans;

/**
 *
 * @author vinic
 */
public class BeansUsuario {

    private Integer codUsuario;
    private String usuNome;
    private Integer UsuIdade;
    private String usuTipo;
    private String usuSenha;
    private Integer numCartao;
    private double valorConta;
    private String UsuPesquisa;

    public String getUsuPesquisa() {
        return UsuPesquisa;
    }

    public void setUsuPesquisa(String UsuPesquisa) {
        this.UsuPesquisa = UsuPesquisa;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public Integer getUsuIdade() {
        return UsuIdade;
    }

    public void setUsuIdade(Integer UsuIdade) {
        this.UsuIdade = UsuIdade;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public Integer getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(Integer numCartao) {
        this.numCartao = numCartao;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }
    
    
}
