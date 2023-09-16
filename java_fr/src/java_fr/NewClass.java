package java_fr;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NewClass extends JFrame {
    private Container c;
    private JLabel label_1,label_2,label_3;
private Font f;
private JTextField t_1,t_2,t_3;
private JButton bt_1,bt_2,bt_3;
private Cursor cursor;
private Scanner sc;
//private String[] s=new String[Java_fr.num];
//private String[] r=new String[Java_fr.num];
//private String[] t=new String[Java_fr.num];
public static float [] ca=new float[Java_fr.num];
 public static float [] exam_marks=new float [Java_fr.num];
  public static float [] total_marks=new float[Java_fr.num];

    // Declare arrays to store grade points and credit hours
   public static float [] grade_points=new float[Java_fr.num];
   public static float [] credit_Hours=new float[Java_fr.num];

   public float total_credit=0;
   public float totalGradePoints = 0;
   public float totalCreditHours = 0;
   public static float sgpa = 0;
    NewClass()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,350);
        this.setLocationRelativeTo(null);
        this.setTitle("Fill up this information");
        
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.yellow);
        cursor=new Cursor(Cursor.HAND_CURSOR);
        f=new Font("Arial",Font.BOLD,14);

label_1=new JLabel();
label_1.setText("Enter Credit: ");
label_1.setBounds(50,15,145,40);
label_1.setFont(f);
label_1.setForeground(Color.red);
label_1.setOpaque(true);
label_1.setBackground(Color.white);
label_1.setCursor(cursor);
c.add(label_1);

label_2=new JLabel();
label_2.setText("Enter CA Marks: ");
label_2.setBounds(50,65,145,40);
label_2.setFont(f);
label_2.setForeground(Color.red);
label_2.setOpaque(true);
label_2.setBackground(Color.white);
label_2.setCursor(cursor);
c.add(label_2);

label_3=new JLabel();
label_3.setText("Enter Exam Marks: ");
label_3.setBounds(50,115,145,40);
label_3.setFont(f);
label_3.setForeground(Color.red);
label_3.setOpaque(true);
label_3.setBackground(Color.white);
label_3.setCursor(cursor);
c.add(label_3);

t_1=new JTextField();
t_1.setBounds(205,15,100,40);
t_1.setFont(f);
c.add(t_1);

t_2=new JTextField();
t_2.setBounds(205,65,100,40);
t_2.setFont(f);
c.add(t_2);

t_3=new JTextField();
t_3.setBounds(205,115,100,40);
t_3.setFont(f);
c.add(t_3);

bt_1=new JButton("Submit");
bt_1.setBounds(60,250,100,40);
bt_1.setFont(f);
bt_1.setCursor(cursor);
c.add(bt_1);

bt_2=new JButton("Clear");
bt_2.setBounds(200,250,100,40);
bt_2.setFont(f);
bt_2.setCursor(cursor);
c.add(bt_2);

bt_3=new JButton("Output");
bt_3.setBounds(340,250,100,40);
bt_3.setFont(f);
bt_3.setCursor(cursor);
c.add(bt_3);

bt_1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        try{
        for(int i=0;i<1;i++){
        credit_Hours[i]=Float.parseFloat(t_1.getText());
        ca[i]=Float.parseFloat(t_2.getText());
        exam_marks[i]=Float.parseFloat(t_3.getText());
        System.out.println(credit_Hours[i]);
        System.out.println(ca[i]);
        System.out.println(exam_marks[i]);
        total_marks[i]=ca[i]+exam_marks[i];
        if(credit_Hours[i]==3)
        {
            grade_points[i]=theorygp(total_marks[i]);
        }
        else if(credit_Hours[i]==1.5)
        {
            grade_points[i]=labgp(total_marks[i]);
        }
        System.out.print("\nGrade points of subject "+(i+1)+"="+grade_points[i]+"\n");
        totalGradePoints += grade_points[i] * credit_Hours[i];
        totalCreditHours += credit_Hours[i];
        t_1.setText("");
        t_2.setText("");
        t_3.setText("");
        //dispose();
        }

    // Calculate the SGPA
    sgpa = totalGradePoints / totalCreditHours;
            System.out.println("SGPA="+sgpa);
        }catch(NumberFormatException ex){
         //JOptionPane.showMessageDialog(rootPane, ex);
        } 
        
    }
  
});

bt_2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        t_1.setText("");
        t_2.setText("");
        t_3.setText("");
    }
});

bt_3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        dispose();
        if(NewClass.sgpa==4.00)
        {
           JOptionPane.showMessageDialog(null,"Extraordinary,Keep it up! you passed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE); 
        }
        else if(sgpa>=3.75)
                {
                    JOptionPane.showMessageDialog(null,"Outstanding,Keep it up! you passed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE);
                }
        else if(sgpa>=3.50)
                {
          JOptionPane.showMessageDialog(null,"Very Good,Keep it up! you passed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE);
      }
        else if(sgpa>=3.25)
        {
            JOptionPane.showMessageDialog(null,"Well done! you passed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE);
        }
        else if(sgpa>=3.00)
        {
            JOptionPane.showMessageDialog(null,"Good! you passed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE);
        }
        else if(sgpa<3.00 && sgpa>=2.00)
        {
            JOptionPane.showMessageDialog(null,"Not So Good! you passed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE);
        }
      else{
          JOptionPane.showMessageDialog(null,"Sorry! you failed and your SGPA is "+sgpa,"RESULT",JOptionPane.PLAIN_MESSAGE);
      }
    }
});
        
    }
    public static float theorygp(float marks){
    if(marks>=79.5 && marks<=100)
    {
        return 4.00f;
    }
    else if(marks>=74.5 && marks<=79)
    {
        return 3.75f;
    }
    else if(marks>=69.5 && marks<=74)
    {
        return 3.50f;
    }
    else if(marks>=64.5 && marks<=79)
    {
        return 3.25f;
    }
    else if(marks>=59.5 && marks<=64)
    {
        return 3.00f;
    }
    else if(marks>=54.5 && marks<=59)
    {
        return 2.75f;
    }
    else if(marks>=49.5 && marks<=54)
    {
        return 2.50f;
    }
    else if(marks>=44.5 && marks<=49)
    {
        return 2.25f;
    }
    else if(marks>=39.5 && marks<=44)
    {
        return 2.00f;
    }
    else
    {
        return 0.00f;
    }
}
public static float labgp(float marks){
    if(marks>=40 && marks<=50)
    {
        return 4.00f;
    }
    else if(marks>=37.5 && marks<=39)
    {
        return 3.75f;
    }
    else if(marks>=35 && marks<=37)
    {

        return 3.50f;
    }
    else if(marks>=32.5 && marks<=34.5)
    {
        return 3.25f;
    }
    else if(marks>=30 && marks<=32)
    {
        return 3.00f;
    }
    else if(marks>=27.5 && marks<=29.5)
    {
        return 2.75f;
    }
    else if(marks>=25 && marks<=27)
    {
        return 2.50f;
    }
    else
    {
        return 0.00f;
    }
}
    
    public static void main(String[] args) {
        NewClass fr=new NewClass();
        fr.setVisible(true);
    }
 
}
