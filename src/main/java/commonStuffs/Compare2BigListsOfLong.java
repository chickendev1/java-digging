package commonStuffs;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import org.roaringbitmap.RoaringBitmap;

/**
 * Created by Thanh Mai on 5/15/2018.
 */
public class Compare2BigListsOfLong {
	public static void compare2BigList(Set<Long> listTrans1, Set<Long> listTrans2) {
		RoaringBitmap bitmap1 = new RoaringBitmap();
	    for (Long transId : listTrans1) {
	      bitmap1.add(transId.intValue());
	    }

	    long t2 = System.currentTimeMillis();
	    RoaringBitmap bitmap2 = new RoaringBitmap();
	    for (Long transId : listTrans2) {
	      bitmap2.add(transId.intValue());
	    }
	    
	    RoaringBitmap same = RoaringBitmap.and(bitmap1, bitmap2);
	    
	    for (int i : same) {
	    	System.out.println(i);
	    }
	    
	    System.out.println("---------or1------------");
	    RoaringBitmap diff1 = RoaringBitmap.or(bitmap1, bitmap2);
	    for (int i : diff1) {
	    	System.out.println(i);
	    }
	    
	    System.out.println("---------or2------------");
	    RoaringBitmap diff2 = RoaringBitmap.or(bitmap2, bitmap1);
	    for (int i : diff2) {
	    	System.out.println(i);
	    }

	}

	private void init2List() {
		Set<Integer> listTrans1 = new TreeSet<>();
		Set<Integer> listTrans2 = new TreeSet<>();

		for (int i = 0; i < 5; i++) {
			int transId1 = ThreadLocalRandom.current().nextInt(0, 9999999 + 1);
			listTrans1.add(transId1);
			int transId2 = ThreadLocalRandom.current().nextInt(0, 9999999 + 1);
			listTrans2.add(transId2);
		}

		System.out.println("Size of list 1: " + listTrans1.size());
		System.out.println("Size of list 2: " + listTrans2.size());
	}
}
