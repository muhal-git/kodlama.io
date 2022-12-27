package kodlama.io.KodlamaDevs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kodlama.io.KodlamaDevs.dataAccess.abstracts.CodingLanguageRepository;
import kodlama.io.KodlamaDevs.entities.concretes.CodingLanguage;

@Repository
public class InMemoryCodingLanguageRepository implements CodingLanguageRepository {
	
	ArrayList<CodingLanguage> codingLanguages;
	
	
	@Autowired
	public InMemoryCodingLanguageRepository() {
		super();
		codingLanguages = new ArrayList<CodingLanguage>();
		codingLanguages.add(new CodingLanguage(1, "Java"));
		codingLanguages.add(new CodingLanguage(2, ".NET"));
		codingLanguages.add(new CodingLanguage(3, "C#"));
		codingLanguages.add(new CodingLanguage(4, "C++"));
		codingLanguages.add(new CodingLanguage(5, "Python"));
		codingLanguages.add(new CodingLanguage(6, "Solidity"));
		
		for (CodingLanguage codingLanguage : codingLanguages) {
			codingLanguage.setName(codingLanguage.getName().toUpperCase());
		}
	}
	
	
	@Override
	public List<CodingLanguage> getAll() {
		System.out.println(new Date()+" Programlama dilleri donduruluyor...");
		return codingLanguages;
	}



	@Override
	public CodingLanguage getLanguage(int id) {
		// TODO Auto-generated method stub
		System.out.println(new Date() + " " + (id) + " numarali programlama dili olan " + codingLanguages.get(id-1).getName() + " donduruluyor...");
		return codingLanguages.get(id-1);
	}



	@Override
	public String addLanguage(String name) {
		// TODO Auto-generated method stub
		name = name.trim().toUpperCase();
		if (name.equals("")) {
			return "Programlama dili bos girilemez.";
		}
		for (CodingLanguage codingLanguage : codingLanguages) {
			if (codingLanguage.getName().equalsIgnoreCase(name)) {
				return "Girilen programlama dili sistemde mevcut.";
			}
		}
		System.out.println(new Date() + " " + name + " isimli programlama dili eklenecek...");
		codingLanguages.add(new CodingLanguage(codingLanguages.size()+1,name));
		System.out.println(new Date() + " " + name + " isimli programlama dili eklendi");
		String totalList = "";
		for (CodingLanguage codingLanguage : codingLanguages) {
			totalList=totalList.concat("\n"+ codingLanguage.getId() +":"+codingLanguage.getName());
		}
		
		totalList = totalList.concat("\n <!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<title>Page Title</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h1>BASLIK KISMI</h1>\r\n"
				+ "<p><a href=\"http://localhost:8080/api/languages/listele/\">http://localhost:8080/api/languages/listele</a> "
				+ "adresinden de guncel listeyi goruntuleyebilirsiniz.</p>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html> ");
		return "Guncel liste: " + totalList + "\nEkleme basarili, ilgili adresten de guncel listeyi goruntuleyebilirsiniz...";
	}



	@Override
	public String deleteLanguage(int id) {
		// TODO Auto-generated method stub
		String totalList = "";
		System.out.println(id + " numarali eleman siliniyor...");
		codingLanguages.remove(id-1);
		for (CodingLanguage codingLanguage : codingLanguages) {
			totalList=totalList.concat("\n"+ codingLanguage.getId() +":"+codingLanguage.getName());
		}
		return totalList;
	}



	@Override
	public String updateLanguage(int id, String name) {
		// TODO Auto-generated method stub
		name = name.trim().toUpperCase();
		if (name.equals("")) {
			return "Programlama dili bos girilemez.";
		}
		for (CodingLanguage codingLanguage : codingLanguages) {
			if (codingLanguage.getName().equalsIgnoreCase(name)) {
				return "Girilen programlama dili sistemde mevcut.";
			}
		}
		String totalList = "";
		System.out.println(id + " numarali eleman guncelleniyor...");
		codingLanguages.set(id, new CodingLanguage(id,name));
		for (CodingLanguage codingLanguage : codingLanguages) {
			totalList=totalList.concat("\n"+ codingLanguage.getId() +":"+codingLanguage.getName());
		}
		return totalList;
		
	}


}
