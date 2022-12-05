import java.util.*;

public class ConsoleView implements OOP_View
{
    @Override
    public void Print(String message)
    {
        System.out.print(message);
    }

    @Override
    public void Format(String format, Object... args)
    {
        System.out.format(format, args);
    }

    @Override
    public void Println(String message)
    {
        System.out.println(message);
    }

    @Override
    public int AskForInt()
    {
        return ReadInt();
    }

    @Override
    public String AskForString() {
        return ReadString();
    }

    public String AskForLine()
    {
        return ReadLine();
    }

    @Override
    public float AskForFloat() {
        return ReadFloat();
    }

    protected int ReadInt()
    {
        Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			return -1;
		}
    }

    protected float ReadFloat()
    {
        Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextFloat();
		} catch (Exception e) {
			return -1;
		}
    }

    protected String ReadString()
    {
        Scanner scanner = new Scanner(System.in);
		try {
			return scanner.next();
		} catch (Exception e) {
			return "";
		}
    }

    protected String ReadLine()
    {
        Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextLine();
		} catch (Exception e) {
			return "";
		}
    }

}
