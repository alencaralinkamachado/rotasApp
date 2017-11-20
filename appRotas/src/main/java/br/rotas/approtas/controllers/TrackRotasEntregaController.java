/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Polyline;
import br.rotas.approtas.model.Track;
import br.rotas.approtas.util.CargaTrackEntregas;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alencarmachado
 */
@RestController
@RequestMapping("/track")
public class TrackRotasEntregaController {
    
     @RequestMapping(value = "polilynes", method = RequestMethod.GET)
    public ArrayList<Polyline> getTracks(){
       
        CargaTrackEntregas ce = new CargaTrackEntregas();
        ArrayList<Polyline> poli = new ArrayList<>();
        
        poli.add(ce.polyDirceu());
        //poli.add(ce.polyEverton());
        
        return poli;
    }
    
     @RequestMapping(value = "trackDirceuInicio", method = RequestMethod.GET)
    public ArrayList<Track> trackDirceuInicio(){
        return new CargaTrackEntregas().polyDirceuInicioTrack();
    }
    
    @RequestMapping(value = "trackHilario", method = RequestMethod.GET)
    public ArrayList<Track> getTrackHilario(){
        return new CargaTrackEntregas().polyHilarioTrack();
    }
    
    @RequestMapping(value = "trackEli", method = RequestMethod.GET)
    public ArrayList<Track> getTrackEli(){
        return new CargaTrackEntregas().polyEliTrack();
    }
    
    @RequestMapping(value = "trackDirceu", method = RequestMethod.GET)
    public ArrayList<Track> getTrackDirceu(){
        return new CargaTrackEntregas().polyDirceuTrack();
    }
    
    @RequestMapping(value = "trackLuiz", method = RequestMethod.GET)
    public ArrayList<Track> getTrackLuiz(){
        return new CargaTrackEntregas().polyLuizTrack();
    }
    
    @RequestMapping(value = "trackEverton", method = RequestMethod.GET)
    public ArrayList<Track> getTrackEverton(){
        return new CargaTrackEntregas().polyEvertonTrack();
    }
    
}
