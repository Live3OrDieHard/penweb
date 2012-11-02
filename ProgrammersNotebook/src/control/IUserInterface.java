package control;

import dataStructure.*;

public interface IUserInterface {
	void show();
	IHeader getHeader();
	IContent getContent();
	IProperties getProperties();
	void init();

}
