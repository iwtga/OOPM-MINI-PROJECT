package Databases;
import Residents.AddResidents;
import Residents.Residents;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ResidentsDao 
{
    public void addResidents(Residents resident)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="INSERT INTO RESIDENTS (NAME, BUILDING_NUMBER, FLAT_NUMBER, DOB, OCCUPATION, ARRIVAL_YEAR, TOTAL_FAMILY_MEMBERS, MARITAL_STATUS, RENT_OWNER) VALUES "
                    + "('"+resident.getName()+"', '"+resident.getBuildingNum()+"', '"+resident.getFlatNum()+"', '"+resident.getDOB()+"', '"+resident.getOccupation()+"', "+resident.getYearOfArrival()+", "
                    +resident.getTotalMembers()+", '"+resident.getMaritalStatus()+"', '"+resident.getRentOrOwner()+"');";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "RESIDENT ADDED!");
            new AddResidents();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ADDING RESIDENT TO THE DATABASE FAILED");
        }        
    }
    
    public boolean checkResident(Residents resident)
    {
        boolean k=false;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from residents where BUILDING_NUMBER= '"+resident.getBuildingNum()+"' and FLAT_NUMBER= '"+resident.getFlatNum()+"';");
            while(rs.next())
            {
                k=true;
                break;
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }
        return k;
    }
    public void updateResidentDetails(Residents resident)
    {
        
    }
}