package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.AddharCard;
import com.masai.model.Person;
import com.masai.repo.AddhharCardRepo;
import com.masai.repo.PersonRepo;

@Service
public class AddharRepoImpl implements AddharRepo {
	
	@Autowired
	private AddhharCardRepo aRepo;
	
	@Autowired
	private PersonRepo pRepo;

	@Override
	public AddharCard registerAddhhar(AddharCard aId) throws Exception {
		
		Optional<Person> opt = pRepo.findById(aId.getPerson().getId());
		if(opt.isEmpty()) {
		throw new Exception("no person here");
		}
		
		return aRepo.save(aId);
				
		
		
	}

	@Override
	public AddharCard getByName(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<AddharCard> opt = aRepo.findById(id);
		if(opt.isEmpty() )
			throw new Exception("No id found of ID " + id);
		else {
			AddharCard aId = opt.get();
			return aId;
		}
	}

	@Override
	public AddharCard updateByid(AddharCard aId) throws Exception {
		// TODO Auto-generated method stub
		Optional<AddharCard> opt = aRepo.findById(aId.getaId());
		
		if(opt.isEmpty()) {
			
			throw new Exception("No id found of ID  -> " + aId.getaId());
		}else {
			
			aRepo.save(aId);
			return aId;
		}
	}

	@Override
	public List<AddharCard> listOfId() throws Exception {
	
		List<AddharCard> list = aRepo.findAll();
		if(list.size() != 0)
		return list;
		else 
			throw new Exception("No id FOund here");
	
	}

	

}
