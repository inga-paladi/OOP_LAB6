public interface OOP_View
{
    public void Print(String message);
    public void Format(String format, Object... args);
    public void Println(String message);
    public int AskForInt();
    public String AskForString();
    public float AskForFloat();
    public String AskForLine();
}