import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        ArrayList<Project> ProjectList = new ArrayList<>();
        ArrayList<Project> PastProjects = new ArrayList<>();
        ArrayList<Collaborator> CollaboratorsList = new ArrayList<>();
        ArrayList<Collaborator> TeachersList = new ArrayList<>();
        ArrayList<Publication> AllPublications = new ArrayList<>();
        ArrayList<Orientations> AllOrientations = new ArrayList<>();
        Main_menu:
        while (true){
            System.out.println("type 0 to exit");
            System.out.println("type 1 to create a project");
            System.out.println("type 2 to manage projects");
            System.out.println("type 3 to add a collaborator");
            System.out.println("type 4 to go to lab orientations");
            System.out.println("type 5 to go to publications");
            System.out.println("type 6 to see lab academic production report");
            System.out.println("type 7 to go to project consult");

            int option = scan.nextInt();
            scan.nextLine();

            if(option == 0){
                break;
            }//exit program
            else if(option == 1){
                if(TeachersList.size() == 0){
                    System.out.println("there are no teachers to create projects");
                    continue Main_menu;
                }
                Project newProject = new Project();
                newProject.Create_project(ProjectList, TeachersList, CollaboratorsList);

            }//creates a project
            else if(option == 2){
                Project newProject = new Project();
                newProject.Manage_menu(ProjectList, CollaboratorsList, PastProjects);
            }//manage a project
            else if(option == 3){
                Collaborator newCollaborator = new Collaborator();
                newCollaborator.Add_collaborator(CollaboratorsList, TeachersList);
            }//add a collaborator to the lab
            else if(option == 4){
                while(true){
                    System.out.println("type 0 to go back");
                    System.out.println("type 1 to create a orientation");
                    System.out.println("type 2 to see all orientations");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    if(choice == 0){
                        break;
                    }
                    else if(choice == 1){
                        Orientations newOrientation = new Orientations();
                        newOrientation.Create_orientation(AllOrientations, TeachersList);
                    }
                    else if(choice == 2){
                        Orientations newOrientation = new Orientations();
                        newOrientation.Show_all_orientations(AllOrientations);
                    }
                }
            }//go to orientations
            else if(option == 5){
                while(true){
                    System.out.println("type 0 to go back");
                    System.out.println("type 1 to create a publication");
                    System.out.println("type 2 to see all publications");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    if(choice == 0){
                        continue Main_menu;
                    }//go back
                    else if(choice == 1){
                        Publication newPublication = new Publication();
                        newPublication.Create_publication(CollaboratorsList, AllPublications, ProjectList);
                    }
                    else if(choice == 2){
                        Publication newPublication = new Publication();
                        newPublication.See_publications(AllPublications);
                    }
                }
            }//go to publications
            else if(option == 6){
                Project newProject = new Project();
                newProject.Show_academic_report(CollaboratorsList, ProjectList, PastProjects, AllPublications, AllOrientations);
            }//go to report
            else if(option == 7){
                ArrayList<Project> AllProjects = new ArrayList<>();

                for(int i = 0; i < ProjectList.size(); i++){
                    AllProjects.add(ProjectList.get(i));
                }
                for(int i = 0; i < PastProjects.size(); i++){
                    AllProjects.add(PastProjects.get(i));
                }
                Project_selection(AllProjects);
            }//project consult
        }
    }


//----------------------------------------- PROJECT SELECTION -----------------------
    public static void Project_selection(ArrayList<Project> AllProjects){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("choose a project to consult:");
        for(int i = 0; i < AllProjects.size(); i++){
            System.out.println(i+". "+AllProjects.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();
        Consult_by_project(AllProjects.get(option));
    }
//----------------------------------------- PROJECT CONSULT ------------------------
    public static void Consult_by_project(Project Yourproject){

        System.out.println("Name: "+Yourproject.getName());
        System.out.println("Status: "+Yourproject.getStatus());
        System.out.println("Description: "+Yourproject.getDescription());
        System.out.println("Goal: "+Yourproject.getGoal());
        System.out.println("Initial date: "+Yourproject.getInitial_date());
        System.out.println("End date: "+Yourproject.getEnd_date());
        System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
        System.out.println("Budget: "+Yourproject.getBudget());
        System.out.println("Collaborators:");
        for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
            System.out.println(Yourproject.getCollaboratorsList().get(i).getName());
        }
        //Sort publications out of bounderies
        Sort_publications(Yourproject.getProjectsPublications());


    }
//--------------------------------------- SORT PUBLICATIONS ------------------------
    public static void Sort_publications(ArrayList<Publication> PublicationList){
        ArrayList<Publication> SortedPublications = new ArrayList<>();
        int GreaterIndex = 0;
        int year = PublicationList.get(0).getYear();
        int size = PublicationList.size();
       while(true){

           for (int i = 0; i < size; i++){
               if(PublicationList.get(i).getYear() > year){
                   GreaterIndex = i;
                   year = PublicationList.get(i).getYear();
               }
           }
           SortedPublications.add(PublicationList.get(GreaterIndex));
           PublicationList.remove(GreaterIndex);
           GreaterIndex = 0;
           if(size != 1){
               year = PublicationList.get(0).getYear();
           }
           size--;
           if(PublicationList.size() == 0){
               break;
           }
       }
       PublicationList = SortedPublications;

       //See_publications(SortedPublications);

    }
}


