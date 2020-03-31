import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

class Fans {
	private int uuid;
	Fans(int uuid) {
		// TODO Auto-generated constructor stub
		this.uuid = uuid;
	}
	int getFans() throws Exception {
		int p=512;
		File file=new File("D:/fandata.txt");
		file.createNewFile();
		URL url=new URL("https://api.bilibili.com/x/relation/stat?vmid="+this.uuid+"&jsonp=jsonp");
		URLConnection connecation=url.openConnection();
		InputStream is= connecation.getInputStream();
		BufferedInputStream bis=new BufferedInputStream(is);//ª∫≥Â ‰»Î¡˜
		OutputStream os=new FileOutputStream("D:/fandata.txt");
		BufferedOutputStream bos=new BufferedOutputStream(os);
		byte[] b=new byte[p];
		int len=0;
		while((len=bis.read(b, 0, b.length))!=-1){
			os.write(b);
		}
		bis.close();
		bos.close();
		BufferedReader br=new BufferedReader(new FileReader("D:/fandata.txt"));
		String in = br.readLine();
		int pos=in.indexOf(",\"follower\":");
		int pos2=in.indexOf("}}");
		String text = in.substring(pos+12, pos2);
		int fans = Integer.parseInt(text);
		return fans;
	}
	int getFollowing() {
		return 0;
	}
	void setUUID(int uuid) {
		this.uuid = uuid;
	}

}
