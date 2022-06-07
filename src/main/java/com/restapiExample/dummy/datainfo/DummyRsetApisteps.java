package com.restapiExample.dummy.datainfo;

import com.restapiExample.dummy.constants.EndPoints;
import com.restapiExample.dummy.model.DummyRestApiPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DummyRsetApisteps {
    @Step("Update all user data :name {0},salary {1},age {2},id{3}")
    public ValidatableResponse createEmployeeData(String name, String salary, String age, String id) {

        DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo();
        dummyRestApiPojo.setName(name);
        dummyRestApiPojo.setSalary(salary);
        dummyRestApiPojo.setAge(age);
        dummyRestApiPojo.setId(id);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(dummyRestApiPojo)
                .when()
                .post(EndPoints.GET_ALL_EMPLOYEES)
                .then();

    }
    @Step("Update all employee data :{0}")
    public ValidatableResponse UpdateemployeeId(int id,String name){
        DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo();
        dummyRestApiPojo.setName(name);

        return  SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",id)
                .body(dummyRestApiPojo)
                .when()
                .patch(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();


    }
    @Step("Delete employees id:{0}")
    public ValidatableResponse deleteemployeeId(int id){
        return  SerenityRest.given().log().all()
                .pathParam("employeeID",id)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }
    @Step("verify that employees id is delete:{0}")
    public ValidatableResponse verifyemployeeid(int id){
        return SerenityRest.given().log().all()
                .pathParam("employeeID",id)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE)
                .then();

    }

}
