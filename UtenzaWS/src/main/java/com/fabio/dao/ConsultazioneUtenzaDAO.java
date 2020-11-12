package com.fabio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fabio.connession.ConnessioneDB;
import com.fabio.richieste.RichiestaConsultazioneUtenza;
import com.fabio.risposte.RispostaConsultazioneUtenza;


public class ConsultazioneUtenzaDAO {
	

	private Properties properties;
	private ConnessioneDB connessione;
	public ConsultazioneUtenzaDAO() {
		
	}
	/**Metodo che recupera dal db interno al servizio il risultato della richiesta*/
	public RispostaConsultazioneUtenza ricercaPerCodiceFiscale(RichiestaConsultazioneUtenza richiesta) {
		RispostaConsultazioneUtenza risposta=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			if(richiesta!=null && richiesta.getCodiceFiscale()!=null) {
				connessione.stabilisciConnessione();
				pstm=connessione.getConnection().prepareStatement(getProperties().getProperty("query.servizio.utentePerCf"));
				pstm.setObject(1,richiesta.getCodiceFiscale());
				rs=pstm.executeQuery();
				if(rs!=null) {
					while(rs.next()) {
						risposta=new RispostaConsultazioneUtenza();
						risposta.setNome(rs.getString("nome"));
						risposta.setCognome(rs.getString("cognome"));
						risposta.setCodiceFiscale(rs.getString("codiceFiscale"));
						risposta.setProfessione(rs.getString("professione"));
						risposta.setEsito(true);
						break;
					}
				}
				if(risposta!=null) {
					if(risposta.isEsito()) {
						risposta.setMessage("OK");
					}else {
						//si verifica se il resultSet è nullo
						risposta.setMessage("KO");
					}
				}
			}else {
				risposta=new RispostaConsultazioneUtenza();
				risposta.setEsito(false);
				risposta.setMessage(getProperties().getProperty("messaggi.servizioRichiesta.errore"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return risposta;
	}
	
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public ConnessioneDB getConnessione() {
		return connessione;
	}
	public void setConnessione(ConnessioneDB connessione) {
		this.connessione = connessione;
	}

	
	 
}
