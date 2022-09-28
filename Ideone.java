package search_word;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.List;
import java.util.Scanner;

public class Ideone {	
	static class trie
	{
	    trie[] child=new trie[26];
	    boolean isword;
	    trie()
	    { isword=false;
	        for(int i=0;i<26;i++)
	        {
	            child[i]=null;
	        }
	    }
	};static trie root;
	    static void insert(String words)
	    {	
	      
	        if(root==null)
	        {
	        	root=new trie();
	        }
	        trie temp = root;
	        for(int i=0;i<words.length();i++)
	        {
	            int index=words.charAt(i)-'a';
	            if(temp.child[index]==null)
	            {
	                temp.child[index]=new trie();
	            }
	            temp=temp.child[index];
	        }
	        temp.isword=true;
	 
	    }
	    public static void  inserting()
	    {
	    	Scanner sc=null;
	    	try
	    	{
		    	File f=new File("datas.txt");
		    	sc=new Scanner(f);
		    	while(sc.hasNextLine())
		    	{
		    		String test=sc.nextLine();
		    		String[] words=test.split(" ");
		    		for(String word:words)
		    		{
		    			insert(word);
		    		}
		    	}
	    	}
	    	catch(FileNotFoundException e)
	    	{
	    		System.out.println("file not found");
	    	}
	    	
	    	
	    }
}
