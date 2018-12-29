package ma.ensa.sqli.states;

import ma.ensa.sqli.building.Elevator;

public class UpState extends ElevatorState {

	public UpState(Elevator elevator) {
		super(elevator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void up() {
		throw new IllegalStateException("elevator already going up");
		
	}

	@Override
	public void down() {
		elevator.setElevatorState(new DownState(elevator));
	}

	@Override
	public void stop() {
		elevator.setElevatorState(new StopState(elevator));
	}

	@Override
	public void resting() {
		// TODO Auto-generated method stub
		elevator.setElevatorState(new RestingState(elevator));
		
	}

	@Override
	public int distanceFromFloor(int floor) {
		if(elevator.getElevator_current_floor()>floor)
			return floor+elevator.getNumberOfFloors()-elevator.getElevator_current_floor();
		return floor-elevator.getElevator_current_floor() ;
	}

}
