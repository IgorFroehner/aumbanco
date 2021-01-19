package br.com.aumbanco.modelo;

public class Produtos {

    private String Pesquisa;
    private int cProd;
    private String Nome;
    private String unidade;
    private double Valor;
    private int quantidade;
    private String horaalteracao;
    private String usuario;
    
    public int getcProd() {
        return cProd;
    }

    public void setcProd(int cProd) {
        this.cProd = cProd;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }


    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getPesquisa() {
        return Pesquisa;
    }

    public void setPesquisa(String Pesquisa) {
        this.Pesquisa = Pesquisa;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getHoraalteracao() {
        return horaalteracao;
    }

    public void setHoraalteracao(String horaalteracao) {
        this.horaalteracao = horaalteracao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


}
