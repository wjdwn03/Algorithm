import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, String> map = new HashMap<>();
        
        map.put("M", "MatKor");
        map.put("W", "WiCys");
        map.put("C", "CyKor");
        map.put("A", "AlKor");
        map.put("$", "$clear");
        
        String input = br.readLine();

        System.out.println(map.get(input));

	}

}