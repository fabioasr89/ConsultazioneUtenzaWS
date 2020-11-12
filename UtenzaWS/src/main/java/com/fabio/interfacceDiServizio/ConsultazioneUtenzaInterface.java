package com.fabio.interfacceDiServizio;

import com.fabio.richieste.RichiestaConsultazioneUtenza;
import com.fabio.risposte.RispostaConsultazioneUtenza;

public interface ConsultazioneUtenzaInterface {

	RispostaConsultazioneUtenza ricercaPerCodiceFiscale(RichiestaConsultazioneUtenza richiesta);

}
