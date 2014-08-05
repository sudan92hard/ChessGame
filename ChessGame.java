
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;






public class ChessGame {
	
    public static void main (String args[]) throws IOException{
    	Game game = new Game();
    	ArrayList <String> input = game.readInput();
    	System.out.println(game.cb);
    }
    /*public String getColor(String position){ }
    public boolean isValidRookMove(String source, String destination) {}
    public boolean isValidKnightMove(String source, String destination) {}
    public boolean isValidBishopMove(String source, String destination) {}
    public boolean isValidkingMove(String source, String destination) {}
    public boolean isValidQueenMove(String source, String destination) {}
    public boolean isValidPawnMove(String source, String destination) {}
    public String getChessPiece(String gameEntry) {}
    public String getPosition(String gameEntry) {}
    public void kill(String str) {}
    */
    }
class Game
{
	public Map <String, String> cb;
	public Game(){
	   cb = new LinkedHashMap<String, String>();
	   cb.put("a1", "R");
	   cb.put("b1", "N");
	   cb.put("c1", "B");
	   cb.put("d1", "K");
	   cb.put("e1", "Q");
	   cb.put("f1", "B");
	   cb.put("g1", "N");
	   cb.put("h1", "R");
	   
	   cb.put("a2", "P");
	   cb.put("b2", "P");
	   cb.put("c2", "P");
	   cb.put("d2", "P");
	   cb.put("e2", "P");
	   cb.put("f2", "P");
	   cb.put("g2", "P");
	   cb.put("h2", "P");
	   
	   cb.put("a8", "R");
	   cb.put("b8", "N");
	   cb.put("c8", "B");
	   cb.put("d8", "Q");
	   cb.put("e8", "K");
	   cb.put("f8", "B");
	   cb.put("g8", "N");
	   cb.put("h8", "R");
	   
	   cb.put("a7", "P");
	   cb.put("b7", "P");
	   cb.put("c7", "P");
	   cb.put("d7", "P");
	   cb.put("e7", "P");
	   cb.put("f7", "P");
	   cb.put("g7", "P");
	   cb.put("h7", "P");
	   
	   
	   for(int i = 3; i <= 6; i++)
	   {
		   char pos = 'a';
		   for(int j = 1; j < 9; j++)
		   {
			   String key = new StringBuilder().append(pos).toString() + Integer.toString(i);
			   cb.put(key, null);
			   pos = (char) (pos + 1);
		   }
	   }
	   
	   
   }   
	public  char getColorOfCell(String destination)
	{
		char color;
		int calNum = destination.charAt(0)-'a' + 1;
		calNum = calNum + (int)destination.charAt(1);
		if(calNum % 2 ==0)
			color = 'b';
		else
			color = 'w';
		return color;
	}   
	
    public  boolean isValidBishopMove(String source, String destination) {
    	String files = "abcdefgh";
    	Integer[] ranks = {0,1,2,3,4,5,6,7,8};
    
    	
    	int differenceInFiles = Math.abs(files.indexOf(source.charAt(0)) -  files.indexOf(destination.charAt(0)));
    	int differenceInRanks = Math.abs((int)source.charAt(1) -  (int)destination.charAt(1));
    	
    	
    	if(differenceInFiles == differenceInRanks){
    		return true;
    	}
    	return false;
    	
    }

    
    public  boolean isValidKingMove(String source, String destination) {
    	String files = "abcdefgh";
    	
    	
    	
    	int differenceInFiles = Math.abs(files.indexOf(source.charAt(0)) -  files.indexOf(destination.charAt(0)));
    	int differenceInRanks = Math.abs((int)source.charAt(1) -  (int)destination.charAt(1));

    	if(differenceInFiles == 1 && differenceInRanks ==1){
    		return true;
    	}
    	else if((differenceInFiles == 0 && differenceInRanks ==1)){
    		return true;
    	}
    	else if((differenceInFiles ==1 && differenceInRanks ==0)){
    		return true;
    	}
    	
    	return false;
    	
    }
    public  String getChessPiece(String gameEntry) {
    	
    	if(Character.isUpperCase(gameEntry.charAt(0))){
    		String chessPiece = "" + gameEntry.charAt(0); 
    		return chessPiece;
    	}
    	return "P";
    		
    	
    		
    }
    public  String getPosition(String gameEntry) {
    	char[] positionToChar = gameEntry.toCharArray();
    	
    	return ""+positionToChar[positionToChar.length - 2]+""+positionToChar[positionToChar.length - 1];
    }
	
	public  boolean isValidRookMove(String source, String destination)
	{
		if((source.charAt(0) != destination.charAt(0)) && (source.charAt(1) != destination.charAt(1)) )
			return false;
		
		return true;
	}
	
	public  boolean isValidKnightMove(String source, String destination)
	{
		if( ((source.charAt(0) == (destination.charAt(0) + 1)) || (source.charAt(0) == (destination.charAt(0) - 1))) && ( (source.charAt(1) == (destination.charAt(1) + 2)) || (source.charAt(1) == (destination.charAt(1) - 2))) )
			return true;
		
		if( ((source.charAt(0) == (destination.charAt(0) + 2)) || (source.charAt(0) == (destination.charAt(0) - 2))) && ( (source.charAt(1) == (destination.charAt(1) + 1)) || (source.charAt(1) == (destination.charAt(1) - 1))) )
			return true;
		
		return false;
	}
	
	public ArrayList<String> readInput() throws IOException{
    	
    	ArrayList <String> input = new ArrayList<String>();
    	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    	String line;
    	while((line = br.readLine()) != null)
    	{
    		line = clean(line);
    		String[] moves = line.split(" ");
    		input.add(moves[0]);
    		input.add(moves[1]);
    	}
    	return input;
    }
    private String clean (String line)
    {
    	line = line.replaceAll("[!?\\+]", "");
    	return line;
    }
}
