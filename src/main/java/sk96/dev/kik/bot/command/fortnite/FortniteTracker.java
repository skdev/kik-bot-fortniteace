package sk96.dev.kik.bot.command.fortnite;

import sk96.dev.kik.bot.utils.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FortniteTracker {
    private static final Logger L = Logger.getTextFileLogger("FortniteTracker");
    private static final String URL = "https://api.fortnitetracker.com/v1/profile";
    private final String platform;
    private final String username;
    private final String apiKey = "1b1f180f-3507-489b-9fda-4c49e7dc1dbb";

    public FortniteTracker(String platform, String username) {
        this.platform = platform;
        this.username = username;
    }

    public String getUser() {
        return post(URL + "/" + platform + "/" + username);
    }

    public String post(String url) {
        try {
            final java.net.URL url2 = new URL(url);
            final HttpURLConnection http = (HttpURLConnection) url2.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("User-Agent", "Mozilla/5.0");
            http.setRequestProperty("TRN-Api-Key", apiKey);
            http.setDoOutput(true);
            final Reader reader = new BufferedReader(new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8));
            final StringBuilder response = new StringBuilder();
            int read;
            while ((read = reader.read()) >= 0) {
                response.append((char) read);
            }
            return response.toString();
        } catch (Exception e) {
            L.error("Failed to send POST to '" + url + "' - Error: " + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }
}