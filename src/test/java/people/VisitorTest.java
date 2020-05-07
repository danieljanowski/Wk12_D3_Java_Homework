package people;

import attractions.Dodgems;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Playground playground;
    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        playground = new Playground("Slides",10);
        dodgems = new Dodgems("Dodge-ems",6);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void canAddVisitedAttraction(){
        visitor.addVisited(playground);
        visitor.addVisited(dodgems);
        assertEquals(2,visitor.countVisitedAttractions());
    }
}
