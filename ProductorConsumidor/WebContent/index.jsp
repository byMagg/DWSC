<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'>
<meta name='Author' content='Luis Iribarne'>
<meta name='Description' content='University of Almeria (Spain)'>
<title>Prototipo HTML para el Productor-Consumidor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body style='color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);'
	alink='#990000' link='#043a66' vlink='#999900'>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a href="http://localhost:8000" class="navbar-brand"> <i
				class="fas fa-home"></i> Inicio
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="/ProductorConsumidor">Administrador</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8001">Gestor</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1>Añadir Noticias</h1>

		<form action="http://localhost:8080/ProductorConsumidor/servlet"
			method="post">
			<div class="mb-3">
				<label for="nivelInteres" class="form-label">Nivel de
					Interés:</label> <select class="form-select" name="nivelInteres"
					id="nivelInteres">
					<option value="Alta">Alta</option>
					<option value="Media">Media</option>
					<option value="Baja">Baja</option>
				</select>
			</div>

			<div class="mb-3">
				<label for="descripcionCorta" class="form-label">Descripción
					Corta:</label>
				<textarea class="form-control" name="descripcionCorta"
					id="descripcionCorta" rows="2"></textarea>
			</div>

			<div class="mb-3">
				<label for="descripcionLarga" class="form-label">Descripción
					Larga:</label>
				<textarea class="form-control" name="descripcionLarga"
					id="descripcionLarga" rows="10"></textarea>
			</div>

			<input value='Enviar' class="btn btn-primary"
				alt='Press button to export' type='submit' name='action'>
		</form>
	</div>

</body>
</html>