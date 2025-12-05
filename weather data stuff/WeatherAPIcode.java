import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class WeatherAPIcode {
    public static void main(String[] args) {
        try {
            String location = "Jeddah Corniche Circuit, Jeddah, Saudi Arabia";
            String apiKey = "DTGW9QTPVB3XGNRMQYTL8PQZK";
            String unitGroup = "metric";
            String contentType = "csv";

            String urlString = String.format(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/2010-01-01/2025-12-4?unitGroup=%s&elements=datetime,description,offset,precip,precipcover,precipprob,preciptype,snow,snowdepth,source,stations,sunriseEpoch,sunsetEpoch,temp,tempmax,tempmin&include=days&months=7&key=%s&contentType=%s",
                location.replace(" ", "%20"), unitGroup, apiKey, contentType);
            
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.printf("GET request failed. Response Code: %d%n", responseCode);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // NEW: Output file writer
            String fileName = "jeddah.csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                writer.write(inputLine);
                writer.newLine();  // ensure proper CSV formatting
            }

            writer.close();
            in.close();

            System.out.println("CSV file successfully saved as: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}