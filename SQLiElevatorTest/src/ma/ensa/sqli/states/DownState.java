package ma.ensa.sqli.states;

import ma.ensa.sqli.building.Elevator;

public class DownState extends ElevatorState {

	public DownState(Elevator elevator) {
		super(elevator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void up() {
    elevator.setElevatorState(new UpState(elevator));		
	}

	@Override
	public void down() {
    throw new IllegalStateException("the elevator is already going down");		
	}

	@Override
	public void stop() {
    elevator.setElevatorState(new StopState(elevator));
		
	}

	@Override
	public void resting() {
		elevator.setElevatorState(new RestingState(elevator));
	}

	@Override
	public int distanceFromFloor(int floor) {
	 if(elevator.getElevator_current_floor()<floor)
		 return floor+elevator.getNumberOfFloors()-elevator.getElevator_current_floor();
	 else 
		 return floor-elevator.getElevator_current_floor();
	}
	

}
