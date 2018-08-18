import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;

UpdateFrame(){
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
String rno=txtRno.getText();
String name=txtName.getText();
try
{
if(name.matches("^[a-zA-Z\\s]*$"))
{
DbHandler db=new DbHandler();
db.updateStudent(Integer.parseInt(rno),name);
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Please Enter The Proper Values");
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"Please Enter RollNo");
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


setTitle("Update Student");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
