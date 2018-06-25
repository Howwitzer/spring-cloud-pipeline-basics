package com.example.messageservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.BDDMockito;

import java.util.Optional;

public abstract class BaseTestClass {

	@Before
	public void setup() {
		MessageController messageController = new MessageController(mockedQuoteRepository());
	    RestAssuredMockMvc.standaloneSetup(messageController);
	}

	private QuoteRepository mockedQuoteRepository() {
        QuoteRepository quoteRepository = BDDMockito.mock(QuoteRepository.class);
        BDDMockito.given(quoteRepository.findById(1)).willReturn(Optional.of(new Quote(1, "to be or not to be", "Shakesheeper")));
        BDDMockito.given(quoteRepository.findRandomQuote()).willReturn(new Quote(0, "whatever", "foo"));
        return quoteRepository;
    }
}