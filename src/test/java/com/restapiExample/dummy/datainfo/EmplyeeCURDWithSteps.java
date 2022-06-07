package com.restapiExample.dummy.datainfo;

import com.restapiExample.dummy.testbase.TestBase;
import com.restapiExample.dummy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class EmplyeeCURDWithSteps extends TestBase {
    static String name = "string" + TestUtils.getRandomValue();
    static String salary="string"+ TestUtils.getRandomValue();
    static String age="string"+TestUtils.getRandomValue();
    static String id="string"+TestUtils.getRandomValue();

    static int ID;


    @Steps
   DummyRsetApisteps dummyRsetApisteps;

    @Title("This will create a new employee data")
    @Test
    public void test001() {
        dummyRsetApisteps.createEmployeeData(name, salary, age, id);
    }
    @Title("update the employee information and verify the update info ")
    @Test
    public void test002 (){
        name=name+"_update03";
        ValidatableResponse response=dummyRsetApisteps.UpdateemployeeId(ID,name);
        response.log().all();


    }
    @Title("Delete the employee and verify if the employee is deleted!")
    @Test
    public void test003() {
        dummyRsetApisteps.deleteemployeeId(ID);
        dummyRsetApisteps.verifyemployeeid(ID);

    }




}
