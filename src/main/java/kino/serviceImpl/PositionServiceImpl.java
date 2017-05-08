package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Position;
import kino.domain.Seans;
import kino.repository.PositionRepository;
import kino.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	PositionRepository miejsceRepository;

	@Override
	public void save(Position miejsce, int size, Seans seans) {
		miejsceRepository.save(miejsce, size, seans);	
	}

	@Override
	public List<Position> getColumn(String decision, Seans seans) {
		return miejsceRepository.getColumn(decision, seans);
	}

	@Override
	public void updateAvailability(Position position, String availability) {
		miejsceRepository.updateAvailability(position, availability);
		
	}

	
	public Position getPosition(String raw, String position, Seans seans) {	
		return miejsceRepository.getPosition(raw, position, seans);
	}

	
	public void addTemporaryBusyPositionToList(String raw, String position) {
		miejsceRepository.addTemporaryBusyPositionToList(raw, position);	
	}

	
	public void deleteTemporaryBusyPositionFromList() {
		miejsceRepository.deleteTemporaryBusyPositionFromList();
		
	}

	
	public Position getLastBusyPosition() {	
		return miejsceRepository.getLastBusyPosition();
	}

	
	public List<Position> getListOfTemporaryBusyPositions() {
		return miejsceRepository.getListOfTemporaryBusyPositions();
	}

	
	public void setListOfTemporaryBusyPositions(List<Position> listOfTemporaryBusyPlaces) {
		miejsceRepository.setListOfTemporaryBusyPositions(listOfTemporaryBusyPlaces);		
	}

	public void deleteAllTemporaryBusyPositionsFromList() {
		miejsceRepository.deleteAllTemporaryBusyPositionsFromList();		
	}

	@Override
	public void update(Position position) {
		miejsceRepository.update(position);
	}

	@Override
	public List<Position> getBusyPositions(Seans seans) {
		return miejsceRepository.getBusyPositions(seans);
	}

	@Override
	public void deleteTemporaryBusyPositionsFromDatabase(Seans seans) {
		miejsceRepository.deleteTemporaryBusyPositionsFromDatabase(seans);	
	}

	@Override
	public List<Position> getAllFromOneSeanse(Seans seans) {
		return miejsceRepository.getAllFromOneSeanse(seans);
	}

}
