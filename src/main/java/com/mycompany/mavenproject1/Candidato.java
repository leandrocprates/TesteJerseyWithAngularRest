/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PW
 */


@XmlRootElement
public class Candidato {
    
    private int id ; 
    private String nome;
    private String idade; 
    private String data_cad;
    
    private dados_candidato dados_candidato = new dados_candidato() ; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getData_cad() {
        return data_cad;
    }

    public void setData_cad(String data_cad) {
        this.data_cad = data_cad;
    }

    public dados_candidato getDados_candidato() {
        return dados_candidato;
    }

    public void setDados_candidato(dados_candidato dados_candidato) {
        this.dados_candidato = dados_candidato;
    }
    
}
