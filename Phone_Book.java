import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Phone_Book implements ActionListener{
    JFrame frame;
    JTextField fName_tf,lName_tf,number_tf;
    JLabel fName,lName,number;
    JRadioButton rb_1,rb_2;
    JCheckBox cb1;
    int count=0;
    JPanel pnl1, pnl2, pnl3, pnl4, pnl5;
    JMenu file,edit,help;
    JMenuItem mi1,mi2, mi3,mi4,mi5,mi6;
    JMenuBar mbar;
    JButton add,remove,clear,search;
    ButtonGroup rButtonGroup;
    JTable table;
    DefaultTableModel model;
    JScrollPane sc_p;
    String[] colNames={"First Name","Last Name","Contact Number","Private"};
    String[] row=new String[4];
    String f_Name,l_Name,num, isPrivate;
    public Phone_Book(){
        frame=new JFrame("Phone Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mbar=new JMenuBar();

        file=new JMenu("File");
        edit=new JMenu("Edit");
        help=new JMenu("Help");
        mbar.add(file);
        mbar.add(edit);
        mbar.add(help);

        mi1=new JMenuItem("Exit");
        file.add(mi1);

        mi2=new JMenuItem("Add");
        edit.add(mi2);
        edit.addSeparator();
        mi3=new JMenuItem("Remove");
        edit.add(mi3);
        edit.addSeparator();
        mi4=new JMenuItem("Clear");
        edit.add(mi4);
        edit.addSeparator();
        mi5=new JMenuItem("Search");
        edit.add(mi5);

        mi6=new JMenuItem("Help");
        help.add(mi6);

        //Adding ActionListeners for menu items.
        mi1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                }
            });
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame messageDilog = new JFrame("Remove Error");
                    JOptionPane.showMessageDialog(messageDilog, "It is still in trial version!!");
                }
            });

        //Setting Mnemonics for menu and menu items
        file.setMnemonic(KeyEvent.VK_F);//VK stands for alt key
        edit.setMnemonic(KeyEvent.VK_E);
        help.setMnemonic(KeyEvent.VK_H);

        mi1.setMnemonic(KeyEvent.VK_X);
        mi2.setMnemonic(KeyEvent.VK_A);
        mi3.setMnemonic(KeyEvent.VK_R);
        mi4.setMnemonic(KeyEvent.VK_C);
        mi5.setMnemonic(KeyEvent.VK_S);
        mi6.setMnemonic(KeyEvent.VK_H);        
        
        //Text fields and their labels
        fName=new JLabel("First Name");
        fName_tf=new JTextField(15);

        lName=new JLabel("Last Name");
        lName_tf=new JTextField(15);

        number=new JLabel("Number");
        number_tf=new JTextField(10);

        cb1=new JCheckBox("Private");

        //Initaillizing table with the help of Default table model
        model=new DefaultTableModel(colNames,100);
        table=new JTable(model);
        table.setModel(model);

        rb_1=new JRadioButton("First Name, Last Name");
        rb_2=new JRadioButton("Last Name, First Name");
        rButtonGroup =new ButtonGroup();
        rButtonGroup.add(rb_1);
        rButtonGroup.add(rb_2);
        
        //for selecting and disabling the two radio buttons 
        rb_1.setSelected(true);
        rb_1.setEnabled(false);

        rb_2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    table.moveColumn(0,1);
                    rb_2.setEnabled(false);
                    rb_1.setEnabled(true);
                }
            });

        rb_1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    table.moveColumn(0,1);
                    rb_2.setEnabled(true);
                    rb_1.setEnabled(false);
                }
            });
            
        add= new JButton("Add");        
        remove= new JButton("Remove,");
        clear= new JButton("Clear");
        search= new JButton("Search");
        
        //actionListeners
        add.addActionListener(this);
        remove.addActionListener(this);
        clear.addActionListener(this);
        search.addActionListener(this);
        
        //Mnemonic keys for users
        add.setMnemonic(KeyEvent.VK_A);
        remove.setMnemonic(KeyEvent.VK_R);
        clear.setMnemonic(KeyEvent.VK_C);
        search.setMnemonic(KeyEvent.VK_S);

        pnl1=new JPanel();
        pnl2=new JPanel();
        pnl3=new JPanel();
        pnl4=new JPanel();
        pnl5=new JPanel();

        pnl1.add(table);
        pnl1.add(new JScrollPane(table));

        pnl4.add(add);
        pnl4.add(remove);
        pnl4.add(clear);
        pnl4.add(search);
        pnl4.setLayout(new GridLayout(2,2));

        pnl3.add(rb_1);
        pnl3.add(rb_2);
        pnl3.setLayout(new GridLayout(2,1));

        pnl2.add(fName);
        pnl2.add(fName_tf);

        pnl2.add(lName);
        pnl2.add(lName_tf);

        pnl2.add(number);
        pnl2.add(number_tf);

        pnl2.add(cb1);
        pnl2.setLayout(new GridLayout(4,2));

        pnl5.add(pnl2);
        pnl5.add(pnl3);
        pnl5.add(pnl4);
        pnl5.setLayout(new GridLayout(3,1));
        
        //Naming Borders for each Panel
        TitledBorder pnl1_border=new TitledBorder("Name:");  
        pnl1_border.setTitleJustification(TitledBorder.LEFT);

        TitledBorder pnl2_border = new TitledBorder("Info:");
        pnl2_border.setTitleJustification(TitledBorder.TOP);
        pnl2_border.setTitleJustification(TitledBorder.LEFT);

        TitledBorder pnl3_border = new TitledBorder("File as:");
        pnl3_border.setTitleJustification(TitledBorder.TOP);
        pnl3_border.setTitleJustification(TitledBorder.LEFT);

        TitledBorder pnl4_border = new TitledBorder("Info:");

        pnl4_border.setTitleJustification(TitledBorder.LEFT); 

        //Simple Tips/Helps for user
        fName_tf.setToolTipText("Please Enter Your Name Valid characters A-Z or a-z");
        lName_tf.setToolTipText("Please Enter Your Name Valid characters A-Z or a-z");
        number_tf.setToolTipText("Valid Numbers from 0-9");
        number_tf.setToolTipText("Valid Numbers from 0-9");
        add.setToolTipText("Click to add values to table (Alt+a)");
        remove.setToolTipText("Click to delete values from  table (Alt+r)");
        clear.setToolTipText("Click to clear text fields (Alt+c)");
        search.setToolTipText("Available in next version");        
        mi1.setToolTipText("(Alt+x)");
        mi2.setToolTipText("(Alt+a)");
        mi3.setToolTipText("Alt+r");
        mi4.setToolTipText("Alt+c");
        mi5.setToolTipText("Alt+s");
        mi6.setToolTipText("Alt+h");
        file.setToolTipText("Alt+f");
        edit.setToolTipText("Alt+e");
        help.setToolTipText("Alt+h");
        
        //Setting Title Borders
        pnl1.setBorder(pnl1_border);
        pnl2.setBorder(pnl2_border);
        pnl3.setBorder(pnl3_border);
        pnl4.setBorder(pnl4_border);

        frame.add(mbar,BorderLayout.NORTH);
        frame.add(pnl1,BorderLayout.WEST);    
        frame.add(pnl5,BorderLayout.EAST);//Positions for borderLayout
        frame.setSize(840,510);
        frame.setResizable(false);//fix dimensions
        frame.setVisible(true);//makes visible

    }

    @Override
    public void actionPerformed(ActionEvent e){

        //Functionalities of the four buttons starts here
        //Add Button
        try{
            if(e.getSource()==add || e.getSource() == mi2){
                f_Name=fName_tf.getText();
                l_Name=lName_tf.getText();
                num=number_tf.getText();
                row[0]=fName_tf.getText();
                row[1]=lName_tf.getText();
                row[2]=number_tf.getText();
                rb_1.setEnabled(false);
                rb_2.setEnabled(false);
                if(cb1.isSelected()){
                    row[3]="Private";
                }
                else{
                    row[3]="";
                }
                //Validation starts (try catch)
                if (f_Name.matches("^([A-Za-z]*)$") && l_Name.matches("^([A-Za-z]*)$") && num.matches("[0-9]{10}") ){
                    model.insertRow(count,new Object[]{row[0],row[1],row[2],row[3]});
                    count++;// without this new datas are added at top
                }
                else{
                    if (f_Name.matches("^([A-Za-z]*)$") != true) {
                        fName_tf.setBorder(new LineBorder(Color.red));
                        throw new PhoneBook_Exceptions();
                    }
                    if (l_Name.matches("^([A-Za-z]*)$") != true) {
                        lName_tf.setBorder(new LineBorder(Color.red));
                        throw new PhoneBook_Exceptions();
                    }
                    if (num.matches("[0-9]{10}") != true) {
                        number_tf.setBorder(new LineBorder(Color.red));
                        throw new PhoneBook_Exceptions();
                    }
                }                   
            }
        }
        catch(PhoneBook_Exceptions w){
            System.out.println(w);// When Errors Occurs Opens JOptionPain
        }
        
        //Clear Button
        if (e.getSource() == clear|| e.getSource() == mi4) {
            fName_tf.setText("");
            lName_tf.setText("");
            number_tf.setText("");
            cb1.setSelected(false);//for making values null
            fName_tf.setBorder(new LineBorder(Color.gray));//if their are errors to change back to default
            lName_tf.setBorder(new LineBorder(Color.gray));//if their are errors to change back to default
            number_tf.setBorder(new LineBorder(Color.gray));//if their are errors to change back to default
        }
        
        //Remove Button
        if (e.getSource() == remove || e.getSource() == mi3) {
            int i=table.getSelectedRow();//selects all rows
            if(i>=0){
                model.removeRow(i);
                count--;//if not written blank space remains
            }
            else{
                JFrame messageDilog = new JFrame("Remove Error");
                JOptionPane.showMessageDialog(messageDilog, "The row chosen is empty");
            }

        }
        
        //Search  Button
        if (e.getSource() == search || e.getSource() == mi5){
            JFrame messageDilog2 = new JFrame("Notice");
            JOptionPane.showMessageDialog(messageDilog2, "It is still in trial version!!");
        } 

    }

    public static void main(String args[]){
        Phone_Book p=new Phone_Book();

    }
}
