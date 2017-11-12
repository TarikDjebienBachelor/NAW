<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="xml" />




<xsl:template match="videotheque">
	<videotheque1> 
		<xsl:apply-templates/>
	</videotheque1> 
</xsl:template> 


<xsl:template match="film">
		<film>
			<xsl:attribute name="titre"> <xsl:value-of select="titre"/> </xsl:attribute >
			<xsl:attribute name="categorie"> <xsl:value-of select="../@nom"/> </xsl:attribute >
		</film>
</xsl:template>


<xsl:template match="@*|text()"></xsl:template>


</xsl:stylesheet>
