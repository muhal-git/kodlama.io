package kodlama.io.KodlamaDevs.webApi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.KodlamaDevs.business.abstracts.CodingLanguageService;
import kodlama.io.KodlamaDevs.entities.concretes.CodingLanguage;

@RestController
@RequestMapping("/api/languages")
public class CodingLanguagesController {
	private CodingLanguageService codingLanguageService;
	long listele = 1;
	long bekletListele = 1;
	long getir = 1;
	long silinen = 1;
	long guncellenen = 1;
	long ekleme = 1;
	long sil = 1;
	@Autowired
	public CodingLanguagesController(CodingLanguageService codingLanguageService) {
		super();
		this.codingLanguageService = codingLanguageService;
	}
	
	@GetMapping("/listele")
	public List<CodingLanguage> listele(){
		System.out.println(new Date()+" Listeleme İstek geldi...	"+ " istek: " + listele++);
		return codingLanguageService.getAll();
	}
	
	@GetMapping("/bekleyereklistele")
	public List<CodingLanguage> listelemek(){
		System.out.println(new Date()+" Bekletilerek listele İstek geldi...	"+ " istek: " + bekletListele++);
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
	public CodingLanguage goster(@PathVariable() int id){
		System.out.println(new Date()+ " tek eleman listeleme istegi geldi, istenen id: " + id + " istek: " + getir++);
		return codingLanguageService.getOneLanguage(id);
	}
	
	@GetMapping("/remove/{id}")
	public String delete(@PathVariable() int id){
		System.out.println(new Date()+ " tek eleman silme istegi geldi, istenen id: " + id + " istek: " + sil++);
		return codingLanguageService.deleteLanguage(id);
	}
	
	@GetMapping("/test")
	public String gosterr(){
		return codingLanguageService.addLanguage("TEST");
	}
	
	@PostMapping("/add")
	public String addLanguage(@RequestBody String name){
		System.out.println(new Date()+ " " + name + " isimli dili ekleme istegi geldi..." + " istek: " + getir++);
		return codingLanguageService.addLanguage(name);
	}
	
	@PostMapping("/update/{id}")
	public String updateLanguage(@PathVariable() int id,@RequestBody String name){
		System.out.println(new Date()+ " " + name + " isimli dili ekleme istegi geldi..." + " istek: " + getir++);
		return codingLanguageService.updateLanguage(id, name);
	}
	
}
