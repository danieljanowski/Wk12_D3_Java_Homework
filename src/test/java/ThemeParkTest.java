import attractions.Dodgems;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
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

    @Before
    public void before(){
        themePark = new ThemePark();
        iceCreamStall = new IceCreamStall("Barney's","Barry Banana", ParkingSpot.B2,7);
        candyflossStall = new CandyflossStall("Candy","Annie",ParkingSpot.A2,4);
        playground = new Playground("Slides",10);
        dodgems = new Dodgems("Dodge-ems",6);
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
}
