package com.emil.calculator;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.wsdl.Add;
import calculator.wsdl.AddResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	public AddResponse add(int intA, int intB) {
		Add request = new Add();
		request.setIntA(intA);
		request.setIntB(intB);

		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.dneonline.com/calculator.asmx", request, new SoapActionCallback("http://tempuri.org/Add"));
		return response;
	}

}
