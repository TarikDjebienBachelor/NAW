<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:output method="html"></xsl:output>


<xsl:template match="//enquete">
<html>
	<head>
		<title>les premiers</title>
		<script language="javascript"  type="text/javascript">
		<xsl:variable name="nb" select="count(//indicateur)"></xsl:variable>
		idMax = <xsl:value-of select="$nb"></xsl:value-of>;
		symbol = new Array(idMax); 
		i=0; 
		<!-- symbole[i] est un tableau a 3 (count(//indicateur)) cases contenant {triangle, carre, rond}-->
		<xsl:for-each select="//indicateur">
		    symbol[i] = "<xsl:value-of select="@idindic"></xsl:value-of>";
		    i++; 
		</xsl:for-each>       
		
		 
		<!-- diag() cree des variables tag avec les valeurs {triangle|carre|rond} et des variables diag avec le texte diagnostic correspondant, regarde si la valeur maxtag en parametre correspond a l'une des valeurs triangle, carre ou rond et modifie mes element d'id = r par le texte correspondant-->
		function diag(maxtag){    
			<xsl:for-each select="//indicateur">
				<xsl:variable name="tag">
					<xsl:value-of select="@idindic"></xsl:value-of>
				</xsl:variable>
				<xsl:variable name="diag">
					<xsl:value-of select="./text()"></xsl:value-of>
				</xsl:variable>
				if (maxtag=="<xsl:value-of select="$tag"></xsl:value-of>") {
					 document.getElementById("r").innerHTML=  "<xsl:value-of select="$diag"></xsl:value-of>" ;
				 } 
			</xsl:for-each> 
		} 

		<!-- methode qui effectue le diagnostic apres validation-->
		function giveDiagnostic(){ 
			 var liste =document.getElementsByTagName("option") ;<!-- ERREUR ICI RENVOIT 0, APRES CF DIAPO 53-->
			alert(liste.length);
		}
		
		</script>	
		
		
	</head>
	<body>
		<xsl:apply-templates select="intro"/>
		<xsl:apply-templates select="question"/>
	</body> 
	<div id="r"></div>
	<input type="submit" value="Valider le questionnaire" onclick="giveDiagnostic()"></input>
	

	
	
	
	
</html>
</xsl:template>





	<xsl:template match="intro">
		<u><center><h2 style="color:#ff8800;"><xsl:value-of select="titre"></xsl:value-of></h2></center></u> 
		<center><h3 style="color:#0000FF;"><xsl:value-of select="presentation"></xsl:value-of></h3></center>
	</xsl:template>



	<xsl:template match="question">
		<u><h4 style="color:#191970;"><xsl:value-of select="libelle"></xsl:value-of></h4></u> 
		<xsl:apply-templates select="option"/>	
	</xsl:template>

	<xsl:template match="option">
		<p><input type="checkbox"> <xsl:value-of select="."></xsl:value-of></input></p>
	</xsl:template>

















<xsl:template match="text()|@*"></xsl:template>


</xsl:stylesheet>
