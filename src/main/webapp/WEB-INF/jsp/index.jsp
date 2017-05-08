<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Startowa Strona</title>
	</head>
	<body>
			<section>
				<div class="jumbotron">
					<div class="container" style="text-align:center">
						<h1><spring:message code="index.witaj" /></h1>
					</div>
				</div>
			</section>
			<section class="container">
				<div class="row">
					`
					<c:forEach items="${movies}" var="movie">
					
						<div class="col-md-3" style="padding-bottom: 25px">
							<div class="thumbnail">
								<img src="<c:url value="/resource/images/${movie.name}.jpg"></c:url>" alt="image" style= "width:100%" />
									<div class="caption" style="text-align:center">
										
										<a href="<spring:url value="/${movie.name}" />" class="btn btn-link">
											<h2>${movie.name}</h2>
										</a>
											<p><spring:message code="index.gatunek" /> ${movie.type}</p>
											<p><spring:message code="index.wiekKlienta" /> ${movie.ageOfClient}</p>
											<p><spring:message code="index.ocena" /> ${movie.rating}</p>
											<p><spring:message code="index.czasTrwania" /> ${movie.time}</p>
											
									</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
	</body>
</html>