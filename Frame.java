/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author admin
 */
public class Frame extends JFrame implements ActionListener{
    
    JButton okButton, deleteButton, searchButton, addButton;
    JTextField text;
    
    public Frame(){
        CreateAndShow();
     
    }
    public void CreateAndShow(){
        text = new JTextField();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,800);
        text.setSize(10,20);
        this.add(text);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(200, 100, 50, 20);
        this.add(searchButton);
        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);
        
        deleteButton = new JButton("Delete");
        searchButton.setBounds(200, 300, 50, 20);
        this.add(deleteButton);
        
        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);
        
        
        addButton = new JButton("Add");
        this.add(addButton);
        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);
        
        this.setLayout(new FlowLayout());
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("search".equals(e.getActionCommand()))
            JOptionPane.showMessageDialog(rootPane, "Search");
        
    }
}
