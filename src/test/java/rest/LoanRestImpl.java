package rest;


import java.util.UUID;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static utilities.GlobalConstants.uriGetLoanByIdApi;


public class LoanRestImpl
{

	Header headerSource = new Header("x-cf-source-id","coding-challenge");
	Header headercorr = new Header("x-cf-corr-id", UUID.randomUUID().toString());

	public Response getLoanDetails(String id, boolean skipEffects)
	{
		Response response = given().header(headerSource).header(headercorr).contentType("application/json")
				.body("\n" + "{   \"loanAppUuid\":"+id+",\n" + "   \"skipSideEffects\":"+String.valueOf(skipEffects)+"}")
				.post(uriGetLoanByIdApi).thenReturn();
		return response;
	}

	public void getLoanDoesNotExistById(String id)
	{
		ValidatableResponse personal_loan = given().header(headerSource).header(headercorr).contentType("application/json").body("\n"
						+ "{   \"loanAppUuid\":"+id+",\n" + "   \"skipSideEffects\":true}")
				.post(uriGetLoanByIdApi)
				.then().statusCode(404);
	}

}
