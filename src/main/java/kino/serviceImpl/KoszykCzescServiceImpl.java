package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.KoszykCzesc;
import kino.repository.KoszykCzescRepository;
import kino.service.KoszykCzescService;

@Service
public class KoszykCzescServiceImpl implements KoszykCzescService{

	@Autowired
	KoszykCzescRepository koszykItemRepository;
	
	@Override
	public void save(KoszykCzesc koszykItem) {
		koszykItemRepository.save(koszykItem);
	}

	@Override
	public List<KoszykCzesc> getAll() {
		return koszykItemRepository.getAll();
	}

	@Override
	public void update(KoszykCzesc koszykItem) {
		koszykItemRepository.update(koszykItem);	
	}

	@Override
	public KoszykCzesc find(Long id) {
		return koszykItemRepository.find(id);
	}

	@Override
	public void delete() {
		koszykItemRepository.delete();
	}

}
