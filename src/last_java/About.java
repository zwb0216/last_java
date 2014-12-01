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
		super( "��Ҫ˵��" );
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
		text.setFont( new Font( "������κ", Font.CENTER_BASELINE, 14 ) );
		text.setText( "1�������������������ַ��Ϸ�2����������֧�ּ���������������"
				);
		this.add( new JScrollPane( text ), "Center" );
		JButton confirm = new JButton( "ȷ��" );
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
		super( "���ڼ��׼�����");
		this.setResizable( false );
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
		this.setLayout( new FlowLayout( FlowLayout.CENTER, 150, 20 ) );
		this.add( new JLabel( "�汾�ţ� 0.0" ) );
		this.add( new JLabel( "**************�����ˣ�֣�Ĳ�*********" ) );
		this.add( new JLabel( "�������Sy1301\t" ) );
		JButton jb = new JButton( "ȷ��" );
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