//凌空工作室拥有追究权利，禁止倒卖
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
public static void main(String[] args) throws Exception {
    boolean copyright_agree = false;//请先将其改为true，否则无法使用。
	if(!copyright_agree){
		System.out.println("\033[31;4m" + "Oh!你还没有同意版权条款：凌空工作室拥有追究权利，禁止倒卖。" + "\033[0m");
		System.exit(0);
	}
	Date date = new Date();
	Date now = new Date();
	SimpleDateFormat df=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
	SimpleDateFormat df2=new SimpleDateFormat("yy-MM-dd HH:mm:ss.S");
	Font normalbig = new Font("微软雅黑",Font.PLAIN,14);
	Font display = new Font("Book Antiqua",Font.BOLD,40);
    JFrame f = new JFrame("粉丝量监视");//创建窗口
    Image icon = (new ImageIcon("D:/java/GoldenEggsFans/objtitle.jpg")).getImage();
	f.setIconImage(icon);
    f.setSize(800, 800);
    f.setLocation(0, 0);
    f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setResizable(false);
	f.setFocusable(true);
	JLabel f1 = new JLabel("当前粉丝");//提示
    f1.setBounds(50, 50, 100, 250);
    f1.setFont(normalbig);
    f.add(f1);
    JLabel f2 = new JLabel("每几秒+1");//提示
    f2.setBounds(50, 150, 100, 250);
    f2.setFont(normalbig);
    f.add(f2);
    JLabel f3 = new JLabel("预计到达");//提示
    f3.setBounds(50, 250, 100, 250);
    f3.setFont(normalbig);
    f.add(f3);
    JLabel f4 = new JLabel("达成时间");//提示
    f4.setBounds(50, 350, 100, 250);
    f4.setFont(normalbig);
    f.add(f4);
	JLabel output = new JLabel("plz wait");//提示
	Color fg = new Color(255,110,110);
	output.setBounds(120, 45, 500, 250);
	output.setFont(display);
	output.setForeground(fg);
    f.add(output);
    JLabel output2 = new JLabel("plz wait");//提示
    Color fg2 = new Color(110,255,110);
	output2.setBounds(120, 145, 500, 250);
	output2.setFont(display);
	output2.setForeground(fg2);
    f.add(output2);
    JLabel output3 = new JLabel("plz wait");//提示
    Color fg3 = new Color(110,110,255);
	output3.setBounds(120, 245, 500, 250);
	output3.setFont(display);
	output3.setForeground(fg3);
    f.add(output3);
    JLabel output4 = new JLabel("plz wait");//提示
    Color fg4 = new Color(255,0,0);
	output4.setBounds(120, 345, 500, 250);
	output4.setFont(display);
	output4.setForeground(fg4);
    f.add(output4);
    Color end = new Color(0,0,0);
	int uuid = 546195;
	Fans fans = new Fans(uuid);
	int fan = 0;
	final int fanstart = fans.getFans();
	final long start = System.currentTimeMillis();
	f.setVisible(true);
	int fanaverage = 2147483647;
	long time;
	while(true) {
		Thread.sleep(100);
		fan=fans.getFans();
		int fanabs = fan-fanstart;
		if(fanabs!=0) {
		fanaverage = (int)Math.round((float)(System.currentTimeMillis() - start) / (float)fanabs);
		}
		time = fanaverage*(10000000-fan)+System.currentTimeMillis();
		date.setTime(time);
		now.setTime(System.currentTimeMillis());
		String tmof = df.format(date);
		String thetime = df2.format(now);
		output.setText(fan+"");
		output2.setText(fanaverage/1000f+"");
		output3.setText(tmof);
		output4.setText(thetime.substring(0, 19));
		if(fan>=10000000) {
			output4.setForeground(end);
			while(true) {
				Thread.sleep(1000);
			}
		}
	}
}
}
