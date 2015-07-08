//package autotask.helloworld;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import net.autotask.atws.v1_5.ATWS;
import net.autotask.atws.v1_5.ATWSResponse;
import net.autotask.atws.v1_5.ATWSSoap;
import net.autotask.atws.v1_5.ATWSZoneInfo;
import net.autotask.atws.v1_5.CreateResponse;
import net.autotask.atws.v1_5.Entity;
import net.autotask.atws.v1_5.Field;
import net.autotask.atws.v1_5.Account;
import net.autotask.atws.v1_5.Create;
import net.autotask.atws.v1_5.ArrayOfEntity;


public class HelloWorldClient {
	// Initiate the webservice
	@WebServiceRef(wsdlLocation = "https://webservices2.autotask.net/atservices/1.5/atws.wsdl")
	private static ATWS service = new ATWS();

	public static void main(String[] args) {
		ATWSSoap port = service.getPort(ATWSSoap.class);
		// Set the credentials for authentication
		BindingProvider prov = (BindingProvider) port;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
		                             "PPierce@OneBillSandbox.com");
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
		                             "12345");
		ATWSZoneInfo zone = port.getZoneInfo("username");
		System.out.println(zone.getURL().hashCode() + "hhh");
		System.out.println("hello");


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

		net.autotask.atws.v1_5.Entity  accounttocreate = account;
		net.autotask.atws.v1_5.Entity [] array = {accounttocreate};

		ArrayOfEntity entityarray = new ArrayOfEntity();
		entityarray.equals(accounttocreate);

		Create create = new Create();

		create.setEntities(entityarray);
		ATWSResponse response = new ATWSResponse();
		CreateResponse createresponse = new CreateResponse();
		response = createresponse.getCreateResult();

	}
}
