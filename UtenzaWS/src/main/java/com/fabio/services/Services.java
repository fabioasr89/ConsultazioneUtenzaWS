package com.fabio.services;

import com.fabio.dao.ConsultazioneUtenzaDAO;
import com.fabio.richieste.RichiestaConsultazioneUtenza;
import com.fabio.risposte.RispostaConsultazioneUtenza;

public class Services{
	
	private ConsultazioneUtenzaDAO consultazioneUtenzaDAO;
	public Services() {
		
	}
	
	public RispostaConsultazioneUtenza ricercaPerCodiceFiscale(RichiestaConsultazioneUtenza richiesta) throws Exception{
		return consultazioneUtenzaDAO.ricercaPerCodiceFiscale(richiesta);
	}

	public ConsultazioneUtenzaDAO getConsultazioneUtenzaDAO() {
		return consultazioneUtenzaDAO;
	}

	public void setConsultazioneUtenzaDAO(ConsultazioneUtenzaDAO consultazioneUtenzaDAO) {
		this.consultazioneUtenzaDAO = consultazioneUtenzaDAO;
	} 
	
}
