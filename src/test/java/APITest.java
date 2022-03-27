import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;

public class APITest {

    @Test
    void testGET() {
        String BASE_URL = "https://reqres.in/api/";
        Response response = RestAssured.get(BASE_URL + "users?page=2");
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println((Integer) JsonPath.from(response.body().asString()).get("page"));
        List<LinkedHashMap> datas = JsonPath.from(response.body().asString()).getList("data");

        for (LinkedHashMap data : datas) {
            System.out.println(data.get("email"));
        }

    }
}

