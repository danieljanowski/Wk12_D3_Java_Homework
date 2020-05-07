import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    IceCreamStall iceCreamStall;
    CandyflossStall candyflossStall;
    Playground playground;
    Dodgems dodgems;
    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void before(){
        themePark = new ThemePark();
        iceCreamStall = new IceCreamStall("Barney's","Barry Banana", ParkingSpot.B2,7);
        candyflossStall = new CandyflossStall("Candy","Annie",ParkingSpot.A2,4);
        playground = new Playground("Slides",10);
        dodgems = new Dodgems("Dodge-ems",6);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(10, 100, 13);
        visitor2 = new Visitor(21, 210, 45);
        visitor3 = new Visitor(13, 140, 30);
    }

    @Test
    public void canAddAttrAndStalls(){
        themePark.add(iceCreamStall);
        assertEquals(1, themePark.countStalls());
        assertEquals(0, themePark.countAtractions());
        assertEquals(1, themePark.getAllReviewed().size());

        themePark.add(candyflossStall);
        assertEquals(2, themePark.countStalls());
        assertEquals(0, themePark.countAtractions());
        assertEquals(2, themePark.getAllReviewed().size());

        themePark.add(playground);
        assertEquals(2, themePark.countStalls());
        assertEquals(1, themePark.countAtractions());
        assertEquals(3, themePark.getAllReviewed().size());

        themePark.add(dodgems);
        assertEquals(2, themePark.countStalls());
        assertEquals(2, themePark.countAtractions());
        assertEquals(4, themePark.getAllReviewed().size());
    }

    @Test
    public void visitorCanVisitAttraction(){
        themePark.visit(visitor1, playground);
        assertEquals(1, playground.getVisitCount());
        assertEquals(1, visitor1.countVisitedAttractions());

        themePark.visit(visitor2, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitor2.countVisitedAttractions());

        themePark.visit(visitor3, playground);
        assertEquals(2, playground.getVisitCount());
        assertEquals(1, visitor3.countVisitedAttractions());


    }

}
