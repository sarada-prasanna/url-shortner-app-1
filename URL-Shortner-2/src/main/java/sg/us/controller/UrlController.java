package sg.us.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sg.us.entity.Url;
import sg.us.services.UrlService;

@CrossOrigin(origins = "*")
@RestController
public class UrlController {
	@Autowired
	private UrlService service;
	
	@PostMapping("/shorten")
	public String shorten(@RequestBody String originalUrlS) {
		return "http://localhost:8080/"+service.shortenUrl(originalUrlS);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> redirect(@PathVariable String code){
		Url url = service.getOriginalUrl(code)
				.orElseThrow(() -> new RuntimeException("URL not found"));
		
		return ResponseEntity
				.status(302)
				.location(URI.create(url.getOriginalUrl()))
				.build();
		
	}
	
	@GetMapping("/analytics/{code}")
	public Url analytics(@PathVariable String code) {
		return service.getStats(code)
				.orElseThrow(()->new RuntimeException("URL not found"));
	}
}
