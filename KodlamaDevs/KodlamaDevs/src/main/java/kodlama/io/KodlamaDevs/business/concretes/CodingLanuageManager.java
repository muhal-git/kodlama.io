package kodlama.io.KodlamaDevs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.KodlamaDevs.business.abstracts.CodingLanguageService;
import kodlama.io.KodlamaDevs.dataAccess.abstracts.CodingLanguageRepository;
import kodlama.io.KodlamaDevs.entities.concretes.CodingLanguage;

@Service
public class CodingLanuageManager implements CodingLanguageService{
	
	private CodingLanguageRepository codingLanguageRepository;
	
	@Autowired
	public CodingLanuageManager(CodingLanguageRepository codingLanguageRepository) {
		super();
		this.codingLanguageRepository = codingLanguageRepository;
	}

	@Override
	public List<CodingLanguage> getAll() {
		return codingLanguageRepository.getAll();
	}

	@Override
	public CodingLanguage getOneLanguage(int id) {
		// TODO Auto-generated method stub
		return codingLanguageRepository.getLanguage(id);
	}
	
	public String addLanguage(String name) {
		return codingLanguageRepository.addLanguage(name);
	}

	@Override
	public String deleteLanguage(int id) {
		// TODO Auto-generated method stub
		return codingLanguageRepository.deleteLanguage(id);
	}

	@Override
	public String updateLanguage(int id, String name) {
		// TODO Auto-generated method stub
		return codingLanguageRepository.updateLanguage(id, name);
	}


}
