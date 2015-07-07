package autotask.helloworld;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import net.autotask.atws.v1_5.ATWS;
import net.autotask.atws.v1_5.ATWSSoap;
import net.autotask.atws.v1_5.ATWSZoneInfo;

public class HelloWorldClient {
	// Initiate the webservice
	@WebServiceRef(wsdlLocation = "https://webservices2.autotask.net/atservices/1.5/atws.wsdl")
	private static ATWS service = new ATWS();

	public static void main(String[] args) {
		ATWSSoap port = service.getPort(ATWSSoap.class);
		// Set the credentials for authentication
		BindingProvider prov = (BindingProvider) port;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
				"username");
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
				"password");
		ATWSZoneInfo zone = port.getZoneInfo("username");
		System.out.println(zone.getURL());
	}
}
