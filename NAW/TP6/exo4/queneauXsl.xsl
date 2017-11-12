<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
 <xsl:output method="html" encoding="ISO-8859-1" doctype-public="-//W3C//DTD HTML 4.01//EN" doctype-system="http://www.w3.org/TR/html4/strict.dtd" indent="yes" />



<xsl:template match="noeuds">
	<html>
		<head>
			<title>Queneau</title>
			<center><h1>Queneau</h1></center>
		</head>
		<body ><xsl:apply-templates/></body>
	</html>
</xsl:template> 



<xsl:template match="noeud">
	<font color= "black"><strong><p><xsl:value-of select="texte"/></p></strong></font >
		<a>
			<xsl:attribute name="id"> <xsl:value-of select="@numero"/> </xsl:attribute>
		</a>
		<a > 
			<xsl:attribute name="href"> <xsl:value-of select="@numero"/>  <xsl:apply-templates/> </xsl:attribute>
		</a>
</xsl:template> 




<xsl:template match="@*|text()"></xsl:template>


</xsl:stylesheet>
