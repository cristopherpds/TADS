
/**
 *
 * @author Atelechi
 */
public class Bebida {

    private String nome;
    private float custo;
    private String descricao;
    private int estoque;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getCusto() {
        return this.custo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public float getPrecoVenda() {
        return this.custo + (float) (this.custo * 0.3);
    }

}
