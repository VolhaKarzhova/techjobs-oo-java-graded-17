package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object objectToCompare) {
        if (this == objectToCompare) return true;
        if (!(objectToCompare instanceof Job that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String newLine = System.lineSeparator();
        String noDataMessage = "Data not available";
        if (this.getName().isBlank() && this.getEmployer().getValue().isBlank() && this.getLocation().getValue().isBlank()
                && this.getPositionType().getValue().isBlank() && this.getCoreCompetency().getValue().isBlank()) {
            return "OOPS! This job does not seem to exist.";
        }
        return newLine + "ID: " + this.id +
                newLine + "Name: " + (this.getName().isBlank() ? noDataMessage : this.getName()) +
                newLine + "Employer: " + (this.getEmployer().getValue().isBlank() ? noDataMessage : this.getEmployer()) +
                newLine + "Location: " + (this.getLocation().getValue().isBlank() ? noDataMessage : this.getLocation()) +
                newLine + "Position Type: " + (this.getPositionType().getValue().isBlank() ? noDataMessage :
                this.getPositionType()) +
                newLine + "Core Competency: " + (this.getCoreCompetency().getValue().isBlank() ? noDataMessage :
                this.getCoreCompetency()) + newLine;
    }
}
