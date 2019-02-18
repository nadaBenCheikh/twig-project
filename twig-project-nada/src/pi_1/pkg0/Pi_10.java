/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_1.pkg0;

import entities.Colabs;
import entities.DonneurJoinProject;
import entities.Offers;
import entities.ProjectJoinTasks;
import entities.Projects;
import entities.Tasks;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import services.ColabsService;
import services.OffersService;
import services.ProjectsService;
import services.TasksService;

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
                                    
        //**************************Projects************************************
        /*
        //ajouter projet 
        Date d=Date.valueOf("2020-07-20"); //convertir string to sql date
        Projects p=new Projects("test", "test", "test", "test", d, 4);
        ProjectsService pservice=new ProjectsService();
        pservice.isert(p);
       
        //supprimer projet
        Projects p1=new Projects(1);
        ProjectsService pservice1=new ProjectsService();
        pservice1.delete(p1);
        
        //modifier projet
        Date d1=Date.valueOf("2002-07-22");
        Projects p2=new Projects(2,"test", "test", "test", "test", d1, "test");
        ProjectsService pservice2=new ProjectsService();
        pservice2.update(p2);
        
        //afficher les projet du donneur d'ordre
        ProjectsService pservice3= new ProjectsService();
        pservice3.displayAllProjects(2).forEach(e ->System.out.println(e));
          //System.out.println(pservice3.displayAllProjects(4));
        
        //afficher en tant qu'admin: projet et donneur d'ordre
        ProjectsService pservice4= new ProjectsService();
        pservice4.display().forEach(e ->System.out.println(e));
        List<DonneurJoinProject> l=pservice4.display();
        Map<Integer,List<DonneurJoinProject>>map=l.stream().collect(Collectors.groupingBy(e->e.getOwnerId()));
        System.out.println(map);
       
        //recherche d'un projet par id
        Projects p3=new Projects(2);
        ProjectsService pservice5= new ProjectsService();
        System.out.println(pservice5.getById(p3));
        
        //changement d'etat d'un projet
        Projects p6=new Projects(7);
        ProjectsService pservice6= new ProjectsService();
        Projects p7=new Projects();
        p7=pservice6.getById(p6);
        
        Date d7=p7.getTerminationDate();
        LocalDate d8=d7.toLocalDate();
        
        LocalDate d9=LocalDate.now();
        Period perd= Period.between(d9, d8);
        int days=perd.getDays();
        int months=perd.getMonths();
        int years=perd.getYears();
        if(years<=0){
           if(months<=0){
               if(days<0){
                   pservice6.state(p6);
               }
           }       
        }
        System.out.println(days);
        System.out.println(months);
        System.out.println(years);
                                  
        //**************************Tasks***************************************
        //ajouter tache
        Tasks t=new Tasks(4,"test","test");
        TasksService tservice=new TasksService();
        tservice.isert(t);
        
        //supprimer tache
        Tasks t1=new Tasks(2);
        TasksService tservice1=new TasksService();
        tservice1.delete(t1);
        
        //modifer tache
        Tasks t2=new Tasks("test","test",5);
        TasksService tservice2= new TasksService();
        tservice2.update(t2);
        
        //afficher les tache d'un projet
        TasksService tservice3=new TasksService();
        tservice3.displayAllProjects(3).forEach(e->System.out.println(e));
        
        //afficher tous les projets et leurs taches d'un donneur d'ordre
        TasksService tservice4=new TasksService();
        //tservice4.displayAllProjectsAndTasks(3).forEach(e->System.out.println(e));
        List<ProjectJoinTasks> list=tservice4.displayAllProjectsAndTasks(3);
        Map<String,List<ProjectJoinTasks>> map=list.stream().collect(Collectors.groupingBy(e->e.getTitle()));
        System.out.println(map);
        
        //**************************offer and collabs***************************
       
        //afficher un offre
        OffersService oservice0= new OffersService();
        oservice0.displayOffer(4).forEach(e->System.out.println(e));
       */
        //confirmer un offre => ajouter un collaborateur et effacer un offre   =>le cas ou il n'ya pas de tache!!!!!!!!!
        Offers o=new Offers(4,3,3,3);
        OffersService oservice=new OffersService();
        oservice.isert(o);
        /*
        //ignorer un offre
        Offers o1=new Offers(2);
        OffersService oservice1=new OffersService();
        oservice1.delete(o1);
        
        //supprimer colab
        Colabs c=new Colabs(1);
        ColabsService cservice=new ColabsService();
        cservice.delete(c);
        
        //collaborateur viré
        Colabs c1=new Colabs(11);
        ColabsService cservice1=new ColabsService();
        cservice1.update(c1);*/
    }
}
