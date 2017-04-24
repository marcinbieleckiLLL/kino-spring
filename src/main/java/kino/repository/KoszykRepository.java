package kino.repository;

import java.util.List;

import kino.domain.Koszyk;
import kino.domain.KoszykItem;
import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.domain.User;

public interface KoszykRepository {

	public void update(Koszyk koszy);
	public Koszyk deleteKoszykItem(KoszykItem koszykItem, User user);
	public void create(User user, Koszyk koszykDoZapisu);
	public List<Koszyk> read();
	public Koszyk read(User user);
	public void deleteKoszyk(User user);
}
