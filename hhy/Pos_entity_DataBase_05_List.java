package Pos��_Դ����;

import java.io.*;
import java.util.Vector;



public class Pos_entity_DataBase_05_List {

	private String number;
	private String vipper;
	public Vector<Pos_entity_DataBase_05_List>numList=new Vector<Pos_entity_DataBase_05_List>();

	
	public Pos_entity_DataBase_05_List()
	{
		
	}
	public Pos_entity_DataBase_05_List(String num)
	{
		setNumber(num);
	}
	
	
	@SuppressWarnings("resource")
	public void readList() throws IOException
	{
		File fileList=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_05_List.txt");
		FileInputStream fis=new FileInputStream(fileList);
		DataInputStream disList=new DataInputStream(fis);
		vipper=disList.readUTF();//�չ���Ա����
		while(disList.available()!=0)//�мǣ��мǣ�
		{
			numList.add(new Pos_entity_DataBase_05_List(disList.readUTF()));
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
	public String getVipper() {
		return vipper;
	}
	public void setVipper(String vipper) {
		this.vipper = vipper;
	}
	
	
	
	
}

