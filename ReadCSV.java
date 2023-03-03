import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ajthe\\IdeaProjects\\CSVInputExample\\src\\data.csv";
        File file = new File(filePath);
        String[] names = new String[100];
        int[] ages = new int[100];
        String[] cities = new String[100];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int cnt = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String city = data[2];
                names[cnt] = name;
                ages[cnt] = age;
                cities[cnt] = city;
                cnt++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        calcBerlin(cities);
    }

    public static void calcBerlin(String[] cities) {
        int numBerlin = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null && cities[i].equals("Berlin")) {
                numBerlin++;
            }
        }
        if (numBerlin == 0) {
            System.out.println("There is nobody from Berlin!");
        } else {
            System.out.println("There are " + numBerlin + " people that live in Berlin!");
        }
    }

}
