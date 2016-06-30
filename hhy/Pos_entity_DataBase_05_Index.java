package Pos机_源代码;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

public class Pos_entity_DataBase_05_Index {
	
	private String number;
	private String name;
	private String unit;
	private double price;
	private double discount;
	private boolean promotion;
	private double vipDiscount;
	public Vector<Pos_entity_DataBase_05_Index> index=new Vector<Pos_entity_DataBase_05_Index>();
	
	public Pos_entity_DataBase_05_Index()
	{

	}
	
	
	public Pos_entity_DataBase_05_Index( String num, String ame, String uni, double pr, double d, boolean pro, double vipD)
	{
		setNumber(num);
		setName(ame);
		setUnit(uni);
		setPrice(pr);
		setDiscount(d);
		setPromotion(pro);
		setVipDiscount(vipD);
	}
	
	
	@SuppressWarnings("resource")
	public void readIndex() throws IOException
	{
		File fileIndex=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_05_Index.txt");
		FileInputStream fis=new FileInputStream(fileIndex);
		DataInputStream disIndex=new DataInputStream(fis);
		while(disIndex.available()!=0)
		{
			index.add(new Pos_entity_DataBase_05_Index(disIndex.readUTF(), disIndex.readUTF(),disIndex.readUTF()
					, disIndex.readDouble(), disIndex.readDouble(), disIndex.readBoolean(), disIndex.readDouble()));
		}
		
		
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
	public boolean getPromotion() {
		return promotion;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public double getVipDiscount() {
		return vipDiscount;
	}
	public void setVipDiscount(double vipDiscount) {
		this.vipDiscount = vipDiscount;
	}
	
	
}
