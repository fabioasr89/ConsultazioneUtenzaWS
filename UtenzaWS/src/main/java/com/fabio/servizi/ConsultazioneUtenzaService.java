package com.fabio.servizi;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.fabio.interfacceDiServizio.ConsultazioneUtenzaInterface;
import com.fabio.richieste.RichiestaConsultazioneUtenza;
import com.fabio.risposte.RispostaConsultazioneUtenza;
import com.fabio.services.Services;
/**Implementazione del nostro servizio*/
@WebService
@SOAPBinding(style=Style.RPC)
public class ConsultazioneUtenzaService implements ConsultazioneUtenzaInterface{
	
	private Services services;
	public ConsultazioneUtenzaService() {
		
	}
	/**Servizio che esponiamo per la chiamata riguardante la ricerca per cf completo o parziale*/
	@WebMethod(operationName ="ricercaPerCodiceFiscale")
	public RispostaConsultazioneUtenza ricercaPerCodiceFiscale(RichiestaConsultazioneUtenza richiesta) {
		RispostaConsultazioneUtenza risposta=null;
		try {
			risposta=services.ricercaPerCodiceFiscale(richiesta);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(risposta==null) {
			risposta=new RispostaConsultazioneUtenza();
			risposta.setEsito(false);
			risposta.setMessage("KO-risposta non valorizzata");
		}
		return risposta;
	}
	@WebMethod(exclude=true)
	public Services getServices() {
		return services;
	}
	@WebMethod(exclude=true)
	public void setServices(Services services) {
		this.services = services;
	}

	
	
	
	
}
