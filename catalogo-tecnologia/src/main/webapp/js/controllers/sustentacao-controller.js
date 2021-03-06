'use strict';

/* Controllers */
var controllers = angular.module('catalogo.controllers');


controllers.controller('SustentacaoCtrl', function SustentacaoCtrl($scope, $rootScope, $http,$location, $routeParams, AlertService, OrigemDemandaService, ValidationService, DocumentoService) {
	
	$scope.fase = {};
	$scope.fase.id = $routeParams.id;
	$scope.fase.fase = 4;
	$scope.origemDemanda = [];
	
	$scope.documentos = [];	
	
	
	// Obtém os itens para o combo de Origem
	OrigemDemandaService.getItens().then(function(data) {
		$scope.origemDemanda = data;
	});
		

	if ($scope.fase.id) {
		$http.get('api/sustentacao/' + $scope.fase.id).success(function(data) {
			$scope.fase = data;
			$scope.fase.faseAnterior = {
					id: 				data.faseAnterior.id, 
					fase: 				data.faseAnterior.fase, 
					origemReferencia: 	data.faseAnterior.origemReferencia,
					codigoReferencia: 	data.faseAnterior.codigoReferencia
			};
			listarDocumentos();
		}).error( function(data, status) {
			AlertService.addWithTimeout('danger','Não foi possível encontrar o registro');
			history.back();
		});
	} else {
		AlertService.addWithTimeout('danger','Não foi possível encontrar a Sustentação');
		history.back();
	}
		
	$scope.salvar = function(finalizar) {
		var url = 'api/sustentacao';
		if(finalizar) url = url+"/finalizar";
		ValidationService.clear();
		$http({
			url : url,
			method : $scope.fase.id ? "PUT" : "POST",
			data : $scope.fase,
			headers : {
				'Content-Type' : 'application/json;charset=utf8'
			}
		}).success(function(data) {
			if(finalizar){
				AlertService.addWithTimeout('success','Sustentação finalizada com sucesso');
			}else{
				AlertService.addWithTimeout('success','Sustentação salva com sucesso');
			}
			$location.path('/pesquisa/fases/4');
		}).error( function(data, status) {
			console.log(data);
			if (status = 412) {
				ValidationService.registrarViolacoes(data);
			}
		});

	};

	$scope.aprovar = function(aprovado) {
		$scope.fase.situacao = aprovado ? 'Aprovado' : 'Reprovado';
	};
	
	$scope.finalizar = function() {
		$scope.salvar(true);
	};
	
	function listarDocumentos(){
		DocumentoService.getDocumentos($scope.fase.id).then(
		function(data){
			$scope.documentos = data;
		});
	}
	

	
	$scope.adicionarDocumento = function() {
		$scope.documento.fase = {id: $scope.fase.id};		
		DocumentoService.inserir($scope.documento).then(
		function(){
			listarDocumentos();
			$scope.documento = {};
		}, function(reason) {
    		console.log('Failed: ' + reason);
  		}, function(update) {
    		console.log('Got notification: ' + update);
  		});
	};
	
	$scope.removerDocumento = function() {
		
	};

});
