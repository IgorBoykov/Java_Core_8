package Task;

import java.util.Scanner;

public class app {

	  static void menu(){
	        System.out.println("Ќатисн≥ть 1, щоб перев≥рити чи Ї такий м≥с€ць");
	        System.out.println("Ќатисн≥ть 2, щоб вивести вс≥ м≥с€ц≥ з такою ж порою року");
	        System.out.println("Ќатисн≥ть 3, щоб вивести вс≥ м≥с€ц≥ €к≥ мають таку саму к≥льк≥сть дн≥в");
	        System.out.println("Ќатисн≥ть 4, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають меншу к≥льк≥сть дн≥в");
	        System.out.println("Ќатисн≥ть 5, щлб вивести на екран вс≥ м≥с€ц≥ €к≥ мають б≥льшу к≥льк≥сть дн≥в");
	        System.out.println("Ќатисн≥ть 6, щоб вивести на екран наступну пору року");
	        System.out.println("Ќатисн≥ть 7, щоб вивести на екран попередню пору року");
	        System.out.println("Ќатисн≥ть 8, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають парну к≥льк≥сть дн≥в");
	        System.out.println("Ќатисн≥ть 9, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають непарну к≥льк≥сть дн≥в");
	        System.out.println("Ќатисн≥ть 10, щоб вивести на екран чи введений з консол≥ м≥с€ць маЇ парну к≥льк≥сть дн≥в");
	    } 
	  
	  
	  static boolean isMonth(String str) {
			boolean isMonth = false;
			for (Month month : Month.values()) {
				if (str.equalsIgnoreCase(month.name())) {
					isMonth = true;
					break;
				}
			}
			return isMonth;

		}

		static boolean isSeason(String str) {
			boolean isSeason = false;
			for (Seasons seasons : Seasons.values()) {
				if (str.equalsIgnoreCase(seasons.name())) {
					isSeason = true;
					break;
				}
			}
			return isSeason;

		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			String str;

			Month[] months = Month.values();

			while (true) {
				menu();
				str = scanner.nextLine();
				switch (str) {
				case "1": {
					System.out.println("¬вед≥ть м≥с€ць");
					str = scanner.nextLine();

					if (isMonth(str))
						System.out.println("“акий м≥с€ць ≥снуЇ");
					else
						System.out.println("“акого м≥с€ц€ не ≥снуЇ");

					System.out.println(" ");
					break;
				}
				case "2": {
					System.out.println("¬вед≥ть пору року");
					str = scanner.nextLine();

					if (isSeason(str)) {
						for (Month month : Month.values()) {
							if (month.getSeason().name().equalsIgnoreCase(str))
								System.out.println(month);
						}
					} else
						System.out.println("“акоњ пори не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				case "3": {
					System.out.println("¬вед≥ть м≥с€ць");
					str = scanner.nextLine();

					if (isMonth(str)) {
						System.out.println("ћ≥с€ц≥ з такою ж самою к≥льк≥стю дн≥в: ");
						Month month = Month.valueOf(str.toUpperCase());
						for (Month m : Month.values()) {
							if (m.getDays() == month.getDays())
								System.out.println(m);
						}
					} else
						System.out.println("“акого м≥с€ц€ не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				case "4": {
					System.out.println("¬вед≥ть м≥с€ць");
					str = scanner.nextLine();

					if (isMonth(str)) {
						System.out.println("ћ≥с€ц≥ з меншою к≥льк≥стю дн≥в: ");
						Month month = Month.valueOf(str.toUpperCase());
						for (Month m : Month.values()) {
							if (m.getDays() < month.getDays())
								System.out.println(m);
						}
					} else
						System.out.println("“акого м≥с€ц€ не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				case "5": {
					System.out.println("¬вед≥ть м≥с€ць");
					str = scanner.nextLine();

					if (isMonth(str)) {
						System.out.println("ћ≥с€ц≥ з б≥льшою к≥льк≥стю дн≥в: ");
						Month month = Month.valueOf(str.toUpperCase());
						for (Month m : Month.values()) {
							if (m.getDays() > month.getDays())
								System.out.println(m);
						}
					} else
						System.out.println("“акого м≥с€ц€ не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				case "6": {
					System.out.println("¬вед≥ть пору року");
					str = scanner.nextLine();

					if (isSeason(str)) {
						System.out.println(Seasons.values()[(Seasons.valueOf(str.toUpperCase()).ordinal() + 1) % 4]);
					} else
						System.out.println("“акоњ пори не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				case "7": {
					System.out.println("¬вед≥ть пору року");
					str = scanner.nextLine();

					if (isSeason(str)) {
						int ord = Seasons.valueOf(str.toUpperCase()).ordinal() - 1;
						System.out.println(Seasons.values()[ord < 0 ? 3 : ord]);
					} else
						System.out.println("“акоњ пори не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				case "8": {
					System.out.println("ћ≥с€ц≥ з парною к≥льк≥стю дн≥в:");
					for (Month month : months) {
						if (month.getDays() % 2 == 0)
							System.out.println(month);

					}
					System.out.println(" ");
					break;
				}
				case "9": {
					System.out.println("ћ≥с€ц≥ з непарною к≥льк≥стю дн≥в:");
					for (Month month : months) {
						if (month.getDays() % 2 != 0)
							System.out.println(month);

					}
					System.out.println(" ");
					break;
				}
				case "10": {
					System.out.println("¬вед≥ть м≥с€ць");
					str = scanner.nextLine();

					if (isMonth(str)) {
						Month month = Month.valueOf(str.toUpperCase());
						if (month.getDays() % 2 == 0)
							System.out.println("ƒаний м≥с€ць маЇ парну к≥льк≥сть дн≥в");
						else
							System.out.println("ƒаний м≥с€ць маЇ парну к≥льк≥сть дн≥в");

					} else
						System.out.println("“акого м≥с€ц€ не ≥снуЇ");
					System.out.println(" ");
					break;
				}
				}

			}

		}
	}