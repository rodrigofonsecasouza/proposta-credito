app.controller('PropostaCtrl', PropostaCtrl);
PropostaCtrl.$inject = [ '$scope', '$location', 'Service' ];

function PropostaCtrl($scope, $location, Service) {
	var vm = this;
	$scope.propostas = []
	$scope.proposta = {};
	$scope.cpf;

	$scope.listar = function() {
		Service.findAllPropostas().then(function(data) {
			$scope.propostas = data;
		});
	}

	$scope.salvar = function() {
		Service.save($scope.proposta).then(function(data) {
			$location.path('/propostas');
		});
	}

	$scope.findByCpf = function() {
		if ($scope.cpf) {
			Service.findByCpf($scope.cpf).then(function(data) {
				$scope.propostas = data;
			});
		} else {
			$scope.listar();
		}
	}

	$scope.analisarProposta = function(proposta) {
		Service.analisarProposta(proposta).then(function(data) {
			$scope.listar();
		});
	}
	$scope.listar();
}
