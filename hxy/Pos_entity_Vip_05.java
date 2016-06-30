package Pos机_源代码;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

public class Pos_entity_Vip_05 {
	private String VipNumber;
	private String vipName;
	private boolean isVip;
	private int points;
	public Vector<Pos_entity_Vip_05>vip=new Vector<Pos_entity_Vip_05>();
	
	
	public Pos_entity_Vip_05()
	{
		
	}
	
	public Pos_entity_Vip_05(String VNumber, String VName, boolean iV, int p)
	{
		setVipNumber(VNumber);
		setVipName(VName);
		setIsVip(iV);
		setPoints(p);
	}

	
	@SuppressWarnings("resource")
	public void readVip() throws IOException
	{
		File file=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_Vip_05.txt");
		FileInputStream fis=new FileInputStream(file);
		DataInputStream dis=new DataInputStream(fis);
		while(dis.available()!=0)
		{
			vip.add(new Pos_entity_Vip_05(dis.readUTF(), dis.readUTF(),dis.readBoolean(), dis.readInt()));
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////
	public String getVipNumber() {
		return VipNumber;
	}

	public void setVipNumber(String vipNumber) {
		VipNumber = vipNumber;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(boolean isVip) {
		this.isVip = isVip;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


}
