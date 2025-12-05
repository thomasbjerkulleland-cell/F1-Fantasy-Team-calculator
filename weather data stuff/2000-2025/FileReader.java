import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class FileReader {
    static String filepath = "abu_dhabi.csv";
    static String searchMonth = "12";
    static int mode = 2; // 1: standardFile, 2: noNameFile, 3: noQuotesName
    static double threshhold = 2.0;
    static int checked = 0;
    static int rainDays = 0;

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        if(mode == 1){
            data = standardFile(filepath);
        } else if(mode == 2){
            data = noNameFile(filepath);
        } else if(mode == 3){
            data = noQuotesName(filepath);
        }

        // Process the data (e.g., print it)
        for (String line : data) {
            System.out.println(line);
        }
        System.out.println("Total days checked: " + checked);
        System.out.println("Total rainy days: " + rainDays);
        System.out.println("Rainy days percentage: " + ((double) rainDays / checked) * 100 + "%");
    }

    private static ArrayList<String> standardFile(String filename){
        ArrayList<String> temp = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filepath))) {
            scanner.nextLine(); // Skip header line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceFirst("^\"[^\"]*\",", "");
                String[] values = line.split(","); // Split by comma
                if(values[0].split("-")[1].equals(searchMonth)) {
                    checked++;
                    if(Double.parseDouble(values[4]) >= threshhold){
                        rainDays++;
                        temp.add(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    private static ArrayList<String> noNameFile(String filename){
        ArrayList<String> temp = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filepath))) {
            scanner.nextLine(); // Skip header line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //line = line.replaceFirst("^\"[^\"]*\",", "");
                String[] values = line.split(","); // Split by comma
                if(values[0].split("-")[1].equals(searchMonth)) {
                    checked++;
                    if(Double.parseDouble(values[4]) >= threshhold){
                        rainDays++;
                        temp.add(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    private static ArrayList<String> noQuotesName(String filename){
        ArrayList<String> temp = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filepath))) {
            scanner.nextLine(); // Skip header line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //line = line.replaceFirst("^\"[^\"]*\",", "");
                String[] values = line.split(","); // Split by comma
                if(values[1].split("-")[1].equals(searchMonth)) {
                    checked++;
                    if(Double.parseDouble(values[5]) >= threshhold){
                        rainDays++;
                        temp.add(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}