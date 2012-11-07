package database;

import java.util.List;
import com.db4o.*;
import com.db4o.query.*;

import dataStructure.IEntry;
import dataStructure.IExample;
import dataStructure.IHeader;
import dataStructure.IPerson;

/*
 * How to create a new instance of this database using IDatabase:
 * IDatabase db = new Db4oDatabase("db/localDb.yap");
 * 
 * Now you can store and query
 * db.store(anEntry);
 * List<IEntry> entries = db.getAll();
 * 
 * If you have any questions about how to use this ask Andy C <andy@wpi.edu>
 */

public class Db4oDatabase implements IDatabase {

	private ObjectContainer db;
	
	public Db4oDatabase(String path) {
		db = Db4oEmbedded.openFile(path);
	}
	
	@Override
	public void store(IEntry e) {
		db.store(e);
	}

	@Override
	public List<IEntry> getAll() {
		return db.query(IEntry.class);
	}

	@Override
	public List<IExample> getByHeader(final IHeader head) {
		final String title = head.getTitle();
		final List<IPerson> authors = head.getAuthors();

		boolean hasTitle = (title != null);
		boolean hasAuthors = (authors != null);
		
		// All authors searches only work if lists are ordered the same.
		if (hasTitle && hasAuthors) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return (e.getHeader().getTitle().equals(title) && e.getHeader().getAuthors().equals(authors));
				}
			});
		}
		else if (hasTitle) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return e.getHeader().getTitle().equals(head.getTitle());
				}
			});
		}
		else if (hasAuthors) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return e.getHeader().getAuthors().equals(authors);
				}
			});
		}
		else return db.query(IExample.class);
	}

	@Override
	public List<IExample> getByKeyword(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IEntry e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void close() {
		db.close();
	}

	/* (non-Javadoc)
	 * @see database.IDatabase#getAllExample()
	 */
	@Override
	public List<IExample> getAllExample() {
		return db.query(IExample.class);
	}
}
