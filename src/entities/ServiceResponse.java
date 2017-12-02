package entities;

import java.util.List;

public class ServiceResponse {

	public boolean status;
	public String query;
	public String queryDescription; // what does the query do 
	public String errorMessage;
	
	public List<Meta> metaData;
	public List<List<String>> data;
	
}
