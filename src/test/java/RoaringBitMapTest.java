import commonStuffs.Compare2BigListsOfLong;
import commonStuffs.StringUsing;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Thanh Mai on 5/15/2018.
 */
public class RoaringBitMapTest {
    @Test
    public void test() {
    	Set<Long> listTrans1 = new TreeSet<>();
		Set<Long> listTrans2 = new TreeSet<>();
		for (int i = 1; i < 20; i++) {
			if (i%4==0)
				listTrans1.add((long) i);
			if (i%2==0)
				listTrans2.add((long) i);
		}
		
		String trans1 = listTrans1.stream().map(e -> e.toString()).collect(Collectors.joining(","));
		String trans2 = listTrans2.stream().map(e -> e.toString()).collect(Collectors.joining(","));
		System.out.println(trans1);
		System.out.println(trans2);
		System.out.println("--------------");
		Compare2BigListsOfLong.compare2BigList(listTrans1, listTrans2);
    }

}
