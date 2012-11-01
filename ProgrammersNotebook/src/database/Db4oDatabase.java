package database;

import java.util.List;
import com.db4o.*;
import com.db4o.query.*;

import dataStructure.IEntry;
import dataStructure.IHeader;

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
	public List<IEntry> getByHeader(final IHeader head) {
		return db.query(new Predicate<IEntry>() {
			public boolean match(IEntry e) {
				return e.getHeader().getTitle().equals(head.getTitle());
			}
		});
	}

	@Override
	public List<IEntry> getByKeyword(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IEntry e) {
		// TODO Auto-generated method stub
	}
}
