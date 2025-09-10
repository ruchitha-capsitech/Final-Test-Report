package gettingStarted.practice;

import org.testng.annotations.Test;

public class TestingUsingTestngTest {
    @Test(priority = 2,groups = {"a"})
    public void test()
    {
        System.out.println(12-3);
    }
    @Test(dependsOnMethods = {"test"})
    public void testAddition() {
        System.out.println(2+8);
    }
@Test(priority = 1)
    public void testAddition2() {
        System.out.println(2+9);
}
}
