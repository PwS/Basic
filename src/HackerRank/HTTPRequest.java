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


                result.addAll(titlesFrom(response.toString()));

                in.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Returns each article's title, or its story_title when the title is null.
     * Articles with neither are skipped.
     * <p>
     * The API returns JSON null for missing titles. getString() throws on null, which
     * used to abort the whole loop and return an empty list, so optString() is used instead.
     */
    static List<String> titlesFrom(String json) {
        List<String> titles = new ArrayList<>();
        JSONArray articles = new JSONObject(json).getJSONArray("data");
        for (int i = 0; i < articles.length(); i++) {
            JSONObject article = articles.getJSONObject(i);
            String title = article.optString("title", null);
            String storyTitle = article.optString("story_title", null);
            if (title != null) {
                titles.add(title);
            } else if (storyTitle != null) {
                titles.add(storyTitle);
            }
        }
        return titles;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(topArticle("olalonde", 1));
    }
}
