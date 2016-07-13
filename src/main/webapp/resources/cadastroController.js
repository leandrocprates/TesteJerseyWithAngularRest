



var myAppModule = angular.module('mainApp', ['ngSanitize']);

myAppModule.controller("cadastroController", function ($scope,$http,$sce)
{
    function candidato(){
        id=null;
        nome=null;
        idade=null;
        data_cad=null;
        
        dados_candidato = new dados_candidato();
    };
    
    function dados_candidato(){
        id=null;
        id_candidato=null;
        endereco=null;
        pretensao_salarial=null;
        telefone_fixo=null;
        telefone_celular=null;
        
    };
    
    $scope.candidato = new candidato();
  
    $scope.inserircandidato = function(){
        
        var url='http://localhost:8084/mavenproject1/rest/cadastro/addcandidato' ;

        $http.post(url,$scope.candidato)
                .success(function (data){
                    console.log('candidato adicionado com sucesso.');
                })
                .error(function (data){
                    console.log('Erro ao adicionar candidato.');
                });
    }
    
    
    $scope.buscarCadastro = function(){
        
        var url = 'http://localhost:8084/mavenproject1/rest/cadastro/buscacadastro' ;
        
        $http.get(url)
                .success(function(data){
                    console.log('Retornando dados de candidato do servidor');
                    $scope.listaCandidatos = data.length > 1 ? data : new Array(data) ;
                })
                .error(function(data){
                    console.log('Erro ao buscar dados de candidatos');
                    
                })

    }
    
    init = function(){
        $scope.buscarCadastro();
    }
    
    
    init();
    
    
});