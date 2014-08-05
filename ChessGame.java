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
    	//game.isWhite("1234");
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
	   cb.put("a1", "Rw");
	   cb.put("b1", "Nw");
	   cb.put("c1", "Bw");
	   cb.put("d1", "Kw");
	   cb.put("e1", "Qw");
	   cb.put("f1", "Bw");
	   cb.put("g1", "Nw");
	   cb.put("h1", "Rw");
	   
	   cb.put("a2", "Pw");
	   cb.put("b2", "Pw");
	   cb.put("c2", "Pw");
	   cb.put("d2", "Pw");
	   cb.put("e2", "Pw");
	   cb.put("f2", "Pw");
	   cb.put("g2", "Pw");
	   cb.put("h2", "Pw");
	   
	   cb.put("a8", "Rb");
	   cb.put("b8", "Nb");
	   cb.put("c8", "Bb");
	   cb.put("d8", "Qb");
	   cb.put("e8", "Kb");
	   cb.put("f8", "Bb");
	   cb.put("g8", "Nb");
	   cb.put("h8", "Rb");
	   
	   cb.put("a7", "Pb");
	   cb.put("b7", "Pb");
	   cb.put("c7", "Pb");
	   cb.put("d7", "Pb");
	   cb.put("e7", "Pb");
	   cb.put("f7", "Pb");
	   cb.put("g7", "Pb");
	   cb.put("h7", "Pb");
	   
	   
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
	  
	
    public boolean isWhite(String str)
    {
    	if(cb.get(str).charAt(1) == 'w')
    	{
    		return true;
    	}
    	
    	return false;
    }
    public boolean isBlack(String str)
    {
    	if(cb.get(str).charAt(1) == 'b')
    	{
    		return true;
    	}
    	
    	return false;
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
	public  boolean isKill(String move)
	{
		if ((move.indexOf('x') == -1) && (move.indexOf('X') == -1))
			return false;
		return true;
	}
	
	public  boolean isCheckMove(String move)
	{
		if ((move.indexOf('+') == -1))
			return false;
		return true;		
		
	}
	
	public  boolean isPromotion(String move)
	{
		if ((move.indexOf('=') == -1))
			return false;
		return true;		
		
	}
    
    
    
    public  boolean isHorizontalMove(String source, String destination)
    {   
        return (source.charAt(1) == destination.charAt(1));
    }
    
    public  boolean isVerticalMove(String source, String destination)
    {   
        return (source.charAt(0) == destination.charAt(0));
    }
    
    public  boolean isDiagonalMove(String source, String destination)
    {   
        return ((Math.abs(source.charAt(1) - destination.charAt(1))) == Math.abs((source.charAt(0) - destination.charAt(0))));
    }
    
    public  boolean isValidPawnMove(String source, String destination)
    {
        return ((source.charAt(1) == '2' && destination.charAt(1) == '3') || (source.charAt(1) == '2' && destination.charAt(1) == '4') || (source.charAt(1) == '7' && destination.charAt(1) == '6') || (source.charAt(1) == '7' && destination.charAt(1) == '5'));
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
	
	public  boolean isValidBishopMove(String source, String destination) {
    	String files = "abcdefgh";
    	//Integer[] ranks = {0,1,2,3,4,5,6,7,8};
    	int differenceInFiles = Math.abs(files.indexOf(source.charAt(0)) -  files.indexOf(destination.charAt(0)));
    	int differenceInRanks = Math.abs((int)source.charAt(1) -  (int)destination.charAt(1));
    	
    	
    	if(differenceInFiles == differenceInRanks){  
    		return true;
    	}
    	return false;
    	
    }  
	
	public  boolean isValidQueenMove(String source, String destination)
    {
        return (isVerticalMove(source, destination) || isHorizontalMove(source, destination) || isDiagonalMove(source, destination));
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
    	
    	return "" + positionToChar[positionToChar.length - 2] + "" + positionToChar[positionToChar.length - 1];
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
    	br.close();
    	return input;
    }
	
    private String clean (String line)
    {
    	line = line.replaceAll("[!?\\+]", "");
    	return line;
    }
}
