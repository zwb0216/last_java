package last_java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
class GUI extends JFrame
{
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem item, about;
	private JTextField express, result;
	private String [] buttonText = 
	{ "0", ".", "=", "+", "C", "1", "2", "3", "-", "(",
	  "4", "5", "6", "*", ")", "7", "8", "9", "/", "Esc" };
	private JButton button[] = new JButton[20];
	private boolean flag = false;
	private Calc calc = new Calc();
	Color color = new Color( 255, 149, 255 );
	Font font = new Font( "宋体", Font.BOLD, 20 );
	
	public GUI()
	{
		super( "简易计算器" );
		this.setIconImage( Toolkit.getDefaultToolkit().createImage( "1.jpg" ) );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setResizable( false );
		this.setSize( 500, 400 );
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setLocation((screenWidth - 450) / 2, (screenHeight - 350) / 2);
		
		MenuBarInit();
		this.add( getNorthPanel(), "North" );
		this.add( getCenterPanel(), "Center" );
	}
	private void MenuBarInit()
	{
		menubar = new JMenuBar();
		menu = new JMenu( "说明"	);
		item = new JMenuItem( "简要使用方法" );
		item.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				new About ();
			}
		} );
		about = new JMenuItem( "关于简易计算器" );
		about.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				new AboutDialog();
			}
		} );
		menu.add( item );
		menu.addSeparator();
		menu.add( about);
		menubar.add( menu );
		this.setJMenuBar( menubar );
	}
	private JPanel getNorthPanel()
	{
		express = new JTextField();
		express.setFont( font );
		express.setColumns( 34 );
		express.addKeyListener( new KeyListener()
		{
			public void keyPressed( KeyEvent e )
			{
				if( e.getKeyCode() == KeyEvent.VK_ENTER && flag )
				{
					calc.run( express.getText() );
					result.setText( calc.getResult() );
					flag = false;
				}
				else if( e.getKeyCode() == KeyEvent.VK_ESCAPE )
				{
					express.setText( "" );
					result.setText( "" );
					express.setFocusable( true );
					flag = false;
				}
				else
				{
					if( !flag )
					{
						express.setText( "" );
						result.setText( "" );
						flag = true;
					}
				}
			}
			public void keyReleased( KeyEvent e )
			{
			}
			public void keyTyped( KeyEvent e )
			{	
			}	
		} );
		result = new JTextField();
		result.setEditable( false );
		result.setFont( font );
		result.setColumns( 34 );
		
		JPanel north = new JPanel( new BorderLayout() );
		JPanel temp1 = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
		JPanel temp2 = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
		temp1.add( new JLabel( "运算表达式：" ) );
		temp1.add( express );
		temp2.add( new JLabel( "运算的结果：" ) );
		temp2.add( result );
		north.add( temp1, "North" );
		north.add( temp2, "South" );
		return north;
	}
	private JPanel getCenterPanel()
	{
		JPanel center = new JPanel( new FlowLayout( FlowLayout.LEFT, 35, 10 ) );
		for( int i = 0; i < 20; i++ )
		{
			button[i] = new JButton( buttonText[i] );
			button[i].setForeground( Color.red );
			button[i].setBackground( color );
			button[i].setFont( new Font( "Courier New", Font.BOLD, 22 ) );
			center.add( button[i] );
			button[i].addActionListener( new ActionListener()
			{
				public void actionPerformed( ActionEvent e )
				{
					String input = e.getActionCommand();
					if( input.equals( "=" ) && flag )
					{
						calc.run( express.getText() );
						result.setText( calc.getResult() );
						flag = false;
					}
					else if( input.equals( "C" ) )
					{
						express.setText( "" );
						result.setText( "" );
						express.setFocusable( true );
						flag = false;
					}
					else if( input.equals( "退出" ) )
					{
						System.exit( 0 );
					}
					else
					{
						if( !flag )
						{
							express.setText( "" );
							result.setText( "" );
							flag = true;
						}
						express.setText( express.getText() + input );
					}
				}
			});
		}
		button[19].setFont( new Font( "新宋体", Font.CENTER_BASELINE, 16 ) );
		center.setBorder( BorderFactory.createBevelBorder( 1 ) );
		return center;
	}
}

public class Calculator2
{
	public static void main( String[] args )
	{
		GUI calc = new GUI();
		calc.setVisible( true );
	}
}