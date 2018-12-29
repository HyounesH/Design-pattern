package ma.ensa.sqli.building;

import ma.ensa.sqli.states.ElevatorState;
import ma.ensa.sqli.states.RestingState;

public class Elevator {
	
	private int numberOfFloors;
	private String elevator_id;
	private int elevator_current_floor;
	private ElevatorState elevatorState;
	public Elevator(int numberOfFloors,String elevator_id,int elevator_current_floor) {
		this.numberOfFloors=numberOfFloors;
		this.elevator_id=elevator_id;
		this.elevator_current_floor=elevator_current_floor;
		elevatorState=new RestingState(this);
	}
	
	public int distanceFromFloor(int floor) {
		return elevatorState.distanceFromFloor(floor);
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public String getElevator_id() {
		return elevator_id;
	}

	public void setElevator_id(String elevator_id) {
		this.elevator_id = elevator_id;
	}

	public int getElevator_current_floor() {
		return elevator_current_floor;
	}

	public void setElevator_current_floor(int elevator_current_floor) {
		this.elevator_current_floor = elevator_current_floor;
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
	}
	

}
