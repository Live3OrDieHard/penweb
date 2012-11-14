package dataStructure;

import java.util.ArrayList;

/**
 * @author tpatikorn
 * @author jfchines
 * @author awiovanna
 * @author kirkgrimsley
 * @author avenkatesh
 * 
<<<<<<< Upstream, based on origin/master
 * User should be used to identify registered user
=======
 * IUser should be used to identify user
>>>>>>> 269476b Add comments to tests and exceptions.
 */
public class User implements IUser {
	private final String loginName; // Name used for logging in. This has to be unique.
	private String displayName; // Name displayed to others on the site on examples, categories, etc
	private String password;
	private ArrayList<IExample> ownedExamples;
	private ArrayList<ICategory> ownedCategories;
	private Long id;
	
	public User (String loginName, String password, String displayName) {		
		this.loginName = loginName;
		this.password = password;
		this.displayName = displayName;
		
		this.ownedExamples = new ArrayList<IExample>();
		this.ownedCategories = new ArrayList<ICategory>();
		this.id = new Long(-1);
	}

	@Override
	public String getLoginName() {
		return this.loginName;
	}
	
	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public void changeDisplayName(String name) {
		this.displayName = name;
	}
	
	@Override
	public void changePassword(String oldPassword, String newPassword, String reenterNew) {
		if(oldPassword.equals(this.password) && newPassword.equals(reenterNew)){
		this.password = newPassword;
		}
	}
	
	public int assignId(Long id) {
		if (this.id != -1)
			return 1; // return 1 if already assigned
		else
			this.id = id;
		return 0;
	}
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Boolean checkPassword(String passwordAttempt) {
		return (passwordAttempt == this.password);
	}
	
	//XXX TODO For now these will do nothing
	////////////////////////////////////////
	@Override
	public IUser getOwner() {
		return null;
	}

	@Override
	public Long getOwnerId() {
		return null;
	}

	@Override
	public int assignOwner(IUser owner) {
		return 0;
	}
	////////////////////////////////////////
}
