package com.masai.service;

import java.util.List;

import com.masai.model.AddharCard;
import com.masai.model.Person;

public interface AddharRepo {
	
	public AddharCard registerAddhhar(AddharCard aId) throws Exception;
	public AddharCard getByName(Integer id)throws Exception;
	public AddharCard updateByid(AddharCard aId)throws Exception;
	public List<AddharCard> listOfId() throws Exception;
	
	
}
