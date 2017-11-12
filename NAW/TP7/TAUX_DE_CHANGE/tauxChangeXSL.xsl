<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="html" encoding="ISO-8859-1" doctype-public="-//W3C//DTD HTML 4.01//EN" doctype-system="http://www.w3.org/TR/html4/strict.dtd" indent="yes"/>
	
	<xsl:template match="/tauxChangeEuro">
		<html>
			<head>
				<title>TAUX DE CHANGE</title>
				<center>
					<h1>TAUX DE CHANGE</h1>
				</center>
			</head>
			<body>
				<select id="mesValeurs" onchange="calculChange()">
					<xsl:apply-templates select="device"/>
				</select>
				<input type="text" id="valeurRentree" onchange="calculChange()" />
				<div id="resultat"></div>
				
				<script language="javascript">
				   <![CDATA[ 
				   var msg ="Conversion="; 
				   function calculChange(){ 
						var valeurInput = document.getElementById('valeurRentree').value;
						var cbbx = document.getElementById('mesValeurs').value;
						msg = msg + valeurInput * cbbx;
						document.getElementById("resultat").innerHTML = msg;
						msg="";
					}
				   ]]>
				</script>
						
				
			</body>
		</html>
	</xsl:template>
	
	
	
	<xsl:template match="device">
		<option >
			<xsl:attribute name="value"><xsl:value-of select="@valeur"></xsl:value-of></xsl:attribute>
			<xsl:value-of select="@nom"/>
		</option>	
	</xsl:template>
	
	
	
</xsl:stylesheet>
