package com.ynj.indexs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.ynj.beans.Competition;
import com.ynj.beans.CompetitionGrade;
import com.ynj.beans.Notice;
import com.ynj.beans.User;

public class Main {
    //用户数据集合
	public static List<User> userList=new ArrayList<User>();
	//管理员数据集合
	public static List<User>managerList=new ArrayList<User>();
	//赛事数据集合
	public static List<Competition>competitionList=new ArrayList<Competition>();
	//通知公告集合
	public static List<Notice> noticeList=new ArrayList<Notice>();
	//赛事成绩集合
	public static List<CompetitionGrade>competitionGradeList=new ArrayList<CompetitionGrade>();
	public static void main(String[] args) {
		//自定义一个管理员账号
		User manager=new User();
		manager.setUsername("manager");
		manager.setPassword("password");
		//添加进账号
		managerList.add(manager);
		 Scanner input=new Scanner(System.in); 
		//欢迎标语
		System.out.println("欢迎来到马拉松管理系统!");
		//
		System.out.println("若有账号，请登录。若没有账号，请先注册。请在以下选项中，选择你要进行的功能：");
		System.out.println("1、用户端登录");
		System.out.println("2、管理员端登录");
		System.out.println("3、注册");
		//输入要选择的功能
		int index1=input.nextInt();
		if(index1==1) {
			userLogin();
		}
		else if(index1==2) {
			managerLogin();
		}
		else if(index1==3){
			register();
		}
	}
	//用户登录
	public static void userLogin() {
		Scanner input=new Scanner(System.in);
		String username=null,password=null;
		System.out.println("请输入用户名:");
		username=input.nextLine();
		System.out.println("请输入密码:");
		password=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					if(user.isAvalible()==true)
					isSuccess=true;
					else {
						System.out.println("该账号已被禁用，请联系管理员!");
					}
					break;
				}
			}
		}
		if(isSuccess) {
			System.out.println("登陆成功"+"欢迎您"+username);
		}
		else {
			System.out.println("登录失败");
		}
		System.out.println("请选择以下功能:");
		System.out.println("1、重新登录");
		System.out.println("2、回到主页");
		System.out.println("3、用户首页");
		System.out.println("4、退出系统");
		int index=input.nextInt();
		if(index==1) {
			userLogin();
		}
		else if(index==2) {
			main(null);
		}
		else if(index==3) {
			userIndex();
		}
		else if(index==4) {
			exit();
		}
	}
	//管理员端登录
	public static void managerLogin() {
		Scanner input=new Scanner(System.in);
		String username=null,password=null;
		System.out.println("请输入用户名:");
		username=input.nextLine();
		System.out.println("请输入密码:");
		password=input.nextLine();
		boolean isSuccess=false;
		for(User user:managerList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					isSuccess=true;
					break;
				}
			}
		}
		if(isSuccess) {
			System.out.println("登陆成功"+"欢迎您"+username);
		}
		else {
			System.out.println("登录失败");
		}
		System.out.println("请选择以下功能:");
		System.out.println("1、重新登录");
		System.out.println("2、回到主页");
		System.out.println("3、管理员首页");
		System.out.println("4、退出系统");
		
		int index=input.nextInt();
		if(index==1) {
			managerLogin();
		}
		else if(index==2) {
			main(null);
		}
		else if(index==3) {
			managerIndex();
		}
		else if(index==4) {
			exit();
		}
	}
	
	//注册
	public static void register() {
		Scanner input=new Scanner(System.in); 
		String password = null;
		String username = null;
		System.out.println("------注册------");
		boolean flag=true;
		boolean isUsernameable=true;
		while(flag) {
			//输入用户名
			System.out.println("请输入您的用户名:");
			username=input.nextLine();
			//用户名校验
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				System.out.println("用户名已存在，请重新输入");
				isUsernameable=false;
				flag=true;
				break;
			}
		}
		//如果用户名不可用
		if(isUsernameable==false)
		{
			//无需输入密码
			isUsernameable=true;
		}
		else {
			System.out.println("请输入您的密码:");
		    password=input.nextLine();
			flag=false;
		}
		}
		//封装数据
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//放入list
		userList.add(user);
		System.out.println("注册成功!");
		System.out.println("请选择:");
		System.out.println("1、回到主页");
		System.out.println("2、登录");
		System.out.println("3、退出系统");
		
		int index=input.nextInt();
		if(index==1) {
			main(null);
		}
		else if(index==2) {
			userLogin();
		}
		else {
			exit();
		}
	}
	
	
	public static void exit() {
		System.out.println("------------系统退出成功------------");
	}
	//管理员首页
	public static void managerIndex() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------管理员欢迎您！---------");
		System.out.println("请选择以下功能进行操作:");
		System.out.println("1、账户管理");
		System.out.println("2、比赛管理");
		System.out.println("3、成绩管理");
		System.out.println("4、通知管理");
		System.out.println("5、返回主页");
		System.out.println("6、退出系统");
		int index=input.nextInt();
		if(index==1) {
			userManage();
		}
		else if(index==2) {
			competitionManage();
		}
		else if(index==3) {
			gradeManage();
		}
        else if(index==4) {
		   noticeManage();
		}
        else if(index==5) {
	    main(null);
}
        else if(index==6) {
	    exit();
}
	}
	//用户首页
	public static void userIndex() {
		System.out.println("------------马拉松管理系统欢迎您------------");
		System.out.println("请选择以下功能:");
		System.out.println("1、比赛报名");
		System.out.println("2、比赛成绩查询");
		System.out.println("3、比赛公告");
		System.out.println("4、返回主页");
		System.out.println("5、退出系统");
		Scanner input=new Scanner(System.in);
		int index=input.nextInt();
		if(index==1) {
			competitionRegister();
		}
		else if(index==2) {
			competitionGrade();
		}
		else if(index==3) {
			competitionNotice();
		}
		else if(index==4) {
			main(null);
		}
		else if(index==5) {
			exit();
		}
	}
	//账户管理
	public static void userManage() {
		System.out.println("请选择以下操作对用户账户进行管理:");
		System.out.println("1、查询账户");
		System.out.println("2、禁用账户");
		System.out.println("3、重置密码");
		System.out.println("4、返回管理员首页");
		System.out.println("5、返回主页");
		Scanner input=new Scanner(System.in);
		int index=input.nextInt();
		if(index==1) {
			userSelect();
		}
		else if(index==2) {
			userDisabled();
		}
		else if(index==3) {
			resetPassword();
		}
        else if(index==4) {
        	managerIndex();
		}
        else if(index==5) {
	    main(null);
}
	}
	
	
	//账户禁用
	public static void userDisabled() {
		System.out.println("请输入您要禁用的账户:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				System.out.println("是否确认禁用该用户，确认请输入1，取消请按2");
				int x=input.nextInt();
				if(x==1) {
					user.setAvalible(false);
					System.out.println("禁用成功!");
				}
				else {
					System.out.println("禁用失败!");	
				}
				
			break;
			}
		}
		System.out.println("自动跳转到账户管理页面。1	...2...");
		userManage();
	}
	//查询账户
	public static void userSelect() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你要查询的用户名:");
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
				System.out.println("查询成功");
				System.out.println(user);
				break;
			}
	}
		if(!isSuccess)
		System.out.println("查询失败，无此账号信息，请核对");
	System.out.println("继续查询请按1，返回请按2");
	int index=input.nextInt();
	if(index==1) {
		userSelect();
	}
	else if(index==2) {
		userManage();
	}
	}
	
	
	//重置密码
	public static void resetPassword() {
		System.out.println("请输入你要重置密码的账号:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
				System.out.println("确认是否重置密码，确认请按1，取消请按2");
				int index=input.nextInt();
				if(index==1) {
					System.out.println("请输入密码进行重置：");
					String password=input.next();
					user.setPassword(password);
					System.out.println("重置成功");
				}
				else if(index==2) {
					System.out.println("取消重置");
				}
				
			}
		}
		//查询失败时
		if(!isSuccess)
			System.out.println("查询失败，无此账号信息，请核对！");
		System.out.println("继续重置密码，请按1，返回请按2:");
		int index=input.nextInt();
		if(index==1) {
			resetPassword();
		}
		else if(index==2) {
			userManage();
		}
	}
	
	
	//报名
	public static void competitionRegister() {
		Scanner input=new Scanner(System.in);
		//获取比赛列表
		System.out.println("请选择你要选择比赛名称:");
		String name=input.nextLine();
		boolean isCompExist=false;
		Competition comp = null;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isCompExist=true;
				comp=competition;
			}
		}
		if(!isCompExist) {
			System.out.println("赛事不存在，即将返回用户首页");
			userIndex();
		}
		else {
		//输入您的个人信息
		System.out.println("请输入您的用户名:");
		String username=input.nextLine();
		boolean isExist=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isExist=true;
				if(comp!=null) {
				comp.getUsersList().add(user);
				comp.setNumber(comp.getNumber()+1);
					System.out.println("报名成功");
					}
				else {
					System.out.println("报名失败");
				}
			}
		}
		if(!isExist) {
			System.out.println("用户不存在，报名失败");
		}
		}
		System.out.println("1....2...返回用户首页");
		userIndex();
	}
	
	//赛事管理
	public static void competitionManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("请对赛事进行以下操作:");
		System.out.println("1、添加比赛");
		System.out.println("2、启停比赛");
		System.out.println("3、查询报名情况");
		System.out.println("4、返回管理员首页");
		int index=input.nextInt();
		if(index==1) {
			insertCompetition();
		}
		else if(index==2) {
			handleCompetition();
		}
		else if(index==3) {
			selectRegister();
		}
		else if(index==4) {
			managerIndex();
		}
	}
	//添加比赛
	public static void insertCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入比赛名称:");
		String name=input.nextLine();
		System.out.println("请输入比赛内容");
		String content=input.nextLine();
		System.out.println("是否进行添加，确定按1，取消按2");
		int index =input.nextInt();
		if(index==1) {
			Competition competition=new Competition(name,content);
			competitionList.add(competition);
			System.out.println("添加比赛成功!");
		}
	System.out.println("1....2...返回管理员首页");
	managerIndex();
	}
	//启停比赛
	public static void handleCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("请选择您要启停的比赛的名称：");
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println("请选择开启或者停止比赛，1为开启，2为停止:");
				int index=input.nextInt();
				if(index==1) {
					competition.setAvalible(true);
					System.out.println("开启成功");
				}
				else if(index==2) {
					competition.setAvalible(false);
					System.out.println("停止成功");
				}
			}
			
		}
		if(!isExist) {
			System.out.println("赛事不存在");
		}
		System.out.println("1....2...返回管理员首页");
		managerIndex();
		
	}
	//查询报名情况
	public static void selectRegister() {
		System.out.println("请输入您要查询的比赛的名称");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println("下面是"+competition.getName()+"的人员报名情况:");
				System.out.println("一共报名人数:"+competition.getNumber());
				for(User user:competition.getUsersList()) {
					System.out.println(user);
				}
			}
			
		}
		if(!isExist) {
			System.out.println("赛事不存在");
		}
		System.out.println("1....2...返回管理员首页");
		managerIndex();
	}
	
	//比赛公告
	public static void noticeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("请进行以下操作对比赛通知进行管理:");
		System.out.println("1、添加公告");
		System.out.println("2、编辑公告");
		System.out.println("3、查询公告");
		System.out.println("4、删除公告");
		System.out.println("5、返回管理员主页");
		int index=input.nextInt();
		if(index==1) {
			insertNotice();
		}
		else if(index==2) {
			updateNotice();
		}
		else if(index==3) {
			selectNotice();
		}
		else if(index==4) {
			deleteNotice();
		}
		else if(index==5) {
			managerIndex();
		}
	}
	
	
	//添加公告
	public static void insertNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入公告名称:");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("该公告已存在!添加失败");
				
				break;
			}
		}
		if(!isNoticeExist) {
			System.out.println("请输入公告内容:");
			String content=input.nextLine();
		    Notice notice=new Notice();
		    notice.setName(name);
		    notice.setContent(content);
		    noticeList.add(notice);
		    System.out.println("添加通知成功!");
		}
		System.out.println("1...2...返回管理员首页");
		managerIndex();
	}
	
	//更新公告
	public static void updateNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入通知的名称:");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		int i=0;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("请输入要修改的内容:");
				String content=input.nextLine();
				noticeList.get(i).setContent(content);
				System.out.println("通知修改成功");
			}
			i++;
		}
		if(!isNoticeExist) {
			System.out.println("该通知不存在！");
		}
		System.out.println("1....2....返回管理员首页");
		managerIndex();
	}
	
	
	//查询公告
	public static void selectNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入通知的名称");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("查询成功！");
				System.out.println("公告名称:"+notice.getName()+"公告内容:"+notice.getContent());
				break;
			}
		}
		if(!isNoticeExist) {
			System.out.println("该公告不存在！");
		}
		System.out.println("1....2....返回管理员首页");
		managerIndex();
	}
	
	//删除公告
	public static void deleteNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入通知的名称");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("请确认是否删除该通知，确认请按1，取消请按2");
				int index=input.nextInt();
				if(index==1)
				{
				noticeList.remove(notice);
				System.out.println("删除成功！");
				}
				else if(index==2)
				{
					System.out.println("取消删除！");
				}
				
				break;
			}
		}
		if(!isNoticeExist) {
			System.out.println("该公告不存在！");
		}
		System.out.println("1....2....返回管理员首页");
		managerIndex();
	}
	
	//用户获得公告
	public static void competitionNotice() {
		System.out.println("接下来为您展示最近的比赛通知");
		int i=1;
		for(Notice notice:noticeList) {
			System.out.println("通知"+i+":");
			System.out.println("通知名称:"+notice.getName());
			System.out.println("通知内容:"+notice.getContent());
			i++;
		}
		System.out.println("1....2....返回用户首页");
		userIndex();
	}
	
	//成绩管理
	public static void gradeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("请选择以下选项对赛事成绩进行管理:");
		System.out.println("1、录入比赛成绩");
		System.out.println("2、查询运动员的成绩和排名");
		System.out.println("3、查询比赛排行榜");
		System.out.println("4、返回管理员首页");
		int index =input.nextInt();
		if(index==1) {
		insertGrade();	
		}
		else if(index==2) {
			selectGrade();
		}
		else if(index==3) {
			selectRank();
		}
		else if(index==4) {
			managerIndex();
		}
	}
	
	//录入成绩
	public static void insertGrade() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入比赛名称");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isCompExist=true;
				boolean isUserExist=false;
				System.out.println("请输入用户名:");
				String username=input.nextLine();
				for(User user:userList) {
					if(user.getUsername().equals(username)) {
						isUserExist=true;
						System.out.println("请输入该用户的成绩:");
						double grade=input.nextDouble();
						CompetitionGrade competitionGrade=new CompetitionGrade();
						competitionGrade.setCompetition(competition);
						competitionGrade.setUser(user);
						competitionGrade.setGrade(grade);
						competitionGradeList.add(competitionGrade);
						System.out.println("成绩录入成功");
						break;
					}	
				}
				if(!isUserExist)
					System.out.println("该用户不存在");
				break;
			}
		}
		if(!isCompExist) {
			System.out.println("赛事不存在!");
		}
		System.out.println("1....2....返回管理也页面");
		managerIndex();
	}
	
	
	
	//查询运动员成绩和排名
	public static void selectGrade() {
		List <CompetitionGrade> competitionGrade = new ArrayList<CompetitionGrade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入赛事的名称");
		String name=input.nextLine();
		boolean isCompExist=false;
		int z=0;
		for(CompetitionGrade competitionGrade2:competitionGradeList) {
			if(competitionGrade2.getCompetition().getName().equals(name)) {
				isCompExist=true;
			 competitionGrade.add(competitionGrade2);
			}
		}
		Collections.sort(competitionGrade);
		if(!isCompExist) {
			System.out.println("赛事不存在或无人员报名");
		}
		
		else {
			boolean isUserExist=false;
		System.out.println("请输入要查询的用户名");
		String username=input.nextLine();
		int i=1;
		for(CompetitionGrade competitionGrade3:competitionGrade) {
			if(competitionGrade3.getUser().getUsername().equals(username)) {
				isUserExist=true;
				System.out.println("查询成功");
				System.out.println("该用户的成绩是:"+competitionGrade3.getGrade()+" 排名是:"+"第"+i+"名");
			}
			i++;
		}
		if(!isUserExist) {
			System.out.println("该用户不存在!");
		}
		System.out.println("1.....2....返回管理员首页");
		managerIndex();
		}
	}
	
	
	
	
	//查询总排行
	public static void selectRank() {
		List <CompetitionGrade> competitionGrade = new ArrayList<CompetitionGrade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你要查询的赛事:");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(CompetitionGrade competitionGrade2:competitionGradeList) {
			if(competitionGrade2.getCompetition().getName().equals(name)) {
				isCompExist=true;
			 competitionGrade.add(competitionGrade2);
			}
		}
		Collections.sort(competitionGrade);
		if(!isCompExist) {
			System.out.println("赛事不存在或无人员报名");
		}
		else {
			System.out.println("赛事"+name+"排行榜如下:");
			int i=1;
		for(CompetitionGrade competitionGrade3:competitionGrade) {
			System.out.println("第"+i+"名:"+competitionGrade3.getUser().getUsername());
			i++;
		}
		}
		System.out.println("1....2...返回管理员首页");
		managerIndex();
	}
	
	
	
	//比赛成绩查询
	public static void competitionGrade() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入您要查询的比赛:");
		List <CompetitionGrade> datas = new ArrayList<CompetitionGrade>() ;
		boolean isCompExist=false;
		String name=input.nextLine();
		for(CompetitionGrade data:competitionGradeList) {
			if(data.getCompetition().getName().equals(name)) {
				isCompExist=true;
			 datas.add(data);
			}
		}
		Collections.sort(datas);
		
		if(!isCompExist) {
			System.out.println("赛事不存在或无人报名该赛事");
		}
		else {
			System.out.println("赛事"+name+"排行榜(前10名)如下:");
			int i=1;
		for(CompetitionGrade competitionGrade3:datas) {
			if(i>10)
				break;
			System.out.println("第"+i+"名:"+competitionGrade3.getUser().getUsername());
			i++;
		}
		}
		System.out.println("请输入您要查询的用户:");
		String username=input.nextLine();
		boolean isUserExist=false;
		int i=1;
		System.out.println("赛事"+name);
		for(CompetitionGrade data:datas) {
			if(data.getUser().getUsername().equals(username)) {
				isUserExist=true;
				System.out.println("您的成绩:"+data.getGrade()+"您的排名:"+i);
				i++;
				break;
			}
		}
		if(!isUserExist)
			System.out.println("该用户未报名该赛事或该用户不存在");
		System.out.println("1....2...返回管理员首页");
		managerIndex();
	}
	
	
	
	
	
	
	
}
