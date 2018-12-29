package ma.sqli.tests.cloudinfrastructure.entities;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private String storeName;
	private List<String> documents;
	
	public Store(String storeName) {
		super();
		this.storeName = storeName;
		documents=new ArrayList<>();
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	
	
	

}
