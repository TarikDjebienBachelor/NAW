<?php 
$xml = simplexml_load_file("moi.xml"); 
echo "Nom:", $xml->nom; 
echo "Prenom:", $xml->prenom;
?>