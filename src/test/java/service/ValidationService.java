package service;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import rest.LoanRestImpl;


public class ValidationService {

    private static LoanRestImpl loanRestImpl = new LoanRestImpl();
    public void GetLoanDetailsById(String id, boolean skipSideEffects) {
        Response response = loanRestImpl.getLoanDetails(id,skipSideEffects);
        JsonPath jsonPathEvaluator = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(),200);

        String productType = jsonPathEvaluator.get("loanAppResumptionInfo.productType");
        Assert.assertTrue(productType.equalsIgnoreCase("PERSONAL_LOAN"));

        String sourceSystem = jsonPathEvaluator.get("loanAppResumptionInfo.sourceSystem");
        Assert.assertTrue(sourceSystem.equalsIgnoreCase("PARTNER_FUNNEL_V2"));

        String firstName = jsonPathEvaluator.get("loanAppResumptionInfo.borrowerResumptionInfo.firstName");
        Assert.assertTrue(firstName.equalsIgnoreCase("Benjamin"));
    }

    public void GetLoanDetailsById(String id)
    {
        loanRestImpl.getLoanDoesNotExistById(id);
    }
}
