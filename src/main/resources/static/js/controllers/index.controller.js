app.controller('IndexCtrl', IndexCtrl);
IndexCtrl.$inject = [ '$scope'];

function IndexCtrl($scope) {
	var vm = this;

	$scope.$parent.title = "Bem vindo ao sistema de cadastro de propostas de crédito";
	$scope.$parent.img = "img/calcard.png";
	$scope.$parent.showTopToggle = false;


}
