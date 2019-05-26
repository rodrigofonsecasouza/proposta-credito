app.service("Service",function($http, ENDPOINT){

	this.findAllPropostas = function(){
		return $http.get(ENDPOINT.PROPOSTAS).then(function(response) {
			return response.data;
		}, function(e) {
			console.error("FindAll propostas error", e);
			return e;
		});
	}
	
	this.save = function(proposta){
		return $http.post(ENDPOINT.PROPOSTAS, proposta).then(function(response) {
			return response.data;
		}, function(e) {
			console.error("Save propostas error", e);
			return e;
		});
	}
	
	this.findByCpf = function(cpf){
		return $http.get(ENDPOINT.PROPOSTAS + "/" + cpf).then(function(response) {
			return response.data;
		}, function(e) {
			console.error("FindByCpf error", e);
			return e;
		});
	}
	
	this.analisarProposta = function(proposta){
		return $http.put(ENDPOINT.ANALISE + "/" + proposta.id, proposta).then(function(response) {
			return response.data;
		}, function(e) {
			console.error("AnalisarProposta error", e);
			return e;
		});
	}
});