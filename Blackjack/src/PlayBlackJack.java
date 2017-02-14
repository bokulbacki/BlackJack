import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Collections;

public class PlayBlackJack
	{
		static boolean playing= true;
		static int hitStay;
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
				Aces();
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
			
		public static void playGame()
			{
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
						
						
					System.out.println("Your cards are a " + userHand.get(0).getName() +" and a "+ userHand.get(1).getName());
					System.out.println("Your total is " + (userHand.get(0).getValue() + userHand.get(1).getValue()));
					if ( userHand.get(0).getValue() + userHand.get(1).getValue() == 21)
						{
							JOptionPane.showMessageDialog(frame, "You Win");
							playAgain();
						}
					
					System.out.println("The computer's first card is a " + coHand.get(0).getName());
					
					Object[] options = {"Hit", "Stay"};
					hitStay = JOptionPane.showOptionDialog(frame, "Would you like to hit or stay?",
							"Your Choice",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, options, options[0]);
					 
					
					switch(hitStay)
					{
						case 0:
						{
							userHand.add( deck.get(0));
							deck.remove(0);
							JOptionPane.showMessageDialog(frame, "Risky Move. The card is a " + userHand.get(2).getName());
							JOptionPane.showMessageDialog(frame, "Your new total is " + (userHand.get(0).getValue() + 
									userHand.get(1).getValue() + userHand.get(2).getValue() ) );
							if (userHand.get(0).getValue() + userHand.get(1).getValue() + userHand.get(2).getValue() > 21)
								{
									JOptionPane.showMessageDialog(frame, "You Lose");
									playing=false;
									playAgain();
								}
							if (userHand.get(0).getValue() + userHand.get(1).getValue() + userHand.get(2).getValue() == 21 &&
									coHand.get(0).getValue() + coHand.get(1).getValue() !=21 )
								{
									JOptionPane.showMessageDialog(frame, "You Win");
									playAgain();	
								}
							
							Object[] options1 = {"Hit", "Stay"};
							hitStay = JOptionPane.showOptionDialog(frame, "Would you like to hit or stay?",
									"Your Choice",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null, options1, options1[0]);
							
							switch(hitStay)
							{
							case 0:
								{
									userHand.add( deck.get(0));
									deck.remove(0);
									JOptionPane.showMessageDialog(frame, "Risky Move. The card is a " + userHand.get(3).getName());
									JOptionPane.showMessageDialog(frame, "Your new total is " + (userHand.get(0).getValue() + 
											userHand.get(1).getValue() + userHand.get(2).getValue() + userHand.get(3).getValue() ) );
									if (userHand.get(0).getValue() + userHand.get(1).getValue() + userHand.get(2).getValue() +  
											userHand.get(3).getValue() > 21)
										{
											JOptionPane.showMessageDialog(frame, "You Lose");
											playing=false;
											playAgain();
										}
									if (userHand.get(0).getValue() + userHand.get(1).getValue() + userHand.get(2).getValue() + 
											userHand.get(3).getValue() == 21 &&
											coHand.get(0).getValue() + coHand.get(1).getValue() !=21 )
										{
											JOptionPane.showMessageDialog(frame, "You Win");
											playAgain();	
										}
									break;
								}
							case 1:
									{
										JOptionPane.showMessageDialog(frame, "Wimpy Move.");
										JOptionPane.showMessageDialog(frame, "The computers cards were a " + coHand.get(0).getName() +
												" and a " + coHand.get(1).getName() );
										playing=false;
										break;
									}
												
							}
						}
							
						case 1:
							{
							
							JOptionPane.showMessageDialog(frame, "Wimpy Move.");
							JOptionPane.showMessageDialog(frame, "The computers cards were a " + coHand.get(0).getName() +
									" and a " + coHand.get(1).getName() );
							playing=false;
							break;
							}
						}
					
					}
			}
		
		public static void Aces()
			{
				if (userHand.get(0).getValue() + userHand.get(1).getValue() + userHand.get(2).getValue() +  
						userHand.get(3).getValue() > 21) // and there is an ace 
					{
						
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
				}
			else
				{
					playing=true;
					playGame();
				}
			}
	}
