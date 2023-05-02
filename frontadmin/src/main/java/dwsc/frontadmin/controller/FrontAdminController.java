package dwsc.frontadmin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URI;
import java.text.SimpleDateFormat;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import dwsc.frontadmin.model.Mensaje;
import dwsc.frontadmin.model.TipoNivelInteres;

@Controller
public class FrontAdminController {
	private static String servletURL ="http://localhost:8080/ProductorConsumidor/servlet";

	
	@PostMapping("/servlet")
	public String insertNews(@ModelAttribute Mensaje mensaje , Model model) {
	    Mensaje sentMessage = null;
	    try {
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        
	        restTemplate.postForLocation(servletURL + "?nivelInteres=" + mensaje.getnivelInteres()
	        + "&descripcionCorta=" + mensaje.descripcionCorta + "&descripcionLarga=" + mensaje.getDescripcionLarga()
	        + "&action=Enviar", Mensaje.class);

	        model.addAttribute("mensajes", sentMessage);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "index";
	}
	

}
