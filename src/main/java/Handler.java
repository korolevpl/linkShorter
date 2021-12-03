import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;

public class Handler {
    HashMap<String, String> links = new HashMap<>();

    public String generateShortLink (String link) {
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    public String getShortLink(String longLink) {
        if (!links.isEmpty()) {
            if (links.containsKey(longLink)) {
                for (String value : links.values()) {
                    if (!value.equals(longLink)) {
                        String shortLink = generateShortLink(longLink);
                        links.put(shortLink, longLink);
                    }
                    return links.get(value);
                }
            }
        }
        return "URL not found";
    }

    public String getLongLink(String shortLink) {
        if (!links.isEmpty()) {
            if (links.containsKey(shortLink)) {
                for (String key : links.keySet()) {
                    if (key.equals(shortLink)) {
                        return links.get(key);
                    }
                }
            }
        }
        return "URL not found";
    }
}
