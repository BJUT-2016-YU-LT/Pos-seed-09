package Pos机_源代码;

import java.io.*;
import java.util.Vector;



public class Pos_entity_DataBase_02 {

	private String number;
	private String name;
	private String unit;
	private double price;
	private double discount;
	public Vector<Pos_entity_DataBase_02>ped=new Vector<Pos_entity_DataBase_02>();
	
	public Pos_entity_DataBase_02()
	{
		
	}
	public Pos_entity_DataBase_02(String num, String ame, String uni, double pr, double d)
	{
		setNumber(num);
		setName(ame);
		setUnit(uni);
		setPrice(pr);
		setDiscount(d);
	}
	
	@SuppressWarnings("resource")
	public void read() throws IOException
	{
		FileInputStream fis=new FileInputStream(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_02.txt");
		DataInputStream dis=new DataInputStream(fis);
		
		while(dis.available()!=0)//切记！切记！
		{
			ped.add(new Pos_entity_DataBase_02(
					dis.readUTF(), dis.readUTF(), dis.readUTF(),dis.readDouble(), dis.readDouble()));
		}
		System.out.println("ped.size()="+ped.size());
		
	}
	
	
	////////////////////////////////////////////////////////////////
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	
	
}

