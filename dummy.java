import java.util.*;

public class dummy {

	public static void main(String[] args) {
	    ArrayList<group> groups = new ArrayList<group>();
	    
		group g1 = new group();
		g1.setName("mantej");
		group g2 = new group();
		g2.setName("baldwin");
		group g3 = new group();
		g3.setName("aaron");
		group g4 = new group();
		g4.setName("penny");
		
		groups.add(g1);
		groups.add(g2);
		groups.add(g3);
		groups.add(g4);
		
		for(int i = 0; i < groups.size(); i++) {
			System.out.println((groups.get(i)).getName());
		}
			System.out.println(g1.getGoals());
	}

}
