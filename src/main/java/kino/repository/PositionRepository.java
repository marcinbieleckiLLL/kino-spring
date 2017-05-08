package kino.repository;

import java.util.List;

import kino.domain.Position;
import kino.domain.Seans;

public interface PositionRepository {
	
	public List<Position> getAllFromOneSeanse(Seans seans);
	public void save(Position position, int size, Seans seans);
	public List<Position> getColumn(String decision, Seans seans);
	public void updateAvailability(Position position, String availability);
	public Position getPosition(String raw, String place, Seans seans);
	public void addTemporaryBusyPositionToList(String raw, String place);
	public void deleteTemporaryBusyPositionFromList();
	public Position getLastBusyPosition();
	public List<Position> getListOfTemporaryBusyPositions();
	public void setListOfTemporaryBusyPositions(List<Position> listOfTemporaryBusyPositions);
	public void deleteAllTemporaryBusyPositionsFromList();
	public void update(Position postion);
	public List<Position> getBusyPositions(Seans seans);
	public void deleteTemporaryBusyPositionsFromDatabase(Seans seans);
	
}
