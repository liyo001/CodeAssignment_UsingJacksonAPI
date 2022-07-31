package com.test.TestVagrant.TestVagrant_java;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	Team team;

	@BeforeSuite

	public void readJsonFile() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			team = mapper.readValue(new File("src/test/resources/TeamRCB.json"), Team.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void FindForeginPlayersCounts()

	{
		int j = 0;
		int expectedForeginPlayers = 4;
		for (int i = 0; i < team.getPlayer().size(); i++) {

			if (!team.getPlayer().get(i).getCountry().equals("India"))
				j++;
		}

		Assert.assertEquals(j, expectedForeginPlayers);

	}

	@Test
	public void FindWicketKeeperCounts()

	{
		int j = 0;
		int expectedWicketKeeper = 1;
		for (int i = 0; i < team.getPlayer().size(); i++) {

			if (team.getPlayer().get(i).getRole().equals("Wicket-keeper"))
				j++;
		}

		Assert.assertEquals(j, expectedWicketKeeper);

	}

}
