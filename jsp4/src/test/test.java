package test;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String, String>> List = new ArrayList<Map<String, String>>();

		Map<String, String> m = new HashMap<String, String>();
		m.put("이름", "강재성");
		m.put("나이", "27");
		List.add(m);
		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("이름", "강제성");
		for (Map<String, String> m1 : List) {
			System.out.println(m1);
		}

	}

}
