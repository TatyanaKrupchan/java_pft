package src.mathematics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class DistanceTest {

    @Test
    public void PointsDistanceTest() {
        Point p1 = new Point(5, 10);
        Point p2 = new Point(-8.25, -9.856);
        Point p3 = new Point(0, 0);

        Assert.assertTrue(p1.distance(p2) >= 0, "Distance between p1 and p2 < 0");
        Assert.assertEquals(p1.distance(p2), 23.870970570967574296227365337104);

        Assert.assertTrue(p1.distance(p3) >= 0, "Distance between p1 and p2 < 0");
        Assert.assertEquals(p1.distance(p3), 11.180339887498949);

        Assert.assertTrue(p2.distance(p3) >= 0, "Distance between p1 and p2 < 0");
        Assert.assertEquals(p2.distance(p3), 12.853141094689656);

    }
}
