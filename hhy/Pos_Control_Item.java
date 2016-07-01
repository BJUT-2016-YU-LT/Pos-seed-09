package Pos��_Դ����;

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
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_01.txt"
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
		File file=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_01.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
		for(int i=0; i<=4; i++)
		{
			dos.writeUTF("ITEM000000");
			dos.writeUTF("�ɿڿ���");
			dos.writeUTF("ƿ");
			dos.writeDouble(3.00);
		}
		for(int i=0; i<=1; i++)
		{
			dos.writeUTF("ITEM000001");
			dos.writeUTF("ѩ��");
			dos.writeUTF("ƿ");
			dos.writeDouble(3.00);
		}
		
		dos.writeUTF("ITEM000004");
		dos.writeUTF("���");
		dos.writeUTF("��");
		dos.writeDouble(2.00);
		
		fos.close();
		dos.close();
		
	}
	
	public void output_01(Vector<Pos_entity_DataBase_01>ped)
	{
		System.out.println("***�̵깺���嵥***");
		int count=1;
		for(int i=0; i<=ped.size()-1; i++)
		{
			if(i<ped.size()-1 && ped.get(i).getNumber().equals(ped.get(i+1).getNumber()))
				count++;		
			else
			{
				xiaoji.add(ped.get(i).getPrice()*count);
				System.out.println("���ƣ�"+ped.get(i).getName()+",������"+count+ped.get(i).getUnit()
						+",���ۣ�"+ped.get(i).getPrice()+",С�ƣ�"+xiaoji.lastElement()+"(Ԫ)");
				count=1;
			}
		}
		System.out.println("----------------------");
		all=0;
		for(int i=0; i<=xiaoji.size()-1; i++ )
			all+=xiaoji.get(i);
		//��ʽ����
		String double_str=String.format("%.2f", all);
		all=Double.valueOf(double_str);
		System.out.println("�ܼۣ�"+all+"��Ԫ��");
		
		System.out.println("**********************");
		
		xiaoji.clear();
		ped.clear();
	}
	
	
	
	public boolean initCheck_02()
	{
		File file=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_02.txt"
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
		File file=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_02.txt");
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
//		for(int i=0; i<=4; i++)
//		{
//			dos.writeUTF("ITEM000000");
//			dos.writeUTF("�ɿڿ���");
//			dos.writeUTF("ƿ");
//			dos.writeDouble(3.00);
//			dos.writeDouble(1.0);
//		}
//		for(int i=0; i<=1; i++)
//		{
//			dos.writeUTF("ITEM000001");
//			dos.writeUTF("ѩ��");
//			dos.writeUTF("ƿ");
//			dos.writeDouble(3.00);
//			dos.writeDouble(1.0);
//		}
		
		dos.writeUTF("ITEM000004");
		dos.writeUTF("���");
		dos.writeUTF("��");
		dos.writeDouble(2.00);
		dos.writeDouble(0.8);
		
		fos.close();
		dos.close();
		
	}
	
	public void output_02(Vector<Pos_entity_DataBase_02>ped)
	{
		System.out.println("***�̵깺���嵥***");
		double count=1, save=0;
		for(int i=0; i<=ped.size()-1; i++)
		{
			
			if(i<ped.size()-1 && ped.get(i).getNumber().equals(ped.get(i+1).getNumber()))
				count++;
			
			else
			{
				xiaoji.add((ped.get(i).getPrice()*ped.get(i).getDiscount())*count);//!!!!!!!!
				save=save+(ped.get(i).getPrice()*(1-ped.get(i).getDiscount()))*count;//!!!!!!!
				System.out.println("���ƣ�"+ped.get(i).getName()+",������"+count+ped.get(i).getUnit()
						+",���ۣ�"+ped.get(i).getPrice()+",С�ƣ�"+xiaoji.lastElement()+"(Ԫ)");
				count=1;
			}
		}
		System.out.println("----------------------");
		all=0;
		for(int i=0; i<=xiaoji.size()-1; i++ )
			all+=xiaoji.get(i);
		//��ʽ����
		String double_str=String.format("%.2f", all);
		all=Double.valueOf(double_str);
		System.out.println("�ܼۣ�"+all+"��Ԫ��");
		
		double_str=String.format("%.2f", save);
		save=Double.valueOf(double_str);
		System.out.println("��ʡ��"+save+"��Ԫ��");
		System.out.println("**********************");
	}

	
	public boolean initCheck_03()
	{
		File file1=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_03_Index.txt"
				);
		File file2=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_03_List.txt"
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
		File fileIndex=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_03_Index.txt");
		File fileList=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_03_List.txt");
		FileOutputStream fos1=new FileOutputStream(fileIndex);
		DataOutputStream dosIndex=new DataOutputStream(fos1);
		FileOutputStream fos2=new FileOutputStream(fileList);
		DataOutputStream dosList=new DataOutputStream(fos2);
		
		for(int i=0; i<=0; i++)
		{
			dosIndex.writeUTF("ITEM000000");
			dosIndex.writeUTF("�ɿڿ���");
			dosIndex.writeUTF("ƿ");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(true);
			
			dosIndex.writeUTF("ITEM000001");
			dosIndex.writeUTF("ѩ��");
			dosIndex.writeUTF("ƿ");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(false);
			
			dosIndex.writeUTF("ITEM000004");
			dosIndex.writeUTF("���");
			dosIndex.writeUTF("��");
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
		System.out.println("***�̵깺���嵥***");
		double count=0, countOver=0, save=0;
//		System.out.println("numList.size()="+numList.size());
//		System.out.println("index.size()="+index.size());
		for(int i=0; i<=numList.size()-1; i++)
		{
			if(i!=numList.size()-1 && numList.get(i).getNumber().equals(numList.get(i+1).getNumber()))
			{
				count++;
				if(count==2 && countOver==0)//��ͬ���Σ������ϣ���δ�ж���
				{
					for(int j=0; j<=index.size()-1; j++)//list��indexƥ��
					{
						if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && index.get(j).getPromotion())//�Ƿ���
						{
							if(index.get(j).getDiscount()!=1)
							{
								System.out.println("˵�õ��Żݺʹ��۲���ͬʱ���ͬһ���Ʒ�أ���������������������");
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
						System.out.println("���ƣ�"+index.get(j).getName()+",������"+(int)(count+1)+index.get(j).getUnit()
								+",���ۣ�"+index.get(j).getPrice()+"(Ԫ),С�ƣ�"+xiaoji.lastElement()+"(Ԫ)");
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
						System.out.println("���ƣ�"+index.get(j).getName()+",������"+(int)count+index.get(j).getUnit()
								+",���ۣ�"+index.get(j).getPrice()+"(Ԫ),С�ƣ�"+xiaoji.lastElement()+"(Ԫ)");
						count=0;
						countOver=0;
						break;
					}
				}
			}
			
		}
			System.out.println("----------------------");
			System.out.println("����������Ʒ��");
			for(int i=0; i<=send3.size()-1; i++)
			{
				System.out.println("���ƣ�"+send3.get(i).getName()+",������1"+send3.get(i).getUnit());
			}
			
			System.out.println("----------------------");
			all=0;
			for(int i=0; i<=xiaoji.size()-1; i++ )
			{
				all+=xiaoji.get(i);
			}
			//��ʽ����
			String double_str=String.format("%.2f", all);
			all=Double.valueOf(double_str);
			System.out.println("�ܼۣ�"+all+"��Ԫ��");
			
			for(int i=0; i<=send3.size()-1; i++ )//Ϊ�˷ֿ����㣬���ӿɶ���
			{
				save=save+send3.get(i).getPrice();
			}
			double_str=String.format("%.2f", save);
			save=Double.valueOf(double_str);
			System.out.println("��ʡ��"+save+"��Ԫ��");
			System.out.println("**********************");
			
	
	}
			
	
	
	
	public boolean initCheck_05()
	{
		File file1=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_05_Index.txt"
				);
		File file2=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_05_List.txt"
				);
		File file3=new File(
				"C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_Vip_05_List.txt"
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
		File fileIndex=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_05_Index.txt");
		File fileList=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_DataBase_05_List.txt");
		File filevip=new File("C:\\Users\\lenovo\\Desktop\\Java\\eclipseСѧ��\\Pos_entity_Vip_05.txt");
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
			dosIndex.writeUTF("�ɿڿ���");
			dosIndex.writeUTF("ƿ");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(true);
			dosIndex.writeDouble(0.9);
			
			dosIndex.writeUTF("ITEM000001");
			dosIndex.writeUTF("ѩ��");
			dosIndex.writeUTF("ƿ");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(1.0);
			dosIndex.writeBoolean(false);
			dosIndex.writeDouble(0.95);
			
			dosIndex.writeUTF("ITEM000004");
			dosIndex.writeUTF("���");
			dosIndex.writeUTF("��");
			dosIndex.writeDouble(3.00);
			dosIndex.writeDouble(0.8);
			dosIndex.writeBoolean(false);
			dosIndex.writeDouble(1);
		}
		
		//DataBase List
		dosList.writeUTF("USER001");//��ʼ����Ա��ǻ�Ա���
		for(int i=0; i<=4; i++)
		{
			dosList.writeUTF("ITEM000000");
		}
		
		for(int i=0; i<=1; i++)
		{
			dosList.writeUTF("ITEM000001");
		}
		
		dosList.writeUTF("ITEM000004");
		
		//��Ա�ļ�
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
				if(count==2 && countOver==0 && isVip==false)//��ͬ���Σ������ϣ���δ�ж���
				{
					for(int j=0; j<=index.size()-1; j++)//list��indexƥ��
					{
						if(numList.get(i).getNumber().equals(index.get(j).getNumber()) && index.get(j).getPromotion())//�Ƿ���
						{
							if(index.get(j).getDiscount()!=1)
							{
								System.out.println("˵�õ��Żݺʹ��۲���ͬʱ���ͬһ���Ʒ�أ���������������������");
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
					System.out.println(numList.get(i).getNumber()+"û�����");
				}
			}
			
		}


			System.out.println("----------------------");
			all=0;
			for(int i=0; i<=xiaoji.size()-1; i++ )
			{
				all+=xiaoji.get(i);
			}
			//��ʽ����
			String double_str=String.format("%.2f", all);
			all=Double.valueOf(double_str);
			
			//��Ա����
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
			
			for(int i=0; i<=send5.size()-1; i++ )//Ϊ�˷ֿ����㣬���ӿɶ���
			{
				save=save+send5.get(i).getPrice();
			}
			
			
			System.out.println("***�̵깺���嵥***");
			System.out.println("��Ա��ţ�"+ped5List.getVipper()+"   ��Ա���֣�"+vip.get(v).getPoints());
			System.out.println("----------------------");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			System.out.println("��ӡʱ�䣺"+df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
			System.out.println("----------------------");
			for(int i=0; i<=index.size()-1; i++)
			{
				System.out.println("���ƣ�"+bill.get(i).getName()+",������"+String.format("%.2f", counter.get(i))+bill.get(i).getUnit()
									+",���ۣ�"+index.get(i).getPrice()+"(Ԫ),С�ƣ�"+xiaoji.get(i)+"(Ԫ)");
			}
			if(send5.size()>0 && isVip==false)
			{
				System.out.println("----------------------");
				System.out.println("����������Ʒ��");
				for(int i=0; i<=send5.size()-1; i++)
				{
					System.out.println("���ƣ�"+send5.get(i).getName()+",������1"+send5.get(i).getUnit());
				}
			}
			System.out.println("----------------------");
			System.out.println("�ܼۣ�"+all+"��Ԫ��");
			double_str=String.format("%.2f", save);
			save=Double.valueOf(double_str);
			System.out.println("��ʡ��"+save+"��Ԫ��");
			System.out.println("**********************");
			

			
	}
		
	
	
}
