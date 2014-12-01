package last_java;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
class About extends JFrame
{
	public About()
	{
		super( "简要说明" );
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize( 400, 400 );
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setLocation((screenWidth - 450) / 2, (screenHeight - 350) / 2);
		this.setVisible( true );
		JTextArea text = new JTextArea();
		text.setLineWrap( true );
		text.setEditable( false );
		text.setFont( new Font( "华文新魏", Font.CENTER_BASELINE, 14 ) );
		text.setText( "1、本计算器假设所有字符合法2、本计算器支持键盘输入和鼠标输入"
				);
		this.add( new JScrollPane( text ), "Center" );
		JButton confirm = new JButton( "确认" );
		confirm.setSize( 50, 60 );
		confirm.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				About.this.dispose();
			}
		});
		JPanel temp = new JPanel();
		temp.add( confirm );
		this.add( temp, "South" );
	}
}
class AboutDialog extends JFrame
{
	public AboutDialog()
	{
		super( "关于简易计算器");
		this.setResizable( false );
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
		this.setLayout( new FlowLayout( FlowLayout.CENTER, 150, 20 ) );
		this.add( new JLabel( "版本号： 0.0" ) );
		this.add( new JLabel( "**************制作人：郑文博*********" ) );
		this.add( new JLabel( "软件工程Sy1301\t" ) );
		JButton jb = new JButton( "确定" );
		jb.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				AboutDialog.this.dispose();
			}
		} );
		this.add( jb );		
		this.setSize( 400, 300 );
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setLocation((screenWidth - 450) / 2, (screenHeight - 350) / 2);
		this.setVisible( true );
	}
}