package control;

import dataStructure.*;

public interface IUserInterface {
	void show();
	void init();
	String getTitle();
	String getAuthor();
	String getCode();
	IProperties getProperties();

}
