package com.takima.adsample.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.takima.adsample.entity.AdSample;

@SpringBootTest
public class UtilParserTest {
	
	
	@Test
	void testParser() throws IOException {
		
		AdSample adSample = UtilParser.parseAdSample("./src/main/resources/ad-sample.json");
		
		assertEquals("Jean",adSample.getContacts().getFirstName());
		assertEquals("Bonneau",adSample.getContacts().getLastName());
		assertEquals("alex@terieur.fr",adSample.getContacts().getEmail());
		assertEquals("0607080910",adSample.getContacts().getPhone1().getValue());
		assertEquals("2020-01-09T09:02:22.610Z",adSample.getCreationDate());
		assertEquals(19000,adSample.getPrice());
		assertArrayEquals(new String[]{"STRENGTHS", "BOOST_VO"},adSample.getPublicationOptions());
		assertEquals("REF_CG_PGS_199617",adSample.getReference());
		assertEquals("CHINESE GENERIC",adSample.getItem().getMake());
		assertEquals("PINK GLITTER SPRAY",adSample.getItem().getModel());
		assertEquals("100ML",adSample.getItem().getVersion());
		assertEquals("SPRAY",adSample.getItem().getCategory());
		assertEquals("9-782940-199617",adSample.getItem().getEanCode());

	}
}
