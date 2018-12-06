package iphonesnatchers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicholas Lance and Saffy winton
 * @date Nov 16, 2017
 */
public class IPhoneSnatchers {
	
	public static final Scanner kbd = new Scanner(System.in);
    
	public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        Item[][] board = new Item[8][8];
        boolean playerLost = false;

        System.out.println("Welcome to iPhoneSnatcher! You are a thief trying to steal an iPhone X from"
                + "an apple store. On the board, your player is a T, for theif. \nDoors are denoted by 'D' "
                + "apple Genius's are denoted as a 'G', keys are a 'K', the iPhone is an 'X', and tables are '#'"
                + "\nYou can move into any open spaces. Try not to get seen by Geniuses, every time you are spotted"
                + " you will gain points towards a spotted meter, \nwhich will end the game once it gets too high."
                + "\n The meter will reset each time you enter a new room."
                + " This is the first level: ");
        System.out.println("Geniuses move up to one space randomly each time you move. Press 'd' to move right"
                + " 's' to move down, \n'a' to move left, and 'd' to move right. Good Luck!");
        //play level 1
        if (!playerLost) {
        	System.out.println("\nGet to the door 'D' without filling the detection meter!");
            board = fillLevel1(board);
            playerLost = playLevel(board);

        }
        board = clearBoard(board);

        //play level 2
        if (!playerLost) {
        System.out.println("LEVEL 2:"
        		+ "\nGet the key 'K' and then get to the door 'D' without filling the detection meter!");    
        	board = fillLevel2(board);
            playerLost = playLevel(board);
        }
        board = clearBoard(board);

        //play level 3
        if (!playerLost) {
        	System.out.println("LEVEL 3:"
        			+ "\ndGet the iPhone 'X' and the get to the door 'D' without filling the detection meter!"); 
            board = fillLevel3(board);
            playerLost = playLevel(board);
        }

        if (!playerLost) {
            //results if players won the game
            System.out.println("/nYou win");
        } else {
            //results is players lost the game
            System.out.println("/nYou lose");
        }
        kbd.close();
    }

    //fills level 1 2d array
    public static Item[][] fillLevel1(Item[][] board) {
        Random rand = new Random();
        for (int i = 1; i < 7; i++) {
            board[i][1] = new Table(new Location(i, 1));
            board[i][3] = new Table(new Location(i, 3));
            board[i][5] = new Table(new Location(i, 5));
        }
        int doorLocation = rand.nextInt(8);
        Item door = new Door(new Location(doorLocation, 7));
        board[doorLocation][7] = door;

        board[0][0] = new Theif(new Location(0, 0));
        findTheif(board).setHasKey(true);
        Item g1 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g1);
        Item g2 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g2);
        Item g3 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g3);
        
       
        return board;
    }

    //fills level 2 2d array
    public static Item[][] fillLevel2(Item[][] board) {
        Random rand = new Random();
        for (int i = 1; i < 7; i++) {
            board[5][i] = new Table(new Location(5, i));
        }
        int doorLocation = rand.nextInt(8);
        Item door = new Door(new Location(7, doorLocation));
        board[7][doorLocation] = door;

        board[0][0] = new Theif(new Location(0, 0));
        int x = rand.nextInt(4) + 3;
        int y = rand.nextInt(5);
        board[x][y] = new Key(new Location(x, y));
        Item g1 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g1);
        Item g2 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g2);
        Item g3 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g3);
        
        
        
        return board;
    }

    //fills level 3 2d array
    public static Item[][] fillLevel3(Item[][] board) {
        Random rand = new Random();
        for (int i = 1; i < 7; i++) {
            if (i == 3 || i == 4); else {
                board[i][1] = new Table(new Location(i, 1));
                board[i][3] = new Table(new Location(i, 3));
                board[i][5] = new Table(new Location(i, 5));
            }

        }
        int doorLocation = rand.nextInt(8);
        Item door = new Door(new Location(doorLocation, 7));
        board[doorLocation][7] = door;
        board[0][0] = new Theif(new Location(0, 0));
        Item iphone = new iPhone(new Location(0, 0));
        board = setItem(board, iphone);
        Item g1 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g1);
        Item g2 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g2);
        Item g3 = new Genius(new Location(0, 0), 1);
        board = setItem(board, g3);
        return board;
    }

    // clears the board for the next level
    public static Item[][] clearBoard(Item[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = null;
            }
        }
        return board;
    }

    //sets an item randomly in a level
    public static Item[][] setItem(Item[][] board, Item item) {
        Random rand = new Random();
        int x;
        int y;
        do {
            x = rand.nextInt(8);
            y = rand.nextInt(8);
            item.setLoc(new Location(x, y));
        } while (!item.canBePlaced(board));

        board[item.getLoc().getY()][item.getLoc().getX()] = item;
        return board;
    }

    //prints board
    public static void printBoard(Item[][] board) {
        String str = "";
        str += " _______________________________\n";
        for (int y = 0; y < board.length; y++) {
            str += "| ";
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == null) {
                    str += "  | ";
                } else {
                    str += board[y][x].getLabel() + " | ";
                }
            }
            str += "\n|___|___|___|___|___|___|___|___| ";
            System.out.println(str);
            str = "";
        }
        System.out.println(str);
    }

 

    //moves thief based on user input
	public static Item[][] movePlayer(Item[][] board) {
        
        String input;
        char move;
        Theif player = findTheif(board);
        Theif newMove = new Theif(findTheif(board));

        System.out.println("Where do you want to go?\n"
                + "(a = left, w = up, s = down, d = right)");
        input = kbd.nextLine().toLowerCase();
        move = input.charAt(0);
        
        if (move == 'd') {
            newMove.setLoc(new Location(newMove.getLoc().getX() + 1, newMove.getLoc().getY()));
        } else if (move == 'a') {
            newMove.setLoc(new Location(newMove.getLoc().getX() - 1, newMove.getLoc().getY()));
        } else if (move == 'w') {
            newMove.setLoc(new Location(newMove.getLoc().getX(), newMove.getLoc().getY() - 1));
        } else if (move == 's') {
            newMove.setLoc(new Location(newMove.getLoc().getX(), newMove.getLoc().getY() + 1));
        } else {
            System.out.println("Thats not a move!");
            kbd.close();
            return movePlayer(board);
        }
        
        try{
            if(isOutOfBounds(newMove.getLoc())){
            	kbd.close();
                throw new Exception("You cant glitch out of this map");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            
            return movePlayer(board);
        }
			
	           
    
        if (board[newMove.getLoc().getY()][newMove.getLoc().getX()] instanceof Key) {
            player.setHasKey(true);
            board[player.getLoc().getY()][player.getLoc().getX()] = null;
            board[newMove.getLoc().getY()][newMove.getLoc().getX()] = player;
            player.setLoc(newMove.getLoc());
            System.out.println("You Have the Key!\n");
            return board;
        }
        
        if (board[newMove.getLoc().getY()][newMove.getLoc().getX()] instanceof Door && player.getHasKey()) {
            player.setEnteredDoor(true);
            board[player.getLoc().getY()][player.getLoc().getX()] = null;
            board[newMove.getLoc().getY()][newMove.getLoc().getX()] = player;
            player.setLoc(newMove.getLoc());
           
            return board;
        }
            if (board[newMove.getLoc().getY()][newMove.getLoc().getX()] instanceof iPhone) {
                player.setHasKey(true);
                board[player.getLoc().getY()][player.getLoc().getX()] = null;
                board[newMove.getLoc().getY()][newMove.getLoc().getX()] = player;
                player.setLoc(newMove.getLoc());
                System.out.println("You Have the iPhone!\n");
              
                return board;
            }
            
            if (board[newMove.getLoc().getY()][newMove.getLoc().getX()] instanceof Door && player.getHasKey()) {
                player.setEnteredDoor(true);
                board[player.getLoc().getY()][player.getLoc().getX()] = null;
                board[newMove.getLoc().getY()][newMove.getLoc().getX()] = player;
                player.setLoc(newMove.getLoc());
              
                return board;
        }
        try {
        	if (board[newMove.getLoc().getY()][newMove.getLoc().getX()] instanceof Genius) {
               setDetectionMeter(player);
               System.out.println("You've been spotted by a genius!");
               printDetectionMeter(player);
        
               throw new Exception("You can't move there, Try Again!");
               
            }
        	
      else if (!newMove.canBePlaced(board)) {
  
    	  throw new Exception("You can't move there, Try Again!");
                
            }
     
            board[player.getLoc().getY()][player.getLoc().getX()] = null;
            board[newMove.getLoc().getY()][newMove.getLoc().getX()] = player;
            player.setLoc(newMove.getLoc());
        } catch (Exception e) {
            System.out.println(e.getMessage());
           
            return movePlayer(board);
        }     
        geniusSpotting(board, player, newMove);


        
        return board;
			}
	

    
    //Play a level of the game
    public static boolean playLevel(Item[][] board) {
        boolean playerLost = false;

        do {
            printBoard(board);
            printDetectionMeter(findTheif(board));
            board = movePlayer(board);
            board = moveGeniuses(board);
            if (findTheif(board).getEnteredDoor()) {
                return false;
            }

        } while (!playerLost);
        return playerLost;
    }

    //gets the location of a specific Item
    public static Location getLocation(Item[][] board, char label) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == null); else if (board[y][x].getLabel() == label) {
                    return board[y][x].getLoc();
                }
            }
        }
        return null;
    }
   
    //randomly moves all geniuses
    public static Item[][] moveGeniuses(Item[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == null); 
                else if (board[y][x] instanceof Genius ) {
                    board = moveAGenius(board, (Genius) board[y][x]);
                }
            }
        }
        for(int y = 0; y < board.length; y++){
           for(int x = 0; x < board[0].length; x++){
               if(board[y][x] instanceof Genius){
                   ((Genius) board[y][x]).setHasBeenMoved(false);
               }
           } 
        }
        return board;

    }
    
    //randomly moves a single genius
    private static Item[][] moveAGenius(Item[][] board, Genius genius) {
        Random rand = new Random();
        int determinant = rand.nextInt(4);
        Genius newMove = new Genius(genius.getLoc(), genius.getSeeingDistance());
        if(genius.getHasBeenMoved()){
            return board;
        }
        if (determinant == 0) {
            newMove.setLoc(new Location(newMove.getLoc().getX() + 1, newMove.getLoc().getY()));

        } else if (determinant == 1) {
            newMove.setLoc(new Location(newMove.getLoc().getX() - 1, newMove.getLoc().getY()));

        } else if (determinant == 2) {
            newMove.setLoc(new Location(newMove.getLoc().getX(), newMove.getLoc().getY() + 1));

        } else if (determinant == 3) {
            newMove.setLoc(new Location(newMove.getLoc().getX(), newMove.getLoc().getY() - 1));
        }
        try{
            if(!newMove.canBePlaced(board)) {
                throw new Exception("Genius cannot be placed");
            }
            board[genius.getLoc().getY()][genius.getLoc().getX()] = null;
            board[newMove.getLoc().getY()][newMove.getLoc().getX()] = genius;
            genius.setLoc(newMove.getLoc());
            genius.setHasBeenMoved(true);
        }
        catch (Exception e){
            return board;
        }
        
        return board;
    }

    public static Theif findTheif(Item[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] instanceof Theif) {
                    return (Theif) board[y][x];
                }
            }
        }
        return null;
    }
    
    //prints out the detection meter
    public static void printDetectionMeter(Theif player){
        String str = "";
        try{
        	for(int i = 1; i <= 12; i++){
            str += "[";
            if(player.getDetectionMeter() >= i){
                str += "X";
            }else {
                str += " ";
            }
            str += "]";
        }
        System.out.println("Detection Meter\n" + str + "\n");
        if (player.getDetectionMeter()>12) {
        	throw new Exception("You've drawn too much attention to yourself! Game over!");
        }
        else return;
        }
        catch (Exception e){
        	System.out.println(e.getMessage());
        	System.exit(0);
        }
    }
    
    public static void setDetectionMeter(Theif player){
    	Die d1 = new Die(4);
    	int newlevel = player.getDetectionMeter()+ d1.roll();
    player.setDetectionMeter(newlevel);
  
        
    }

    public static void geniusSpotting(Item [][] board, Theif player, Theif newMove) {
    	Genius genius = new Genius(2);
    	for (int i = 0; i <= genius.getSeeingDistance(); i++) {
     	   for (int j = 1; j <= genius.getSeeingDistance(); j++) {
     		   Location seeingrange = new Location(newMove.getLoc().getX()+i,newMove.getLoc().getY()+j);
     		   if (isOutOfBounds(seeingrange) == false && board[newMove.getLoc().getX()+i][newMove.getLoc().getY()+j] instanceof Genius ) {
                System.out.println("You've been spotted by a genius!");
                setDetectionMeter(player);
                board[player.getLoc().getY()][player.getLoc().getX()] = null;
                board[newMove.getLoc().getY()][newMove.getLoc().getX()] = player;
                player.setLoc(newMove.getLoc());
     		   }
     	   }
        }
    }

    private static boolean isOutOfBounds(Location loc) {
        return loc.getX() > 7 || loc.getY() > 7 || loc.getX() < 0 || loc.getY() < 0;
    }
  
}