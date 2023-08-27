import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int number = rand.nextInt(100);
		Scanner inp = new Scanner(System.in);
		int right = 0;
		int selected;
		int[] wrong = new int [5];
		boolean isWin = false;
		boolean isWrong = false;
		System.out.println(number);
		while (right<5) {
			System.out.print("Lutfen Tahmininizi Giriniz: ");
			selected = inp.nextInt();
			if (selected < 0 || selected > 100) {
				System.out.println("Tahmin Ettiginiz Sayi 0-100 Arasinda Olmali.");
				if (isWrong) {
					right++;
					System.out.println("Cok Fazla Hatali Giris Yaptiniz.Kalan Hakkiniz: "+(5-right));
				}
				else {
					isWrong = true;
					System.out.println("Bir Daha Hatali Giris Yaparsaniz Kalan Hakkiniz Azalacaktir.");
				}
				continue;
			}
			if (number == selected) {
				System.out.println("Tebrikler Dogru Tahmin Ettiniz. Tahmin Ettiginiz Sayi: "+number);
				isWin = true;
				break;
			}
			else {
				System.out.println("Yanlis Tahmin Ettiniz");
				if (number < selected) {
					System.out.println(selected+" Sayisi Gizli Sayidan Buyuktur.");
				}
				else {
					System.out.println(selected+" Sayisi Gizli Sayidan Kucuktur.");
				}
				wrong[right++] = selected;
				System.out.println("Kalan Hakkiniz: "+(5-right));
			}
		}
		if (!isWin) {
			System.out.println("Kaybettiniz!");
			if (isWrong) {
				System.out.println("Tahmin Ettiginiz Sayilar: "+Arrays.toString(wrong));
			}
		}
	}
}
