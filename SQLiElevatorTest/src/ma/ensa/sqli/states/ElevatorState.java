package ma.ensa.sqli.states;

import ma.ensa.sqli.building.Elevator;

public  abstract class ElevatorState {
	protected Elevator elevator;
	public ElevatorState(Elevator elevator) {
		this.elevator=elevator;
	}
	
	public abstract void up();
	public abstract void down();
	public abstract void stop();
	public abstract void resting();
	
	public abstract int distanceFromFloor(int floor); 
}
