package com.gopi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api")
public class PhoneContoller {
	
	public static final String ACCOUNT_SID = "AC8848585cb904a2b89681ec8ccdf39010";
	public static final String AUTH_TOKEN = "youhave to past your twilo Auth Token ";
	public static final String FROM_NUMBER = "+15417256893";
	public static final String TO_NUMBER = "+917702776595";
	
	static {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}
	@GetMapping("/voicecall")
	public String makeVoiceCall() throws URISyntaxException {
		
		String twimlResponse = "https://handler.twilio.com/twiml/EHf0ff95b514292c648c780138774df083";
		
		

		
		Call call = Call
			      .creator(
			        new PhoneNumber(TO_NUMBER),
			        new PhoneNumber(FROM_NUMBER),
			        new URI(twimlResponse)
			      )
			      .create();

			    System.out.println(call.getSid());
				return "check your phone";
	}
}
