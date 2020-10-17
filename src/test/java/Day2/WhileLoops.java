package Day2;

public class WhileLoops {
    public static void main(String[] args) {
        String[] zipCode = new String[4];
        zipCode[0] = "11432";
        zipCode[1] = "10001";
        zipCode[2] = "11218";
        zipCode[3] = "10002";

    int i = 0;
    while (i < zipCode.length){

    System.out.println("My zipcodes are "+zipCode[i]+"");
    i = i +1;

    }
    }
}
