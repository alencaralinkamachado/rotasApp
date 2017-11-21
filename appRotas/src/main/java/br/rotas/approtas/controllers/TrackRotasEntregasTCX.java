/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Polyline;
import br.rotas.approtas.util.CargaTracksEntregasArquivoTCX;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alencarmachado
 */
@RestController
@RequestMapping("/tracktcx")
public class TrackRotasEntregasTCX {
    
    @RequestMapping(value = "tcx", method = RequestMethod.GET)
    public Polyline getTrackTcx(){
        return new CargaTracksEntregasArquivoTCX().getTcx();
    }
    
}
