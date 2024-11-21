package com.prototipo.leitorarquivo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.leitorarquivo.model.Produto;
import com.prototipo.leitorarquivo.model.Usuario;
import com.prototipo.leitorarquivo.service.LeitorArquivoService;
import com.prototipo.leitorarquivo.util.Utils;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final LeitorArquivoService leitorArquivoService;

    public ApiController(LeitorArquivoService leitorArquivoService){
        this.leitorArquivoService = leitorArquivoService;
    }
    
    @GetMapping("/csv")
    public ResponseEntity<List<Usuario>> readCsv(){
        List<Usuario> leitorCsv = leitorArquivoService.leitorCsv(Utils.FILE_CSV);
        return ResponseEntity.ok().body(leitorCsv);
    }

    @GetMapping("/json")
    public ResponseEntity<List<Usuario>> readJson(){
        List<Usuario> leitorJSON = leitorArquivoService.leitorJSON(Utils.FILE_JSON);
        return ResponseEntity.ok().body(leitorJSON);
    }

    @GetMapping("/txt")
    public ResponseEntity<List<Produto>> readTxt(){
        List<Produto> leitorTxt = leitorArquivoService.leitorTxt(Utils.FILE_TXT);
        return ResponseEntity.ok().body(leitorTxt);
    }

    @GetMapping("/xml")
    public ResponseEntity<Produto> readXML(){
        Produto leitorXML = leitorArquivoService.leitorXML(Utils.FILE_XML);
        return ResponseEntity.ok().body(leitorXML);
    }
}
