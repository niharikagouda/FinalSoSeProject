package it.univaq.odws.maven.sum;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BookController {
	
	@WebMethod
	public boolean removeBook(String isbn);
	

}
