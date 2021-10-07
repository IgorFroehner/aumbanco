/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igor.modelo;

/**
 *
 * @author Igor & Artur
 */
public class Usuario {

    private int valida;
    private String nome;
    private String login;
    private String senha;
    private String permissao;
    private String horaentrada;
    private String horasaida;
    private String dataentrada;
    private String datasaida;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getValida() {
        return valida;
    }

    public void setValida(int valida) {
        this.valida = valida;
    }

    /**
     * @return the horaentrada
     */
    public String getHoraentrada() {
        return horaentrada;
    }

    /**
     * @param horaentrada the horaentrada to set
     */
    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }

    /**
     * @return the horasaida
     */
    public String getHorasaida() {
        return horasaida;
    }

    /**
     * @param horasaida the horasaida to set
     */
    public void setHorasaida(String horasaida) {
        this.horasaida = horasaida;
    }

    /**
     * @return the dataentrada
     */
    public String getDataentrada() {
        return dataentrada;
    }

    /**
     * @param dataentrada the dataentrada to set
     */
    public void setDataentrada(String dataentrada) {
        this.dataentrada = dataentrada;
    }

    /**
     * @return the datasaida
     */
    public String getDatasaida() {
        return datasaida;
    }

    /**
     * @param datasaida the datasaida to set
     */
    public void setDatasaida(String datasaida) {
        this.datasaida = datasaida;
    }

    /**
     * @return the aiaiai
     */
}
