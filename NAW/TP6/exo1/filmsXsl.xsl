<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
 <xsl:output method="html" encoding="ISO-8859-1" doctype-public="-//W3C//DTD HTML 4.01//EN" doctype-system="http://www.w3.org/TR/html4/strict.dtd" indent="yes" />




<xsl:template match="videotheque">
	<html>
		<head>
			<title>les films</title>
		</head>
		<body><xsl:apply-templates/></body>
	</html>
</xsl:template> 


<xsl:template match="categorie[@nom= 'Comédie'] ">
	<h2>Comédie</h2>
	<ul>
		<xsl:apply-templates/>
	</ul>
</xsl:template>


<xsl:template match="categorie[@nom= 'Comédie']/film">
	<li><xsl:value-of select="titre"/> </li>
</xsl:template>

<xsl:template match="@*|text()"></xsl:template>


</xsl:stylesheet>
