package pnotebook;

import java.util.List;
import com.db4o.*;

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
	public List<IEntry> getByHeader(IHeader head) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntry> getByKeyword(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
