import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PhoneBook_Exceptions extends Exception{
    @Override
    public String getMessage(){
          JFrame message=new JFrame("Notice");
          JOptionPane.showMessageDialog(message,"Please Input Valid Inputs for First Name, Last Name and Number");
          return "";
    }
    
    public String toString(){
        return"" +getMessage();
    }
}

