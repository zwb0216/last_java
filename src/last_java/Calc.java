package last_java;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;

class Calc
{
	private Stack<String> optr, opnd;
	private Queue<String> exp;
	private String result;
	private HashMap<String, Integer> hashmap;
	private char[][] hash = {
			{ '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '<', '<', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '>', '>' },
			{ '>', '>', '>', '>', '<', '>', '>' },
			{ '<', '<', '<', '<', '<', '=', '#' },
			{ '>', '>', '>', '>', '#', '>', '>' },
			{ '<', '<', '<', '<', '<', '#', '=' }
	};
	public Calc()
	{
		hashmap = new HashMap<String, Integer>();
	    hashmap.put( "+", 0 );   
	    hashmap.put( "-", 1 );   
	    hashmap.put( "*", 2 );   
	    hashmap.put( "/", 3 );
	    hashmap.put( "(", 4 );
	    hashmap.put( ")", 5 );
	    hashmap.put( "#", 6 );
	}
	public void run( String expression )
	{
		optr = new Stack<String>();
		opnd = new Stack<String>();
		Analyse( expression );
	    optr.push( "#" );
		String s = exp.poll();
	    while( s != "#" || optr.peek() != "#" )
	    {
	    	if( isOpnd( s ) )
	    	{
	    		opnd.push( s );
	    		s = exp.poll();
	    	}
	    	else
	    	{
	    		Integer i = hashmap.get( optr.peek() ),
	    				j = hashmap.get( s );
	    		if( i == null || j == null )
	    			Error();
	    		switch( hash[i][j] )
	    		{
	    			case '<':
	    				optr.push( s );
	    				s = exp.poll();
	    				break;
	    			case '=':
	    				System.out.println( optr.pop() );
	    				s = exp.poll();
	    				break;
	    			case '>':
	    				try
	    				{
		    				String a = optr.pop();
		    				String b = opnd.pop();
		    				String c = opnd.pop();
		    				opnd.push( Operate( a, c, b ) );
	    				}
	    				catch( EmptyStackException e )
	    				{
	    					Error();
	    				}
	    				break;
	    			default:
	    				Error();	
	    		}
	    	}
	    }
	    try
	    {
	    	result = opnd.peek();
	    }
	    catch( EmptyStackException e)
	    {
	    	Error();
	    }
	}
	public void Analyse( String expression )
	{
		exp = new LinkedList<String>();
		String s;
		int begin = 0;
		boolean flag = true;
		for( int i = 0; i < expression.length(); i++ )
		{
			s = String.valueOf( expression.charAt( i ) );
			if( !isOpnd( s ) )
			{
				if( !flag )
				{
					exp.offer( expression.substring( begin, i ) );
				}
				exp.offer( s );
				begin = i + 1;
				flag = true;
			}
			else
				flag = false;
		}
		if( isOpnd( expression.substring( expression.length() - 1 ) ) )
		{
			exp.offer( expression.substring( begin ) );
		}
		exp.offer( "#" );
	}
	private boolean isOpnd( String s )
	{
		if( s.equals( "+" ) || s.equals( "-" ) ||
			s.equals( "*" ) || s.equals( "*" ) ||
			s.equals( "/" ) || s.equals( "(" ) ||
			s.equals( ")" ) || s.equals( "#" ) )
			return false;
		return true;
	}
	private String Operate( String optr, String a, String b )
	{
		String res = null;
		BigDecimal c = new BigDecimal( a );
		BigDecimal d = new BigDecimal( b );
		if( optr.equals( "+" ) )
			res = c.add( d, new MathContext( 32, RoundingMode.HALF_DOWN ) ).toString();
		else if( optr.equals( "-" ) )
			res = c.subtract( d, new MathContext( 32, RoundingMode.HALF_DOWN ) ).toString();
		else if( optr.equals( "*" ) )
			res = c.multiply( d, new MathContext( 32, RoundingMode.HALF_DOWN ) ).toString();
		else if( optr.equals( "/" ) )
			try
			{
				res = c.divide( d, new MathContext( 32, RoundingMode.HALF_DOWN ) ).toString();
			} catch( ArithmeticException e )
			{
				JOptionPane.showMessageDialog( null, "³ý0´íÎó£¡", "´íÎó", JOptionPane.ERROR_MESSAGE );
			}
		else
			JOptionPane.showMessageDialog( null, "×ª»»Ê±³öÏÖ´íÎó£¡", "´íÎó", JOptionPane.ERROR_MESSAGE );
		return res;
	}
	private void Error()
	{
		JOptionPane.showMessageDialog( null, "±í´ïÊ½´íÎó£¡£¡£¡", "´íÎó", JOptionPane.ERROR_MESSAGE );
		System.exit( 0 );
	}
	public String getResult()
	{
		return result;
	}
}