import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);
    public void Login(){
        
        System.out.println("Welcoem to the Adventure Game ⚔️ ⚔️ ⚔️ ");
        System.out.println("Enter your user name: ");
        String userName = scan.nextLine();
        player = new Player(userName);
        player.selectChar();
        start();

    }
    
    public void start(){
        while(true){
            System.out.println();
        System.out.println("==================================");
        System.out.println();
        System.out.println("Select your destination! :");
        System.out.println("1. Safe House ==> It is a safe house that belongs to you.");
        System.out.println("2. Cave ==> Be careful zombies may appear. The probability of a zombie appearing is 1-3.");
        System.out.println("3. Forest ==> Be careful vampires may appear. The probability of a vampire appearing is 1-3.");
        System.out.println("4. River ==> Be careful bears may appear. The probability of a bear appearing is 1-2.");
        System.out.println("5. Tool Store ==> You get weapons and armor.");
        int selLoc = scan.nextInt();
        while(selLoc < 1 || selLoc > 5){
            System.out.println("Invalit location choices please try again!!!");
            selLoc = scan.nextInt();
        }
        switch(selLoc) {
            case 1:
            location = new SafeHouse(player); 
            break;
            case 2:
            location = new Cave(player);
            break;
            case 3:
            location = new Forest(player);
            break;
            case 4:
            location = new River(player);
            break;
            case 5:
            location = new ToolStore(player);
            break;
        }
        if(!location.getLocation()){
            System.out.println("Game Over...");
            break;
        }

        }
    }

}
