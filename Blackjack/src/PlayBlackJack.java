import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Collections;

public class PlayBlackJack
	{
		static boolean playing= true;
		static boolean playHitStay= true;
		static int hitStay;
		static int money = 100;  // User starts with $100.
		static int bet; 
		static boolean userWins;
		static int coTotal;
		static int userTotal;
		static JFrame frame = new JFrame();
		static boolean wantsToPlay= true;
		static Scanner userInput = new Scanner(System.in);
		static ArrayList <Cards> userHand =  new ArrayList<Cards>();
		static ArrayList <Cards> coHand =  new ArrayList<Cards>();
		static ArrayList <Cards> deck = new ArrayList<Cards>();
		public static void main(String[] args)
			{
				while (wantsToPlay)
					{
				makeCards();
				printCards();
				playGame();
				coHitStay();
				Aces();
				bet();
				playAgain();
					}
			}

		public static void makeCards()
			{
				deck.clear();
				deck.add (new Cards ("Ace", 11 , "Diamonds", "Red "));
				deck.add (new Cards ("Ace", 11 , "Hearts", "Red "));
				deck.add (new Cards ("Ace", 11 , "Spades", "Black "));
				deck.add (new Cards ("Ace", 11 , "Clubs", "Black "));
				deck.add (new Cards ("Two", 2 , "Diamonds", "Red "));
				deck.add (new Cards ("Two", 2 , "Hearts", "Red "));
				deck.add (new Cards ("Two", 2 , "Spades", "Black "));
				deck.add (new Cards ("Two", 2 , "Clubs", "Black "));
				deck.add (new Cards ("Three", 3 , "Diamonds", "Red "));
				deck.add (new Cards ("Three", 3 , "Hearts", "Red "));
				deck.add (new Cards ("Three", 3 , "Spades", "Black "));
				deck.add (new Cards ("Three", 3, "Clubs", "Black "));
				deck.add (new Cards ("Four", 4 , "Diamonds", "Red "));
				deck.add (new Cards ("Four", 4 , "Hearts", "Red "));
				deck.add (new Cards ("Four", 4 , "Spades", "Black "));
				deck.add (new Cards ("Four", 4, "Clubs", "Black "));
				deck.add (new Cards ("Five", 5 , "Diamonds", "Red "));
				deck.add (new Cards ("Five", 5 , "Hearts", "Red "));
				deck.add (new Cards ("Five", 5 , "Spades", "Black "));
				deck.add (new Cards ("Five", 5, "Clubs", "Black "));
				deck.add (new Cards ("Six", 6 , "Diamonds", "Red "));
				deck.add (new Cards ("Six", 6 , "Hearts", "Red "));
				deck.add (new Cards ("Six", 6 , "Spades", "Black "));
				deck.add (new Cards ("Six", 6, "Clubs", "Black "));
				deck.add (new Cards ("Seven", 7 , "Diamonds", "Red "));
				deck.add (new Cards ("Seven", 7 , "Hearts", "Red "));
				deck.add (new Cards ("Seven", 7 , "Spades", "Black "));
				deck.add (new Cards ("Seven", 7, "Clubs", "Black "));
				deck.add (new Cards ("Eight", 8 , "Diamonds", "Red "));
				deck.add (new Cards ("Eight", 8 , "Hearts", "Red "));
				deck.add (new Cards ("Eight", 8 , "Spades", "Black "));
				deck.add (new Cards ("Eight", 8, "Clubs", "Black "));
				deck.add (new Cards ("Nine", 9 , "Diamonds", "Red "));
				deck.add (new Cards ("Nine", 9 , "Hearts", "Red "));
				deck.add (new Cards ("Nine", 9 , "Spades", "Black "));
				deck.add (new Cards ("Nine", 9, "Clubs", "Black "));
				deck.add (new Cards ("Ten", 10 , "Diamonds", "Red "));
				deck.add (new Cards ("Ten", 10 , "Hearts", "Red "));
				deck.add (new Cards ("Ten", 10 , "Spades", "Black "));
				deck.add (new Cards ("Ten", 10 , "Clubs", "Black "));
				deck.add (new Cards ("Jack", 10 , "Diamonds", "Red "));
				deck.add (new Cards ("Jack", 10 , "Hearts", "Red "));
				deck.add (new Cards ("Jack", 10 , "Spades", "Black "));
				deck.add (new Cards ("Jack", 10 , "Clubs", "Black "));
				deck.add (new Cards ("Queen", 10 , "Diamonds", "Red "));
				deck.add (new Cards ("Queen", 10 , "Hearts", "Red "));
				deck.add (new Cards ("Queen", 10 , "Spades", "Black "));
				deck.add (new Cards ("Queen", 10 , "Clubs", "Black "));
				deck.add (new Cards ("King", 10 , "Diamonds", "Red "));
				deck.add (new Cards ("King", 10 , "Hearts", "Red "));
				deck.add (new Cards ("King", 10 , "Spades", "Black "));
				deck.add (new Cards ("King", 10 , "Clubs", "Black "));
			}
		
		public static void printCards()
			{
				Scanner userInput7 = new Scanner(System.in);
				System.out.println("Would you like to see the cards? Please type yes or no.");
				String showcards = userInput7.nextLine().toLowerCase();
					if(showcards.equals("yes"))
					{
					System.out.println("Name:       " + "Shooting Percentage:  " + " Player's Number:      "
							+"Jersey Color:");
					System.out.println();
					for (int i = 0; i < deck.size(); i++)
						{
							System.out.printf("%-20s%-20s%-20s%-20s" , i+1+ " " + deck.get(i).getName() ,
									deck.get(i).getValue() , deck.get(i).getSuit() ,
									deck.get(i).getColor());
							System.out.println();
						}
					}
			}
			
		public static void playGame()
			{
				
				Scanner userInput0 = new Scanner(System.in);
		            System.out.println("You have " + money + " dollars.");
		            
		                System.out.println("How many dollars do you want to bet?  (Enter 0 to end game.)");
		                System.out.print("? ");
		                bet = userInput0.nextInt();
		                if (bet < 0 || bet > money)
		                {
		                    System.out.println("Your answer must be between 0 and " + money + '.');
		                }     
		        
				Collections.shuffle(deck);
				
				while(playing)
					{
						userHand.clear();
						coHand.clear();
						
						userHand.add( deck.get(0));
						deck.remove(0);
						coHand.add(deck.get(0));
						deck.remove(0);
						userHand.add( deck.get(0));
						deck.remove(0);
						coHand.add(deck.get(0));
						deck.remove(0);
						
					coTotal=coHand.get(0).getValue() + + coHand.get(1).getValue();
					userTotal=userHand.get(0).getValue() + + userHand.get(1).getValue();
					
					System.out.println("Your cards are a " + userHand.get(0).getName() +" and a "+ userHand.get(1).getName());
					System.out.println("Your total is " + (userHand.get(0).getValue() + userHand.get(1).getValue()));
					if ( userHand.get(0).getValue() + userHand.get(1).getValue() == 21 && coTotal != 21)
						{
							JOptionPane.showMessageDialog(frame, "You Win");
							System.out.println("You Win!");
							userWins=true;
							bet();
							System.out.println("The computers total was " + coTotal);
							playAgain();
						}
					
					System.out.println("The computer's first card is a " + coHand.get(0).getName());
					
			while (playHitStay)
				{
							
					Scanner userInput2 = new Scanner(System.in);
					System.out.println("Would you like to hit or stay? h or s");
					String userChoice = userInput2.nextLine().toLowerCase();
					
					if (userChoice.equals("h"))
						{
							userHand.add( deck.get(0));
							userTotal= userTotal + deck.get(0).getValue();
							Aces();
							
							JOptionPane.showMessageDialog(frame, "Risky Move. The card is a " + deck.get(0).getValue());
							JOptionPane.showMessageDialog(frame, "Your new total is " + (userTotal ) );
							deck.remove(0);
							
							
							coHitStay();
							
							System.out.println("Your new total is " + userTotal);
							
							if (userTotal > 21)
								{
									JOptionPane.showMessageDialog(frame, "You Lose");
									System.out.println("You Lose.");
									bet();
									playing=false;
									playHitStay=false;
									playAgain();
								}
							if (userTotal == 21 &&
									coTotal !=21 )
								{
									JOptionPane.showMessageDialog(frame, "You Win");
									System.out.println("You Win.");
									userWins=true;
									bet();
									playing=false;
									playHitStay=false;
									playAgain();	
								}
						}
					
					else if (userChoice.equals("s"))
						{
							coHitStay();
							
							JOptionPane.showMessageDialog(frame, "We will see if that was a good move.");
							JOptionPane.showMessageDialog(frame, "The computers total was " + coTotal );
							System.out.println("The computers total was " + coTotal);
							
							Aces();
							if (userTotal > 21)
								{
									JOptionPane.showMessageDialog(frame, "You Lose");
									System.out.println("You Lose.");
									playing=false;
									bet();
									playHitStay=false;
									playAgain();
								}
							
							if (coTotal > 21)
								{
									JOptionPane.showMessageDialog(frame, "You Win!");
									System.out.println("You Win!");
									userWins=true;
									bet();
									playing=false;
									playHitStay=false;
									playAgain();
								}
							
							if (userTotal == 21 &&
									coTotal !=21 )
								{
									JOptionPane.showMessageDialog(frame, "You Win");
									System.out.println("You Win.");
									userWins=true;
									bet();
									playing=false;
									playHitStay=false;
									playAgain();	
								}
							
							if (userTotal > coTotal)
								{
									JOptionPane.showMessageDialog(frame, "You Win");
									System.out.println("You Win.");
									userWins=true;
									bet();
									playing=false;
									playHitStay=false;
									playAgain();
								}
							
							if (userTotal < coTotal)
								{
									JOptionPane.showMessageDialog(frame, "You Lose");
									System.out.println("You Lose.");
									bet();
									playing=false;
									playHitStay=false;
									playAgain();
								}
							if (userTotal == coTotal)
								{
									JOptionPane.showMessageDialog(frame, "Tie");
									System.out.println("Tie");
									bet();
									playing=false;
									playHitStay=false;
									playAgain();
								}
						}
					
//					int money = 100;  // User starts with $100.
//					int bet; 
//					Scanner userInput0 = new Scanner(System.in);
//					
//			        while (true)
//			        {
//			            System.out.println("You have " + money + " dollars.");
//			            do
//			            {
//			                System.out.println("How many dollars do you want to bet?  (Enter 0 to end game.)");
//			                System.out.print("? ");
//			                bet = userInput0.nextInt();
//			                if (bet < 0 || bet > money)
//			                {
//			                    System.out.println("Your answer must be between 0 and " + money + '.');
//			                }
//			                
//			            } 
//			            while (bet < 0 || bet > money);
//			            if (bet == 0)
//			            {
//			                break;
//			            }
//			            if (userWins)
//			            {
//			                money = money + bet;
//			            } 
//			            else
//			            {
//			                money = money - bet;
//			            }
//			            System.out.println();
//			            if (money == 0)
//			            {
//			                System.out.println("Looks like you've are out of money!");
//			                break;
//			            }
//			        }
//
//			        System.out.println();
//			        System.out.println("You leave with $" + money + '.');

					
					 
					
//					switch(hitStay)
//					{
//						case 0:
//						{
//							
//							userHand.add( deck.get(0));
//							deck.remove(0);
//							
//							
//							Aces();
//							
//							userTotal = userHand.get(0).getValue() + userHand.get(1).getValue() + 
//									userHand.get(2).getValue();
//							
//							coHitStay();
//							
//							JOptionPane.showMessageDialog(frame, "Risky Move. The card is a " + userHand.get(2).getName());
//							JOptionPane.showMessageDialog(frame, "Your new total is " + (userTotal ) );
//							System.out.println("Your new total is " + userTotal);
//							
//							if (userTotal > 21)
//								{
//									JOptionPane.showMessageDialog(frame, "You Lose");
//									playing=false;
//									playHitStay=false;
//									playAgain();
//								}
//							if (userTotal == 21 &&
//									coTotal !=21 )
//								{
//									JOptionPane.showMessageDialog(frame, "You Win");
//									playing=false;
//									playHitStay=false;
//									playAgain();	
//								}
//						}
//							
////							Object[] options1 = {"Hit", "Stay"};
////							hitStay = JOptionPane.showOptionDialog(frame, "Would you like to hit or stay?",
////									"Your Choice",
////									JOptionPane.YES_NO_CANCEL_OPTION,
////									JOptionPane.QUESTION_MESSAGE,
////									null, options1, options1[0]);
////							
////							switch(hitStay)
////							{
////							case 0:
////								{
////									userHand.add( deck.get(0));
////									deck.remove(0);
////									
////									userTotal = userHand.get(0).getValue() + userHand.get(1).getValue() + 
////									userHand.get(2).getValue() +  
////									userHand.get(3).getValue();
////									
////									JOptionPane.showMessageDialog(frame, "Risky Move. The card is a " + userHand.get(3).getName());
////									JOptionPane.showMessageDialog(frame, "Your new total is " + userTotal);
////									System.out.println("Your new total is " + userTotal );
////									
////									Aces();
////									if (userTotal > 21)
////										{
////											
////											JOptionPane.showMessageDialog(frame, "You Lose");
////											playing=false;
////											playAgain();
////										}
////									if (userTotal == 21 &&
////											coTotal !=21 )
////										{
////											
////											JOptionPane.showMessageDialog(frame, "You Win");
////											playAgain();	
////										}
////									break;
////								}
////							case 1:
////									{
////										JOptionPane.showMessageDialog(frame, "Wimpy Move.");
////										JOptionPane.showMessageDialog(frame, "The computers cards were a " + coHand.get(0).getName() +
////												" and a " + coHand.get(1).getName() );
////										
////										System.out.println("The computers cards were a " + coHand.get(0).getName() +
////												" and a " + coHand.get(1).getName());
////										
////										if (coTotal> userTotal)
////											{
////												System.out.println("You Lose.");
////											}
////										else if (coTotal> userTotal)
////											{
////												System.out.println("You Lose.");
////											}
////										
////									
////										
////										playing=false;
////										playAgain();
////										break;
////									}
////							}
//									
//						case 1:
//							{
//							coHitStay();
//							
//							JOptionPane.showMessageDialog(frame, "We will see if that was a good move.");
//							JOptionPane.showMessageDialog(frame, "The computers total was " + coTotal );
//							System.out.println("The computers total was " + coTotal);
//							
//							Aces();
//							if (userTotal > 21)
//								{
//									JOptionPane.showMessageDialog(frame, "You Lose");
//									System.out.println("You Lose.");
//									playing=false;
//									playHitStay=false;
//									playAgain();
//								}
//							
//							if (userTotal == 21 &&
//									coTotal !=21 )
//								{
//									JOptionPane.showMessageDialog(frame, "You Win");
//									System.out.println("You Win.");
//									playing=false;
//									playHitStay=false;
//									playAgain();	
//								}
//							
//							if (userTotal > coTotal)
//								{
//									JOptionPane.showMessageDialog(frame, "You Win");
//									System.out.println("You Win.");
//									playing=false;
//									playHitStay=false;
//									playAgain();
//								}
//							
//							if (userTotal < coTotal)
//								{
//									JOptionPane.showMessageDialog(frame, "You Lose");
//									System.out.println("You Lose.");
//									playing=false;
//									playHitStay=false;
//									playAgain();
//								}
//							
//							
//							break;
//							}
//					}
					
					}
			}
			
					
				}
		
		
		public static void coHitStay() 
		{
			if (coTotal<=16)
				{
					coHand.add(deck.get(0));
					System.out.println("The computer hit and got a " + deck.get(0).getName());
					coTotal= coTotal + deck.get(0).getValue();
					System.out.println("New Computer Total= " + coTotal);
					deck.remove(0);
					
				}
		}
		
		public static void Aces()
		{
				if (userTotal > 21 )	 
					{
						
					for (int i = 0; i<userHand.size(); i++)
						{
							if (userHand.get(i).getValue() == 11)  
								{
								userTotal = userTotal-10;
								System.out.println("The ace value was changed from 11 to 1 to prevent a loss.");
								}	
						}	
					}
		}
		
		 public static void bet()  
		 {
	         while (bet < 0 || bet > money);
	         if (bet == 0)
	         {
	             playAgain();
	         }
	         if (userWins)
	         {
	             money = money + bet;
	             System.out.println("Your amount of moeny is " + money);
	         } 
	         else
	         {
	             money = money - bet;
	             System.out.println("Your amount of moeny is " + money);
	         }
	         System.out.println();
	         if (money == 0)
	         {
	             System.out.println("Looks like you've are out of money!");
	             playAgain();
	         }
		 }
		
		public static void playAgain()
			{
			System.out.println("Would you like to play again? Please type yes or no.");
			Scanner userInput9 = new Scanner(System.in);
			String keepPlaying = userInput9.nextLine();
			if (!keepPlaying.toLowerCase().equals("yes"))
				{
					wantsToPlay = false;
					System.out.println("Thanks for playing!");
					System.out.println();
			        System.out.println("You leave with $" + money + '.');
				}
			else
				{
					playing=true;
					playHitStay=true;
					playGame();
				}
			}
	}
