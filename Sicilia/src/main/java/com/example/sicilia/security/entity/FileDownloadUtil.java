package com.example.sicilia.security.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
 
public class FileDownloadUtil {
    
	private Path foundFile;
     
    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get("src/main/resources/upload");
    
    /*
     * public Resource getFileAsResource(String fileCode) throws IOException { 
     * Questo è un metodo che accetta un fileCode come parametro e restituisce un oggetto 
     * Resource. L'obiettivo di questo metodo sembra essere quello di recuperare un file da
     * l sistema di archiviazione basato su file e restituirlo come un oggetto Resource, che 
     * può essere utilizzato per inviare il contenuto del file come risposta HTTP.
     * Path dirPath = Paths.get("src/main/resources/upload");
     * Qui viene creato un oggetto Path chiamato dirPath che rappresenta il percorso 
     * della directory in cui sono stati salvati i file precedentemente. Nel tuo caso, 
     * sembra essere la cartella "upload" all'interno delle risorse del tuo progetto 
     * Spring Boot.
     */ 
        
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });
        
        /* Files.list(dirPath).forEach(file -> { ... }); 
         * Questa riga di codice utilizza la classe Files per elencare tutti i file nella 
         * directory dirPath. Successivamente, viene iterato su ciascun file utilizzando 
         * un'espressione lambda (fornita all'interno del metodo forEach).
         * if (file.getFileName().toString().startsWith(fileCode)) { ... }: All'interno del 
         * ciclo forEach, questo codice verifica se il nome del file corrente inizia con il 
         * fileCode passato come parametro al metodo. Se trova un file con un nome che inizia 
         * con il fileCode, lo imposta come foundFile e esce dal ciclo.
         */
 
        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }
         
        return null;
    }
    
    /* if (foundFile != null) { return new UrlResource(foundFile.toUri()); }
     * Dopo il ciclo forEach, il codice verifica se è stato trovato un file che 
     * corrisponde al fileCode. Se è stato trovato un file, viene creato un oggetto 
     * UrlResource utilizzando l'URI del file trovato e restituito come risultato. 
     * L'oggetto UrlResource rappresenta una risorsa ottenuta tramite un URL, che può 
     * essere utilizzato per accedere al contenuto del file.
     * 
     * return null; 
     * Se nessun file corrispondente al fileCode è stato trovato, il metodo restituisce null.
     * 
     * 
     * 
     * */
  
}
