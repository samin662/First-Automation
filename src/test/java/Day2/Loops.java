package Day2;

public class Loops {
    public static void main(String[] args) {

        String[] zipCode = new String[4];
        zipCode[0] = "11432";
        zipCode[1] = "10001";
        zipCode[2] = "11218";
        zipCode[3] = "10002";

      for (int i = 0;i<4;i++){ //++ is the same as +1
//int i+1 = to skip specific intervals
System.out.println("My zipcodes are "+zipCode[i]+"");
        }
    }
}