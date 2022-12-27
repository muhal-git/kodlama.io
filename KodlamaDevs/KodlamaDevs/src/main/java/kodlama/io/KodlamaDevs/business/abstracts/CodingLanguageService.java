package kodlama.io.KodlamaDevs.business.abstracts;

import java.util.List;

import kodlama.io.KodlamaDevs.entities.concretes.CodingLanguage;

public interface CodingLanguageService {
	List<CodingLanguage> getAll();
	CodingLanguage getOneLanguage(int id);
	String addLanguage(String name);
	String deleteLanguage(int id);
	String updateLanguage(int id,String name);
}
