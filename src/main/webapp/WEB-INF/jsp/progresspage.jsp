<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>

<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>YukAMU-contrib</title>

<link href="/css/bootstrap.min.css" rel="stylesheet" />
<link href="/css/shop-homepage.css" rel="stylesheet" />
<link href="/css/animate.css" rel="stylesheet" />
<link href="/css/all.min.css" rel="stylesheet" />

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/">YukAMU-contrib</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<ul class="navbar-nav">
			    <li class="nav-item">
			      <a class="nav-link" href="${pageContext.request.contextPath}/"> <i class="fas fa-home"></i> Home</a>
			    </li>
			 </ul>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a href="${pageContext.request.contextPath}/shutdown" class="btn btn-danger" >Quit</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
	
		
	
		<div class="row">
			<div class="col-12">
				<form id="tagselectform" action="${pageContext.request.contextPath}/progress" method="GET">
					<div class="form-group">
						<label for="tagselect">Filter by Food Type:</label> 
						<select	class="form-control" id="tagselect" name="SelectedTag" onchange="this.form.submit()">
							<option>Filter by tag</option>
							<option>ALL</option>
							<option>NONE</option> 
							<option>EXCELLENT</option> 
							<option>GOOD</option> 
							<option>MEDIOCRE</option> 
							<option>BAD</option> 
						</select>
					</div>
				</form>
			</div>
		</div>
		

		<div class="row">

			<div class="col">
				<div class="row"><h2>TODO LIST</h2></div>
				<div class="row">
					
					<c:forEach items="${ TODOFoods }" var="food">
						<div class="card bg-warning col-4" id="${ food.id }">
							<h4 class="card-title">	<c:out value="${ food.name }" /> </h4>
							<p class="card-text"> <c:out value="${ food.tag }" /> </p>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<div class="col">
				<div class="row"><h2>DONE LIST</h2></div>
				<div class="row">
					<c:forEach items="${ DONEFoods }" var="food">
						<div class="card bg-success col-4" id="${ food.id }">
							<h4 class="card-title"> <c:out value="${ food.name }" /> </h4>
							<p class="card-text"> <c:out value="${ food.tag }" /> </p>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<!-- /.row -->

		
	</div>
	<!-- /.container -->

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>	
<script src="/js/all.min.js"></script>

</body>

</html>
