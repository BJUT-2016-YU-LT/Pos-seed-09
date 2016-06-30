package Pos机_源代码;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Pos_Control_Item {

	public Vector<Double>xiaoji=new Vector<Double>();
	public Vector<Pos_entity_DataBase_03_Index>send3=new Vector<Pos_entity_DataBase_03_Index>();
	public Vector<Pos_entity_DataBase_05_Index>send5=new Vector<Pos_entity_DataBase_05_Index>();
	public Vector<Pos_entity_DataBase_05_Index>bill=new Vector<Pos_entity_DataBase_05_Index>();
	public Vector<Double>counter=new Vector<Double>();
	public boolean isVip;
	public double save;
	public double all;
	
	public boolean initCheck_01()
	{
		File file=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_01.txt"
				);
		
		if(file.exists())
		{
			if(file.length()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public void init_01() throws IOException
	{
		File file=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_01.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
		for(int i=0; i<=4; i++)
		{
			dos.writeUTF("ITEM000000");
			dos.writeUTF("可口可乐");
			dos.writeUTF("瓶");
			dos.writeDouble(3.00);
		}
		for(int i=0; i<=1; i++)
		{
			dos.writeUTF("ITEM000001");
			dos.writeUTF("雪碧");
			dos.writeUTF("瓶");
			dos.writeDouble(3.00);
		}
		
		dos.writeUTF("ITEM000004");
		dos.writeUTF("电池");
		dos.writeUTF("个");
		dos.writeDouble(2.00);
		
		fos.close();
		dos.close();
		
	}
	
	public void output_01(Vector<Pos_entity_DataBase_01>ped)
	{
		System.out.println("***商店购物清单***");
		int count=1;
		for(int i=0; i<=ped.size()-1; i++)
		{
			if(i<ped.size()-1 && ped.get(i).getNumber().equals(ped.get(i+1).getNumber()))
				count++;		
			else
			{
				xiaoji.add(ped.get(i).getPrice()*count);
				System.out.println("名称："+ped.get(i).getName()+",数量："+count+ped.get(i).getUnit()
						+",单价："+ped.get(i).getPrice()+",小计："+xiaoji.lastElement()+"(元)");
				count=1;
			}
		}
		System.out.println("----------------------");
		all=0;
		for(int i=0; i<=xiaoji.size()-1; i++ )
			all+=xiaoji.get(i);
		//格式控制
		String double_str=String.format("%.2f", all);
		all=Double.valueOf(double_str);
		System.out.println("总价："+all+"（元）");
		
		System.out.println("**********************");
		
		xiaoji.clear();
		ped.clear();
	}
	
	
	
	public boolean initCheck_02()
	{
		File file=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_02.txt"
				);
		
		if(file.exists())
		{
			if(file.length()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public void init_02() throws IOException
	{
		File file=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_02.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
//		for(int i=0; i<=4; i++)
//		{
//			dos.writeUTF("ITEM000000");
//			dos.writeUTF("可口可乐");
//			dos.writeUTF("瓶");
//			dos.writeDouble(3.00);
//			dos.writeDouble(1.0);
//		}
//		for(int i=0; i<=1; i++)
//		{
//			dos.writeUTF("ITEM000001");
//			dos.writeUTF("雪碧");
//			dos.writeUTF("瓶");
//			dos.writeDouble(3.00);
//			dos.writeDouble(1.0);
//		}
		
		dos.writeUTF("ITEM000004");
		dos.writeUTF("电池");
		dos.writeUTF("个");
		dos.writeDouble(2.00);
		dos.writeDouble(0.8);
		
		fos.close();
		dos.close();
		
	}
	
	public void output_02(Vector<Pos_entity_DataBase_02>ped)
	{
		System.out.println("***商店购物清单***");
		double count=1, save=0;
		for(int i=0; i<=ped.size()-1; i++)
		{
			
			if(i<ped.size()-1 && ped.get(i).getNumber().equals(ped.get(i+1).getNumber()))
				count++;
			
			else
			{
				xiaoji.add((ped.get(i).getPrice()*ped.get(i).getDiscount())*count);//!!!!!!!!
				save=save+(ped.get(i).getPrice()*(1-ped.get(i).getDiscount()))*count;//!!!!!!!
				System.out.println("名称："+ped.get(i).getName()+",数量："+count+ped.get(i).getUnit()
						+",单价："+ped.get(i).getPrice()+",小计："+xiaoji.lastElement()+"(元)");
				count=1;
			}
		}
		System.out.println("----------------------");
		all=0;
		for(int i=0; i<=xiaoji.size()-1; i++ )
			all+=xiaoji.get(i);
		//格式控制
		String double_str=String.format("%.2f", all);
		all=Double.valueOf(double_str);
		System.out.println("总价："+all+"（元）");
		
		double_str=String.format("%.2f", save);
		save=Double.valueOf(double_str);
		System.out.println("节省："+save+"（元）");
		System.out.println("**********************");
	}

	
	public boolean initCheck_03()
	{
		File file1=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_03_Index.txt"
				);
		File file2=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_03_List.txt"
				);
		
		if(file1.exists() && file2.exists())
		{
			if(file1.length()>0 && file2.length()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public void init_03() throws IOException
	{
		File fileIndex=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_03_Index.txt");
		File fileList=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_03_List.txt");
		FileOutputStream fos1=new FileOutputStream(fileIndex);
		DataOutputStream dosIndex=new DataOutputStream(fos1);
		FileOutputStream fos2=new FileOutputStream(fileList);
		DataOutputStream dosList=new DataOutputStream(fos2);
		
		for(int i=0; i<=0; i++)
		{
			dosIndex.writeUTF("ITEM000000");
			dosIndex.writeUTF("可口可乐");
			dosIndex.writeUTF("瓶");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(true);
			
			dosIndex.writeUTF("ITEM000001");
			dosIndex.writeUTF("雪碧");
			dosIndex.writeUTF("瓶");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(false);
			
			dosIndex.writeUTF("ITEM000004");
			dosIndex.writeUTF("电池");
			dosIndex.writeUTF("个");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(0.8);
			dosIndex.writeBoolean(false);
		}
		
		for(int i=0; i<=4; i++)
		{
			dosList.writeUTF("ITEM000000");
		}
		
		for(int i=0; i<=1; i++)
		{
			dosList.writeUTF("ITEM000001");
		}
		
		dosList.writeUTF("ITEM000004");
		
		fos1.close();
		fos2.close();
		dosIndex.close();
		dosList.close();
		
	}
	
	public void output_03(Vector<Pos_entity_DataBase_03_List>numList, Vector<Pos_entity_DataBase_03_Index>index)
	{
		System.out.println("***商店购物清单***");
		double count=0, countOver=0, save=0;
//		System.out.println("numList.size()="+numList.size());
//		System.out.println("index.size()="+index.size());
		for(int i=0; i<=numList.size()-1; i++)
		{
			if(i!=numList.size()-1 && numList.get(i).getNumber().equals(numList.get(i+1).getNumber()))
			{
				count++;
				if(count==2 && countOver==0)//相同两次（或以上）且未判定送
				{
					for(int j=0; j<=index.size()-1; j++)//list和index匹配
					{
						if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && index.get(j).getPromotion())//是否送
						{
							if(index.get(j).getDiscount()!=1)
							{
								System.out.println("说好的优惠和打折不会同时针对同一款产品呢？出错！！！请检查索引！！");
							}
							send3.add(index.get(j));
							countOver=1;
						}
					}
				}
			}
			else
			{
				count++;
				for(int j=0; j<=index.size()-1; j++)
				{
					if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && index.get(j).getPromotion()==true)
					{
						xiaoji.add((index.get(j).getPrice()*index.get(j).getDiscount())*count);
						save=save+(index.get(j).getPrice()*(1-index.get(j).getDiscount()))*count;
						System.out.println("名称："+index.get(j).getName()+",数量："+(int)(count+1)+index.get(j).getUnit()
								+",单价："+index.get(j).getPrice()+"(元),小计："+xiaoji.lastElement()+"(元)");
						count=0;
						countOver=0;
						break;
					}
					else if(numList.get(i).getNumber().equals(index.get(j).getNumber()))
					{
						double a=(index.get(j).getPrice()*index.get(j).getDiscount())*count;
						String double_str=String.format("%.2f", a);
						a=Double.valueOf(double_str);
						xiaoji.add(a);
						save=save+(index.get(j).getPrice()*(1-index.get(j).getDiscount()))*count;
						System.out.println("名称："+index.get(j).getName()+",数量："+(int)count+index.get(j).getUnit()
								+",单价："+index.get(j).getPrice()+"(元),小计："+xiaoji.lastElement()+"(元)");
						count=0;
						countOver=0;
						break;
					}
				}
			}
			
		}
			System.out.println("----------------------");
			System.out.println("挥泪赠送商品：");
			for(int i=0; i<=send3.size()-1; i++)
			{
				System.out.println("名称："+send3.get(i).getName()+",数量：1"+send3.get(i).getUnit());
			}
			
			System.out.println("----------------------");
			all=0;
			for(int i=0; i<=xiaoji.size()-1; i++ )
			{
				all+=xiaoji.get(i);
			}
			//格式控制
			String double_str=String.format("%.2f", all);
			all=Double.valueOf(double_str);
			System.out.println("总价："+all+"（元）");
			
			for(int i=0; i<=send3.size()-1; i++ )//为了分开计算，增加可读性
			{
				save=save+send3.get(i).getPrice();
			}
			double_str=String.format("%.2f", save);
			save=Double.valueOf(double_str);
			System.out.println("节省："+save+"（元）");
			System.out.println("**********************");
			
	
	}
			
	
	
	
	public boolean initCheck_05()
	{
		File file1=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_05_Index.txt"
				);
		File file2=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_05_List.txt"
				);
		File file3=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_Vip_05_List.txt"
				);
		if(file1.exists() && file2.exists() && file3.exists())
		{
			if(file1.length()>0 && file2.length()>0 && file3.length()>0 )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public void init_05() throws IOException
	{
		File fileIndex=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_05_Index.txt");
		File fileList=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_DataBase_05_List.txt");
		File filevip=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipse小学期\\Pos_entity_Vip_05.txt");
		FileOutputStream fos1=new FileOutputStream(fileIndex);
		DataOutputStream dosIndex=new DataOutputStream(fos1);
		FileOutputStream fos2=new FileOutputStream(fileList);
		DataOutputStream dosList=new DataOutputStream(fos2);
		FileOutputStream fos3=new FileOutputStream(filevip);
		DataOutputStream dosVip=new DataOutputStream(fos3);
		
		//DataBase index
		for(int i=0; i<=0; i++)
		{
			dosIndex.writeUTF("ITEM000000");
			dosIndex.writeUTF("可口可乐");
			dosIndex.writeUTF("瓶");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(true);
			dosIndex.writeDouble(0.9);
			
			dosIndex.writeUTF("ITEM000001");
			dosIndex.writeUTF("雪碧");
			dosIndex.writeUTF("瓶");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(false);
			dosIndex.writeDouble(0.95);
			
			dosIndex.writeUTF("ITEM000004");
			dosIndex.writeUTF("电池");
			dosIndex.writeUTF("个");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(0.8);
			dosIndex.writeBoolean(false);
			dosIndex.writeDouble(1);
		}
		
		//DataBase List
		dosList.writeUTF("USER001");//初始化会员或非会员编号
		for(int i=0; i<=4; i++)
		{
			dosList.writeUTF("ITEM000000");
		}
		
		for(int i=0; i<=1; i++)
		{
			dosList.writeUTF("ITEM000001");
		}
		
		dosList.writeUTF("ITEM000004");
		
		//会员文件
		dosVip.writeUTF("USER001");
		dosVip.writeUTF("USER 001");
		dosVip.writeBoolean(true);
		dosVip.writeInt(0);
		
		dosVip.writeUTF("USER002");
		dosVip.writeUTF("USER 002");
		dosVip.writeBoolean(false);
		dosVip.writeInt(300);
		
		dosVip.writeUTF("USER003");
		dosVip.writeUTF("USER 003");
		dosVip.writeBoolean(false);
		dosVip.writeInt(700);
		
		//database
		fos1.close();
		fos2.close();
		fos3.close();
		dosIndex.close();
		dosList.close();
		dosVip.close();

		
	}
	
	public void output_05(Vector<Pos_entity_DataBase_05_List> numList, Vector<Pos_entity_DataBase_05_Index>index,
			Vector<Pos_entity_Vip_05>vip, Pos_entity_DataBase_05_List ped5List)
	{
		int v=0, jEmpty=0;
//		System.out.println("vip.size()="+vip.size());
		for(v=0; v<=vip.size()-1; v++)
		{
			if(ped5List.getVipper().equals(vip.get(v).getVipNumber()))
			{
				isVip=vip.get(v).getIsVip();
				break;
			}
		}
//		for(int i=0; i<=vip.size()-1; i++)
//			System.out.println("vip="+vip.get(i).getVipNumber()+vip.get(i).getIsVip()+"v="+v+" p="+ped5List.getVipper());
		double count=0, countOver=0, save=0;
//		System.out.println("numList.size()="+numList.size());
//		System.out.println("index.size()="+index.size());
		for(int i=0; i<=numList.size()-1; i++)
		{
			if(i!=numList.size()-1 && numList.get(i).getNumber().equals(numList.get(i+1).getNumber()))
			{
				count++;
				if(count==2 && countOver==0 && isVip==false)//相同两次（或以上）且未判定送
				{
					for(int j=0; j<=index.size()-1; j++)//list和index匹配
					{
						if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && index.get(j).getPromotion())//是否送
						{
							if(index.get(j).getDiscount()!=1)
							{
								System.out.println("说好的优惠和打折不会同时针对同一款产品呢？出错！！！请检查索引！！");
							}
							send5.add(index.get(j));
							countOver=1;
						}
					}
				}
			}
			else
			{
				count++;
				for(int j=0; j<=index.size()-1; j++,jEmpty=j)
				{
					if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && isVip==true)
					{
						double a=(index.get(j).getPrice()*index.get(j).getDiscount()*index.get(j).getVipDiscount())*count;/////
						String double_str=String.format("%.2f", a);
						a=Double.valueOf(double_str);
						xiaoji.add(a);
						save=save+(index.get(j).getPrice()*(1-index.get(j).getDiscount()*index.get(j).getVipDiscount()))*count;
						bill.add(index.get(j));
						counter.add(count);
						count=0;
						countOver=0;
						break;
					}
					else if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && index.get(j).getPromotion()==true && isVip==false)
					{
						double a=(index.get(j).getPrice()*index.get(j).getDiscount())*count;
						String double_str=String.format("%.2f", a);
						a=Double.valueOf(double_str);
						xiaoji.add(a);
						System.out.println("xiaoji"+xiaoji.lastElement());
						save=save+(index.get(j).getPrice()*count-xiaoji.lastElement());
						bill.add(index.get(j));
						counter.add(count+1);////////
						count=0;
						countOver=0;
						break;
					}
					else if(numList.get(i).getNumber().equals(index.get(j).getNumber())&& index.get(j).getPromotion()==false && isVip==false)
					{
						double a=(index.get(j).getPrice()*index.get(j).getDiscount())*count;
						String double_str=String.format("%.2f", a);
						a=Double.valueOf(double_str);
						xiaoji.add(a);
						save=save+(index.get(j).getPrice()*(1-index.get(j).getDiscount()))*count;
						bill.add(index.get(j));
						counter.add(count);
						count=0;
						countOver=0;
						break;
					}
					
		
				}
				
				
				if(jEmpty==index.size())
				{
					System.out.println(numList.get(i).getNumber()+"没存货了");
				}
			}
			
		}


			System.out.println("----------------------");
			all=0;
			for(int i=0; i<=xiaoji.size()-1; i++ )
			{
				all+=xiaoji.get(i);
			}
			//格式控制
			String double_str=String.format("%.2f", all);
			all=Double.valueOf(double_str);
			
			//会员积分
			if(all>=0 && all<=200 && vip.get(v).getIsVip()==true)
			{
				vip.get(v).setPoints(((int)(all/5))*1);
			}
			else if(all>200 && all<=500 && vip.get(v).getIsVip()==true)
			{
				vip.get(v).setPoints(((int)(all/5))*3);
			}
			if(all>500 && vip.get(v).getIsVip()==true)
			{
				vip.get(v).setPoints(((int)(all/5))*5);
			}
			
			for(int i=0; i<=send5.size()-1; i++ )//为了分开计算，增加可读性
			{
				save=save+send5.get(i).getPrice();
			}
			
			
			System.out.println("***商店购物清单***");
			System.out.println("会员编号："+ped5List.getVipper()+"   会员积分："+vip.get(v).getPoints());
			System.out.println("----------------------");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("打印时间："+df.format(new Date()));// new Date()为获取当前系统时间
			System.out.println("----------------------");
			for(int i=0; i<=index.size()-1; i++)
			{
				System.out.println("名称："+bill.get(i).getName()+",数量："+String.format("%.2f", counter.get(i))+bill.get(i).getUnit()
									+",单价："+index.get(i).getPrice()+"(元),小计："+xiaoji.get(i)+"(元)");
			}
			if(send5.size()>0 && isVip==false)
			{
				System.out.println("----------------------");
				System.out.println("挥泪赠送商品：");
				for(int i=0; i<=send5.size()-1; i++)
				{
					System.out.println("名称："+send5.get(i).getName()+",数量：1"+send5.get(i).getUnit());
				}
			}
			System.out.println("----------------------");
			System.out.println("总价："+all+"（元）");
			double_str=String.format("%.2f", save);
			save=Double.valueOf(double_str);
			System.out.println("节省："+save+"（元）");
			System.out.println("**********************");
			

			
	}
		
	
	
}
