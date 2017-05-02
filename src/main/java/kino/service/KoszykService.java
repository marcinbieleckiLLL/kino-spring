package kino.service;

import java.util.List;

import kino.domain.Koszyk;
import kino.domain.KoszykCzesc;
import kino.domain.User;

public interface KoszykService {

	
	public void update(Koszyk koszy);
	public Koszyk deleteKoszykItem(KoszykCzesc koszykItem, User user);
	public void create(User user, Koszyk koszykDoZapisu);
	public List<Koszyk> read();
	public Koszyk read(User user);
	public void deleteKoszyk(User user);
}
