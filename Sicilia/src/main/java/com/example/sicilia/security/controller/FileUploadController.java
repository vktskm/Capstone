package com.example.sicilia.security.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.sicilia.security.entity.FileUploadResponse;
import com.example.sicilia.security.entity.FileUploadUtil;

 
@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins = "*")
public class FileUploadController {
    
    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
                   throws IOException {
        
    	 /* public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") 
         * MultipartFile multipartFile) throws IOException: 
         * Questo è il metodo effettivo che gestisce la richiesta. Prende un parametro 
         * multipartFile che rappresenta il file inviato come parte della richiesta. 
         * Il @RequestParam("file") indica che il file viene inviato come parametro 
         * denominato "file" nella richiesta HTTP.
         **/
    	
    	
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
        /*
         * String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
         * Qui, viene estratto il nome del file originale del multipartFile. 
         * StringUtils.cleanPath viene utilizzato per assicurarsi che il nome del file non 
         * contenga caratteri non validi o pericolosi.
         * long size = multipartFile.getSize();
         * Questa riga calcola la dimensione del file in byte.
         */ 
        
        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
        /* String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
         * Questo passo chiama un metodo esterno FileUploadUtil.saveFile per salvare il file 
         * sul server. Il nome del file e il contenuto del file vengono passati a questo metodo, 
         * che dovrebbe gestire il salvataggio fisico del file e restituire un "filecode" o un 
         * identificatore univoco per il file appena salvato.
         */
        
        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);
         
        return new ResponseEntity<>(response, HttpStatus.OK);
       
        /* FileUploadResponse response = new FileUploadResponse();
         * Viene creata un'istanza di FileUploadResponse, che sembra essere una classe 
         * utilizzata per rappresentare la risposta.
         * response.setFileName(fileName);: Imposta il nome del file nella risposta.
         * response.setSize(size);: Imposta la dimensione del file nella risposta.
         * response.setDownloadUri("/downloadFile/" + filecode);
         * Imposta l'URI da cui il file può essere scaricato nella risposta. L'URI sembra 
         * includere il "filecode" generato precedentemente.
         * return new ResponseEntity<>(response, HttpStatus.OK);
         * Infine, viene restituita una ResponseEntity che contiene l'oggetto FileUploadResponse
         * creato in precedenza. La ResponseEntity indica anche che la richiesta è stata gestita 
         * con successo con uno stato HTTP OK (codice di stato 200).*/
        
    }
    
}

