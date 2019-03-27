package CodeDungeon;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class codeDungeon {
	static Random generator = new Random();
	static int purchase;
	static int playerClass;
	static String classString;
	static int firewall;
	static int viruses;
	static int code;
	static int system;
	static int intelligence;
	static int cash=0;
	static int buy;
	static int mainOption;
	static int XP=0;
	static int level=0;
	static int room;
	
	static boolean alive = true;
	public static ArrayList<String> inventory = new ArrayList<>();
	
	public static void say(String temp){
		JOptionPane.showMessageDialog(null, temp, "Code Dungeon",  JOptionPane.DEFAULT_OPTION);
	}
	
	public static void purchase (){
		try{
			purchase = Integer.parseInt(JOptionPane.showInputDialog("BestBuy Merchant: I see you are not properly equipped with a peoper laptop"
					+ "and equipment..."
					+ "\n<1>Alienware Laptop, (2) Tech Support, (1) USD"
					+ ""
					+ ""
					+ ""
					+ ""));
		}catch (Exception e){
			
		}
	}
	
	public static void classChoose(){
		try{
			playerClass = Integer.parseInt(JOptionPane.showInputDialog("Pick a class:"
					+ "\n<1> HACKER: Good with virues and code but weak to firewalls"
					+ "\n<2>CEO: Intelligent and lots of system space, bad with code"
					+ "\n<3>Coder: Good with code, bad system space, OK with virus and firewall"));
		}catch (Exception e){
			say("invalid Option");
			classChoose();
		}
		
		switch(playerClass){
		case 1:{
			classString = "hacker";
			firewall = 1;
			viruses = generator.nextInt(1) +4;
			code = generator.nextInt(1) +3;
			system = generator.nextInt(20) +4;
			intelligence = generator.nextInt(2) +1;
		}break;
		case 2:{
			classString = "CEO";
			firewall = 1;
			viruses = generator.nextInt(1) +4;
			code = generator.nextInt(1) +3;
			system = generator.nextInt(20) +4;
			intelligence = generator.nextInt(2) +1;
		}break;
		case 3:{
			classString = "coder";
			firewall = 1;
			viruses = generator.nextInt(1) +4;
			code = generator.nextInt(1) +3;
			system = generator.nextInt(20) +4;
			intelligence = generator.nextInt(2) +1;
		}break;
		default:
			classChoose();
		}
	}
	
	public static void merchant(){
		try{
			buy = Integer.parseInt(JOptionPane.showInputDialog("Shady Merchant: Buy Something?!??!?!?!?!"
					+ "\n<1>USB - 10 Coins"
					+ "\n<2>Tech Support - 20 Coins"
					+ "\n<3>Trojan Virus - 30 Coins"
					+ "\n<4>Anti-Virus - 15 Coins"
					+ "\n\n Coins: "+ cash
					+ "\n<5>Nothing Thanks"));
		}catch(Exception e){
			say("Invalid Option");
			merchant();
		}
		
		switch(buy){
		case 1:{
			if(cash >= 10){
				inventory.add("USB");
				cash = cash-10;
			}else {
				say("NOT ENOUGH COIN");
			}
		}break;
		case 2:{
			if(cash >= 20){
				inventory.add("Tech Support");
				cash = cash-20;
			}else {
				say("NOT ENOUGH COIN");
			}
		}break;
		case 3:{
			if(cash >= 30){
				inventory.add("Trojan Virus");
				cash = cash-30;
			}else {
				say("NOT ENOUGH COIN");
			}
		}break;
		case 4:{
			if(cash >= 15){
				inventory.add("Anti-Virus");
				cash = cash-15;
			}else {
				say("NOT ENOUGH COIN");
			}
		}break;
		default: 
			say("NO MERCHANT");
		}
	}
	
	public static void statRead(){
		say("**Stat** \n Firewall: "+ firewall
				+ "\n Viruses: "+ viruses
				+ "\n Code: "+ code
				+ "\n Intelligence: "+ intelligence
				+ "\n System: " + system
				+ "\n Level: "+ level
				+ "\n XP: "+ XP);
	}
	
	public static int InvenAsk(){
		String list;
		list = inventory.get(0);
		for(int i=1;i<inventory.size();i++){
			list = list + "\n<"+i+">"+inventory.get(i);
		}
		int invenOption;
		try{
			invenOption = Integer.parseInt(JOptionPane.showInputDialog(
					"Select an Item: \n"+list));
		}catch (Exception e){
			invenOption = 1;
			say("That's not a valid Item.Using Item 1");
		}
		return invenOption;
	}
	
	public static boolean doBattle(String name, int sentHP, int sentAttack, int sentDefense){
		int enemyHP = sentHP + generator.nextInt(1)+level;
		int enemyAttack  = sentAttack + generator.nextInt(1) +level;
		int enemyDefense = sentDefense + generator.nextInt(1) +level;
		
		int myDefense = firewall;
		
		int virusesMade=0;
		int virusesAttack=0;
		
		while(system >0 && enemyHP >0){
			int action;
			try{
				action = Integer.parseInt(JOptionPane.showInputDialog("Action:"
						+ "\n<1>Send out Virus"
						+ "\n<2> Build Virus"
						+ "\n<3>Work on system Defense"
						+ "\n<4>Repair System"
						+ "\n<5>Use Item"
						+ "\nSystem Status: "+ system
						+ "\nDefense: " + myDefense
						+ "\nEnemy HP: "+ enemyHP
						+ "\nEnemy Attack: "+ enemyAttack
						+ "\nEnemy Defense: "+ enemyDefense
						+ "\nVirus Make: "+ virusesMade
						+ "\nVirus Power: "+ virusesAttack
						+"\n<6> See Full Stats"));
			}catch (Exception e){
				action = 7;
				say("Wrong Input");
			}
			
			switch(action){
			case 1:{
				if(virusesMade >0){
					if(virusesAttack - enemyDefense> 0){
						enemyHP = enemyHP - virusesAttack;
						virusesMade--;
					}else {
						say("Make Virus!");
						action = 7;
					}
				}
			}break;
			case 2:{
				virusesMade++;
				if(virusesAttack > 0){
					virusesAttack = viruses + code/2;
					virusesAttack++;
				}
				else {
					virusesAttack = viruses + code /2;
				}
				say("Build a virus");
			}break;
			case 3:{
				myDefense = myDefense + (code+firewall)/2;
				say("Defense Improved");
			}break;
			case 4:{
				system = intelligence/2 + code/2;
				say("System Up!");
			}break;
			case 5:{
				int selectItem = InvenAsk();
				if(inventory.get(selectItem).equals("USB")){
					system = system+15;
					inventory.remove(selectItem);
					say("Used USB");
				}else if(inventory.get(selectItem).equals("Tech Support")){
					say("Leave Battle ");
					inventory.remove(selectItem);
					return true;
				}else if(inventory.get(selectItem).equals("Anti-Virus")){
					myDefense = myDefense+5;
					inventory.remove(selectItem);
					say("Defence Up by 5");
				}else if(inventory.get(selectItem).equals("Trojan Virus")){
					virusesAttack = virusesAttack +3;
					virusesMade = virusesMade +2;
					inventory.remove(selectItem);
					say("Increase Virus Strength / Virus Amount increase by 2");
				}else {
					action = 7;
					say("Not valid Item");
				}
			}break;
			case 6:{
				statRead();
			}break;
			default:
				
			}
			
			if(action !=6 || action !=7){
				if(enemyAttack > myDefense){
					system = system - (enemyAttack = myDefense);
					say("Enemy Attack for" + (enemyAttack - myDefense));
				}else {
					system = system-enemyAttack;
					say("Enemy attacks for "+enemyAttack);
				}
			}
		}
		
		if(system<=0){
			return false;
		}else {
			say("You got "+ sentHP/2 + "cash. "+ "\n "+ sentHP + "XP,");
			cash = cash+sentHP/2;
			XP =XP +sentHP;
			return true;
		}
	}
	
	public static void invenRead(){
		String list;
		list = inventory.get(0);
		for(int i=1;i<inventory.size();i++){
			list = list +"\n"+ inventory.get(i);
		}
		
		say("--Inventory--\n"+list+"\nCoins: "+cash);
	}
	
	public static void mainOpt(){
		try{
			mainOption = Integer.parseInt(JOptionPane.showInputDialog("You arrive in a room"
					+ room +":"
					+ "\n<1>Look Around"
					+ "\n<2>Talk to the Shady Dealer in the corner"
					+ "\n<3>Inventory"
					+ "\n<4>View Stats"
					+ "\n<5>Next Room"
					+ "\n<6>Use Item"));
		}catch(Exception e){
			say("Invalid Option");
			mainOpt();
		}
	}
	
	public static void main (String [] args){
		
	}
}
