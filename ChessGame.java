

import java.io.*;
import java.util.*;

public class ChessGame {

    public static void main (String args[]) throws IOException{
    	Game game = new Game();
    	ArrayList <String> input = game.readInput();
    	System.out.println(game.cb);
    	game.checkNextMove(input);
    	game.getRemainingPieces();
    	System.out.println(game.cb);
    	
    
    	
    }
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
    
    public  boolean isPossiblePawnMove(String source, String destination)
    {
     
    	return ((source.charAt(1) == '2' && destination.charAt(1) == '3') || (source.charAt(1) == '2' && destination.charAt(1) == '4') || (source.charAt(1) == '7' && destination.charAt(1) == '6') || (source.charAt(1) == '7' && destination.charAt(1) == '5'));
    }
    
    public  boolean isPossibleKingMove(String source, String destination) {
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
    

	public boolean isPossibleRookMove(String source, String destination)
	{
		if((!isHorizontalMove(source, destination)) && (!isVerticalMove(source, destination)) )
			return false;

		return true;
	}


	public  boolean isPossibleKnightMove(String source, String destination)
	{
		if( ((source.charAt(0) == (destination.charAt(0) + 1)) || (source.charAt(0) == (destination.charAt(0) - 1))) && ( (source.charAt(1) == (destination.charAt(1) + 2)) || (source.charAt(1) == (destination.charAt(1) - 2))) )
			return true;

		if( ((source.charAt(0) == (destination.charAt(0) + 2)) || (source.charAt(0) == (destination.charAt(0) - 2))) && ( (source.charAt(1) == (destination.charAt(1) + 1)) || (source.charAt(1) == (destination.charAt(1) - 1))) )
			return true;

		return false;
	}

	public  boolean isPossibleBishopMove(String source, String destination) {
    	String files = "abcdefgh";
    	int differenceInFiles = Math.abs(files.indexOf(source.charAt(0)) -  files.indexOf(destination.charAt(0)));
    	int differenceInRanks = Math.abs((int)source.charAt(1) -  (int)destination.charAt(1));
    	
    	
    	if(differenceInFiles == differenceInRanks){  
    		return true;
    	}
    	return false;
    	
    }  

	public  boolean isPossibleQueenMove(String source, String destination)
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
    	BufferedReader br = new BufferedReader(new FileReader("pngInput.txt"));
    	String line;
    	while((line = br.readLine()) != null)
    	{
    		line = clean(line);
    		String[] moves = line.split(" ");
    		input.add(moves[0]);
    		input.add(moves[1]);
    	}
    	br.close();
    	System.out.println("Result of Game: "+input.get(input.size() -1));
    	input.remove(input.size() -1 );
    	return input;
    }

    private String clean (String line)
    {
    	line = line.replaceAll("[!?\\+]", "");
    	return line;
    }
    
    public ArrayList<String> getPossibleSources(String input, Integer index)
    {
		String[] pieceName = { "K", "Q", "R", "N", "B", "P" };
		ArrayList<String> possibleSource = new ArrayList<String>();
		String piece = getChessPiece(input);
		Set keySet = cb.keySet();
		Iterator<String> iter = keySet.iterator();

		if (index % 2 == 0) {

			while (iter.hasNext()) {
				String position = iter.next();
				if (cb.get(position)!= null && cb.get(position).contains(piece + "w")) {
					possibleSource.add(position);
				}
			}

		} else {
			while (iter.hasNext()) {
				String position = iter.next();
				if (cb.get(position) != null && cb.get(position).contains(piece + "b")) {
					possibleSource.add(position);
				}
			}

		}

		return possibleSource;
	}
    
    public void checkNextMove (ArrayList <String> input)
    {
    	for(String move : input){
    		ArrayList<String> possibleMoves = getPossibleSources(move , input.indexOf(move));
    		String piece = getChessPiece(move);
    		String position = getPosition(move);
    		
    			
    			if(piece.equals("R")){
    				for (int i =0; i < possibleMoves.size(); i++){
    					if(isPossibleRookMove(possibleMoves.get(i), position)){
    						updateHashMap(possibleMoves.get(i), position);
    						
    					}
    				}
    			}else if (piece.equals("K")){
    				for (int i =0; i < possibleMoves.size(); i++){
    					if(isPossibleKingMove(possibleMoves.get(i), position)){
    						updateHashMap(possibleMoves.get(i), position);
    					}
    				}
    				
    			} else if(piece.equals("Q")){
    				for (int i =0; i < possibleMoves.size(); i++){
    					if(isPossibleQueenMove(possibleMoves.get(i), position)){
    						updateHashMap(possibleMoves.get(i), position);
    					}
    				}
    		} else if(piece.equals("B")){
    			for (int i =0; i < possibleMoves.size(); i++){
    				if(isPossibleBishopMove(possibleMoves.get(i), position)){
    					updateHashMap(possibleMoves.get(i), position);
    				}
    			}
    		} else if(piece.equals("N")){
    			for (int i =0; i < possibleMoves.size(); i++){
					if(isPossibleKnightMove(possibleMoves.get(i), position)){
						updateHashMap(possibleMoves.get(i), position);
					}
				}
    		} else if (piece.equals("P")){
    			for (int i =0; i < possibleMoves.size(); i++){
    				if(isPossiblePawnMove(possibleMoves.get(i), position)){
						updateHashMap(possibleMoves.get(i), position);
					}
				}
    		}
    	}
    	
    }
    
    public void updateHashMap(String source, String destination){
    	
    	String value = cb.get(source);
    	cb.put(source, null);
    	cb.put(destination, value);
    }
    
    public void getRemainingPieces(){
    	
    	Set keySet = cb.keySet();
		Iterator<String> iter = keySet.iterator();
		String[] piecesName = {"Bishop","King","Queen","Rook","Knight","Pawn"};
		while (iter.hasNext()){
			String position = iter.next();
			if (cb.get(position) != null){
				
					for(String i:piecesName){
						if(i.startsWith(String.valueOf(cb.get(position).charAt(0)))){
							if(cb.get(position).contains("w")){
								System.out.println(i +" of white");
						}
							else
								System.out.println(i +" of black");
					}
				}
			}
		}
    	
    }
}
