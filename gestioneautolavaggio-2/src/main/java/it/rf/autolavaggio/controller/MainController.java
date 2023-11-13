package it.rf.autolavaggio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.rf.autolavaggio.model.Clienti;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Veicolo;

import it.rf.autolavaggio.service.ClientiService;
import it.rf.autolavaggio.service.CompongonoService;
import it.rf.autolavaggio.service.OperaioService;
import it.rf.autolavaggio.service.SquadraService;
import it.rf.autolavaggio.service.VeicoloService;
import jakarta.servlet.http.HttpSession;


public class MainController {
	@Autowired
	private ClientiService cs;//istanza del service del cliente
	@Autowired
	private VeicoloService vs;//istanza del service del veicolo
	@Autowired
	private OperaioService os;//istanza del service dell'operaio
	@Autowired
	private SquadraService sqs;//istanza del service della squadra
	@Autowired
	private CompongonoService coms;//istanza del service di compongono
	//registrazione del cliente
	@PostMapping(path = "/registrazioneClienti")
	public String inserimentoClienti(@ModelAttribute Clienti c) {
		
		this.cs.insert_cliente(c);//inserimento
		return "Index";
	}
	
	//registrazione dei veicoli
	@PostMapping(path = "/registrazioneVeicoli")
	public String inserimentoVeicoli(@ModelAttribute Veicolo v,@RequestParam String cfCliente) {
		
		this.vs.insertVeicolo(v);//inserimento veicolo
	
		this.vs.insertPossiede(v,cfCliente);//inserimento del cf e del codice squadra in possiede
		
		return "Index";
		
	}
	
	//registrazione degli operai 
	@PostMapping(path = "/registrazioneOperai")
	public String inserimentoOperai(@ModelAttribute Operaio o) {
		this.os.insertOperaio(o);
		return "Index";
	}
	
	//inserimento degli operai nelle squadre e creazione delle squadre
	@PostMapping(path = "/creazioneSqadra")
	public String creaSquadra(@ModelAttribute List<Operaio> listaOperaio, HttpSession sessione) {
		Integer massimo;
		
		List<Operaio> listaOperaio2=this.os.creaLista();
		
		List<Operaio> listaSquadra=this.coms.ultimaSquadra();
		
		massimo=(Integer)this.sqs.massimoSquadra();
		
		sessione.setAttribute("tabella1", listaOperaio2);
		sessione.setAttribute("tabella2", listaSquadra);
		
		return "";
	}
	
	
}

