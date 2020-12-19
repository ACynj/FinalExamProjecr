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
    //�û����ݼ���
	public static List<User> userList=new ArrayList<User>();
	//����Ա���ݼ���
	public static List<User>managerList=new ArrayList<User>();
	//�������ݼ���
	public static List<Competition>competitionList=new ArrayList<Competition>();
	//֪ͨ���漯��
	public static List<Notice> noticeList=new ArrayList<Notice>();
	//���³ɼ�����
	public static List<CompetitionGrade>competitionGradeList=new ArrayList<CompetitionGrade>();
	public static void main(String[] args) {
		//�Զ���һ������Ա�˺�
		User manager=new User();
		manager.setUsername("manager");
		manager.setPassword("password");
		//��ӽ��˺�
		managerList.add(manager);
		 Scanner input=new Scanner(System.in); 
		//��ӭ����
		System.out.println("��ӭ���������ɹ���ϵͳ!");
		//
		System.out.println("�����˺ţ����¼����û���˺ţ�����ע�ᡣ��������ѡ���У�ѡ����Ҫ���еĹ��ܣ�");
		System.out.println("1���û��˵�¼");
		System.out.println("2������Ա�˵�¼");
		System.out.println("3��ע��");
		//����Ҫѡ��Ĺ���
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
	//�û���¼
	public static void userLogin() {
		Scanner input=new Scanner(System.in);
		String username=null,password=null;
		System.out.println("�������û���:");
		username=input.nextLine();
		System.out.println("����������:");
		password=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					if(user.isAvalible()==true)
					isSuccess=true;
					else {
						System.out.println("���˺��ѱ����ã�����ϵ����Ա!");
					}
					break;
				}
			}
		}
		if(isSuccess) {
			System.out.println("��½�ɹ�"+"��ӭ��"+username);
		}
		else {
			System.out.println("��¼ʧ��");
		}
		System.out.println("��ѡ�����¹���:");
		System.out.println("1�����µ�¼");
		System.out.println("2���ص���ҳ");
		System.out.println("3���û���ҳ");
		System.out.println("4���˳�ϵͳ");
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
	//����Ա�˵�¼
	public static void managerLogin() {
		Scanner input=new Scanner(System.in);
		String username=null,password=null;
		System.out.println("�������û���:");
		username=input.nextLine();
		System.out.println("����������:");
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
			System.out.println("��½�ɹ�"+"��ӭ��"+username);
		}
		else {
			System.out.println("��¼ʧ��");
		}
		System.out.println("��ѡ�����¹���:");
		System.out.println("1�����µ�¼");
		System.out.println("2���ص���ҳ");
		System.out.println("3������Ա��ҳ");
		System.out.println("4���˳�ϵͳ");
		
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
	
	//ע��
	public static void register() {
		Scanner input=new Scanner(System.in); 
		String password = null;
		String username = null;
		System.out.println("------ע��------");
		boolean flag=true;
		boolean isUsernameable=true;
		while(flag) {
			//�����û���
			System.out.println("�����������û���:");
			username=input.nextLine();
			//�û���У��
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				System.out.println("�û����Ѵ��ڣ�����������");
				isUsernameable=false;
				flag=true;
				break;
			}
		}
		//����û���������
		if(isUsernameable==false)
		{
			//������������
			isUsernameable=true;
		}
		else {
			System.out.println("��������������:");
		    password=input.nextLine();
			flag=false;
		}
		}
		//��װ����
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//����list
		userList.add(user);
		System.out.println("ע��ɹ�!");
		System.out.println("��ѡ��:");
		System.out.println("1���ص���ҳ");
		System.out.println("2����¼");
		System.out.println("3���˳�ϵͳ");
		
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
		System.out.println("------------ϵͳ�˳��ɹ�------------");
	}
	//����Ա��ҳ
	public static void managerIndex() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------����Ա��ӭ����---------");
		System.out.println("��ѡ�����¹��ܽ��в���:");
		System.out.println("1���˻�����");
		System.out.println("2����������");
		System.out.println("3���ɼ�����");
		System.out.println("4��֪ͨ����");
		System.out.println("5��������ҳ");
		System.out.println("6���˳�ϵͳ");
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
	//�û���ҳ
	public static void userIndex() {
		System.out.println("------------�����ɹ���ϵͳ��ӭ��------------");
		System.out.println("��ѡ�����¹���:");
		System.out.println("1����������");
		System.out.println("2�������ɼ���ѯ");
		System.out.println("3����������");
		System.out.println("4��������ҳ");
		System.out.println("5���˳�ϵͳ");
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
	//�˻�����
	public static void userManage() {
		System.out.println("��ѡ�����²������û��˻����й���:");
		System.out.println("1����ѯ�˻�");
		System.out.println("2�������˻�");
		System.out.println("3����������");
		System.out.println("4�����ع���Ա��ҳ");
		System.out.println("5��������ҳ");
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
	
	
	//�˻�����
	public static void userDisabled() {
		System.out.println("��������Ҫ���õ��˻�:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				System.out.println("�Ƿ�ȷ�Ͻ��ø��û���ȷ��������1��ȡ���밴2");
				int x=input.nextInt();
				if(x==1) {
					user.setAvalible(false);
					System.out.println("���óɹ�!");
				}
				else {
					System.out.println("����ʧ��!");	
				}
				
			break;
			}
		}
		System.out.println("�Զ���ת���˻�����ҳ�档1	...2...");
		userManage();
	}
	//��ѯ�˻�
	public static void userSelect() {
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ���û���:");
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
				System.out.println("��ѯ�ɹ�");
				System.out.println(user);
				break;
			}
	}
		if(!isSuccess)
		System.out.println("��ѯʧ�ܣ��޴��˺���Ϣ����˶�");
	System.out.println("������ѯ�밴1�������밴2");
	int index=input.nextInt();
	if(index==1) {
		userSelect();
	}
	else if(index==2) {
		userManage();
	}
	}
	
	
	//��������
	public static void resetPassword() {
		System.out.println("��������Ҫ����������˺�:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
				System.out.println("ȷ���Ƿ��������룬ȷ���밴1��ȡ���밴2");
				int index=input.nextInt();
				if(index==1) {
					System.out.println("����������������ã�");
					String password=input.next();
					user.setPassword(password);
					System.out.println("���óɹ�");
				}
				else if(index==2) {
					System.out.println("ȡ������");
				}
				
			}
		}
		//��ѯʧ��ʱ
		if(!isSuccess)
			System.out.println("��ѯʧ�ܣ��޴��˺���Ϣ����˶ԣ�");
		System.out.println("�����������룬�밴1�������밴2:");
		int index=input.nextInt();
		if(index==1) {
			resetPassword();
		}
		else if(index==2) {
			userManage();
		}
	}
	
	
	//����
	public static void competitionRegister() {
		Scanner input=new Scanner(System.in);
		//��ȡ�����б�
		System.out.println("��ѡ����Ҫѡ���������:");
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
			System.out.println("���²����ڣ����������û���ҳ");
			userIndex();
		}
		else {
		//�������ĸ�����Ϣ
		System.out.println("�����������û���:");
		String username=input.nextLine();
		boolean isExist=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isExist=true;
				if(comp!=null) {
				comp.getUsersList().add(user);
				comp.setNumber(comp.getNumber()+1);
					System.out.println("�����ɹ�");
					}
				else {
					System.out.println("����ʧ��");
				}
			}
		}
		if(!isExist) {
			System.out.println("�û������ڣ�����ʧ��");
		}
		}
		System.out.println("1....2...�����û���ҳ");
		userIndex();
	}
	
	//���¹���
	public static void competitionManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("������½������²���:");
		System.out.println("1����ӱ���");
		System.out.println("2����ͣ����");
		System.out.println("3����ѯ�������");
		System.out.println("4�����ع���Ա��ҳ");
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
	//��ӱ���
	public static void insertCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("�������������:");
		String name=input.nextLine();
		System.out.println("�������������");
		String content=input.nextLine();
		System.out.println("�Ƿ������ӣ�ȷ����1��ȡ����2");
		int index =input.nextInt();
		if(index==1) {
			Competition competition=new Competition(name,content);
			competitionList.add(competition);
			System.out.println("��ӱ����ɹ�!");
		}
	System.out.println("1....2...���ع���Ա��ҳ");
	managerIndex();
	}
	//��ͣ����
	public static void handleCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("��ѡ����Ҫ��ͣ�ı��������ƣ�");
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println("��ѡ��������ֹͣ������1Ϊ������2Ϊֹͣ:");
				int index=input.nextInt();
				if(index==1) {
					competition.setAvalible(true);
					System.out.println("�����ɹ�");
				}
				else if(index==2) {
					competition.setAvalible(false);
					System.out.println("ֹͣ�ɹ�");
				}
			}
			
		}
		if(!isExist) {
			System.out.println("���²�����");
		}
		System.out.println("1....2...���ع���Ա��ҳ");
		managerIndex();
		
	}
	//��ѯ�������
	public static void selectRegister() {
		System.out.println("��������Ҫ��ѯ�ı���������");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println("������"+competition.getName()+"����Ա�������:");
				System.out.println("һ����������:"+competition.getNumber());
				for(User user:competition.getUsersList()) {
					System.out.println(user);
				}
			}
			
		}
		if(!isExist) {
			System.out.println("���²�����");
		}
		System.out.println("1....2...���ع���Ա��ҳ");
		managerIndex();
	}
	
	//��������
	public static void noticeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("��������²����Ա���֪ͨ���й���:");
		System.out.println("1����ӹ���");
		System.out.println("2���༭����");
		System.out.println("3����ѯ����");
		System.out.println("4��ɾ������");
		System.out.println("5�����ع���Ա��ҳ");
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
	
	
	//��ӹ���
	public static void insertNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("�����빫������:");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("�ù����Ѵ���!���ʧ��");
				
				break;
			}
		}
		if(!isNoticeExist) {
			System.out.println("�����빫������:");
			String content=input.nextLine();
		    Notice notice=new Notice();
		    notice.setName(name);
		    notice.setContent(content);
		    noticeList.add(notice);
		    System.out.println("���֪ͨ�ɹ�!");
		}
		System.out.println("1...2...���ع���Ա��ҳ");
		managerIndex();
	}
	
	//���¹���
	public static void updateNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("������֪ͨ������:");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		int i=0;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("������Ҫ�޸ĵ�����:");
				String content=input.nextLine();
				noticeList.get(i).setContent(content);
				System.out.println("֪ͨ�޸ĳɹ�");
			}
			i++;
		}
		if(!isNoticeExist) {
			System.out.println("��֪ͨ�����ڣ�");
		}
		System.out.println("1....2....���ع���Ա��ҳ");
		managerIndex();
	}
	
	
	//��ѯ����
	public static void selectNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("������֪ͨ������");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("��ѯ�ɹ���");
				System.out.println("��������:"+notice.getName()+"��������:"+notice.getContent());
				break;
			}
		}
		if(!isNoticeExist) {
			System.out.println("�ù��治���ڣ�");
		}
		System.out.println("1....2....���ع���Ա��ҳ");
		managerIndex();
	}
	
	//ɾ������
	public static void deleteNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("������֪ͨ������");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("��ȷ���Ƿ�ɾ����֪ͨ��ȷ���밴1��ȡ���밴2");
				int index=input.nextInt();
				if(index==1)
				{
				noticeList.remove(notice);
				System.out.println("ɾ���ɹ���");
				}
				else if(index==2)
				{
					System.out.println("ȡ��ɾ����");
				}
				
				break;
			}
		}
		if(!isNoticeExist) {
			System.out.println("�ù��治���ڣ�");
		}
		System.out.println("1....2....���ع���Ա��ҳ");
		managerIndex();
	}
	
	//�û���ù���
	public static void competitionNotice() {
		System.out.println("������Ϊ��չʾ����ı���֪ͨ");
		int i=1;
		for(Notice notice:noticeList) {
			System.out.println("֪ͨ"+i+":");
			System.out.println("֪ͨ����:"+notice.getName());
			System.out.println("֪ͨ����:"+notice.getContent());
			i++;
		}
		System.out.println("1....2....�����û���ҳ");
		userIndex();
	}
	
	//�ɼ�����
	public static void gradeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("��ѡ������ѡ������³ɼ����й���:");
		System.out.println("1��¼������ɼ�");
		System.out.println("2����ѯ�˶�Ա�ĳɼ�������");
		System.out.println("3����ѯ�������а�");
		System.out.println("4�����ع���Ա��ҳ");
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
	
	//¼��ɼ�
	public static void insertGrade() {
		Scanner input=new Scanner(System.in);
		System.out.println("�������������");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isCompExist=true;
				boolean isUserExist=false;
				System.out.println("�������û���:");
				String username=input.nextLine();
				for(User user:userList) {
					if(user.getUsername().equals(username)) {
						isUserExist=true;
						System.out.println("��������û��ĳɼ�:");
						double grade=input.nextDouble();
						CompetitionGrade competitionGrade=new CompetitionGrade();
						competitionGrade.setCompetition(competition);
						competitionGrade.setUser(user);
						competitionGrade.setGrade(grade);
						competitionGradeList.add(competitionGrade);
						System.out.println("�ɼ�¼��ɹ�");
						break;
					}	
				}
				if(!isUserExist)
					System.out.println("���û�������");
				break;
			}
		}
		if(!isCompExist) {
			System.out.println("���²�����!");
		}
		System.out.println("1....2....���ع���Ҳҳ��");
		managerIndex();
	}
	
	
	
	//��ѯ�˶�Ա�ɼ�������
	public static void selectGrade() {
		List <CompetitionGrade> competitionGrade = new ArrayList<CompetitionGrade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("���������µ�����");
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
			System.out.println("���²����ڻ�����Ա����");
		}
		
		else {
			boolean isUserExist=false;
		System.out.println("������Ҫ��ѯ���û���");
		String username=input.nextLine();
		int i=1;
		for(CompetitionGrade competitionGrade3:competitionGrade) {
			if(competitionGrade3.getUser().getUsername().equals(username)) {
				isUserExist=true;
				System.out.println("��ѯ�ɹ�");
				System.out.println("���û��ĳɼ���:"+competitionGrade3.getGrade()+" ������:"+"��"+i+"��");
			}
			i++;
		}
		if(!isUserExist) {
			System.out.println("���û�������!");
		}
		System.out.println("1.....2....���ع���Ա��ҳ");
		managerIndex();
		}
	}
	
	
	
	
	//��ѯ������
	public static void selectRank() {
		List <CompetitionGrade> competitionGrade = new ArrayList<CompetitionGrade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ������:");
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
			System.out.println("���²����ڻ�����Ա����");
		}
		else {
			System.out.println("����"+name+"���а�����:");
			int i=1;
		for(CompetitionGrade competitionGrade3:competitionGrade) {
			System.out.println("��"+i+"��:"+competitionGrade3.getUser().getUsername());
			i++;
		}
		}
		System.out.println("1....2...���ع���Ա��ҳ");
		managerIndex();
	}
	
	
	
	//�����ɼ���ѯ
	public static void competitionGrade() {
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ�ı���:");
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
			System.out.println("���²����ڻ����˱���������");
		}
		else {
			System.out.println("����"+name+"���а�(ǰ10��)����:");
			int i=1;
		for(CompetitionGrade competitionGrade3:datas) {
			if(i>10)
				break;
			System.out.println("��"+i+"��:"+competitionGrade3.getUser().getUsername());
			i++;
		}
		}
		System.out.println("��������Ҫ��ѯ���û�:");
		String username=input.nextLine();
		boolean isUserExist=false;
		int i=1;
		System.out.println("����"+name);
		for(CompetitionGrade data:datas) {
			if(data.getUser().getUsername().equals(username)) {
				isUserExist=true;
				System.out.println("���ĳɼ�:"+data.getGrade()+"��������:"+i);
				i++;
				break;
			}
		}
		if(!isUserExist)
			System.out.println("���û�δ���������»���û�������");
		System.out.println("1....2...���ع���Ա��ҳ");
		managerIndex();
	}
	
	
	
	
	
	
	
}
