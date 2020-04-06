package excel;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;

public class readwriteinexcel {
	public static void main(String[] args) throws IOException {
		excellogic r = new excellogic();
		ArrayList data = excellogic.getData("Book");

		// Reading data from excel
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));

		RestAssured.baseURI = "http://216.10.245.166";
		// add book
		Response response = given().log().all().header("Content-Type", "application/json").body(map).when()
				.post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response();

		System.out.println(response);
		JsonPath js = rawToJson(response);
		String id = js.getString("ID");
		System.out.println("Book id is " + id);

		// Writing data to excel

		Write.writeData(id);

		System.out.println("data written in excel");

	}

	//reusable method to covet responce to string 
	
	public static JsonPath rawToJson(Response r) {
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		return x;
	}
}
