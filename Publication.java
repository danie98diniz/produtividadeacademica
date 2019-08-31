import java.util.ArrayList;
import java.util.Scanner;

public class Publication {

    private ArrayList<Collaborator> Autors = new ArrayList<>();
    private String name;
    private String conference_name;
    private int year;
    private ArrayList<String> publication = new ArrayList<>();
    private int project;
    private Project ProjectAssociated;

    //----------------------------------------- CREATE PUBLICATION ------------------
    public void Create_publication(ArrayList<Collaborator> CollaboratorsList, ArrayList<Publication> AllPublications, ArrayList<Project> Projectslist){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        Publication new_publication = new Publication();
        while(true){

            System.out.println("who´s writing this publication?");
            System.out.println("type -1 when done");
            for(int i = 0; i < CollaboratorsList.size(); i++){
                System.out.println(i+". "+CollaboratorsList.get(i).getName());
            }
            int option = scan.nextInt();
            scan.nextLine();
            if(option == -1){
                break;
            }
            new_publication.getAutors().add(CollaboratorsList.get(option));
            CollaboratorsList.get(option).getYourPublications().add(new_publication);

        }

        System.out.println("type the title of this publication:");
        String title = scan.nextLine();
        new_publication.setName(title);
        System.out.println("type the name of the conference of publication:");
        title = scan.nextLine();
        new_publication.setConference_name(title);
        System.out.println("type the year of publication (ex '2018'):");
        int year = scan.nextInt();
        new_publication.setYear(year);
        System.out.println("type 1 if this publication is associated with a project from this laboratory");
        System.out.println("type 0 if its not (*note that the project need to be 'ongoing'*)");
        int choice = scan.nextInt();
        scan.nextLine();
        int yes = 0;
        if(choice == 1){
            System.out.println("what project is your publication associated with?");
            System.out.println("or type -1 to dismiss project association");
            for(int i = 0; i < Projectslist.size(); i++){
                if(Projectslist.get(i).getStatus().equals("Ongoing")){
                    System.out.println(i+". "+Projectslist.get(i).getName());
                }
            }
            int choice2 = scan.nextInt();
            scan.nextLine();
            if(choice2 >= 0 && choice2 < Projectslist.size()){
                yes = 1;
                new_publication.setProject(yes);
                new_publication.setProjectAssociated(Projectslist.get(choice2));
                Projectslist.get(choice2).getProjectsPublications().add(new_publication);
            }

        }
        else{
            new_publication.setProject(yes);
        }
        System.out.println("write your publication and type 'DONE' when done:");
        String string;
        while(true){
            string = scan.nextLine();
            if(string .equals("DONE")){
                break;
            }
            new_publication.getPublication().add(string);
        }
        AllPublications.add(new_publication);
        System.out.println("your publication is done!");
        System.out.println("type any key to continue:");
        string = scan.nextLine();
    }
    //----------------------------------------- SEE PUBLICATIONS -----------------------
    public void See_publications(ArrayList<Publication> AllPublications){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        while(true){
            System.out.println("choose a publication to see");
            System.out.println("or type -1 to go back:");
            for (int i = 0; i < AllPublications.size(); i++){
                System.out.println(i+". "+AllPublications.get(i).getName()+" Year: "+AllPublications.get(i).getYear());
            }
            int option = scan.nextInt();
            scan.nextLine();

            if(option == -1){
                break;
            }
            else if(option >= 0 && option < AllPublications.size()){
                Publication yourPublication = AllPublications.get(option);
                System.out.println(" - Publication title: "+yourPublication.getName());
                System.out.println(" - Authors: ");
                for(int i = 0; i < yourPublication.getAutors().size(); i++){
                    System.out.println(yourPublication.getAutors().get(i).getName());
                }
                System.out.println(" - published in "+yourPublication.getConference_name()+" conference");
                System.out.println(" - year: "+yourPublication.getYear());
                if(yourPublication.getProject() == 1){
                    System.out.println(" - Project: "+yourPublication.getProjectAssociated().getName());
                }
                for(int i = 0; i < yourPublication.getPublication().size(); i++){
                    System.out.println(yourPublication.getPublication().get(i));
                }
                System.out.println("---------------------------------");
                System.out.println("type any key to continue");
                String string = scan.nextLine();
            }
        }
    }

    public Publication() {
    }

    public ArrayList<String> getPublication() {
        return publication;
    }

    public void setPublication(ArrayList<String> publication) {
        this.publication = publication;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public ArrayList<Collaborator> getAutors() {
        return Autors;
    }

    public void setAutors(ArrayList<Collaborator> autors) {
        Autors = autors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference_name() {
        return conference_name;
    }

    public void setConference_name(String conference_name) {
        this.conference_name = conference_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Project getProjectAssociated() {
        return ProjectAssociated;
    }

    public void setProjectAssociated(Project projectAssociated) {
        ProjectAssociated = projectAssociated;
    }
}
