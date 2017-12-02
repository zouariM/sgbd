package services;

import java.util.ArrayList;
import java.util.List;

import entities.Meta;
import entities.ServiceResponse;

public class ServiceEntraineur {

	
	public ServiceResponse getEntraineurs(){
		ServiceResponse res = new ServiceResponse();
		res.query = "select * from entraineurs";
		res.status = true;
		res.errorMessage = null;
		res.queryDescription = "selectionner tous les entraineurs";
		
		// set up the metadata
		List<Meta> metadata = new ArrayList<>();
		metadata.add(new Meta("id", true, false, null));
		metadata.add(new Meta("nom", false, false, null) );
		metadata.add(new Meta("ID_EQUIPE",false,true,"equipes"));
		res.metaData = metadata;
		
		// set up the data
		List< List<String> > data = new ArrayList<>();
		// while result set.next() ... fill the data
		List<String> l = new ArrayList<>();
		l.add("12");
		l.add("john trabolta");
		l.add("3");
		data.add(l);
		List<String> l1 = new ArrayList<>();
		l1.add("2");
		l1.add("john smith");
		l1.add("4");
		data.add(l1);
		res.data = data;
		
		return res;
	}
	
	
}
