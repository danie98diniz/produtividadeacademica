import java.util.ArrayList;
import java.util.Scanner;

public class Orientations {

    private Collaborator autor;
    private ArrayList<String> orientation = new ArrayList<>();

    //----------------------------------------- SEE ORIENTATIONS ----------------------
    public void Show_all_orientations(ArrayList<Orientations> AllOrientations){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        if(AllOrientations.size() < 1){
            System.out.println("this lab has no orientations");
            return;
        }

        for(int i = 0; i < AllOrientations.size(); i++){
            System.out.println("--------------------");
            System.out.println(AllOrientations.get(i).getAutor().getName()+":");
            for(int j = 0; j < AllOrientations.get(i).getOrientation().size(); j++){
                System.out.println(AllOrientations.get(i).getOrientation().get(j));
            }
        }
        System.out.println("type any key to go back");
        String string = scan.nextLine();
    }
    //----------------------------------------- CREATE ORIENTATION ------------------
    public void Create_orientation(ArrayList<Orientations> AllOrientations, ArrayList<Collaborator> TeachersList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("what teacher is giving this orientation?");
        for(int i = 0; i < TeachersList.size(); i++){
            System.out.println(i+". "+TeachersList.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();
        Collaborator teacher = TeachersList.get(option);
        Orientations new_orientation = new Orientations();
        new_orientation.setAutor(teacher);
        System.out.println("write your orientation");
        System.out.println("type 'DONE' when done.");
        String string;
        while(true){
            string = scan.nextLine();
            if(string .equals("DONE")){
                break;
            }
            new_orientation.getOrientation().add(string);
        }
        teacher.getYourOrientations().add(new_orientation);
        AllOrientations.add(new_orientation);
        System.out.println("your orientation is published in this laboratory.");

    }

    public Collaborator getAutor() {
        return autor;
    }

    public void setAutor(Collaborator autor) {
        this.autor = autor;
    }

    public ArrayList<String> getOrientation() {
        return orientation;
    }

    public void setOrientation(ArrayList<String> orientation) {
        this.orientation = orientation;
    }

    public Orientations() {
    }
}
