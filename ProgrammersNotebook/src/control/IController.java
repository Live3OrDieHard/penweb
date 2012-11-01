package control;

import database.*;
import dataStructure.*;

public interface IController 
{
	void addEntry();
	
	void addToDB(BasicExample bx);

	IProperties getProperties();
	IContent getContent();
	IHeader getHeader();
}
