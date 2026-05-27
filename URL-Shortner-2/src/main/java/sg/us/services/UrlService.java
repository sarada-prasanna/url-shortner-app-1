package sg.us.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.us.entity.Url;
import sg.us.repository.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository repository;
	
	private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	private static final int LENGTH = 6;
	
	public String shortenUrl(String originalUrl) {
		String code = generateCode();
		
		Url url = new Url();
		url.setOriginalUrl(originalUrl);
		url.setShortCode(code);
		url.setCreatedAt(LocalDateTime.now());
		url.setClickCount(0);
		
		repository.save(url);
		return code;
	}
	
	public Optional<Url> getOriginalUrl(String code){
		Optional<Url> urlOpt = repository.findByShortCode(code);
		
		urlOpt.ifPresent(url ->{
			url.setClickCount(url.getClickCount() + 1);
			repository.save(url);
		});
		return urlOpt;
	}
	
	public Optional<Url> getStats(String code){
		return repository.findByShortCode(code);
	}
	
	public String generateCode() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<LENGTH;i++) {
			sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
		}
		return sb.toString();
	}

}
