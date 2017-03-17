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
 * 系統入口
 * 
 * @author 汪博
 *  
 */
public class MainPage {
	public static void main(String[] args) {

		mainMenu();

	}

	/**
	 * 主菜单界面
	 */
	public static void mainMenu() {
		System.out.println("****************************************");
		System.out.println("\n\t\t1.商品维护\n");
		System.out.println("\t\t2.前台收银\n");
		System.out.println("\t\t3.商品管理\n");
		System.out.println("****************************************");
		System.out.println("请选择,输入数字或者按0退出：");
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			int num = input.nextInt();
			switch (num) {
			case 0:
				System.out.println("谢谢您的使用！");
				System.exit(0);
				break;
			case 1:
				System.out.println("执行显示商品维护菜单");
				mainMenu01();
				break;
			case 2:
				System.out.println("执行前台收银\n\n");
				mainMenu02();
				break;
			case 3:
				System.out.println("执行商品管理\n\n");
				mainMenu03();
				break;
			default:
				System.out.println("\n输入错误，请重新输入");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * 商品维护菜单界面
	 */
	public static void mainMenu01() {
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("商超购物管理系统>>商品维护");
			System.out.println("****************************************");
			System.out.println("\n\t\t1.添加商品\n");
			System.out.println("\t\t2.更改商品\n");
			System.out.println("\t\t3.删除商品\n");
			System.out.println("\t\t4.显示所有商品\n");
			System.out.println("\t\t5.查询商品\n");
			System.out.println("****************************************");
			System.out.println("请选择,输入数字或者按0返回上一级菜单：");
			int num = input.nextInt();
			switch (num) {
			case 0:
				mainMenu();
				break;
			case 1:
				String flag = "y";
				while ("y".equals(flag)) {
					System.out.println("执行添加商品操作：");
					System.out.println("\n请输入添加商品名称：");
					String goodsName = input.next();
					float goodsPrice = 0;
					int goodsNum=0;
					String fla = "y";
					while ("y".equals(fla)) {
						System.out.println("\n请输入添加商品价格：");
						goodsPrice = input.nextFloat();
						if(goodsPrice<=0){
							System.out.println("请重新输入，商品价格应该大于0。");
							fla="y";
						}else
							fla="n";
					}
					String fla2 = "y";
					while ("y".equals(fla2)) {
						System.out.println("\n请输入添加商品数量：");
						goodsNum = input.nextInt();
						if(goodsNum<=0){
							System.out.println("请重新输入，商品价格应该大于0。");
							fla2="y";
						}else
							fla2="n";
					}
					
					Goods goods = new Goods(goodsName, goodsPrice, goodsNum);
					int count = GoodsDao.add(goods);
					if (count > 0) {
						System.out.println("增加成功！");
					} else {
						System.out.println("增加失败！");
					}
					System.out.println("是否继续添加（y/n）");
					flag = input.next();
				}
				con = true;
				break;
			case 2:
				String flag1 = "y";
				while ("y".equals(flag1)) {
					System.out.println("执行更改商品操作：");
					System.out.println("\n请输入要更改的商品名称：");
					String goodsName = input.next();
					System.out.println("\n请输入新的商品名称：");
					String newGoodsName = input.next();
					System.out.println("\n请输入新的商品价格：");
					float newGoodsPrice = input.nextFloat();
					System.out.println("\n请输入新的商品数量：");
					int newGoodsNum = input.nextInt();
					Goods goods = new Goods(newGoodsName, newGoodsPrice, newGoodsNum);
					int count = GoodsDao.mod(goods, goodsName);
					if (count > 0) {
						System.out.println("更改成功！");
					} else {
						System.out.println("更改失败！");
					}
					System.out.println("是否继续更改（y/n）");
					flag1 = input.next();
				}
				con = true;
				break;
			case 3:
				String flag2 = "y";
				while ("y".equals(flag2)) {
					System.out.println("执行删除商品操作：");
					System.out.println("\n请输入要删除的商品名称：");
					String goodsName = input.next();
					int count = GoodsDao.del(goodsName);
					if (count > 0) {
						System.out.println("删除成功！");
					} else {
						System.out.println("删除失败！");
					}
					System.out.println("是否继续删除（y/n）");
					flag2 = input.next();
				}
				con = true;
				break;
			case 4:
				System.out.println("执行显示所有商品的操作");
				List<Goods> goodList = GoodsDao.query();
				System.out.printf("%-17s%-17s%-17s%-17s\n", "商品名称", "商品价格", "商品数量", "备注");
				for (Goods goods : goodList) {
					System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
							goods.getGoodsNum(), goods.getInfo());
				}
				con = true;
				break;
			case 5:
				System.out.println("执行查询商品的操作");
				boolean con1 = false;
				do {
					System.out.println("\n1、按商品数量升序查询\n");
					System.out.println("2、按商品价格升序查询\n");
					System.out.println("3、输入关键字查询\n");
					System.out.println("请选择,输入数字或者按0返回上一级菜单：");
					int num1 = input.nextInt();
					switch (num1) {
					case 0:
						mainMenu01();
						break;
					case 1:
						List<Goods> upGoodList = GoodsDao.upNumsQuery();
						System.out.printf("%-17s%-17s%-17s%-17s\n", "商品名称", "商品价格", "商品数量", "备注");
						for (Goods goods : upGoodList) {
							System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
									goods.getGoodsNum(), goods.getInfo());
						}
						con1 = true;
						break;
					case 2:
						List<Goods> upPrice = GoodsDao.upPrice();
						System.out.printf("%-17s%-17s%-17s%-17s\n", "商品名称", "商品价格", "商品数量", "备注");
						for (Goods goods : upPrice) {
							System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
									goods.getGoodsNum(), goods.getInfo());
						}
						con1 = true;
						break;
					case 3:
						System.out.println("请输入要查询商品的关键字：");
						String goodName = input.next();
						List<Goods> goodList1 = GoodsDao.getByName(goodName);
						System.out.printf("%-17s%-17s%-17s%-17s\n", "商品名称", "商品价格", "商品数量", "备注");
						for (Goods goods : goodList1) {
							System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
									goods.getGoodsNum(), goods.getInfo());
						}
						con1 = true;
						break;
					default:
						System.out.println("\n输入错误，请重新输入");
						con1 = true;
						break;
					}
				} while (con1);
				con = true;
				break;
			default:
				System.out.println("\n输入错误，请重新输入");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * 前台收银菜单界面
	 */
	public static void mainMenu02() {
		int tureSalesmanID;
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("欢迎使用商超购物管理系统");
			System.out.println("****************************************");
			System.out.println("\n\t\t1.登录系统 \n");
			System.out.println("\t\t2.退出,并返回上级菜单\n");
			System.out.println("请选择，请输入数字：");
			int num = input.nextInt();
			switch (num) {
			case 1:

				List<Salesman> salesmanList = SalesmanDao.query();
				for (int i = 3; i > 0; i--) {
					System.out.println("\n请输入用户名：");
					String name = input.next();
					System.out.println("\n请输入密码：");
					String password = input.next();

					Salesman admin = new Salesman(name, password);
					if (salesmanList.contains(admin)) {
						List<Salesman> salesman = SalesmanDao.getByName(name);
						tureSalesmanID = salesman.get(0).getSalesManId();
						System.out.println("登陆成功，进入购物结算功能");
						mainMenu0202(tureSalesmanID);
						break;
					} else {
						System.out.print("用户名密码不匹配!\n您还有" + (i - 1) + "次登入机会,请重新输入：");
					}
				}
				System.out.println("系统已退出！");
				break;
			case 2:
				mainMenu();
				break;
			default:
				System.out.println("\n输入错误，请重新输入");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * 购物结算功能菜单
	 */
	private static void mainMenu0202(int tureSalesmanID) {
		float total = 0;
		String flag = "y";
		Scanner console = new Scanner(System.in);
		while ("y".equals(flag)) {
			System.out.println("\t\t\t1.购物结算");
			String dot1 = "y";
			while ("y".equals(dot1)) {
				System.out.println("请输入商品的关键字");

				String vagueGoodsName = console.next();
				List<Goods> vagueList = GSalesDao.vagueQuery(vagueGoodsName);
				if (vagueList.isEmpty()) {
					System.out.println("没有找到您要购买的商品，请重新输入：");
					dot1 = "y";
				} else {
					System.out.printf("%-17s%-17s%-17s%-17s\n", "商品名称", "商品价格", "商品数量", "备注");
					for (Goods goods : vagueList) {
						System.out.printf("%-20s%-20s%-20s%-20s\n", goods.getGoodsName(), goods.getGoodsPrice(),
								goods.getGoodsNum(),goods.getInfo());
					}
					dot1 = "n";
				}
			}

			System.out.println("请选择商品");
			String buyGoodsName = console.next();
			List<Goods> buyList = GoodsDao.getByName(buyGoodsName);
			int buyGoodsNums = 0;
			String dot = "y";
			while ("y".equals(dot)) {
				System.out.println("请输入购买数量");
				buyGoodsNums = console.nextInt();
				if (buyGoodsNums > buyList.get(0).getGoodsNum()) {
					System.out.println("库存不足，请调整购买数量");
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
				System.out.println(goods1.getGoodsName() + "\t" + "￥" + goods1.getGoodsPrice() + "\t购买数量" + buyGoodsNums
						+ "\t\t" + buyGoodsName + "总价" + (goods1.getGoodsPrice() * buyGoodsNums));
			}

			System.out.println("是否继续购买(y/n)");
			flag = console.next();

		}

		String flage = "y";
		System.out.println("总计：" + total + "元");
		while ("y".equals(flage)) {
			System.out.println("请输入实际缴费金额：");
			float m = console.nextFloat();
			if (m <= total) {
				System.out.println("您的金额不够支付这些商品，请重新输入");
				flage = "y";
			} else {
				System.out.println("找钱：" + (m - total) + "元");
				System.out.println("谢谢光临！");
				flage = "n";
				mainMenu02();
			}
		}
		console.close();
	}

	/**
	 * 商品管理菜单界面
	 */
	public static void mainMenu03() {
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("商超购物管理系统>>商品管理");
			System.out.println("****************************************");
			System.out.println("\n\t\t1.列出当日卖出的商品列表\n");
			System.out.println("\t\t2.售货员管理\n");
			System.out.println("****************************************");
			System.out.println("请选择,输入数字或者按0返回上一级菜单：");
			int num = input.nextInt();
			switch (num) {
			case 0:
				mainMenu();
				break;
			case 1:
				System.out.println("执行当日卖出的商品列表操作：");
				System.out.println("\n今日售出商品：");
				List<TodaySold> goodsListToday = GSalesDao.GoodSales();
				System.out.printf("%-17s%-17s%-17s%-17s%-17s\n", "商品名称", "商品价格", "商品数量", "销量", "备注");
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
				System.out.println("\n输入错误，请重新输入");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}

	/**
	 * 商超管理系统>>商品管理>>售货员管理菜单
	 */

	private static void mainMenu0302() {
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do {
			System.out.println("商超购物管理系统>>商品管理>>售货员管理");
			System.out.println("****************************************");
			System.out.println("\n\t1.添加售货员\n");
			System.out.println("\n\t2.更改售货员\n");
			System.out.println("\n\t3.删除售货员\n");
			System.out.println("\n\t4.显示所有售货员\n");
			System.out.println("\n\t5.查询售货员\n");
			System.out.println("****************************************");
			System.out.println("请选择,输入数字或者按0返回上一级菜单：");
			int num = input.nextInt();
			switch (num) {
			case 0:
				mainMenu03();
				break;
			case 1:
				String flag = "y";
				while ("y".equals(flag)) {
					System.out.println("执行添加售货员操作：");
					System.out.println("\n请输入售货员姓名：");
					String salesManName = input.next();
					System.out.println("\n请输入售货员密码：");
					String salesManPassword = input.next();
					Salesman sales = new Salesman(salesManName, salesManPassword);
					int count = SalesmanDao.add(sales);
					if (count > 0) {
						System.out.println("添加售货员成功！");
					} else {
						System.out.println("添加售货员失败！");
					}
					System.out.println("是否继续添加（y/n）");
					flag = input.next();
				}
				con = true;
				break;
			case 2:
				String flag1 = "y";
				while ("y".equals(flag1)) {
					System.out.println("执行更改售货员操作：");
					System.out.println("\n请输入要更改的售货员名称：");
					String salesManName = input.next();
					System.out.println("\n请输入新的售货员名称：");
					String newsalesManName = input.next();
					System.out.println("\n请输入新的售货员密码：");
					String newsalesManPass = input.next();
					Salesman sales = new Salesman(newsalesManName, newsalesManPass);
					int count = SalesmanDao.mod(sales, salesManName);
					if (count > 0) {
						System.out.println("更改成功！");
					} else {
						System.out.println("更改失败！");
					}
					System.out.println("是否继续更改（y/n）");
					flag1 = input.next();
				}
				con = true;
				break;
			case 3:
				String flag2 = "y";
				while ("y".equals(flag2)) {
					System.out.println("执行删除售货员操作：");
					System.out.println("\n请输入要删除的售货员名称：");
					String salesManName = input.next();
					int count = SalesmanDao.del(salesManName);
					if (count > 0) {
						System.out.println("删除成功！");
					} else {
						System.out.println("删除失败！");
					}
					System.out.println("是否继续删除（y/n）");
					flag2 = input.next();
				}
				con = true;
				break;
			case 4:
				System.out.println("执行显示所有售货员的操作");
				List<Salesman> salesmanList = SalesmanDao.query();
				System.out.printf("%-17s%-17s%-17s\n", "售货员编号", "售货员姓名", "售货员密码");
				for (Salesman sales : salesmanList) {
					System.out.printf("%-20s%-20s%-20s\n", sales.getSalesManId(), sales.getSalesManName(),
							sales.getSalesManPassword());
				}
				con = true;
				break;
			case 5:
				System.out.println("请输入要查询售货员姓名关键字:");
				String salesmanName = input.next();
				List<Salesman> salesmanList1 = SalesmanDao.getByName(salesmanName);
				System.out.printf("%-17s%-17s%-17s\n", "售货员编号", "售货员姓名", "售货员密码");
				for (Salesman sales : salesmanList1) {
					System.out.printf("%-20s%-20s%-20s\n", sales.getSalesManId(), sales.getSalesManName(),
							sales.getSalesManPassword());
				}
				con = true;
				break;
			default:
				System.out.println("\n输入错误，请重新输入");
				con = true;
				break;
			}
		} while (con);
		input.close();
	}
}
