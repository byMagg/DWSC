<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'>
<meta name='Author' content='Luis Iribarne'>
<meta name='Description' content='University of Almeria (Spain)'>
<title>Prototipo HTML para el Productor-Consumidor</title>
</head>
<body style='color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);'
	alink='#990000' link='#043a66' vlink='#999900'>
	<dl>
		<table nosave='' border='0' cellspacing='5' width='98%'>
			<tbody>
				<tr nosave='' valign='top'>
					<td nosave='' width='100%'>
						<blockquote></blockquote>
						<center>
							<b> <font face='Arial,Helvetica'> <font
									color='#660000'><font size='+1'> Registrar
											Noticia </font></font></font>
							</b>
						</center> <br>
						<form action='http://localhost:8080/ProductorConsumidor/servlet'
							method='post'>
							<center>
								<font size='-1'>Nivel de Interes:</font></font> <select
									name="nivelInteres">
									<option value="Alta">Alta</option>
									<option value="Media">Media</option>
									<option value="Baja">Baja</option>
								</select>
								<center>
									<font face='Arial,Helvetica'><font size='-1'>Descripcion
											Corta:</font></font>
									<p>
										<textarea name='descripcionCorta' rows='2' cols='50'></textarea>
									</p>
									<center>
										<font face='Arial,Helvetica'><font size='-1'>Descripcion
												Larga:</font></font>

										<p>
											<textarea name='descripcionLarga' rows='10' cols='50'></textarea>
										</p>
										<p>
											<input value='Enviar' alt='Press button to export'
												type='submit' name='action'><input value='Recibir'
												alt='Press button to export' type='submit' name='action'
												disabled><input value='Leer'
												alt='Press button to export' type='submit' name='action'
												disabled> <input value=' Reset ' type='reset'
												name='action'>
										</p>
									</center>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</dl>
</body>
</html>