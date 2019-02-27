/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.Login1.project;


/**
 *
 * @author esprit
 */
public class Project{



    public static void main(String[] args) {
        
        database d=database.getInstance();
        System.out.println(d);
        /*//inserer user
        users u=new users("ons","mtar","hhh","123","jjjj",5,2145,"hhjj","ffdfff","kkkk",5);
        UserServices uService=new UserServices();
        uService.insert(u);*/
        
        //System.out.println(uService.displayAll());
        //uService.displayAll().forEach(e->System.out.println(e));
       
       /* users u1=new users("bn","kkk","hkkkh","123","jjjj",5,2145,"hhjj","ffdfff","kkkk",5);
        UserServices uService=new UserServices();
        uService.insert(u1);*/
        
        /*//supprimer user
        users u1=new users(3);
        UserServices uservice1=new UserServices();
        uservice1.delete(u1);*/
        
        /*//update user
        users u=new users(4,"ons","bnn","hhh","123","jjj",5,2145,"hhjj","ffdff","kkk",5);
        UserServices uservice2=new UserServices();
        uservice2.update(u);*/
        
        /*//affichage par id pour user
        users u2=new users(7);
        UserServices uservice2=new UserServices();
        users u3=uservice2.getById(u2);
        System.out.println(u3);*/
        
        
        
         /*//insert freelancer
         Freelancer f=new Freelancer(1,"français",5,1,"cv",9,"clas");
         FreelancerService fservice=new FreelancerService();
         fservice.insert(f);*/
        
        //affiche all freelancer
        //System.out.println(fservice.displayAll());
        
          /*//supprimer freelancer
        Freelancer f=new Freelancer(10);
        FreelancerService fservice1=new FreelancerService ();
        fservice1.delete(f);*/
        
       //update freelancer
       /* Freelancer f1=new Freelancer(3,1,"arabe",1,5,"cvv1",6,"cc");
       FreelancerService fservice2=new FreelancerService();
        fservice2.update(f1);*/
        
       /* //affichage par id pour freelancer
        Freelancer f2=new Freelancer(3);
        FreelancerService fservice2=new FreelancerService();
        Freelancer f3=fservice2.getById(f2);
        System.out.println(f3);*/
        
                
        
        
      
       
        
        
        
        
       
        
        
        
        
        
         
         
      
    }
}
