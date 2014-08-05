
public class Rules {

    public static char getColorOfCell(String destination)
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
	
	public static boolean isValidRookMove(String source, String destination)
	{
		if((!isHorizontalMove(source, destination)) && ((!isVerticalalMove(source, destination)) )
			return false;
		
		return true;
	}
	
	public static boolean isValidKnightMove(String source, String destination)
	{
		if( ((source.charAt(0) == (destination.charAt(0) + 1)) || (source.charAt(0) == (destination.charAt(0) - 1))) && ( (source.charAt(1) == (destination.charAt(1) + 2)) || (source.charAt(1) == (destination.charAt(1) - 2))) )
			return true;
		
		if( ((source.charAt(0) == (destination.charAt(0) + 2)) || (source.charAt(0) == (destination.charAt(0) - 2))) && ( (source.charAt(1) == (destination.charAt(1) + 1)) || (source.charAt(1) == (destination.charAt(1) - 1))) )
			return true;
		
		return false;
	}
	
	public static boolean isKill(String move)
	{
		if ((move.indexOf('x') == -1) && (move.indexOf('X') == -1))
			return false;
		return true;
	}
	
	public static boolean isCheckMove(String move)
	{
		if ((move.indexOf('+') == -1))
			return false;
		return true;		
		
	}
	
	public static boolean isPromotion(String move)
	{
		if ((move.indexOf('=') == -1))
			return false;
		return true;		
		
	}
    
    public static boolean isValidQueenMove(String source, String destination)
    {
        return (isVerticalMove(source, destination) || isHorizontalMove(source, destination) || isDiagonalMove(source, destination));
    }
    
    public static boolean isHorizontalMove(String source, String destination)
    {   
        return (source.charAt(1) == destination.charAt(1));
    }
    
    public static boolean isVerticalMove(String source, String destination)
    {   
        return (source.charAt(0) == destination.charAt(0));
    }
    
    public static boolean isDiagonalMove(String source, String destination)
    {   
        return ((Math.abs(source.charAt(1) - destination.charAt(1))) == Math.abs((source.charAt(0) - destination.charAt(0))));
    }
    
    public static boolean isValidPawnMove(String source, String destination)
    {
        return ((source.charAt(1) == '2' && destination.charAt(1) == '3') || (source.charAt(1) == '2' && destination.charAt(1) == '4') || (source.charAt(1) == '7' && destination.charAt(1) == '6') || (source.charAt(1) == '7' && destination.charAt(1) == '5'));
    }
	
	public static void main(String[] args)
	{
		//char color = getColorOfCell("b3");
		//System.out.println(color);
		
		boolean check = isKill("xcx3");
		System.out.println(check);
        
        System.out.println(isDiagonalMove("c3", "a1"));
        System.out.println(isValidPawnMove("c2", "c4"));
        
		
	}
}
