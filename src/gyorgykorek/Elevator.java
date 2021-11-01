package gyorgykorek;

public class Elevator {

    //Lift azonosító
    private int eid;
    //Megengedett maximum szint
    private int maximumfloor=10;
    //Megengedett minimum szint => földszint
    private int minimumfloor=0;
    //Lift aktuális szintje
    private int actualfloor;
    //Lift maximális kapacitása főben
    private int maximumPerson = 5;
    //Lift minimum kapacitása (egyedül ne induljon el)
    private int minimumPerson = 1;
    //Lift aktuális terheltsége főben
    private int actualPerson;
    //Lift maximális kapacitása kg-ben
    private int maximumKG=999;
    //Lift minimális kapacitása kg-ben
    private int minimumKG=0;
    //Lift aktuális terheltsége kg-ben.
    private int actualKG;
    //Lift megtett útja utasokkal => számláló
    private int tracker;
    //Lift megtett útja összesen (üresen is) => számláló
    private int alltracker;
    //Összes utas
    private int allPerson;

    @Override
    public String toString() {
        return "Elevator{" +
                "eid=" + eid +
                ", maximumfloor=" + maximumfloor +
                ", minimumfloor=" + minimumfloor +
                ", actualfloor=" + actualfloor +
                ", maximumPerson=" + maximumPerson +
                ", minimumPerson=" + minimumPerson +
                ", actualPerson=" + actualPerson +
                ", maximumKG=" + maximumKG +
                ", minimumKG=" + minimumKG +
                ", actualKG=" + actualKG +
                ", tracker=" + tracker +
                '}';
    }

    public int getAllPerson() {
        return allPerson;
    }

    public void setAllPerson(int allPerson) {
        this.allPerson = allPerson;
    }

    public int getAlltracker() {
        return alltracker;
    }

    public void setAlltracker(int alltracker) {
        this.alltracker = alltracker;
    }

    public int getTracker() {
        return tracker;
    }

    public void setTracker(int tracker) {
        this.tracker = tracker;
    }

    public int getActualKG() {
        return actualKG;
    }

    public void setActualKG(int actualKG) {
        this.actualKG = actualKG;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getMaximumfloor() {
        return maximumfloor;
    }

    public void setMaximumfloor(int maximumfloor) {
        this.maximumfloor = maximumfloor;
    }

    public int getMinimumfloor() {
        return minimumfloor;
    }

    public void setMinimumfloor(int minimumfloor) {
        this.minimumfloor = minimumfloor;
    }

    public int getActualfloor() {
        return actualfloor;
    }

    public void setActualfloor(int actualfloor) {
        this.actualfloor = actualfloor;
    }

    public int getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(int maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public int getMinimumPerson() {
        return minimumPerson;
    }

    public void setMinimumPerson(int minimumPerson) {
        this.minimumPerson = minimumPerson;
    }

    public int getActualPerson() {
        return actualPerson;
    }

    public void setActualPerson(int actualPerson) {
        this.actualPerson = actualPerson;
    }

    public int getMaximumKG() {
        return maximumKG;
    }

    public void setMaximumKG(int maximumKG) {
        this.maximumKG = maximumKG;
    }

    public int getMinimumKG() {
        return minimumKG;
    }

    public void setMinimumKG(int minimumKG) {
        this.minimumKG = minimumKG;
    }
}
