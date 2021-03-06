<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="KoszykApp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<script src="resource/js/KoszykController.js"></script>
		<title>Koszyk</title>
	</head>
	<body ng-controller="KoszykCtrl">
		<section>
					<div class="jumbotron">
						<div class="container" style="text-align:center">
							<h1><spring:message code="koszyk.koszyk" /></h1>
							<h3><spring:message code="koszyk.listaSeansow" /></h3>
							
						</div>
					</div>
		</section>
		<section class="container">
				<div>
					<div>
						<a class="btn btn-danger pull-left" ng-click="clearKoszyk()">
							<span class="glyphicon glyphicon-remove-sign">
							</span>
							<spring:message code="koszyk.Wyczysc" />
						</a>
						<a href="/kino/koniec" class="btn btn-success pull-right">
							<span class="glyphicon-shopping-cart glyphicon">
							</span>
							<spring:message code="koszyk.Kupuje" />
						</a>
					</div>
					<table class="table table-hover">
						<tr>
							<th><spring:message code="koszyk.NazwaFilmu" /></th>
							<th><spring:message code="koszyk.Dzien" /></th>
							<th><spring:message code="koszyk.Godzina" /></th>
							<th><spring:message code="koszyk.TypFilmu" /></th>
							<th><spring:message code="koszyk.Miejsce" /></th>
							<th><spring:message code="koszyk.Rzad" /></th>
							<th><spring:message code="koszyk.Cena" /></th>
						</tr>
										
						<c:forEach items="${basket.basketItems}" var="item"> 
							<tr>
								<td>${item.seans.movie.name}</td>
								<td>${item.seans.day}</td>
								<td>${item.seans.hour}</td>
								<td>${item.seans.type} ${item.seans.subtitlesOrLector} ${item.seans.language}</td>							
								<td>${item.position.place}</td>
								<td>${item.position.raw}</td>
								<td >${item.price}</td>
							</tr>
						</c:forEach>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th><spring:message code="koszyk.LacznaCena" /></th>
							<th>${basket.price}</th>
						</tr>
					</table>
					<a  href="javascript: history.back()" class="btn btn-success pull-right">
							<span class="glyphicon-hand-left glyphicon">
							</span>
							<spring:message code="koszyk.Powrot" />		
					</a>
					
				</div>
		</section>
		<script>
		
		
				var app = angular.module('KoszykApp', []);
				app.controller('KoszykCtrl', function ($scope, $http){
					
					$scope.clearKoszyk = function(){
						
						var successCallBack = function(response){
							location.reload();
						    };
		
				   var errorCallBack = function(response){
					   		location.reload()
						    };
						      
						  $http.post('http://localhost:8080/kino/koszyk/delete').then(successCallBack, errorCallBack);
					
					}
					
					
					
				});
		
		
		</script>
	</body>
</html>