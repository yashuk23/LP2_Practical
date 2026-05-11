import java.util.*;
class Chatbot
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Welcome to Shopping ChatBot ");
        System.out.println(" Type 'exit' to end chat ");
        System.out.println("=================================");

        while(true)
        {
            System.out.print("\nYou: ");
            String msg = sc.nextLine().toLowerCase();

            if(msg.equals("exit"))
            {
                System.out.println("Bot: Thank you for visiting!");
                break;
            }
            else if(msg.contains("hello") || msg.contains("hi"))
            {
                System.out.println("Bot: Hello! How can I help you?");
            }
            else if(msg.contains("product"))
            {
                System.out.println("Bot: We have mobiles, laptops and headphones available.");
            }
            else if(msg.contains("price"))
            {
                System.out.println("Bot: Prices start from Rs.999.");
            }
            else if(msg.contains("delivery"))
            {
                System.out.println("Bot: Delivery takes 3-5 working days.");
            }
            else if(msg.contains("payment"))
            {
                System.out.println("Bot: We accept UPI, Debit Card and Credit Card.");
            }
            else if(msg.contains("return"))
            {
                System.out.println("Bot: Products can be returned within 7 days.");
            }
            else if(msg.contains("contact"))
            {
                System.out.println("Bot: Contact us at support@gmail.com");
            }
            else
            {
                System.out.println("Bot: Sorry, I didn't understand your query.");
            }
        }
        sc.close();
    }
}