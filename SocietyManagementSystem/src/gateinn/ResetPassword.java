package gateinn;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;
import javax.swing.*;

class ResetPassword implements ActionListener
{
    JFrame jf;
    JTextField tid;
    JLabel lblid,lblnew,lblconfirm,lblimage,lblkeyid;
    JButton bcheck,bcancel,bchange;
    JPasswordField tconfirm,tnew,tkeyid;
    final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public ResetPassword()
    {
        //Frame Details
        jf=new JFrame("FORGOT PASSWORD");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setBackground(Color.green);
        jf.setLayout(null);

        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,500,500);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\gateinn\\images\\remove.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);

        lblid=new JLabel("ENTER KEY ID:");
        lblid.setVisible(true);
        lblid.setBounds(50,50,150,30);
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblid);

        //Key Id Text Field
        tid=new JTextField();
        tid.setBounds(220,50,200,30);
        tid.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tid);
        
        //Change button
        bcheck=new JButton("CHECK");
        bcheck.setBounds(150,120,120,30);
        bcheck.setBackground(Color.BLACK);
        bcheck.setForeground(Color.WHITE);
        bcheck.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcheck);
        
        //Cancel button
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(290,120,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcancel);
        
        bcheck.addActionListener(this);
        bcancel.addActionListener(this);
        
        //New,Confirm Password and Key ID Label Details
        lblnew=new JLabel("NEW PASSWORD:");
        lblnew.setVisible(true);
        lblnew.setBounds(40,200,170,30);
        lblnew.setForeground(Color.BLACK);
        lblnew.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblnew);
        
        lblconfirm=new JLabel("CONFIRM PASSWORD:");
        lblconfirm.setVisible(true);
        lblconfirm.setBounds(40,250,220,30);
        lblconfirm.setForeground(Color.BLACK);
        lblconfirm.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblconfirm);
        
        lblkeyid=new JLabel("NEW KEY ID:");
        lblkeyid.setVisible(true);
        lblkeyid.setBounds(40,300,220,30);
        lblkeyid.setForeground(Color.BLACK);
        lblkeyid.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblkeyid);
        
        //New, Confirm Password and New Key Id TextField
        tnew=new JPasswordField();
        tnew.setBounds(280,200,190,30);
        tnew.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tnew);
        
        tconfirm=new JPasswordField();
        tconfirm.setBounds(280,250,190,30);
        tconfirm.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tconfirm);
        
        tkeyid=new JPasswordField();
        tkeyid.setBounds(280,300,190,30);
        tkeyid.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tkeyid);
        
        //Button Change
        bchange=new JButton("CHANGE PASSWORD");
        bchange.setBounds(140,350,220,30);
        bchange.setBackground(Color.BLACK);
        bchange.setForeground(Color.WHITE);
        bchange.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bchange);
        bchange.addActionListener(this);
        
        lblnew.setVisible(false);
        lblconfirm.setVisible(false);
        lblkeyid.setVisible(false);
        tnew.setVisible(false);
        tconfirm.setVisible(false);
        tkeyid.setVisible(false);
        bchange.setVisible(false);
        
        jf.setSize(500,500);
        jf.setLocation(30,30);
        jf.setVisible(true);

    }
    public String generateString(int len) 
    {
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ ) 
            sb.append( AB.charAt(rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==bcancel)
        {
            jf.dispose();
            GateinnLogin l=new GateinnLogin();
        }

        if(ae.getSource()==bcheck)
        {
            GateDao gatedao=new GateDao();
            int k=gatedao.checkKeyID(tid.getText());
            if(k==0)
            {
                jf.dispose();
                JOptionPane.showMessageDialog(null,"INCORRECT KEY ID");
                ResetPassword fp=new ResetPassword();
            }
            if(k==1)
            {
                lblnew.setVisible(true);
                lblconfirm.setVisible(true);
                lblkeyid.setVisible(true);
                tnew.setVisible(true);
                tconfirm.setVisible(true);
                tkeyid.setVisible(true);
                bchange.setVisible(true); 
                tkeyid.setText(generateString(10));
                tkeyid.setEditable(false);
            }      
        }
        if(ae.getSource()==bchange)
        {
            String newpassword = tnew.getText();
            String confirmpassword=tconfirm.getText();
            String newkeyid=tkeyid.getText();
            jf.dispose();
            GateDao gatedao=new GateDao();
            gatedao.changePassword(newpassword, confirmpassword, newkeyid);
        }

    }
    public static void main(String[]ar)
    {
        ResetPassword f=new ResetPassword();
    }
}