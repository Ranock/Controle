angular.module("controleDeCustos").controller("lancamentosController", function($scope, $http){
		$scope.lancamentos = [];

		$scope.lancamentosDebitos = [{}];
		$scope.lancamentosCreditos = [{}];
		$scope.selecionado = true;
		$scope.valorDebito = 0;
		$scope.valorCredito = 0;

		var carregarLancamentos = function(){
			$http.get("http://localhost:8080/usuario/1/lancamentos?dataInicial=01/01/2015&dataFinal=12/12/2018").then(function(data, status){
					$scope.lancamentos = data.data;
					$scope.valorDebito  =	calcular($scope.lancamentosDebitos);
					$scope.valorCredito =	calcular($scope.lancamentosCreditos);
					$scope.valorTotal=	calcular($scope.lancamentos);
					$scope.lancamentosDebitos = $scope.lancamentos.filter(function(debito){
						if(debito.valorLancamento < 0) return debito;
					});
					$scope.lancamentosCreditos = $scope.lancamentos.filter(function(credito){
						if(credito.valorLancamento > 0) return credito;
					});

			});	
		}

		carregarLancamentos();

	
		$scope.modificarVisualizacao = function(selecionado){
			$scope.selecionado = !selecionado;
		}
	

 		function calcular(lancamentos){
			var valorTotal = 0;
			for(lancamento in lancamentos){
				if(lancamentos.hasOwnProperty(lancamento)){
					valorTotal += lancamentos[lancamento].valorLancamento ;
				}
			}
			return valorTotal
		}


})