import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
class LoanAssistant extends JFrame{
    public static JLabel lb,ir,np,mp,la;
    public static JTextField LB,IR,NP,MP;
    public static JButton CMP,NLA,X1,X2,Exit;
    public static JTextArea LA;
    public static Color lightYellow = new Color(255, 255, 128);
    public static boolean computePayment;
    LoanAssistant(){
        setTitle("Loan Assistance");
        setSize(670,320);
        setResizable(false);
        setLocation(500,200);
        setLayout(null);
        Border br=BorderFactory.createLineBorder(Color.BLACK,1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font2=new Font("Arial", Font.PLAIN, 16);
        Font font=new Font("Ariel", Font.BOLD, 12);
        Font font3=new Font("Valentina", Font.BOLD, 14);
        lb=new JLabel("Loan Balance");
        lb.setBounds(10,0,200,50);
        lb.setFont(font2);
        LB=new JTextField("");
        LB.setBounds(170,10,100,25);
        LB.setHorizontalAlignment(SwingConstants.RIGHT);
        LB.setFont(font2);
        LB.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                LBActionPerformed(e);
                
            }

            private void LBActionPerformed(ActionEvent e) {
                LB.transferFocus();
            }
            
        });
        ir=new JLabel("Interest Rate");
        ir.setBounds(10,40,200,50);
        ir.setFont(font2);
        IR=new JTextField("");
        IR.setBounds(170,50,100,25);
        IR.setHorizontalAlignment(SwingConstants.RIGHT);
        IR.setFont(font2);
        IR.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                IRActionPerformed(e);
                
            }

            private void IRActionPerformed(ActionEvent e) {
                IR.transferFocus();
            }
            
        });
        np=new JLabel("Number Of Payments");
        np.setBounds(10,80,200,50);
        np.setFont(font2);
        NP=new JTextField("");
        NP.setBounds(170,90,100,25);
        NP.setHorizontalAlignment(SwingConstants.RIGHT);
        NP.setFont(font2);
        NP.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                NPActionPerformed(e);
                
            }

            private void NPActionPerformed(ActionEvent e) {
                NP.transferFocus();
            }
            
        });
        mp=new JLabel("Monthly Payment");
        mp.setBounds(10,120,200,50);
        mp.setFont(font2);
        MP=new JTextField("");
        MP.setBounds(170,130,100,25);
        MP.setHorizontalAlignment(SwingConstants.RIGHT);
        MP.setFont(font2);
        MP.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                MPActionPerformed(e);
                
            }

            private void MPActionPerformed(ActionEvent e) {
                MP.transferFocus();
            }
            
        });
        CMP=new JButton("Compute Monthly Payment");
        CMP.setBounds(50,170,210,30);
        CMP.setFont(font);
        CMP.setFocusable(false);
        NLA=new JButton("New Loan Analysis");
        NLA.setBounds(80,210,150,30);
        NLA.setFont(font);
        NLA.setEnabled(false);
        NLA.setFocusable(false);
        X1=new JButton("X");
        X1.setBounds(280,90,45,25);
        X1.setFont(font);
        X1.setFocusable(false);
        X2=new JButton("X");
        X2.setBounds(280,130,45,25);
        X2.setFont(font);
        X2.setFocusable(false);
        la=new JLabel("Loan Analysis:");
        la.setBounds(335,5,150,30);
        la.setFont(font2);
        LA=new JTextArea("");
        LA.setBounds(335,40,300,160);
        LA.setBorder(br);
        LA.setFont(font3);
        LA.setEditable(false);
        Exit=new JButton("Exit");
        Exit.setBounds(450,210,60,30);
        Exit.setFont(font);
        Exit.setFocusable(false);
        add(Exit);
        add(la);
        add(X1);
        add(X2);
        add(CMP);
        add(NLA);
        add(lb);
        add(ir);
        add(np);
        add(mp);
        add(LB);
        add(IR);
        add(NP);
        add(MP);
        add(LA);
        setVisible(true);
        X2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                computePayment = true;               
                X2.setVisible(false);
                X1.setVisible(true);
                NP.setEditable(true);
                NP.setBackground(Color.WHITE);
                NP.setFocusable(true);
                MP.setText("");
                MP.setEditable(false);
                MP.setBackground(lightYellow);
                MP.setFocusable(false);
                CMP.setText("Compute Monthly Payment");
                LB.requestFocus();
                
            }

        });
        X1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                computePayment = false;
                X2.setVisible(true);
                X1.setVisible(false);
                NP.setEditable(false);
                NP.setBackground(lightYellow);
                NP.setText("");
                NP.setFocusable(false);
                MP.setEditable(true);
                MP.setBackground(Color.white);
                MP.setFocusable(true);
                CMP.setText("Compute Number of Payments");
                LB.requestFocus();
            }   
        });
        NLA.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                if (computePayment)
                {
                MP.setText("");
                }
                else
                {
                NP.setText("");
                }
                LA.setText("");
                CMP.setEnabled(true);
                NLA.setEnabled(false);
                LB.requestFocus();
                
            }
            
        });
        CMP.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                double bl,it,pay;
                int mon;
                double monit,mul;
                double loanBalance, finalPayment;
                if(validateDecimalNumber(LB)){
                    bl=Double.valueOf(LB.getText()).doubleValue();
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(validateDecimalNumber(IR)){
                    it=Double.valueOf(IR.getText()).doubleValue();
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                monit=it/1200;
                if(computePayment){
                    if(validateDecimalNumber(NP)){
                        mon=Integer.valueOf(NP.getText()).intValue();
                    }
                    else{
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                   
                    if(it==0){
                        pay=bl/mon;
                    }
                    else{
                        mul = Math.pow(1 + monit, mon);
                        pay = bl * monit * mul/(mul - 1);
                    }
                    MP.setText(new DecimalFormat("0.00").format(pay));

                }
                else{
                    if(validateDecimalNumber(MP)){
                        pay=Double.valueOf(MP.getText()).doubleValue();
                        if (pay <= (bl * monit + 1.0))
                        {
                        if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int)(bl * monit + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                        {
                        MP.setText(new DecimalFormat("0.00").format((int)
                        (bl * monit + 1.0)));
                        pay =Double.valueOf(MP.getText()).doubleValue();
                        }
                        else
                        {
                        MP.requestFocus();
                        return;
                        }
                    }
                }
                    else{
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                    if(it==0){
                        mon=(int)(bl/pay);
                    }
                    else{
                        mon= (int)((Math.log(pay) - Math.log(pay - bl * monit))/ Math.log(1 + monit)); 
                    }
                   
                    NP.setText(String.valueOf(mon));
                }
                pay = Double.valueOf(MP.getText()).doubleValue();
                LA.setText("\n"+" Loan Balance: $" + new
                DecimalFormat("0.00").format(bl));
                LA.append("\n" + " Interest Rate: " + new
                DecimalFormat("0.00").format(it) + "%");
                
                loanBalance = bl;
                for (int paymentNumber = 1; paymentNumber <= mon - 1; paymentNumber++)
                {
                loanBalance += loanBalance * monit - pay;
                }
                finalPayment = loanBalance;
                if (finalPayment > pay)
                {
                loanBalance += loanBalance * monit - pay;
                finalPayment = loanBalance;
                mon++;
                NP.setText(String.valueOf(mon));
            }
            LA.append("\n\n " + String.valueOf(mon - 1) + " Payments of $" + new DecimalFormat("0.00").format(pay));
            LA.append("\n" + " Final Payment of: $" + new DecimalFormat("0.00").format(finalPayment));
            LA.append("\n" + " Total Payments: $" + new DecimalFormat("0.00").format((mon - 1) * pay + finalPayment));
            LA.append("\n" + " Interest Paid $" + new DecimalFormat("0.00").format((mon - 1) * pay + finalPayment - bl));
            CMP.setEnabled(false);
            NLA.setEnabled(true);
            NLA.requestFocus();
            }

        });

        Exit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
                
            }
            
        });
        X2.doClick();

    }
    public boolean validateDecimalNumber(JTextField tf)
    {
        String s = tf.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;
        if (s.length() == 0)
        {
            valid = false;
        }
        else
        {
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9')
                {
                    continue;
                }
                else if (c == '.' && !hasDecimal)
                {
                    hasDecimal = true;
                }
                else
                {
                    valid = false;
                }
            }
        }
        tf.setText(s);
        if (!valid)
        {
           tf.requestFocus();
        }
        return (valid);
    }
    
    
    public static void main(String[] args) {
        new LoanAssistant();
    }
}