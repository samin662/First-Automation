package ActionItems;

public class CitiesWhileLoop {
    public static void main(String[] args) {
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Staten Island";

        int i = 0;
        while (i < cities.length) {

            if (cities[i] == "Brooklyn") {
                System.out.println(cities[i]);

            } else if (cities[i] == "Manhattan") {
                System.out.println(cities[i]);

            }
i = i+1;

        }
    }}