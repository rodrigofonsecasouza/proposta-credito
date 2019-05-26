var app = angular.module('myApp', [ 'ngRoute']);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/propostas', {
		templateUrl : 'templates/propostas.html',
		controller : 'PropostaCtrl',
		controllerAs : 'vm'
	});
	$routeProvider.when('/cadastroProposta', {
		templateUrl : 'templates/cadastro-proposta.html',
		controller : 'PropostaCtrl'
	});
	$routeProvider.when('/', {
		templateUrl : 'templates/home.html',
		controller: 'IndexCtrl'
	});
	
	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
;