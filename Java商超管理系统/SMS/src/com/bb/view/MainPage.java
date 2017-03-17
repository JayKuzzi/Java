package com.bb.view;

import java.util.List;
import java.util.Scanner;

import com.bb.bean.Goods;
import com.bb.bean.Salesman;
import com.bb.bean.TodaySold;
import com.bb.dao.GSalesDao;
import com.bb.dao.GoodsDao;
import com.bb.dao.SalesmanDao;

/**
 * ϵ�y���
 * 
 * @author ����
 *  
 */
public class MainPage {
	public static void main(String[] args) {

		mainMenu();

	}

	/**
	 * ���˵�����
	 */
	public static void mainMenu() {
		System.out.println("****************************************");
		System.out.println("\n\t\t1.��Ʒά��\n");
		System.out.println("\t\t2.ǰ̨����\n");
		System.out.println("\t\t3.��Ʒ����\n");
		System.out.println("****************************************");
		System.out.println("��ѡ��,�������ֻ��߰�0�˳���");
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			int num = input.nextInt();
			switch (num) {
			case 0:
				System.out.println("лл����ʹ�ã�");
				System.exit(0);
				break;
			case 1:
				System.out.println("ִ����ʾ��Ʒά���˵�");
				mainMenu01();
				break;
			case 2:
				System.out.println("ִ��ǰ̨����\n\n");
				mainMenu02();
				break;
			case 3:
				System.out.println("ִ����Ʒ����\n\n");
				mainMenu03();
				break;
			default:
				System.out.println("\n�����������������");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * ��Ʒά���˵�����
	 */
	public static void mainMenu01() {
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("�̳��������ϵͳ>>��Ʒά��");
			System.out.println("****************************************");
			System.out.println("\n\t\t1.�����Ʒ\n");
			System.out.println("\t\t2.������Ʒ\n");
			System.out.println("\t\t3.ɾ����Ʒ\n");
			System.out.println("\t\t4.��ʾ������Ʒ\n");
			System.out.println("\t\t5.��ѯ��Ʒ\n");
			System.out.println("****************************************");
			System.out.println("��ѡ��,�������ֻ��߰�0������һ���˵���");
			int num = input.nextInt();
			switch (num) {
			case 0:
				mainMenu();
				break;
			case 1:
				String flag = "y";
				while ("y".equals(flag)) {
					System.out.println("ִ�������Ʒ������");
					System.out.println("\n�����������Ʒ���ƣ�");
					String goodsName = input.next();
					float goodsPrice = 0;
					int goodsNum=0;
					String fla = "y";
					while ("y".equals(fla)) {
						System.out.println("\n�����������Ʒ�۸�");
						goodsPrice = input.nextFloat();
						if(goodsPrice<=0){
							System.out.println("���������룬��Ʒ�۸�Ӧ�ô���0��");
							fla="y";
						}else
							fla="n";
					}
					String fla2 = "y";
					while ("y".equals(fla2)) {
						System.out.println("\n�����������Ʒ������");
						goodsNum = input.nextInt();
						if(goodsNum<=0){
							System.out.println("���������룬��Ʒ�۸�Ӧ�ô���0��");
							fla2="y";
						}else
							fla2="n";
					}
					
					Goods goods = new Goods(goodsName, goodsPrice, goodsNum);
					int count = GoodsDao.add(goods);
					if (count > 0) {
						System.out.println("���ӳɹ���");
					} else {
						System.out.println("����ʧ�ܣ�");
					}
					System.out.println("�Ƿ������ӣ�y/n��");
					flag = input.next();
				}
				con = true;
				break;
			case 2:
				String flag1 = "y";
				while ("y".equals(flag1)) {
					System.out.println("ִ�и�����Ʒ������");
					System.out.println("\n������Ҫ���ĵ���Ʒ���ƣ�");
					String goodsName = input.next();
					System.out.println("\n�������µ���Ʒ���ƣ�");
					String newGoodsName = input.next();
					System.out.println("\n�������µ���Ʒ�۸�");
					float newGoodsPrice = input.nextFloat();
					System.out.println("\n�������µ���Ʒ������");
					int newGoodsNum = input.nextInt();
					Goods goods = new Goods(newGoodsName, newGoodsPrice, newGoodsNum);
					int count = GoodsDao.mod(goods, goodsName);
					if (count > 0) {
						System.out.println("���ĳɹ���");
					} else {
						System.out.println("����ʧ�ܣ�");
					}
					System.out.println("�Ƿ�������ģ�y/n��");
					flag1 = input.next();
				}
				con = true;
				break;
			case 3:
				String flag2 = "y";
				while ("y".equals(flag2)) {
					System.out.println("ִ��ɾ����Ʒ������");
					System.out.println("\n������Ҫɾ������Ʒ���ƣ�");
					String goodsName = input.next();
					int count = GoodsDao.del(goodsName);
					if (count > 0) {
						System.out.println("ɾ���ɹ���");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
					System.out.println("�Ƿ����ɾ����y/n��");
					flag2 = input.next();
				}
				con = true;
				break;
			case 4:
				System.out.println("ִ����ʾ������Ʒ�Ĳ���");
				List<Goods> goodList = GoodsDao.query();
				System.out.printf("%-17s%-17s%-17s%-17s\n", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "��ע");
				for (Goods goods : goodList) {
					System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
							goods.getGoodsNum(), goods.getInfo());
				}
				con = true;
				break;
			case 5:
				System.out.println("ִ�в�ѯ��Ʒ�Ĳ���");
				boolean con1 = false;
				do {
					System.out.println("\n1������Ʒ���������ѯ\n");
					System.out.println("2������Ʒ�۸������ѯ\n");
					System.out.println("3������ؼ��ֲ�ѯ\n");
					System.out.println("��ѡ��,�������ֻ��߰�0������һ���˵���");
					int num1 = input.nextInt();
					switch (num1) {
					case 0:
						mainMenu01();
						break;
					case 1:
						List<Goods> upGoodList = GoodsDao.upNumsQuery();
						System.out.printf("%-17s%-17s%-17s%-17s\n", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "��ע");
						for (Goods goods : upGoodList) {
							System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
									goods.getGoodsNum(), goods.getInfo());
						}
						con1 = true;
						break;
					case 2:
						List<Goods> upPrice = GoodsDao.upPrice();
						System.out.printf("%-17s%-17s%-17s%-17s\n", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "��ע");
						for (Goods goods : upPrice) {
							System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
									goods.getGoodsNum(), goods.getInfo());
						}
						con1 = true;
						break;
					case 3:
						System.out.println("������Ҫ��ѯ��Ʒ�Ĺؼ��֣�");
						String goodName = input.next();
						List<Goods> goodList1 = GoodsDao.getByName(goodName);
						System.out.printf("%-17s%-17s%-17s%-17s\n", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "��ע");
						for (Goods goods : goodList1) {
							System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
									goods.getGoodsNum(), goods.getInfo());
						}
						con1 = true;
						break;
					default:
						System.out.println("\n�����������������");
						con1 = true;
						break;
					}
				} while (con1);
				con = true;
				break;
			default:
				System.out.println("\n�����������������");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * ǰ̨�����˵�����
	 */
	public static void mainMenu02() {
		int tureSalesmanID;
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("��ӭʹ���̳��������ϵͳ");
			System.out.println("****************************************");
			System.out.println("\n\t\t1.��¼ϵͳ \n");
			System.out.println("\t\t2.�˳�,�������ϼ��˵�\n");
			System.out.println("��ѡ�����������֣�");
			int num = input.nextInt();
			switch (num) {
			case 1:

				List<Salesman> salesmanList = SalesmanDao.query();
				for (int i = 3; i > 0; i--) {
					System.out.println("\n�������û�����");
					String name = input.next();
					System.out.println("\n���������룺");
					String password = input.next();

					Salesman admin = new Salesman(name, password);
					if (salesmanList.contains(admin)) {
						List<Salesman> salesman = SalesmanDao.getByName(name);
						tureSalesmanID = salesman.get(0).getSalesManId();
						System.out.println("��½�ɹ������빺����㹦��");
						mainMenu0202(tureSalesmanID);
						break;
					} else {
						System.out.print("�û������벻ƥ��!\n������" + (i - 1) + "�ε������,���������룺");
					}
				}
				System.out.println("ϵͳ���˳���");
				break;
			case 2:
				mainMenu();
				break;
			default:
				System.out.println("\n�����������������");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * ������㹦�ܲ˵�
	 */
	private static void mainMenu0202(int tureSalesmanID) {
		float total = 0;
		String flag = "y";
		Scanner console = new Scanner(System.in);
		while ("y".equals(flag)) {
			System.out.println("\t\t\t1.�������");
			String dot1 = "y";
			while ("y".equals(dot1)) {
				System.out.println("��������Ʒ�Ĺؼ���");

				String vagueGoodsName = console.next();
				List<Goods> vagueList = GSalesDao.vagueQuery(vagueGoodsName);
				if (vagueList.isEmpty()) {
					System.out.println("û���ҵ���Ҫ�������Ʒ�����������룺");
					dot1 = "y";
				} else {
					System.out.printf("%-17s%-17s%-17s%-17s\n", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "��ע");
					for (Goods goods : vagueList) {
						System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
								goods.getGoodsNum(),goods.getInfo());
					}
					dot1 = "n";
				}
			}

			System.out.println("��ѡ����Ʒ");
			String buyGoodsName = console.next();
			List<Goods> buyList = GoodsDao.getByName(buyGoodsName);
			int buyGoodsNums = 0;
			String dot = "y";
			while ("y".equals(dot)) {
				System.out.println("�����빺������");
				buyGoodsNums = console.nextInt();
				if (buyGoodsNums > buyList.get(0).getGoodsNum()) {
					System.out.println("��治�㣬�������������");
					dot = "y";
				} else {
					dot = "n";
				}
			}
			int soldNum = buyList.get(0).getGoodsNum() - buyGoodsNums;
			GSalesDao.goodsChange(soldNum, buyGoodsName);
			Goods buyGoods = buyList.get(0);
			total = total + buyList.get(0).getGoodsPrice() * buyGoodsNums;
			GSalesDao.addSalesGoods(buyGoods, buyGoodsNums, tureSalesmanID);

			for (Goods goods1 : buyList) {
				System.out.println(goods1.getGoodsName() + "\t" + "��" + goods1.getGoodsPrice() + "\t��������" + buyGoodsNums
						+ "\t\t" + buyGoodsName + "�ܼ�" + (goods1.getGoodsPrice() * buyGoodsNums));
			}

			System.out.println("�Ƿ��������(y/n)");
			flag = console.next();

		}

		String flage = "y";
		System.out.println("�ܼƣ�" + total + "Ԫ");
		while ("y".equals(flage)) {
			System.out.println("������ʵ�ʽɷѽ�");
			float m = console.nextFloat();
			if (m <= total) {
				System.out.println("���Ľ���֧����Щ��Ʒ������������");
				flage = "y";
			} else {
				System.out.println("��Ǯ��" + (m - total) + "Ԫ");
				System.out.println("лл���٣�");
				flage = "n";
				mainMenu02();
			}
		}
		console.close();
	}

	/**
	 * ��Ʒ����˵�����
	 */
	public static void mainMenu03() {
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("�̳��������ϵͳ>>��Ʒ����");
			System.out.println("****************************************");
			System.out.println("\n\t\t1.�г�������������Ʒ�б�\n");
			System.out.println("\t\t2.�ۻ�Ա����\n");
			System.out.println("****************************************");
			System.out.println("��ѡ��,�������ֻ��߰�0������һ���˵���");
			int num = input.nextInt();
			switch (num) {
			case 0:
				mainMenu();
				break;
			case 1:
				System.out.println("ִ�е�����������Ʒ�б������");
				System.out.println("\n�����۳���Ʒ��");
				List<TodaySold> goodsListToday = GSalesDao.GoodSales();
				System.out.printf("%-17s%-17s%-17s%-17s%-17s\n", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "����", "��ע");
				for (TodaySold todaySold : goodsListToday) {
					System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", todaySold.getSaleGoodsName(),
							todaySold.getSaleGoodsPrice(), todaySold.getSaleGoodsSums(), todaySold.getSaleGoodsNums(),
							todaySold.getInfo());
				}
				con = true;
				break;
			case 2:
				mainMenu0302();
				break;
			default:
				System.out.println("\n�����������������");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * �̳�����ϵͳ>>��Ʒ����>>�ۻ�Ա����˵�
	 */

	private static void mainMenu0302() {
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("�̳��������ϵͳ>>��Ʒ����>>�ۻ�Ա����");
			System.out.println("****************************************");
			System.out.println("\n\t1.����ۻ�Ա\n");
			System.out.println("\n\t2.�����ۻ�Ա\n");
			System.out.println("\n\t3.ɾ���ۻ�Ա\n");
			System.out.println("\n\t4.��ʾ�����ۻ�Ա\n");
			System.out.println("\n\t5.��ѯ�ۻ�Ա\n");
			System.out.println("****************************************");
			System.out.println("��ѡ��,�������ֻ��߰�0������һ���˵���");
			int num = input.nextInt();
			switch (num) {
			case 0:
				mainMenu03();
				break;
			case 1:
				String flag = "y";
				while ("y".equals(flag)) {
					System.out.println("ִ������ۻ�Ա������");
					System.out.println("\n�������ۻ�Ա������");
					String salesManName = input.next();
					System.out.println("\n�������ۻ�Ա���룺");
					String salesManPassword = input.next();
					Salesman sales = new Salesman(salesManName, salesManPassword);
					int count = SalesmanDao.add(sales);
					if (count > 0) {
						System.out.println("����ۻ�Ա�ɹ���");
					} else {
						System.out.println("����ۻ�Աʧ�ܣ�");
					}
					System.out.println("�Ƿ������ӣ�y/n��");
					flag = input.next();
				}
				con = true;
				break;
			case 2:
				String flag1 = "y";
				while ("y".equals(flag1)) {
					System.out.println("ִ�и����ۻ�Ա������");
					System.out.println("\n������Ҫ���ĵ��ۻ�Ա���ƣ�");
					String salesManName = input.next();
					System.out.println("\n�������µ��ۻ�Ա���ƣ�");
					String newsalesManName = input.next();
					System.out.println("\n�������µ��ۻ�Ա���룺");
					String newsalesManPass = input.next();
					Salesman sales = new Salesman(newsalesManName, newsalesManPass);
					int count = SalesmanDao.mod(sales, salesManName);
					if (count > 0) {
						System.out.println("���ĳɹ���");
					} else {
						System.out.println("����ʧ�ܣ�");
					}
					System.out.println("�Ƿ�������ģ�y/n��");
					flag1 = input.next();
				}
				con = true;
				break;
			case 3:
				String flag2 = "y";
				while ("y".equals(flag2)) {
					System.out.println("ִ��ɾ���ۻ�Ա������");
					System.out.println("\n������Ҫɾ�����ۻ�Ա���ƣ�");
					String salesManName = input.next();
					int count = SalesmanDao.del(salesManName);
					if (count > 0) {
						System.out.println("ɾ���ɹ���");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
					System.out.println("�Ƿ����ɾ����y/n��");
					flag2 = input.next();
				}
				con = true;
				break;
			case 4:
				System.out.println("ִ����ʾ�����ۻ�Ա�Ĳ���");
				List<Salesman> salesmanList = SalesmanDao.query();
				System.out.printf("%-17s%-17s%-17s\n", "�ۻ�Ա���", "�ۻ�Ա����", "�ۻ�Ա����");
				for (Salesman sales : salesmanList) {
					System.out.printf("%-20s%-20s%-20s\n", sales.getSalesManId(), sales.getSalesManName(),
							sales.getSalesManPassword());
				}
				con = true;
				break;
			case 5:
				System.out.println("������Ҫ��ѯ�ۻ�Ա�����ؼ���:");
				String salesmanName = input.next();
				List<Salesman> salesmanList1 = SalesmanDao.getByName(salesmanName);
				System.out.printf("%-17s%-17s%-17s\n", "�ۻ�Ա���", "�ۻ�Ա����", "�ۻ�Ա����");
				for (Salesman sales : salesmanList1) {
					System.out.printf("%-20s%-20s%-20s\n", sales.getSalesManId(), sales.getSalesManName(),
							sales.getSalesManPassword());
				}
				con = true;
				break;
			default:
				System.out.println("\n�����������������");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}
}
