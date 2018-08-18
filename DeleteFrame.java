import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave,btnBack;
JPanel p1,p2;

DeleteFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
lblRno=new JLabel("Rno:");
txtRno=new JTextField(4);

p1.add(lblRno);
p1.add(txtRno);
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
try
{
int rno=Integer.parseInt(rno2);
if(rno>0)
{
DbHandler db=new DbHandler();
db.deleteStudent(rno);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"Invalid Record");
}
txtRno.setText("");
txtRno.requestFocus();
}
});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
MainFrame a=new MainFrame();
dispose();
}
});


setTitle("Delete Student");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
