var app = angular.module('KoszykApp', []);
app.controller('KoszykCtrl', function ($scope, $http){
	
	$scope.clearKoszykItem = function(id){
		
		var data = {
			        id: id
			    };
		
		var successCallBack = function(response){
				 $scope.seans = response.data;
			    };
	
	    var errorCallBack = function(response){
	    		$scope.seans = response.status;
			    };
			      
			  $http.post('http://localhost:8080/kino/koszyk/index/deleteItem',JSON.stringify(data)).then(successCallBack, errorCallBack);
	}
	
	
	
	$scope.init = function(koszyk){
		$scope.koszyk = koszyk;
		$scope.seans = 1;
	}
	
	
	
	$scope.clearKoszyk = function(){
	
		$scope.seans = 1;
		
		var successCallBack = function(response){
			 $scope.seans = response.data;
		    };

   var errorCallBack = function(response){
   		$scope.seans = response.status;
		    };
		      
		  $http.post('http://localhost:8080/kino/koszyk/index/delete').then(successCallBack, errorCallBack);
	
	}
});