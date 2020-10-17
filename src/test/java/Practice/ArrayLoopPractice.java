package Practice;

public class ArrayLoopPractice {
    public static void main(String[] args) {
        String[] FirstName = new String[4];
        FirstName[0] = "Messi";
        FirstName[1] = "Ronaldo";
        FirstName[2] = "Neymar";
        FirstName[3] = "Lewa";

    for (int i = 1; i < FirstName.length; i = i+2)   {

        System.out.println(FirstName[i]);
    }




    }
}
