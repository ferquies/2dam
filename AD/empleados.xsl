<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match='/'>
		<html><xsl:apply-templates /></html>
	</xsl:template>
	<xsl:template match='listaempleados'>
		<head><title>Listado de empleados</title></head>
		<body>
			<h1>Lista de empleados</h1>
			<table style='border: 1px solid black;'>
				<tr><th>ID</th><th>Apellido</th><th>Departamento</th><th>Salario</th></tr>
				<xsl:apply-templates select='empleado' />
			</table>
		</body>
	</xsl:template>
	<xsl:template match='id|apellido|dep|salario'>
		<td><xsl:apply-templates /></td>
	</xsl:template>
</xsl:stylesheet>
