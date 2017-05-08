package kino.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.Position;
import kino.domain.Seans;
import kino.repository.PositionRepository;

@Repository
@Transactional
public class PositionRepositoryImpl implements PositionRepository {

	@PersistenceContext
	private EntityManager emManager;
	public List<Position> listOfTemporaryBusyPositions = new ArrayList<Position>();
	
	
	
	public List<Position> getListOfTemporaryBusyPositions(){
		return this.listOfTemporaryBusyPositions;
	}

	public void setListOfTemporaryBusyPositions(List<Position> listOfTemporaryBusyPositions) {
		this.listOfTemporaryBusyPositions = listOfTemporaryBusyPositions;
	}
	

	@Override
	public void save(Position position, int size, Seans seans) {
		List<Position> listOfPositions = getAllFromOneSeanse(seans);
		
		if(listOfPositions.size() < size){
			emManager.persist(position);
		}
	}
	
	public List<Position> getColumn(String decision, Seans seans) throws NullPointerException{
		
		List<Position> listOfPositions = getAllFromOneSeanse(seans);
		List<Position> listOfResults = new ArrayList<Position>();
		boolean ifGet = true;
		
		if(listOfPositions.isEmpty() || listOfPositions == null){
			ifGet = false;
		}
		
		if(ifGet){
			if(decision.equals("1")){
				for(Position position: listOfPositions){
					if(position.getPlace() != null){
						if(position.getPlace().equals("1") || position.getPlace().equals("2") || position.getPlace().equals("3")){
							listOfResults.add(position);
						}
					}
				}
				
			}else if(decision.equals("2")){
				for(Position position: listOfPositions){
					if(position.getPlace() != null){
						if(position.getPlace().equals("4") || position.getPlace().equals("5") || position.getPlace().equals("6") || position.getPlace().equals("7") || position.getPlace().equals("8")){
							listOfResults.add(position);
						}
					}
				}
			}if(decision.equals("3")){
				for(Position position: listOfPositions){
					if(position.getPlace() != null){
						if(position.getPlace().equals("9") || position.getPlace().equals("10") || position.getPlace().equals("11") || position.getPlace().equals("12")){
							listOfResults.add(position);
						}
					}
				}
			}	
		}
		return listOfResults;
	}

	@Override
	public void updateAvailability(Position position, String availability) {
		position.setAvailability(availability);
		emManager.merge(position);
		
	}

	@Override
	public Position getPosition(String raw, String place, Seans seans) {
		
		Position listOfResultPositions = new Position();
		List<Position> listOfPositionFromOneSeanse = getAllFromOneSeanse(seans);
		
		for(Position m: listOfPositionFromOneSeanse){
			if(m.getPlace().equals(place) && m.getRaw().equals(raw)){
				listOfResultPositions = m;
			}
		}

	return listOfResultPositions;
		
	}

	public void addTemporaryBusyPositionToList(String raw, String place) {
		
		Position busyPosition = new Position(raw, place, "chwilowoZajête");
		listOfTemporaryBusyPositions.add(busyPosition);
	}

	@Override
	public void deleteTemporaryBusyPositionFromList() {
		
		if(!listOfTemporaryBusyPositions.isEmpty())
			listOfTemporaryBusyPositions.remove(listOfTemporaryBusyPositions.size() - 1);
		
	}

	@Override
	public Position getLastBusyPosition() throws NoResultException{
		
		Position position = new Position();
		
		if(listOfTemporaryBusyPositions.isEmpty()){
			throw new NoResultException("¯adne miejsce nie jest zajête!");
		}else{
			position = listOfTemporaryBusyPositions.get(listOfTemporaryBusyPositions.size() - 1);
		}
		
		return position;
	}

	@Override
	public void deleteAllTemporaryBusyPositionsFromList() {
		setListOfTemporaryBusyPositions(new ArrayList<Position>());
	}

	
	@Override
	public void update(Position position) {
		emManager.merge(position);
		
	}

	@Override
	public List<Position> getBusyPositions(Seans seans) {
		List<Position> listOfAllPositions = getAllFromOneSeanse(seans);
		List<Position> listOfBusyPositions = new ArrayList<>();
		
		for(Position position: listOfAllPositions){
			if(position.getAvailability().equals("chwilowoZajête")){
				listOfBusyPositions.add(position);
			}
		}
		return listOfBusyPositions;
	}

	@Override
	public void deleteTemporaryBusyPositionsFromDatabase(Seans seans) {
		List<Position> listOfBusyPosition = getBusyPositions(seans);
		
		for(Position miejsce: listOfBusyPosition){
			updateAvailability(miejsce, "wolne");
		}
		
	}

	@Override
	public List<Position> getAllFromOneSeanse(Seans seans) {
		
		TypedQuery<Position> query = emManager.createQuery("SELECT p FROM Position p", Position.class);
		List<Position> listOfAllPositions = query.getResultList();
		List<Position> listaOfAllPositionsFromOneSeanse = new ArrayList<Position>();
		
		for(Position position: listOfAllPositions){
			for(Seans s: position.getSeanse()){
				if(s.equals(seans)){
					listaOfAllPositionsFromOneSeanse.add(position);
				}
			}
		}
		
		return listaOfAllPositionsFromOneSeanse;
	}
}
