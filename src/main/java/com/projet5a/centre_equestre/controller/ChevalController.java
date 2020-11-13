package com.projet5a.centre_equestre.controller;

import com.projet5a.centre_equestre.model.Cheval;
import com.projet5a.centre_equestre.repository.ChevalRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class ChevalController {

    private ChevalRepository chevalRepository;

    public ChevalController(ChevalRepository chevalRepository) {
        this.chevalRepository = chevalRepository;
    }

    @GetMapping("/chevaux")
    public Iterable<Cheval> chevaux(){
        return chevalRepository.findAll();
    }

    @GetMapping("/cheval/{id}")
    public Optional<Cheval> cheval(@PathVariable Long id){
        return chevalRepository.findById(id);
    }

    @PostMapping("/cheval")
    public void nouveauCheval(@RequestBody Cheval newCheval) throws IOException {
        chevalRepository.save(newCheval);
    }

}
