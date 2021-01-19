/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aumbanco.modelo;

/**
 *
 * @author IgorDev & Artur
 */
public class Pessoas {

    private int id;
    private String CPF_CNPJ;
    private String nomePessoa;
    private String Telefone;
    private String Estado;
    private int codEstado;
    private String Cidade;
    private String bairro;
    private String Rua;
    private String Num;

    public String getNum() {
        return Num;
    }

    public void setNum(String Num) {
        this.Num = Num;
    }
    private String Complemento;
    private String Email;
    private String pesquisa;
    private String horaalteracao;
    private String usuario;
    private String cliente_fornecedor;

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }


    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the horaalteracao
     */
    public String getHoraalteracao() {
        return horaalteracao;
    }

    /**
     * @param horaalteracao the horaalteracao to set
     */
    public void setHoraalteracao(String horaalteracao) {
        this.horaalteracao = horaalteracao;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCliente_fornecedor() {
        return cliente_fornecedor;
    }

    public void setCliente_fornecedor(String cliente_fornecedor) {
        this.cliente_fornecedor = cliente_fornecedor;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
