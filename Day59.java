/* Encode and Decode TinyURL , HashMap */

import java.util.HashMap;
import java.util.Map;

public class Day59 {
    private Map<String, String> urlMap;
    private String baseUrl;
    private int count;

    public Day59() {
        urlMap = new HashMap<>();
        baseUrl = "http://tinyurl.com/";
        count = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlMap.containsKey(longUrl)) {
            return urlMap.get(longUrl);
        }

        String shortUrl = baseUrl + count++;
        urlMap.put(longUrl, shortUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] parts = shortUrl.split("/");
        String key = parts[parts.length - 1];

        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            if (entry.getValue().equals(shortUrl)) {
                return entry.getKey();
            }
        }

        return ""; // Return an empty string or handle error as needed.
    }
    public static void main(String[] args) {
        Day59 codec = new Day59();

        String longUrl = "https://leetcode.com/problems/encode-and-decode-tinyurl/description/";

        String shortUrl = codec.encode(longUrl);
        System.out.println("Short URL: " + shortUrl);

        String decodedUrl = codec.decode(shortUrl);
        System.out.println("Decoded URL: " + decodedUrl);
        /*
         OutPut:
         Short URL: http://tinyurl.com/0
		 Decoded URL: https://leetcode.com/problems/encode-and-decode-tinyurl/description/
         */

    }
}

