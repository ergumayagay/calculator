package com.emil.calculator;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.wsdl.Add;
import calculator.wsdl.AddResponse;
import calculator.wsdl.Divide;
import calculator.wsdl.DivideResponse;
import calculator.wsdl.Multiply;
import calculator.wsdl.MultiplyResponse;
import calculator.wsdl.Subtract;
import calculator.wsdl.SubtractResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	//intA + intB
	public AddResponse add(int intA, int intB) {
		Add request = new Add();
		request.setIntA(intA);
		request.setIntB(intB);
		
		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.dneonline.com/calculator.asmx", request, new SoapActionCallback("http://tempuri.org/Add"));
		return response;
	}
	
	//intA - intB
	public SubtractResponse subtract(int intA, int intB) {
		Subtract request = new Subtract();
		request.setIntA(intA);
		request.setIntB(intB);
		
		SubtractResponse response  = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.dneonline.com/calculator.asmx", request, new SoapActionCallback("http://tempuri.org/Subtract"));
		return response;
	}
	
	//intA * intB
	public MultiplyResponse multiply(int intA, int intB) {
		Multiply request = new Multiply();
		request.setIntA(intA);
		request.setIntB(intB);
		
		MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.dneonline.com/calculator.asmx", request, new SoapActionCallback("http://tempuri.org/Multiply"));
		return response;
	}
	
	//intA / intB
	public DivideResponse divide(int intA, int intB) {
		Divide request = new Divide();
		request.setIntA(intA);
		request.setIntB(intB);
		
		DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.dneonline.com/calculator.asmx", request, new SoapActionCallback("http://tempuri.org/Divide"));
		return response;
	}

}
