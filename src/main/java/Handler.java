import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Handler {
    HashMap<String, String> links = new HashMap<>();
    String shortLink;
    String longLink;

    public String generateShortLink (String link) throws MalformedURLException {
        /*
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.US_ASCII);
        */

        String alphabet = "abcdefghijklmnopqrstuvwyz";
        char[] array = new char[5];
        for (int i=0; i<array.length; i++) {
            int index = new Random().nextInt(alphabet.length());
            array[i] = alphabet.charAt(index);
        }

        URL url = new URL(link);
        String protocol = url.getProtocol();
        String host = url.getHost();
        String domain = host.substring(host.lastIndexOf(".") + 1);

        return protocol + "://" + String.valueOf(array) + "." + domain;
    }

    public String getShortLink(String longLink) {
        if (!links.isEmpty()) { // если словарь не пустой
            if (links.containsValue(longLink)) {  // если словарь содержит искомое значение
                for (Map.Entry<String, String> entry : links.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (value.equals(longLink)) {
                        shortLink = key;
                    }
                }
            }
        }


        try {
            shortLink = generateShortLink(longLink);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        links.put(shortLink, longLink);
        return shortLink;
    }

    public String getLongLink(String shortLink) {
        if (!links.isEmpty()) {
            if (!links.containsKey(shortLink)) {
                return "This short link not found. Try again.";
            }
            for (String key : links.keySet()) {
                if (key.equals(shortLink)) {
                    longLink = links.get(key);
                    break;
                }
            }
        }
        return longLink;
    }
}
