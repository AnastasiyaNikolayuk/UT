import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import triangle.Triangle;

public class MyTest {
    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDYNARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // прямоугольный

    @DataProvider(name = "FirstDataProvider")
    public Object[][] createSomeData() {
        return new Object[][] {
                { TR_EQUILATERAL, new ArrayList<Double>(Arrays.asList(2.0, 2.0, 2.0)) },
                { TR_ISOSCELES, new ArrayList<Double>(Arrays.asList(3.0, 3.0, 2.0)) },
                { TR_RECTANGULAR, new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0)) },
                { TR_ORDYNARY, new ArrayList<Double>(Arrays.asList(4.5, 8.0, 6.1))}
        };
    }

    @Test(dataProvider = "FirstDataProvider")
    public void FirstTest(int type, ArrayList<Double> parameters) {
        Triangle tr = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        Assert.assertEquals(tr.checkTriangle(), true);
        Assert.assertEquals(tr.detectTriangle(), type, "Something wrong!");
    }

    @DataProvider(name = "SecondDataProvider")
    public Object[] createNullData() {
        return new Object[] {
                new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0)),
                new ArrayList<Double>(Arrays.asList(0.0, 2.0, 2.0)),
                new ArrayList<Double>(Arrays.asList(7.1, -6.0, 5.0)),
                new ArrayList<Double>(Arrays.asList(8.7, 5.9, -0.1)),
                new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0))
        };
    }

    @Test(dataProvider = "SecondDataProvider")
    public void SecondTest(ArrayList<Double> parameters) {
        Triangle tr = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        Assert.assertEquals(tr.checkTriangle(), false);
        Assert.assertEquals(tr.detectTriangle(), 0);
    }
}
