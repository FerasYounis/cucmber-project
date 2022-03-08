package service;

import rest.LoanRestImpl;


public class ValidationService {


    private static LoanRestImpl loanRestImpl = new LoanRestImpl();
    public void GetLoanDetailsById(String id, boolean skipSideEffects) {
        loanRestImpl.getLoanDetails(id,skipSideEffects);
    }
}
