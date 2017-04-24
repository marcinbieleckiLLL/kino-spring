package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Koszyk;
import kino.domain.KoszykItem;
import kino.domain.User;
import kino.repository.KoszykRepository;
import kino.service.KoszykService;

@Service
public class KoszykServiceImpl implements KoszykService {

	@Autowired
	KoszykRepository koszykRepository;
	
	@Override
	public void update(Koszyk koszyk) {
		koszykRepository.update(koszyk);
		
	}

	@Override
	public Koszyk deleteKoszykItem(KoszykItem koszykItem, User user) {
		return koszykRepository.deleteKoszykItem(koszykItem, user);
		
	}

	@Override
	public void create(User user, Koszyk koszykDoZapisu) {
		koszykRepository.create(user, koszykDoZapisu);
		
	}

	@Override
	public List<Koszyk> read() {
		return koszykRepository.read();
	}

	@Override
	public Koszyk read(User user) {
		return koszykRepository.read(user);
	}

	@Override
	public void deleteKoszyk(User user) {
		koszykRepository.deleteKoszyk(user);
	}

}
