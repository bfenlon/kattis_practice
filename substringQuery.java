import java.io.File;
import java.util.*;
import java.io.IOException;

public class anothersubstringqueryproblem {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        File test = new File("/Users/bryce/input.txt");
        Scanner sc = new Scanner(test);

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String master = lines.get(0);
        int numQueries = Integer.parseInt(lines.get(1));
        lines = lines.subList(2, lines.size());
        Object[][] queries = new Object[numQueries][2];
        int[] answers = new int[numQueries];

        for (int i=0; i<numQueries; i++) {
            String[] tokens = lines.get(i).split("\\s");
            queries[i][0] = tokens[0];
            queries[i][1] = Integer.parseInt(tokens[1]);
        }

        for (int j=0; j<queries.length; j++) {
            int occ = 0;
            int pos = -1;
            String subString = (String)queries[j][0];
            int targetOcc = (int)queries[j][1];
            while (occ < targetOcc) {
                int curIndex = master.indexOf(subString, pos);
                if (curIndex > -1) {
                    occ++;
                    pos = curIndex+1;
                } else {
                    break;
                }
            }
            answers[j] = pos;
        }
        for(int ans : answers) {
            System.out.println(ans);
        }
    }
}

