package Pos机_源代码;

import java.io.IOException;


public class Pos_View {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub

		Pos_Control_Item pci=new Pos_Control_Item();
		int z=0;
		
	do{
		z=0;
		System.out.println("请输入实现需求01、02、03、04，以int类型输入");
		int a=System.in.read()-48;
		
		//需求01
		if(a==1)
		{
			Pos_entity_DataBase_01 ped_01=new Pos_entity_DataBase_01();
			if(pci.initCheck_01()==false)
			{
				System.out.println("pci.initCheck()==false");
				pci.init_01();
			}
			ped_01.read();
			pci.output_01(ped_01.ped);
			z=0;
		}
		
		//需求02
		else if(a==2)
		{
			Pos_entity_DataBase_02 ped_02=new Pos_entity_DataBase_02();
			if(pci.initCheck_02()==false)
			{
				System.out.println("pci.initCheck()==false");
				pci.init_02();
			}
			ped_02.read();
			pci.output_02(ped_02.ped);
			z=0;
		}
		
		//需求3、4
		else if(a==3 || a==4)
		{
			Pos_entity_DataBase_03_List ped_03_list=new Pos_entity_DataBase_03_List();
			Pos_entity_DataBase_03_Index ped_03_index=new Pos_entity_DataBase_03_Index();
			if(pci.initCheck_03()==false)
			{
				System.out.println("pci.initCheck()==false");
				pci.init_03();
			}
			ped_03_index.readIndex();
			ped_03_list.readList();
			pci.output_03(ped_03_list.numList, ped_03_index.index);
			z=0;
		}
		
		
		else if(a==5 || a==6)
		{
			Pos_entity_Vip_05 pev=new Pos_entity_Vip_05();
			Pos_entity_DataBase_05_List ped_05_list=new Pos_entity_DataBase_05_List();
			Pos_entity_DataBase_05_Index ped_05_index=new Pos_entity_DataBase_05_Index();
			if(pci.initCheck_05()==false)
			{
				System.out.println("pci.initCheck()==false");
				pci.init_05();
			}
			ped_05_index.readIndex();
			ped_05_list.readList();
			pev.readVip();
			pci.output_05(ped_05_list.numList, ped_05_index.index, pev.vip, ped_05_list);
			
		}
		else
		{
			System.out.println("非法输入。。。");
			z=-1;
		}
		
	}while(z==-1);

	}
}
