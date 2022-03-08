package utilities;

import groovy.lang.Singleton;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Session
{
	private String firstName;
	private String password;
	private String email;
	private String amountApproved;
	private String monthlyPayment;
	private String terms;
	private String rate;
	private String APR;
}
