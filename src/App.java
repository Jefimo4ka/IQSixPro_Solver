import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.SwingUtilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {
    final static String FIGURES_JSON_PATH = "./static/figures.json";

    // private final int[][] mapMatrix = {
    // { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
    // { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    // { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    // { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    // { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    // { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
    // };
    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> new SolverUI());
        // String figures = readFigures();

        // System.out.println(figures);
    }

    static String readFigures() {
        String result = "";
        try {
            // Create a Path object from the file path
            Path path = Paths.get(FIGURES_JSON_PATH);

            // Read all lines from the file into a List of Strings
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            // Print the content of the file
            for (String line : lines) {
                result += line + "\n";
            }
            JSONObject json = new JSONObject(result);

            JSONArray figures = json.getJSONArray("figures");

            for (int i = 0; i < figures.length(); i++) {
                // Get the i-th figure object
                JSONObject figureObject = figures.getJSONObject(i);

                // Access properties of the figure
                int size = figureObject.getInt("size");
                String color = figureObject.getString("color");
                JSONArray matrixArray = figureObject.getJSONArray("matrix");

                // Print information about the figure
                System.out.println("Figure " + (i + 1) + ":");
                System.out.println("Size: " + size);
                System.out.println("Color: " + color);

                // Access and print the matrix elements
                System.out.println("Matrix:");
                for (int row = 0; row < matrixArray.length(); row++) {
                    JSONArray rowArray = matrixArray.getJSONArray(row);
                    for (int col = 0; col < rowArray.length(); col++) {
                        int element = rowArray.getInt(col);
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }

                System.out.println(); // Add a newline for better readability
            }

        } catch (IOException e) {
            // Handle the exception appropriately (e.g., print an error message)
            e.printStackTrace();
        }

        return "result";
    };
}
