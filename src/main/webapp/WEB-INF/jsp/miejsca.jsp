<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<title>Miejsca</title>
	</head>
	<body>
	
			<section>
				<div class="jumbotron" ng-app="MiejsceApp">
					<div class="container" ng-controller="MiejsceCtrl">
					
				
				<div class="row" style="text-align:center">
							
						<h2 style="text-shadow:0 0 6px #FFFFCC"><font face="Verdana"><spring:message code="miejsca.wybierzMiejsce" /></h2>
	
							
						<div class="col-md-2 col-md-offset-2" style="padding-bottom: 25px">
							<div class="btn-group">
								
								
									<div class="col-md-0.66">
										 <c:forEach items="${miejsca1}" var="miejsce">
											<c:if test="${miejsce.dostepnosc == 'wolne'}">
											      
											     <a href="javascript:location.reload()" class="btn btn-success" role="button" ng-click="dodaj('${miejsce.rzad}', '${miejsce.miejsce}')" >${miejsce.rzad}${miejsce.miejsce}</a>
												 
											</c:if>
											
											<c:if test="${miejsce.dostepnosc == 'zajęte'}">
											       <a class="btn btn-danger disabled" role="button">${miejsce.rzad}${miejsce.miejsce}</a>	
											</c:if>
											
											<c:if test="${miejsce.dostepnosc == 'chwilowoZajęte'}">
											       <a class="btn btn-warning disabled" role="button">${miejsce.rzad}${miejsce.miejsce}</a>	
											</c:if>
										</c:forEach> 
									</div>
							</div>
						</div>
						<div class="col-md-3 col-md-offset-0.4" style="padding-bottom: 25px">
							<div class="btn-group">
								
									<div class="col-md-0.5">
										 <c:forEach items="${miejsca2}" var="miejsce">
											<c:if test="${miejsce.dostepnosc == 'wolne'}">
											      
											     <a href="javascript:location.reload()" class="btn btn-success" role="button" ng-click="dodaj('${miejsce.rzad}', '${miejsce.miejsce}')">${miejsce.rzad}${miejsce.miejsce}</a>
												  
											</c:if>
											
											<c:if test="${miejsce.dostepnosc == 'zajęte'}">
											       <a class="btn btn-danger disabled" role="button">${miejsce.rzad}${miejsce.miejsce}</a>	
											</c:if>
											
											<c:if test="${miejsce.dostepnosc == 'chwilowoZajęte'}">
											       <a class="btn btn-warning disabled" role="button">${miejsce.rzad}${miejsce.miejsce}</a>	
											</c:if>
										</c:forEach> 
									</div>
							</div>
						</div>
						<div class="col-md-3 col-md-offset-0.5" style="padding-bottom: 25px">
							<div class="btn-group">
								
									<div class="col-md-0.83">
										 <c:forEach items="${miejsca3}" var="miejsce">
											<c:if test="${miejsce.dostepnosc == 'wolne'}">
											      
											     <a href="javascript:location.reload()" class="btn btn-success" role="button" ng-click="dodaj('${miejsce.rzad}', '${miejsce.miejsce}')" >${miejsce.rzad}${miejsce.miejsce}</a>
												  
											</c:if>
											
											<c:if test="${miejsce.dostepnosc == 'zajęte'}">
											       <a class="btn btn-danger disabled" role="button">${miejsce.rzad}${miejsce.miejsce}</a>	
											</c:if>
											
											<c:if test="${miejsce.dostepnosc == 'chwilowoZajęte'}">
											       <a class="btn btn-warning disabled" role="button">${miejsce.rzad}${miejsce.miejsce}</a>	
											</c:if>
										</c:forEach> 
										
								</div>
							</div>
						</div>
					</div>
					 <div class="col-md-4 col-md-offset-0.5"></div>
						 <a href="javascript:location.reload()" class="btn btn-default" role="button" ng-click="cofnij()" ><spring:message code="miejsca.cofnij" /></a>
						 <a href="<spring:url value="/koszyk/index" />" class="btn btn-danger" role="button">
						 	<span class="glyphicon-shopping-cart glyphicon"></span>
						 	<spring:message code="miejsca.przejdzDoKoszyka" />
						 </a>
					 	</div> 
				</div>
			</div>
			
		</section>
			 <section class="container">
					<div class="row">
					<div class="col-md-9 col-md-offset-1" style="padding-bottom: 15px">
						
								<div class="thumbnail" style="width:100%" style="text-align:center">
									
										<div class="embed-responsive embed-responsive-16by9">
											<video width="835" heihgt="800" controls>
										  	<source src="<c:url value="/resource/movies/${seans.film.nazwa}.mp4"></c:url>" type="video/mp4">
											<source src="<c:url value="/resource/movies/${seans.film.nazwa}.ogg"></c:url>" type="video/ogg">
										</video>
										</div>
									<div class="caption" style="text-align:center">
										<h2>${seans.film.nazwa}</h2>
										<h3>${seans.dzien}: ${seans.godzina}</h3>
										<h3>${seans.typ} ${seans.napisy} ${seans.jezyk}</h3>
					
									</div>
								</div>
						
					</div>
				</div>
				
			</section>
			
		
		
		
			<script>
				var app = angular.module('MiejsceApp', []);
				app.controller('MiejsceCtrl', function ($scope, $http){
					
					$scope.dodaj = function(rzad, miejsce){
						
						var data = {
									miejsce: miejsce,
							        rzad: rzad
							    };
						
						$http.post('http://localhost:8080/kino/miejsce/rest/dodaj',JSON.stringify(data));
					}
					
					$scope.cofnij = function(){	
						
						$http.post('http://localhost:8080/kino/miejsce/rest/cofnij');
						}
				});
			</script>	
	</body>
</html>