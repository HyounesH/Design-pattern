package ma.ensa.sqli.states;

import ma.ensa.sqli.building.Elevator;

public class StopState extends ElevatorState {

	public StopState(Elevator elevator) {
		super(elevator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void up() {
		elevator.setElevatorState(new UpState(elevator));
		
	}

	@Override
	public void down() {
	elevator.setElevatorState(new DownState(elevator));
	}

	@Override
	public void stop() {
		throw new IllegalStateException("the elevator is already is stop state");
	}

	@Override
	public void resting() {
	elevator.setElevatorState(new RestingState(elevator));
	}

	@Override
	public int distanceFromFloor(int floor) {
		// TODO Auto-generated method stub
		return -1;
	}

}
