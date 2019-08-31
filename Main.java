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
                Project newProjects = new Project();
                newProjects.Project_selection(AllProjects);
            }//project consult
        }
    }
}


















