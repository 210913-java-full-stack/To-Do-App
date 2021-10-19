package collections;

import org.junit.*;

public class MyLinkedListTest {
    /*
    SUT: add(T t, int index);

    add an element at some index
    check to see if the element at index x is that element we added - done
    check if size has grown - done
    check element, prev, next, head, and tail are valid. -
        this would be great, but is too much for our purposes today
    check to see if input/output matches correct type(check generics).

    test to make sure it fails properly!
    try to throw indexoutofbound exception
     */


    //The Three A's
    //Arrange
    //Act
    //Assert

    private MyLinkedList<String> sut;

    @BeforeClass //before ALL tests have started
    public static void beforeClass() {
        //setup stuff
    }

    @AfterClass //after ALL tests completed
    public static void afterClass() {
        //tear-down stuff here
    }

    @Before //before each test starts
    public void before() {
        sut = new MyLinkedList<String>();
    }

    @After //after each test completes
    public void after() {
        sut = null;
    }

    @Test
    public void Test_addElementToListIsValid() {
        //Arrange
        /*
        we're going to pretend that we've already tested add(T t);
        This way our current test can validly rely upon it.
         */
        sut.add("0");
        sut.add("1");
        //we will be using index 2 to test
        sut.add("3");
        sut.add("4");

        //Act
        Assert.assertEquals(sut.size(), 4);
        Assert.assertEquals(sut.get(2), "3");
        sut.add("2", 2);

        //Assert
        Assert.assertEquals(sut.size(), 5);
        Assert.assertEquals(sut.get(2), "2");
        Assert.assertEquals(sut.get(2).getClass(), String.class);


    }


    //how we test for exceptions in Junit 4 (it's different in Junit 5!)
    @Test(expected = IndexOutOfBoundsException.class)
    public void Test_addElementLessThanZeroThrowsException() {
        //Arrange
        //MyLinkedList<String> sutLinkedList = new MyLinkedList<>();
        //no longer need to do this here, we are resetting out sut (the list)
        //with every test using @Before and @After annotated methods

        //Act
        sut.add("test", -5);

        //Assert
        //don't need to assert here because Junit 4 uses the above expected exception for
        //the test. In JUnit 5 we would use assertThrows().
    }

    //how we test for exceptions in Junit 4 (it's different in Junit 5!)
    @Test(expected = IndexOutOfBoundsException.class)
    public void Test_addElementGreaterThanBoundThrowsException() {
        //Arrange
        //MyLinkedList<String> sutLinkedList = new MyLinkedList<>();
        //no longer need to do this here, we are resetting out sut (the list)
        //with every test using @Before and @After annotated methods

        //Act
        sut.add("test", 5);

        //Assert
        //don't need to assert here because Junit 4 uses the above expected exception for
        //the test. In JUnit 5 we would use assertThrows().
    }


}
