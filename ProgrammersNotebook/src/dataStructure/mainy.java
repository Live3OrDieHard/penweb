package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class mainy 
{
	public static void main(String args[]) throws IOException
	{
		LinkedList<BasicExample> list = new LinkedList<BasicExample>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ExampleHeader h = new ExampleHeader();
		h.setTitle(in.readLine());
		ExampleContent c = new ExampleContent();
		c.setCode(in.readLine());
		ExampleProperties p = new ExampleProperties();
		p.setLanguage("C");
		p.setSource(null);
		if(p.getSource()==null) p.setSource("success");
		p.addTag("haha");
		p.addTag("testing");
		list.add(BasicExample.makeBasicExample(h,c,p));
		IExample e = list.get(0);
		System.out.println("Code"+((ExampleContent) e.getContent()).getCode());
		System.out.println("Title"+e.getHeader().getTitle());
		//System.out.println(e.getHeader().getAuthors().get(0).getName()); //gonna break
		System.out.println("lang"+((ExampleProperties) e.getProperties()).getLanguage());
		System.out.println("Source"+((ExampleProperties) e.getProperties()).getSource());
		System.out.println("tag"+((ExampleProperties) e.getProperties()).getTags().get(0));
	}

}
