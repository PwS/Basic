package HackerRank;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.*;

class HTTPRequest {
    private static List<String> topArticle(String username, int limit) throws IOException {
        String userName = "UNKNOWN";

        List<String> result = new ArrayList<>();

        if (username != null) {
            userName = username;
        }

        final String baseUrl = "https://jsonmock.hackerrank.com/api/articles?author=" + userName + "&page=" + limit;


        try {
            URL url = new URL(baseUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }


                JSONObject jsonObject = new JSONObject(response.toString());

                List<HashMap> list = new ArrayList<>();
                JSONArray array = jsonObject.getJSONArray("data");
                for (int i = 0; i < array.length(); i++) {
                    HashMap<String, String> value = new HashMap<>();
                    value.put("title", array.getJSONObject(i).getString("title"));
                    value.put("story_title", array.getJSONObject(i).getString("story_title"));

                    list.add(value);
                }

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).get("title") == "null" && list.get(i).get("story_title") == "null") {
                    } else {
                        String value = (list.get(i).get("title") != "null" ? list.get(i).get("title") : list.get(i).get("story_title")).toString();
                        result.add(value);
                    }

                }

                in.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(topArticle("olalonde", 1));
    }
}
