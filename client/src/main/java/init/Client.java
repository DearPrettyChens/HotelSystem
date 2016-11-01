package init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		try {
			System.out.println("Please input the list of names:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String names = br.readLine();
			String []nameList=names.split(",");
			names=nameChanging(nameList);
			System.out.print(names.substring(0,names.length()-1));                      //remove the last "," in the string
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// use java8
	public static String nameChanging(String[] nameList){
		List<String> list=(List) Arrays.asList(nameList);	
		return list.stream()
					.filter(name->name.length()>1)                                      //to filter the single string
					.map(name->name.substring(0,1).toUpperCase()+name.substring(1)+",") //to change the first char into the upper case
					.reduce("",(x,y)->x+y);                                             //to get the final single string
	}
}
