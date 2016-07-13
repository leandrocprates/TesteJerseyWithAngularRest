/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceangulajs.service;

import com.mycompany.mavenproject1.Candidato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * REST Web Service
 *
 * @author PW
 */
@Path("/cadastro")
public class GenericResource {
    
        @GET
	@Path("/teste")
	public String getMsg(@PathParam("param") String cep) {
            return "teste"; 
        }

        @POST
        @Path("/addcandidato")
        @Consumes(MediaType.APPLICATION_JSON)
        public void addEndereco(Candidato  candidato){
            
            System.out.println("ID: "+  candidato.getId()  );
            System.out.println("nome: "+  candidato.getNome()  );
            System.out.println("idade: "+  candidato.getIdade()  );
            System.out.println("data cadastro: "+  candidato.getData_cad()  );

            Integer risultato=-1;
            try{
                
                Class.forName("com.mysql.jdbc.Driver").newInstance ();
                String url = "jdbc:mysql://localhost/teste_peopleway";
                Connection con = DriverManager.getConnection(url, "root","root");
                
                String sql = "insert into candidato (nome,idade,data_cad) values   " + 
                " ( '" + candidato.getNome()+ "'," + candidato.getIdade() + ", '" + candidato.getData_cad()+ "' ) " ; 
                
                Statement st = con.createStatement() ; 
                st.execute(sql);
                
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    risultato=rs.getInt(1);
                }
                rs.close();
                String sql2 = " insert into dados_candidato(id_candidato,endereco,pretensao_salario,telefone_fixo,telefone_celular,email  ) " + 
                        " values ( " +risultato + " , '" + candidato.getDados_candidato().getEndereco()+ "',"
                        + candidato.getDados_candidato().getPretensao_salarial()+ ","
                        + candidato.getDados_candidato().getTelefone_fixo()+ ","
                        + candidato.getDados_candidato().getTelefone_celular()+ ","
                        + " 'vazio' "
                        +  ")  " ;  
                
                Statement st2 = con.createStatement() ; 
                st2.execute(sql2);

                st.close();
                st2.close();
                con.close();
                
            }catch(Exception ex){
                System.err.println("Error ao inserir registro : " + ex);
            }
            
        }   

        @GET
	@Path("/buscacadastro")
        @Produces(MediaType.APPLICATION_JSON)
	public Response buscacadastro() {
            
            List<Candidato> listaCandidato = new ArrayList<Candidato>();
            
            try{
                
                Class.forName("com.mysql.jdbc.Driver").newInstance ();
                String url = "jdbc:mysql://localhost/teste_peopleway";
                Connection con = DriverManager.getConnection(url, "root","root");
                
                Statement st = con.createStatement() ;
                
                ResultSet rs = st.executeQuery( " select *from candidato  ,dados_candidato\n" +
                                                "\n" +
                                                "\n" +
                                                "where candidato.id =dados_candidato.id_candidato ;    "  ) ; 
                
                SimpleDateFormat  sdf = new SimpleDateFormat( "yyyy-MM-dd");
                 
                
                while ( rs.next() ){
                    
                    Candidato candidato = new Candidato(); 

                    candidato.setId( rs.getInt("id") );
                    candidato.setNome( rs.getString("nome")   );
                    candidato.setIdade( String.valueOf( rs.getInt("idade") ) );
                    candidato.setData_cad( sdf.format( rs.getDate("data_cad") ) );
                    
                    candidato.getDados_candidato().setEndereco( rs.getString("endereco") );
                    candidato.getDados_candidato().setPretensao_salarial( rs.getInt("pretensao_salario") );
                    candidato.getDados_candidato().setTelefone_fixo(  String.valueOf( rs.getInt( "telefone_fixo" ) ) );
                    candidato.getDados_candidato().setTelefone_celular(String.valueOf( rs.getInt( "telefone_celular" ) ) );
                    
                    listaCandidato.add(candidato);
                    
                }
                
                return Response.ok().entity(listaCandidato).build(); 
                
            }catch(Exception ex){
                System.err.println("Error ao buscar registro : " + ex);
            }
            
            return null;
            
        }

}
