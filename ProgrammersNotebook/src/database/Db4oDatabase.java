package database;

import java.util.List;
import com.db4o.*;
import com.db4o.query.*;

import dataStructure.IEntry;
import dataStructure.IHeader;

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

}
