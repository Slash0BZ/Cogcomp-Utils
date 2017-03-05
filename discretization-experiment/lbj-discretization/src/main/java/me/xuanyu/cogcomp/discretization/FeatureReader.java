package me.xuanyu.cogcomp.discretization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import edu.illinois.cs.cogcomp.lbjava.parse.Parser;

public class FeatureReader implements Parser
{
	private List<String> lines;
	private int currentline;
	private BufferedReader br;

	public FeatureReader(String file){
		lines = new ArrayList<String>();
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str = br.readLine();
			while (str != null){
				lines.add(str);
				str = br.readLine();
			}
			br.close();
		} catch (Exception e){
		}
	}

	public void close(){}

	public Object next(){
		if (currentline == lines.size()){
			return null;
		}
		else{
			currentline++;
			return lines.get(currentline - 1);
		}
	}

	public void reset(){
		currentline = 0;
	}
}
