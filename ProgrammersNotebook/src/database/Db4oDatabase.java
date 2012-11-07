package database;

import java.util.List;
import com.db4o.*;
import com.db4o.query.*;

import dataStructure.IEntry;
import dataStructure.IExample;
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
		long id = this.getNewId();
		e.assignID(id);
		e.assignOwner(null);
		db.store(e);
	}

	@Override
	public List<IEntry> getAll() {
		return db.query(IEntry.class);
	}

	@Override
	public List<IExample> getByHeader(final String title, final IPerson owner) {

		boolean hasTitle = (title != null);
		boolean hasOwner = (owner != null);
		
		// All authors searches only work if lists are ordered the same.
		if (hasTitle && hasOwner) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return (e.getTitle().equals(title) && e.getOwnerId()==owner.getId());
				}
			});
		}
		else if (hasTitle) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return e.getTitle().equals(title);
				}
			});
		}
		else if (hasOwner) {
			return db.query(new Predicate<IExample>() {
				public boolean match(IExample e) {
					return e.getOwnerId()==owner.getId();
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

	
	/**
	 * TODO: generate it, somehow
	 */
	private Long getNewId() 
	{
		return (long) (Math.random()*1000000);
	}
}
