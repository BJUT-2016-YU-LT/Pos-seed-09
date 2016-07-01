package Pos机_源代码;

import java.io.*;
import java.util.Vector;



public class Pos_entity_DataBase_03_List {

	private String number;
	public Vector<Pos_entity_DataBase_03_List>numList=new Vector<Pos_entity_DataBase_03_List>();

	
	public Pos_entity_DataBase_03_List()
	{
		
	}
	public Pos_entity_DataBase_03_List(String num)
	{
		setNumber(num);
	}
	
	
	@SuppressWarnings("resource")
	public void readList() throws IOException
	{
		File fileList=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_03_List.txt");
		FileInputStream fis=new FileInputStream(fileList);
		DataInputStream disList=new DataInputStream(fis);
		while(disList.available()!=0)//切记！切记！
		{
			numList.add(new Pos_entity_DataBase_03_List(disList.readUTF()));
		}
//		System.out.println("numList.size()="+numList.size());
		
	}
	
	
	
	////////////////////////////////////////////////////////////////
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	
}

