import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class ReadJsonFile {

	String config_path = System.getProperty("user.dir") + File.separator + "SampleFiles" + File.separator
			+ "TeamRCB.json";

	@Test
	public void countof_foreginPlayers() {

		try {

			String exampleRequest = FileUtils.readFileToString(new File(config_path), StandardCharsets.UTF_8);

			DocumentContext documentContext = JsonPath.parse(exampleRequest);
			JsonPath jsonPath = JsonPath.compile("$..player[?(@.country!=\"India\")]");

			List<Map<String, String>> jsonList = documentContext.read(jsonPath);

			int countof_forginPlaycount = jsonList.size();
			Assert.assertEquals(countof_forginPlaycount, 4);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void countof_WicketKeeper() {

		try {
			String exampleRequest = FileUtils.readFileToString(new File(config_path), StandardCharsets.UTF_8);

			DocumentContext documentContext = JsonPath.parse(exampleRequest);
			JsonPath jsonPath = JsonPath.compile("$..player[?(@.role == 'Wicket-keeper')]");

			List<Map<String, String>> jsonList = documentContext.read(jsonPath);

			int countof_wicketkeeper = jsonList.size();
			Assert.assertEquals(countof_wicketkeeper, 1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
