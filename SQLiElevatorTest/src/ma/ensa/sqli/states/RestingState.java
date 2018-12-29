package ma.ensa.sqli.states;

import ma.ensa.sqli.building.Elevator;

public class RestingState extends ElevatorState {

	public RestingState(Elevator elevator) {
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
		elevator.setElevatorState(new StopState(elevator));

	}

	@Override
	public void resting() {
		throw new IllegalStateException("elevator is already in resting state");
	}

	@Override
	public int distanceFromFloor(int floor) {
		return Math.abs(floor-elevator.getElevator_current_floor());
	}

}
