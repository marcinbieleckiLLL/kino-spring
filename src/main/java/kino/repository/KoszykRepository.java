package kino.repository;

import java.util.List;

import kino.domain.Koszyk;
import kino.domain.KoszykCzesc;
import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.domain.User;

public interface KoszykRepository {

	public void update(Koszyk koszyk);
	public Koszyk deleteKoszykCzesc(KoszykCzesc koszykCzesc, User user);
	public void create(User user, Koszyk koszykDoZapisu);
	public List<Koszyk> read();
	public Koszyk read(User user);
	public void deleteKoszyk(User user);
}
