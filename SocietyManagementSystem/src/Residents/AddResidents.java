package Residents;
import Databases.ResidentsDao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import societymanagementsystem.MainPage;
public class AddResidents implements ActionListener
{
    JFrame jf;
    JLabel lbltitle,lblowner,lblBuilding,lblflatno,lblDOB,lbloccupation,lblarriving_year,lbltotalfamilymem,lblmaritalstatus,lblRentOrOwner;
    JTextField towner,tBuilding,tflatno,tDOB,toccupation,tarrival_year,ttotalfamilymem;
    JRadioButton jrbMarried,jrbSingle,jrbOwner,jrbRent;
    ButtonGroup G1,G2;
    JButton bback,bAddResidents,bView,bUpdate;
    public AddResidents()
    {
        //Frame Details
        jf=new JFrame("ADD RESIDENTS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(20,20);
        jf.setSize(850,700);
        
        //Label and TextField Details
        //Title
        lbltitle = new JLabel("ADD  RESIDENTS");
        lbltitle.setBounds(20,0,400,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,36));
        lbltitle.setForeground(Color.BLUE);
        jf.add(lbltitle);
        
        //1.Owner
        lblowner = new JLabel("NAME OF RESIDENT: ");
        lblowner.setBounds(40,100,230,30);
        lblowner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblowner.setForeground(Color.BLACK);
        jf.add(lblowner);
        
        towner=new JTextField();
        towner.setBounds(345,95,280,40);
        towner.setFont(new Font("serif",Font.PLAIN,20));
        towner.setForeground(Color.BLACK);
        jf.add(towner);
        
        //2.Wing
        lblBuilding = new JLabel("BUILDING NUMBER: ");
        lblBuilding.setBounds(40,150,200,30);
        lblBuilding.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblBuilding.setForeground(Color.BLACK);
        jf.add(lblBuilding);
        
        tBuilding=new JTextField();
        tBuilding.setBounds(345,145,280,40);
        tBuilding.setFont(new Font("serif",Font.PLAIN,20));
        tBuilding.setForeground(Color.BLACK);
        jf.add(tBuilding);
        
        //3.Flat No.
        lblflatno = new JLabel("FLAT NUMBER: ");
        lblflatno.setBounds(40,200,200,30);
        lblflatno.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblflatno.setForeground(Color.BLACK);
        jf.add(lblflatno);
        
        tflatno=new JTextField();
        tflatno.setBounds(345,195,280,40);
        tflatno.setFont(new Font("serif",Font.PLAIN,20));
        tflatno.setForeground(Color.BLACK);
        jf.add(tflatno);
        
        //4.DOB
        lblDOB = new JLabel("DATE OF BIRTH(DD/MM/YYYY):");
        lblDOB.setBounds(40,250,320,30);
        lblDOB.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblDOB.setForeground(Color.BLACK);
        jf.add(lblDOB);
        
        tDOB=new JTextField();
        tDOB.setBounds(345,245,280,40);
        tDOB.setFont(new Font("serif",Font.PLAIN,20));
        tDOB.setForeground(Color.BLACK);
        jf.add(tDOB);
        
        //4.Occupation
        lbloccupation = new JLabel("OCCUPATION: ");
        lbloccupation.setBounds(40,300,200,30);
        lbloccupation.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbloccupation.setForeground(Color.BLACK);
        jf.add(lbloccupation);
        
        toccupation=new JTextField();
        toccupation.setBounds(345,295,280,40);
        toccupation.setFont(new Font("serif",Font.PLAIN,20));
        toccupation.setForeground(Color.BLACK);
        jf.add(toccupation);
        
        //6.Arrival Year
        lblarriving_year = new JLabel("YEAR OF ARRIVAL: ");
        lblarriving_year.setBounds(40,350,220,30);
        lblarriving_year.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblarriving_year.setForeground(Color.BLACK);
        jf.add(lblarriving_year);
        
        tarrival_year=new JTextField();
        tarrival_year.setBounds(345,345,280,40);
        tarrival_year.setFont(new Font("serif",Font.PLAIN,20));
        tarrival_year.setForeground(Color.BLACK);
        jf.add(tarrival_year);
        
        //7.Total Family Members
        lbltotalfamilymem = new JLabel("TOTAL FAMILY MEMBERS: ");
        lbltotalfamilymem.setBounds(40,400,300,30);
        lbltotalfamilymem.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbltotalfamilymem.setForeground(Color.BLACK);
        jf.add(lbltotalfamilymem);
        
        ttotalfamilymem=new JTextField();
        ttotalfamilymem.setBounds(345,395,280,40);
        ttotalfamilymem.setFont(new Font("serif",Font.PLAIN,20));
        ttotalfamilymem.setForeground(Color.BLACK);
        jf.add(ttotalfamilymem);
        
        //8.Marital Status
        lblmaritalstatus = new JLabel("MARITAL STATUS: ");
        lblmaritalstatus.setBounds(40,450,300,30);
        lblmaritalstatus.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblmaritalstatus.setForeground(Color.BLACK);
        jf.add(lblmaritalstatus);
        
        jrbSingle=new JRadioButton("SINGLE");
        jrbSingle.setBounds(345,445,140,40);
        jrbSingle.setFont(new Font("serif",Font.PLAIN,25));
        jrbSingle.setForeground(Color.BLACK);
        jf.add(jrbSingle);
        
        jrbMarried=new JRadioButton("MARRIED");
        jrbMarried.setBounds(490,445,200,40);
        jrbMarried.setFont(new Font("serif",Font.PLAIN,25));
        jrbMarried.setForeground(Color.BLACK);
        jf.add(jrbMarried);
        
        //9.Rent or Owner
        lblRentOrOwner = new JLabel("RENTED/OWNER: ");
        lblRentOrOwner.setBounds(40,500,300,30);
        lblRentOrOwner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblRentOrOwner.setForeground(Color.BLACK);
        jf.add(lblRentOrOwner);
        
        jrbOwner=new JRadioButton("OWNER");
        jrbOwner.setBounds(345,495,140,40);
        jrbOwner.setFont(new Font("serif",Font.PLAIN,25));
        jrbOwner.setForeground(Color.BLACK);
        jf.add(jrbOwner);
        
        jrbRent=new JRadioButton("RENT");
        jrbRent.setBounds(490,495,200,40);
        jrbRent.setFont(new Font("serif",Font.PLAIN,25));
        jrbRent.setForeground(Color.BLACK);
        jf.add(jrbRent);
        
        //Add Residents Button
        bAddResidents=new JButton("ADD RESIDENT");
        bAddResidents.setBounds(80,600,250,40);
        bAddResidents.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bAddResidents.setForeground(Color.WHITE);
        bAddResidents.setBackground(Color.BLACK);
        jf.add(bAddResidents);
        
        //Back Button
        bback=new JButton("BACK");
        bback.setBounds(670,600,100,40);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback);
        
        //View Button
        bView=new JButton("VIEW");
        bView.setBounds(540,600,100,40);
        bView.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bView.setForeground(Color.WHITE);
        bView.setBackground(Color.BLACK);
        jf.add(bView);
        
        //Update Button
        bUpdate=new JButton("UPDATE");
        bUpdate.setBounds(360,600,150,40);
        bUpdate.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bUpdate.setForeground(Color.WHITE);
        bUpdate.setBackground(Color.BLACK);
        jf.add(bUpdate);
        
        G1=new ButtonGroup();
        G1.add(jrbMarried);
        G1.add(jrbSingle);
        
        G2=new ButtonGroup();
        G2.add(jrbOwner);
        G2.add(jrbRent);
        
        bView.addActionListener(this);
        bUpdate.addActionListener(this);
        bAddResidents.addActionListener(this);
        bback.addActionListener(this);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bback)
        {
            jf.dispose();
            new MainPage();
        }
        if(ae.getSource()==bAddResidents)
        {
            jf.dispose();
            Residents resident=new Residents();
            resident.setName(towner.getText());
            resident.setBuildingNum(tBuilding.getText());
            resident.setFlatNum(tflatno.getText());
            resident.setDOB(tDOB.getText());
            resident.setOccupation(toccupation.getText());
            resident.setYearOfArrival(Integer.parseInt(tarrival_year.getText()));
            resident.setTotalMembers(Integer.parseInt(ttotalfamilymem.getText()));
            if(jrbMarried.isSelected())
                resident.setMaritalStatus("MARRIED");
            if(jrbSingle.isSelected())
                resident.setMaritalStatus("SINGLE");
            if(jrbOwner.isSelected())
                resident.setRentOrOwner("OWNER");
            if(jrbRent.isSelected())
                resident.setRentOrOwner("RENT");
            ResidentsDao residentDao=new ResidentsDao();
            boolean check=residentDao.checkResident(resident);
            if(!check)
            {
                residentDao.addResidents(resident);
                new AddResidents();
            }
            else
            {
                jf.dispose();
                JOptionPane.showMessageDialog(null,"The Flat Already Has A Resident!");
                new AddResidents();
            }    
        }
        if(ae.getSource()==bView)
        {
            new ViewResidents(" ");
        }
        if(ae.getSource()==bUpdate)
        {
            jf.dispose();
            new UpdateResidents();
        }
    }   
    public static void main(String args[])
    {
        new AddResidents();
    }
}
