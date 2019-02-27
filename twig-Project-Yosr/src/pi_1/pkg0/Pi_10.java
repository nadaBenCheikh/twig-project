/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_1.pkg0;

import entities.Projects;
import entities.Offers;
import entities.Friends;
import entities.ReferalList;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import services.ProjectsService;
import services.OffersService;
import services.FriendsService;
import services.ReferalListService;

/**
 *
 * @author esprit
 */
public class Pi_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        connexionDb cn = connexionDb.getInstance();
        System.err.println(cn);
        
        //ajouter projet 
       /* Date d=Date.valueOf("2007-07-31"); //convertir string to sql date
        Projects p=new Projects("ghjk", "fghj", "xxx", "tunis", d, 2, "xxx");
        ProjectsService pservice=new ProjectsService();
        pservice.isert(p);
        
        //supprimer projet
        Projects p1=new Projects(1);
        ProjectsService pservice1=new ProjectsService();
        pservice1.delete(p1);*/
        
        //modifier projet
      
                
      /*  Date d1=Date.valueOf("2002-07-22");
        Projects p2=new Projects(2,"v", "v", "v", "v", d1, "v");
        ProjectsService pservice2=new ProjectsService();
        pservice2.update(p2);*/
        
      
      //*******************************************************************
      
        //ajouter offre
     /*   Date d=Date.valueOf("2007-07-31"); //convertir string to sql date
        Offers o =new  Offers(1,2,1,1, 8, d, "Je suis tres motivé");
//int taskId, int projectId, int freelancerId, int bid, int duration, Date offerDate, String motivationalLetter
         OffersService oservice=new  OffersService();
        oservice.isert(o);
      
      */  
          //supprimer Offre
       /* Offers o1=new Offers(1);
        OffersService oservice1=new OffersService();
        oservice1.delete(o1);*/
      
       // afficher les offres 
//       List<Offers> l = new ArrayList();
//         OffersService oservice2=new OffersService();
//       l=  oservice2.displayAll();
//       //Afficher les offres d'un freelance
//        l=  oservice2.getOffersByyId();
//        
          
        
      //modifier offre
      // Date d1=Date.valueOf("2002-07-22");
      /*  Offers o2=new Offers(2,111, 15, "Je suis treeeeeeeees motivé");
        OffersService oservice2=new OffersService();
        oservice2.update(o2);*/
      
      // ajouter un ami 
      
       /*  Friends f =new  Friends(2,1,1,0);
         FriendsService fservice=new  FriendsService();
        fservice.isert(f);
        */
        
         //supprimer un ami
      /*   Friends f1 =new  Friends(1);
        FriendsService fservice1=new FriendsService();
        fservice1.delete(f1);*/
        
        
              
      //modifier ami ==>  closefriend / coworker
      
      /* Friends f2 =new  Friends(2,0,1);
       FriendsService fservice2=new  FriendsService();
       fservice2.update(f2);*/
        
        
        // ajouter un ami à la referal list
   /*   
        ReferalList r =new  ReferalList(1,1,0);
        ReferalListService rservice=new  ReferalListService();
        rservice.isert(r);
       */
        
       //supprimer un ami de la liste referal
       // ReferalList r1 =new  ReferalList(2);
     //   ReferalListService rservice1=new  ReferalListService();
//        rservice1.delete(r1);
        
        
    }
    
}
