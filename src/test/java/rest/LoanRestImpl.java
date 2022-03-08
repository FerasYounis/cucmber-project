package rest;


import java.util.UUID;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


public class LoanRestImpl
{

	public Response getLoanDetails(String id, boolean skipEffects)
	{
//		Response response = (Response) RestAssured.post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret)");
		Header headerSource = new Header("x-cf-source-id","coding-challenge");
		Header headercorr = new Header("x-cf-corr-id", UUID.randomUUID().toString());
		Header headercorr2 = new Header("x-cf-corr-id", "Any random UUID");


		ValidatableResponse personal_loan = given().header(headerSource).header(headercorr).contentType("application/json").body("\n"
				+ "{   \"loanAppUuid\":"+id+",\n" + "   \"skipSideEffects\":"+String.valueOf(skipEffects)+"}")
				.post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret")
				.then().statusCode(200).body("loanAppResumptionInfo.productType", equalTo("PERSONAL_LOAN"))
				.body("loanAppResumptionInfo.borrowerResumptionInfo.firstName",not("Feras"));
		return null;
	}
}
