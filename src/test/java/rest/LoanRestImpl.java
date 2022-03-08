package rest;


import java.util.UUID;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static utilities.GlobalConstants.getLoanByIdApiURL;


public class LoanRestImpl
{

	Header headerSource = new Header("x-cf-source-id","coding-challenge");
	Header headercorr = new Header("x-cf-corr-id", UUID.randomUUID().toString());

	public Response getLoanDetails(String id, boolean skipEffects)
	{
		Response response = given().header(headerSource).header(headercorr).contentType("application/json")
				.body("\n" + "{   \"loanAppUuid\":"+id+",\n" + "   \"skipSideEffects\":"+String.valueOf(skipEffects)+"}")
				.post(getLoanByIdApiURL).thenReturn();
		return response;
	}

	public void getLoanDoesNotExistById(String id)
	{
		ValidatableResponse personal_loan = given().header(headerSource).header(headercorr).contentType("application/json").body("\n"
						+ "{   \"loanAppUuid\":"+id+",\n" + "   \"skipSideEffects\":true}")
				.post(getLoanByIdApiURL)
				.then().statusCode(404);
	}

}
