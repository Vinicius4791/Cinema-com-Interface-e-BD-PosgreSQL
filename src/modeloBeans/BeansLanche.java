package modeloBeans;

/**
 *
 * @author vinic
 */
public class BeansLanche {
    
    private int codLanche;
    private String nomeLanche;
    private double precoLanche;
    private String ingredientesLanche;
    private String pesquisa;
    
    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public int getCodLanche() {
        return codLanche;
    }

    public void setCodLanche(int codLanche) {
        this.codLanche = codLanche;
    }

    public String getNomeLanche() {
        return nomeLanche;
    }

    public void setNomeLanche(String nomeLanche) {
        this.nomeLanche = nomeLanche;
    }

    public double getPrecoLanche() {
        return precoLanche;
    }

    public void setPrecoLanche(double precoLanche) {
        this.precoLanche = precoLanche;
    }

    public String getIngredientesLanche() {
        return ingredientesLanche;
    }

    public void setIngredientesLanche(String ingredientesLanche) {
        this.ingredientesLanche = ingredientesLanche;
    }
    
}
