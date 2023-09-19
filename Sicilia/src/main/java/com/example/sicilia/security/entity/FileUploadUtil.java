package com.example.sicilia.security.entity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
 
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;
 
public class FileUploadUtil {
	
    public static String saveFile(String fileName, MultipartFile multipartFile)
            throws IOException {
        
    	 /*
         * public static- String saveFile(String fileName, MultipartFile multipartFile) 
         * throws IOException { 
         * Questo è il metodo saveFile che viene chiamato dalla funzione uploadFile che 
         * hai mostrato in precedenza. Prende due parametri: fileName, che rappresenta 
         * il nome del file, e multipartFile, che è il file caricato in memoria.
         */
    	
    	Path uploadPath = Paths.get("src/main/resources/upload");
    	 /* Path uploadPath = Paths.get("src/main/resources/upload");
         * Qui viene creato un oggetto Path chiamato uploadPath che rappresenta il percorso 
         * in cui verrà salvato il file. Nel tuo caso, sembra essere una cartella denominata 
         * "upload" all'interno delle risorse del tuo progetto Spring Boot.
         */
    	
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
            
        /* if (!Files.exists(uploadPath)) { Files.createDirectories(uploadPath); } 
         * Queste righe di codice verificano se la cartella uploadPath esiste già. 
         * Se non esiste, viene creata utilizzando Files.createDirectories.
         */
                 
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        /* String fileCode = RandomStringUtils.randomAlphanumeric(8); 
         * Qui viene generato un codice casuale di 8 caratteri che verrà utilizzato come 
         * parte del nome del file. È possibile che questo codice venga utilizzato per 
         * rendere univoci i nomi dei file.
         */
        
        
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {       
            throw new IOException("Could not save file: " + fileName, ioe);
        }
        
        /* try (InputStream inputStream = multipartFile.getInputStream()) {
         * Inizia un blocco try che gestisce il flusso di input dal multipartFile. Questo è 
         * il punto in cui il file caricato viene letto come un flusso di byte.
         * Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
         * Qui viene creato un oggetto Path chiamato filePath che rappresenta il percorso 
         * completo del file in cui verrà salvato. Il nome del file con il codice casuale 
         * viene concatenato al fileName originale.
         * Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
         * Questa riga di codice copia il flusso di input (inputStream) nel percorso filePath. 
         * Se il file esiste già, viene sovrascritto (grazie all'opzione StandardCopyOption.REPLACE_EXISTING).
         * } catch (IOException ioe) { throw new IOException("Could not save file: " + fileName, ioe); }
         * Questo blocco catch cattura eventuali eccezioni di tipo IOException che possono 
         * verificarsi durante l'operazione di copia del file e le rilancia come un'eccezione 
         * con un messaggio specifico.
         */
        
        return fileCode;
        
        /*
         * return fileCode;
         *  Alla fine, il metodo restituisce il fileCode, che potrebbe essere utilizzato come 
         *  identificatore univoco per il file appena salvato.
         * 
         * */
    }
}