package com.fabio.risposte;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RispostaConsultazioneUtenzaMapper implements RowMapper<RispostaConsultazioneUtenza>{

	public RispostaConsultazioneUtenzaMapper() {
		
	}
	
	public RispostaConsultazioneUtenza mapRow(ResultSet rs, int rowNum) throws SQLException {
		RispostaConsultazioneUtenza risposta=new RispostaConsultazioneUtenza();
		if(rs!=null && rowNum>0) {
			risposta.setNome(rs.getString("nome"));
			risposta.setCognome(rs.getString("cognome"));
			risposta.setCodiceFiscale(rs.getString("codiceFiscale"));
			risposta.setProfessione(rs.getString("professione"));
			risposta.setEsito(true);
		}else if(rs==null){
			risposta.setEsito(false);
		}
		return risposta;
	}
}
