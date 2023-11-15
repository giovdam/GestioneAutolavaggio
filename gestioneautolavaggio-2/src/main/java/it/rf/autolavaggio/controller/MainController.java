package it.rf.autolavaggio.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.rf.autolavaggio.model.Clienti;
import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.model.DTO.RecuperoCodaDTO;
import it.rf.autolavaggio.service.ClientiService;
import it.rf.autolavaggio.service.CompongonoService;
import it.rf.autolavaggio.service.EffettuataService;
import it.rf.autolavaggio.service.LavorazioneService;
import it.rf.autolavaggio.service.OperaioService;
import it.rf.autolavaggio.service.SquadraService;
import it.rf.autolavaggio.service.VeicoloService;
import jakarta.servlet.http.HttpSession;

@Controller
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
	@Autowired
	private LavorazioneService lavs;//istanza del service della lavorazione
	@Autowired
	private EffettuataService effs;//istanza del service di effettuata
	
	@GetMapping(path = "/")
	public String homepage(HttpSession sessione) {
		ArrayList<Lavorazione> lista=this.lavs.riepilogoLavorazioni();
		Integer codice= this.effs.trovaCodice();
		sessione.setAttribute("listaLavorazioni",lista);
		sessione.setAttribute("codOrdine", codice);
		return "homepage";
	}
	
	@GetMapping(path = "/clienti")//noi andiamo in questo path
	public String nuovoCliente() {
		return "inserimento_clienti";//questo return ci porta alla pagina jsp
	}
	
	@GetMapping(path = "/veicolo")
	public String nuovoVeicolo() {
		return "inserimento_veicoli";
	}
	
	@GetMapping(path = "/operai")
	public String nuovoOperaio() {
		return "inserimento_operai";
	}
	
	@GetMapping(path = "/lavorazione")
	public String nuovaLavorazione() {
		return "inserimento_lavorazioni";
	}
	
	@GetMapping(path = "/squadra")
	public String nuovaSquadra(HttpSession sessione) {
		List<Operaio> listaOperaio2=this.os.creaLista();
		Integer massimo;
		List<Operaio> listaSquadra=this.coms.ultimaSquadra();
		
		massimo=(Integer)this.sqs.massimoSquadra();
		
		sessione.setAttribute("tabellaOperai", listaOperaio2);
		sessione.setAttribute("tabellaSquadra", listaSquadra);
		sessione.setAttribute("numero", massimo);
		return "registrazione_squadre";
	}
	
	@GetMapping(path = "/coda")
	public String gestioneCoda(HttpSession sessione) {
		ArrayList<RecuperoCodaDTO> lista=this.effs.recuperoCoda();
		sessione.setAttribute("listacoda", lista);
		return "evasione_ordini";
	}

	//registrazione del cliente
	@PostMapping(value = "/ins_clienti")//dalla jsp andiamo in questo metodo
	public String inserimentoClienti(@ModelAttribute Clienti c) {
		this.cs.insert_cliente(c);//svolgiamo inserimento
		return "redirect:/clienti";//ritorniamo alla jsp
	}
	
	//registrazione dei veicoli
	@PostMapping(value = "/registrazioneVeicoli")
	public String inserimentoVeicoli(@ModelAttribute Veicolo v,@RequestParam String cfCliente) {
		
		this.vs.insertVeicolo(v);//inserimento veicolo
	
		this.vs.insertPossiede(v,cfCliente);//inserimento del cf e del codice squadra in possiede
		
		return "redirect:/veicolo";
	}

	
	//registrazione degli operai 
	@PostMapping(path = "/registrazione_operai")
	public String inserimentoOperai(@ModelAttribute Operaio o) {
		this.os.insertOperaio(o);
		return "redirect:/operai";
	}
	
	//inserimento degli operai nelle squadre e creazione delle squadre
	@PostMapping(value = "/creazioneSquadra")
	public String creaSquadra(@RequestParam ArrayList<String> cfOperaio, HttpSession sessione) {
		//controllare l'arraylist
		Integer massimo;
		
		ArrayList<Operaio> listaOperaio2=this.os.creaLista();
		
		ArrayList<Operaio> listaSquadra= (ArrayList<Operaio>)this.coms.ultimaSquadra();
		
		massimo=(Integer)this.sqs.massimoSquadra();
		
		this.coms.insertCompongono(cfOperaio);
		sessione.setAttribute("tabellaOperai", listaOperaio2);
		sessione.setAttribute("tabellaSquadra", listaSquadra);
		sessione.setAttribute("numero", massimo);
		
		return "redirect:/squadra";
	}
	
	//inserimento della lavorazione
	@PostMapping(value = "/creazione_lavorazione")
	public String creaLavorazione(@RequestParam String nomeLavorazione, @RequestParam Float costoLavorazione) {
		this.lavs.insertLavorazione(nomeLavorazione, costoLavorazione);
		return "redirect:/lavorazione";
	}
	//gestione della coda
	@PostMapping(value = "/evasione_ordini")
	public String gestisciOrdine(@RequestParam Integer codOrdine, @RequestParam Integer codLavorazione) {
		//aggiornare lo stato dell'ordine
		System.out.print(""+codOrdine+""+codLavorazione);
		this.effs.aggiornaStato(codOrdine, codLavorazione);
		return "redirect:/coda";
	}
	//creazione dell'ordine nella homepage
	@PostMapping(value = "/creazione_ordine")
	public String creaOrdine(@RequestParam String targa,@RequestParam List<Integer>codLavorazione) {
		/*System.out.println(targa);
		for(Integer l: codLavorazione) {
			System.out.println(l);
		}*/
		this.effs.insertEffettuata(targa, codLavorazione);
		return "redirect:/";
	}
	 
	
	
}

