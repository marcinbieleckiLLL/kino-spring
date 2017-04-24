package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.KoszykItem;
import kino.repository.KoszykItemRepository;
import kino.service.KoszykItemService;

@Service
public class KoszykItemServiceImpl implements KoszykItemService{

	@Autowired
	KoszykItemRepository koszykItemRepository;
	
	@Override
	public void save(KoszykItem koszykItem) {
		koszykItemRepository.save(koszykItem);
	}

	@Override
	public List<KoszykItem> getAll() {
		return koszykItemRepository.getAll();
	}

	@Override
	public void update(KoszykItem koszykItem) {
		koszykItemRepository.update(koszykItem);	
	}

	@Override
	public KoszykItem find(Long id) {
		return koszykItemRepository.find(id);
	}

	@Override
	public void delete() {
		koszykItemRepository.delete();
	}

}
