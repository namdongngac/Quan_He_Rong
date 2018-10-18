/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author admin
 */
public class Frame extends JFrame implements ActionListener{
    
    JButton okButton, cancelButton;
    JTextField tText, eText;
    JLabel target, explain;
    Dictionary Dic = new Dictionary();
    public void CreateAndShow(){
        target = new JLabel("Tiếng Anh: ");
        explain = new JLabel("Tiếng Việt");
        tText = new JTextField(5);
        eText = new JTextField(5);
        okButton = new JButton("OK");
        okButton.setActionCommand("ok");
        this.setLayout(new GridLayout(5, 2));
        this.setLocationRelativeTo(null);
        
        this.setSize(300,200);
        tText.setAlignmentX(TOP_ALIGNMENT);
        tText.setAlignmentY(LEFT_ALIGNMENT);
        this.add(target);
        this.add(tText);
        this.add(explain);
        this.add(eText);
        this.add(okButton);      
        okButton.addActionListener(this);
       
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("ok".equals(e.getActionCommand())){
            if(!tText.getText().equals("")&&!eText.getText().equals("")){
            
            String wt = tText.getText();
            String we = eText.getText();
            if(this.Dic.tm.containsKey(wt)){
                JOptionPane.showMessageDialog(rootPane, "Từ đã có trong từ điển");
            }
            else{
                this.Dic.tm.put(wt, we);
                JOptionPane.showMessageDialog(rootPane, "Thêm từ thành công");
            }         
        }
        else JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ thông tin");
        }      
        
    }
}
