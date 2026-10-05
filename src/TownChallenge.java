import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class TownChallenge {

    public static void main(String[] args) throws Exception{

        String[] towns = new String[8];
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        File fileIn = new File("src/towns.txt");
        Scanner fileInput = new Scanner(fileIn);
        FileWriter fileOut = new FileWriter("src/results.txt", true);

        int homeScore, awayScore;
        int homes = 0, draws = 0, aways = 0;
        int thisTown = 0, numSetsOfResults = 0;


        while (fileInput.hasNextLine()) {
            towns[thisTown] = fileInput.nextLine();
            thisTown++;
        }

        System.out.print("How many sets of results would you like to generate? ");
        numSetsOfResults = keyboard.nextInt();

        for (int resultSet = 0; resultSet < numSetsOfResults; resultSet++) {

            for (int i = 0; i <4; i++) {
                homeScore = random.nextInt(10);
                awayScore = random.nextInt(10);
                System.out.printf("%-12s %3d %-12s %3d \n",
                        towns[i * 2], homeScore, towns[i * 2 + 1], awayScore);

                fileOut.write(towns[i*2] + " " + homeScore + " " + towns[i*2 + 1] + " " + awayScore + "\n");
                if (homeScore > awayScore) {
                    homes++;
                } else if (homeScore < awayScore) {
                    aways++;
                } else draws++;
            }
            System.out.printf("Homes %d, Draws %d, Aways %d \n\n", homes, draws, aways);
            fileOut.write("Homes " + homes + ", Draws " + draws + ", Aways " + aways + "\n\n");

        }
        fileOut.close();


    }
}