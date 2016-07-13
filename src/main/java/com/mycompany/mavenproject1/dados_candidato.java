/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class dados_candidato {
    private int id ; 
    private int id_candidato ; 
    private String endereco ; 
    private int pretensao_salarial;
    private String telefone_fixo;
    private String telefone_celular;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPretensao_salarial() {
        return pretensao_salarial;
    }

    public void setPretensao_salarial(int pretensao_salarial) {
        this.pretensao_salarial = pretensao_salarial;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getTelefone_celular() {
        return telefone_celular;
    }

    public void setTelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }
    
}



