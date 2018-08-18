import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

MainFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
AddFrame a=new AddFrame();
dispose();
}
});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
ViewFrame a=new ViewFrame();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a=new UpdateFrame();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a=new DeleteFrame();
dispose();
}
});



setTitle("Student Management Student");
setSize(350,200);

setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public static void main(String args[])
{
MainFrame m=new MainFrame();
}
}

class DbHandler
{
public void addStudent(int rno,String name)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="insert into student values(?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);
int r=pst.executeUpdate();
if(r==r)
{
JOptionPane.showMessageDialog(new JDialog(),r+"Record Added");
}
con.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"Record already Exist");
}
}

public void updateStudent(int rno,String name)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="update student set name= ?" + " where rno=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,name);
pst.setInt(2,rno);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"Records Updated");
con.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(), "ii");
}
}



public void deleteStudent(int rno)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="delete student where rno=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"Records Deleted");
con.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"No Records Found");
}
}

public String viewStudent()
{
StringBuffer sb=new StringBuffer();
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="select * from student";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);

while(rs.next()){
	int rno=rs.getInt(1);
	String name=rs.getString(2);
	sb.append(" Rno " +  rno  + " Name " +  name  + "\n");
}
rs.close();
con.close();
}
catch(SQLException e){
}
return sb.toString();
}
}	