package day13;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// ������
// == �ܺο��� ������ �����Ͽ�(����͸�) Ư�� �޼��带 �����ϴ� ���
@WebListener
//== ������̼� == �ֳ����̼�
public class InitialMember implements ServletContextListener{
// �������̽��� ���� "������"
   @Override
   public void contextDestroyed(ServletContextEvent sce) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void contextInitialized(ServletContextEvent sce) {
      
      ArrayList<Member> datas=new ArrayList<Member>();
      for(int i=0;i<8;i++) {
         Member data=new Member("Ƽ��"+(i+1),"010-1234-123"+i);
         datas.add(data);
      }
      datas.add(new Member("�Ƹ�",null));
      datas.add(new Member("����",null));
      
      ServletContext context=sce.getServletContext();
      // context�� ���� scope(application scope)
      context.setAttribute("datas",datas);
      context.setAttribute("data",new Member());
   
   }

   
}