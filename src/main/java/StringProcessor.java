
public class StringProcessor {
	public static void main(String[] args) {
		String s= "https\\://url.com/";
		String str = s.split("\\://")[1].split("/")[0];
		System.out.println(str);
	}
}
