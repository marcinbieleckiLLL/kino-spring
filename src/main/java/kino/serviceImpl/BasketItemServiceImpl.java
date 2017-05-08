package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.BasketItem;
import kino.repository.BasketItemRepository;
import kino.service.BasketItemService;

@Service
public class BasketItemServiceImpl implements BasketItemService{

	@Autowired
	BasketItemRepository koszykItemRepository;
	
	@Override
	public void save(BasketItem basketItem) {
		koszykItemRepository.save(basketItem);
	}

	@Override
	public List<BasketItem> getAll() {
		return koszykItemRepository.getAll();
	}

	@Override
	public void update(BasketItem basketItem) {
		koszykItemRepository.update(basketItem);	
	}

	@Override
	public BasketItem find(Long id) {
		return koszykItemRepository.find(id);
	}

	@Override
	public void delete() {
		koszykItemRepository.delete();
	}

}
