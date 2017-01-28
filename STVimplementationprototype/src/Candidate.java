
// This class has been designed to take into account all of the party data, these calculations are used in calculating the final seats
public class Candidate {


private String candidateName;
private int firstpreference;
private int secondpreference;
private int totalSeats;

public Candidate(String name, int firstPreference, int secondPreference) {
	candidateName = name;
	firstpreference = firstPreference;
	secondpreference = secondPreference;
}

public void addSeat() {
	totalSeats += 1;
}

// formula for working out the threshold for winning a seat

public int firstPreference() {
	return firstpreference;
}


public String candidateName() {
	return candidateName;
}


public int totalSeats() {
	return totalSeats;
	
}


}
