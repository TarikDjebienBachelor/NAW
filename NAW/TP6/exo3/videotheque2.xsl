<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="xml" />




<xsl:template match="videotheque">
	<videotheque2> 
			<xsl:apply-templates/>
	</videotheque2> 
</xsl:template> 


<xsl:template match="categorie">
		<categorie>
			<nomCat>	
				<xsl:value-of select=" @nom"/>
			</nomCat>
			<xsl:apply-templates/>
		</categorie>
</xsl:template>



<xsl:template match="film">
				<xsl:value-of select=" titre"/>
</xsl:template>



<xsl:template match="@*|text()"></xsl:template>


</xsl:stylesheet>
