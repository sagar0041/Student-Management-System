import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame{
Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;

AddFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
lblRno=new JLabel("Rno:");
txtRno=new JTextField(4);
lblName=new JLabel("Name:");
txtName=new JTextField(10);

p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);
c.add(p1);

p2=new JPanel();
btnSave=new JButton("Save");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String rno2=txtRno.getText();
String name=txtName.getText();
try
{
int rno=Integer.parseInt(rno2);
if(name.matches("^[a-zA-Z\\s]*$")&&(rno>0))
{
DbHandler db=new DbHandler();
db.addStudent(rno,name);
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Please Re-Enter The Values");
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"Records not Added");
}
txtRno.setText("");
txtRno.requestFocus();
txtName.setText("");
}
});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
MainFrame a=new MainFrame();
dispose();
}
});


setTitle("Add Student");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
