/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import entities.event;
import entities.jointureTable;

import entities.participant;
import entities.questions;
import entities.test;
import java.sql.Date;
import service.eventService;
import service.participantService;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.questionServ;
import service.testServ;

/**
 *
 * @author rim
 */
public class testt {
    public static void main(String[] args) {
        Projet conn=Projet.getInstance();
        System.err.println(conn);
        Date d=Date.valueOf("2007-09-27"); 
        Time t=Time.valueOf("01:20:00");
        event e=new event("xxx", "xx",d,"xxx",3,"x","xxxx");//creer un event
        eventService eservice=new eventService();//creation d'un event service
        
      // eservice.insertPST(e);//insertion event
              //  event e1=new event(9,"vv", "v",d,"xxx",5,"x","xxxx");
      // event et= new event(9);//instansation d'un event pour la suppression par id
       eventService eservice1=new eventService(); 
      // eservice1.delete(et); //suppression d'un event

                //eventService eservice1=new eventService();
            //  event et1=new event("test", "xx",d,"xxx",3,"x","xxxx",1);//creation un nouveau event pour update
              //  eservice1.delete(et);
              //  eservice.update(et1);
               // System.out.println(eservice1.getAll()); afficher tout les events
               // event p2= new event(2); (pour la rechercher par id)
       //  eventService pservice2= new eventService();
       //  event p3= pservice2.getById(p2);
        // System.out.println(p3);
        // participant et= new participant(1);

               participantService pserv=new participantService();
             //   event et1=new event("test", "xx",d,"xxx",3,"x","xxxx",1);
              //  eservice1.delete(et);
              // pserv.delete(et);
        participant part1=new participant(8, 5);
        participantService ps=new participantService();
       // ps.update(part1);
       // ps.insertPST(part1);
      //   System.out.println(ps.getAll());
          participant p2= new participant(3); //pour l'afficher par id

         participantService pservice2= new participantService();
         //participant p3= pservice2.getById(p2);
       //  System.out.println(p3);
        //System.out.println(pservice2.displayAllParticipant(2));//afficher selon l'id du event
       //  test test1= new test(100, t, "html", "test2", "niveau1"); //insertion un test
         testServ ts1= new testServ();
        // ts1.insertPST(test1);
         //test test2=new test(2); //supprimer un test
        // testServ ts1= new testServ();
       //  ts1.delete(test2);
      //   test test3=new test(200, t, "javaFX", "facile", "niveau2", 1); pour la mise à jour
        // ts1.update(test3);
         test test9= new test(1);
         testServ tt1=new testServ();
      //   tt1.getById(test9);
      //   System.out.println(tt1.getById(test9));
      //   System.out.println(tt1.getAll()); afficher tout les test
 questions q=new questions(5, "desc", "rep");
 
        
           questionServ q1=new questionServ();
          // q1.insertPST(q);
       // System.out.println(q1.getAll());
         //  q1.insertPST(q);
        //   questions q=new questions(5);
         //  System.out.println(q1.getById(q));
        //   q1.insertPST(q);
          // System.out.println(q1.getAll());
           
           
          
            questionServ pservice11= new questionServ();
         
        //    List<jointureTable> list=pservice11.display(4);
            
        //    Map<Integer,List<jointureTable>>map=list.stream().collect(Collectors.groupingBy(m->m.getTestID()));
         //   System.out.println(map);
            
           
            
       
           

  
         
         
         
         
         
         
         
         
       
         


        
        
                

        
        
    
}
}
