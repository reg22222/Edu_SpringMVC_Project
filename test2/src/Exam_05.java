import java.util.*;

public class Exam_05 {
	public static void main(String[] args) {
		String str = new String("aaa,100,100");
		
		StringTokenizer st = 
				new StringTokenizer(str, ",");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		/*
		Scanner sc = 
			new Scanner(str).useDelimiter("\\s*,\\s*");
		System.out.println(sc.next());
		System.out.println(sc.nextInt());
		System.out.println(sc.nextInt());
		sc.close();
		/*
		String[] data = str.split(",");
		
		for(String s : data) {
			System.out.println(s);
		}
		*/
	}
}
