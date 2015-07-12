package autotask.helloworld;

import java.util.List;

import javax.xml.ws.BindingProvider;

import net.autotask.atws.v1_5.ATWS;
import net.autotask.atws.v1_5.ATWSResponse;
import net.autotask.atws.v1_5.ATWSSoap;
import net.autotask.atws.v1_5.Account;
import net.autotask.atws.v1_5.ArrayOfEntity;
import net.autotask.atws.v1_5.Entity;

public class HelloWorldClient {
	// Initiate the webservice
	private static ATWS service = new ATWS();

	public static void main(String[] args) {
		ATWSSoap port = service.getPort(ATWSSoap.class);
		// Set the credentials for authentication
		BindingProvider prov = (BindingProvider) port;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
				"PPierce@OneBillSandbox.com");
		prov.getRequestContext()
				.put(BindingProvider.PASSWORD_PROPERTY, "12345");
		prov.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"https://webservices2.autotask.net/ATServices/1.5/atws.asmx");
		// ATWSZoneInfo zone = port.getZoneInfo("PPierce@OneBillSandbox.com");
		// System.out.println("Zone info is " + zone.getURL());

		Account account = new Account();
		account.setAccountName("Aditya Jain");
		account.setAccountNumber(39233203);
		account.setId(0);
		account.setAccountType(0);
		account.setCountry("United States");
		account.setOwnerResourceID(29682885);
		account.setPhone("89999999");
		account.setAccountType(2);
		account.setActive(true);
		account.setClientPortalActive(false);
		account.setTaskFireActive(false);
		account.setTaxExempt(false);
		account.setCountryID(237);
		account.setBillToAddressToUse(1);
		account.setBillToCountryID(237);

		ArrayOfEntity accountArray = new ArrayOfEntity();
		accountArray.getEntity().add(account);

		ATWSResponse response = port.create(accountArray);
		List<Entity> results = response.getEntityResults().getEntity();
		Account resAccount = (Account) results.get(0);

		System.out.println("Create account response - "
				+ response.getReturnCode() + "," + resAccount.getId() + ","
				+ resAccount.getAccountName());
	}
}
