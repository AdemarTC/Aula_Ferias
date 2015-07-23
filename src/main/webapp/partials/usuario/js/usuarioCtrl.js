/**
 * 
 */
(function() {

	'use strict';

	angular.module('aulaFerias')
	.controller('UsuarioCtrl', ['$scope', 'UsuarioFactory', function($scope, UsuarioFactory){

		$scope.cadastrar = function () {
			
			UsuarioFactory.cadastrar($scope.usuario).then(function(data) {
				
				if(data){
					
					alert("Cadastrado com sucesso!");
					$scope.usuario = '';
					carregarTodos();
				}
				
			})
			
		}
		
		carregarTodos();
		function carregarTodos() {
			
			UsuarioFactory.buscarTodos().then(function(dados) {
				
				var dadosCopy = angular.copy(dados);
				
				$scope.usuarios = dadosCopy;
				
				console.log(dadosCopy);
				
			})
			
		}
		
		UsuarioFactory.buscarTodos().then(function(dados) {
		
			var dadosCopy = angular.copy(dados);
			
			$scope.usuarios = dadosCopy;
			
			console.log(dadosCopy);
			
		})
		
		/////////////////////////////////////////////////
		
		$scope.excluir = function (sequencial) {
			
			UsuarioFactory.excluir(sequencial).then(function(data) {
				
				if(data){
					
					alert("Excluido com sucesso!");
					carregarTodos();
				}
				
			})
			
		}
		
		//////////////////////////////////////////////////////////
		
		$scope.buscarUsuarioPorSequencial = function(sequencial) {
			
			UsuarioFactory.buscarUsuarioPorSequencial(sequencial).then(function(data) {
			
				var dadosCopy = angular.copy(data);
				
				$scope.usuario = dadosCopy;
				carregarTodos();
				
			})
			
			
		}
		
		$scope.atualizar = function(usuario) {
			
			UsuarioFactory.atualizar(usuario).then(function(data) {
				
				if(data){
					
					alert("Atualizado com sucesso!");
					$scope.usuario = '';
					carregarTodos();
					
				}else{
					
					
					
				}
				
			})
			
			
		}
		
		$scope.voltar = function () {
			
			$scope.usuario ='';
			
		}
		
		$scope.dinheiro = 12;
		

	}]);



}())