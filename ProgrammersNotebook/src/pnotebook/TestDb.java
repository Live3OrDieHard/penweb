package pnotebook;


import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;


public class TestDb {
	public static void main(String args[]) {
		// Create a new entry object
		Entry entry1 = new BasicEntry("Example 1", "This is some code!\nIt is very cool!");
		Entry entry2 = new BasicEntry("Example 2", "This is another test entry.\nPretend this is code");
		
		// Open the database
		ObjectContainer db = Db4oEmbedded.openFile("db/testDb.yap");
		
		// Store our two entries
		//db.store(entry1);
		//db.store(entry2);
		// Commented out because they are already in the DB
		
		// Try to retrieve entry2 by matching its title
		List<Entry> entries = db.query(new Predicate<Entry>() {
			public boolean match(Entry e) {
				return e.getTitle().equals("Example 2");
			}
		});
		
		// Print out the body text for example 2
		if (entries.isEmpty())
			System.out.println("Query returned no entries.");
		else
			System.out.println(entries.get(0).getBody());
		
		db.close();
	}
}
