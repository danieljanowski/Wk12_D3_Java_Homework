import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
    }

    public void add(Attraction attraction){
        attractions.add(attraction);
    }

    public int countAtractions(){
        return attractions.size();
    }

    public void add(Stall stall){
        stalls.add(stall);
    }

    public int countStalls(){
        return stalls.size();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> allReviewed = new ArrayList<>();
        allReviewed.addAll(attractions);
        allReviewed.addAll(stalls);
        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.incVisitCounter();
        visitor.addVisited(attraction);
    }
}
