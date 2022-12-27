package kodlama.io.KodlamaDevs.dataAccess.abstracts;
import java.util.List;

import kodlama.io.KodlamaDevs.entities.concretes.CodingLanguage;

public interface CodingLanguageRepository {
	List<CodingLanguage> getAll();
	CodingLanguage getLanguage(int id);
	String addLanguage(String name);
	String deleteLanguage(int id);
	String updateLanguage(int id, String name);
	/*
	List<CodingLanguage> updateLnguage(int id,String name);
	List<CodingLanguage> deleteLanguage(int id);
	*/

}
