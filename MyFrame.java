/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;


import static java.awt.event.KeyEvent.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author admin
 */
public class MyFrame extends javax.swing.JFrame {
    
    static Dictionary Dic = new Dictionary();
    static DictionaryManagement Dm = new DictionaryManagement();   
    //static Frame f =new Frame(); 
    
    /**
     * Creates new form MyFrame
     */
    public MyFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputWord = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        outputWord = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showDic = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary");
        setBackground(new java.awt.Color(0, 0, 0));

        inputWord.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputWordInputMethodTextChanged(evt);
            }
        });
        inputWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputWordActionPerformed(evt);
            }
        });
        inputWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputWordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputWordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputWordKeyTyped(evt);
            }
        });

        searchButton.setText("Tìm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addButton.setText("Thêm từ");
        addButton.setToolTipText("Thêm từ vào từ điển");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa từ");
        deleteButton.setToolTipText("Xóa từ trong từ điển");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Thoát");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        outputWord.setBackground(new java.awt.Color(255, 255, 255));
        outputWord.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        outputWord.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        outputWord.setOpaque(true);
        outputWord.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        showDic.setModel(Dm.model);
        showDic.setToolTipText("");
        showDic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showDicMouseClicked(evt);
            }
        });
        showDic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showDicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                showDicKeyReleased(evt);
            }
        });
        showDic.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                showDicValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(showDic);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(inputWord))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outputWord, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addComponent(searchButton))
                    .addComponent(exitButton))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(inputWord, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outputWord, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void inputWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputWordActionPerformed
        //nhập input tìm từ
        if(!inputWord.getText().equals("")){
            outputWord.setText("");
            String a = inputWord.getText();
            String b = (String)Dic.tm.get(a);
            if(b==null){
                b = "";
                JOptionPane.showMessageDialog(rootPane, "Từ chưa có trong từ điển");    
            }           
            outputWord.setText(b+"\n");
        }
        else JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập từ");
            
               
    }//GEN-LAST:event_inputWordActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //
        if(!inputWord.getText().equals("")){
            outputWord.setText("");
            String a = inputWord.getText();
            String b = (String)Dic.tm.get(a);
            if(b==null){
                b = "";
                JOptionPane.showMessageDialog(rootPane, "Từ chưa có trong từ điển");
                  
            }              
            outputWord.setText(b+"\n");
            //outputWord.setText(Dic.words[showDic.getSelectedIndex()].getWordExplain());
        }
        
        else JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập từ");
            
    }//GEN-LAST:event_searchButtonActionPerformed

    private void inputWordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputWordInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_inputWordInputMethodTextChanged

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void showDicValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_showDicValueChanged
        //inputWord.setText(f.Dic.words[showDic.getSelectedIndex()].getWordTarget());
       //outputWord.setText(f.Dic.words[showDic.getSelectedIndex()].getWordExplain());
// TODO add your handling code here:
    }//GEN-LAST:event_showDicValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        Frame f = new Frame();
        f.setVisible(true);           
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here
        if(showDic.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn từ");
            
        }
        else{
            int click = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc muốn xóa từ này ?");       
        if(click == JOptionPane.YES_OPTION){
            String wordtarget = showDic.getSelectedValue();
            if(Dic.tm.containsKey(wordtarget)){
                Dic.tm.remove(wordtarget);
                Dm.model.removeElement(wordtarget);
            }
            try {
                Dm.update(Dic);                
                    
            } catch (IOException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);                   
            }                             
            
            inputWord.setText("");
            outputWord.setText("");
            JOptionPane.showMessageDialog(rootPane, "Xóa từ thành công");
        } 
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void inputWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputWordKeyTyped
       
    }//GEN-LAST:event_inputWordKeyTyped

    private void inputWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputWordKeyPressed
       
    }//GEN-LAST:event_inputWordKeyPressed

    private void inputWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputWordKeyReleased
        // TODO add your handling code here:
        if(!evt.equals(VK_ENTER)){
            String a = inputWord.getText();
            for(int i=0;i<Dic.getN();i++){
                String s = Dic.words[i].getWordTarget();
                
                if(s.startsWith(a)){   
                    showDic.setSelectedIndex(i);                   
                    if(showDic.getSelectedIndex()<Dic.getN()-24)
                        showDic.ensureIndexIsVisible(showDic.getSelectedIndex()+24);
                    else
                        showDic.ensureIndexIsVisible(Dic.getN()-1);
                    break;                                    
                }
                
            }
            
        }
        
    }//GEN-LAST:event_inputWordKeyReleased

    private void showDicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showDicMouseClicked
        // TODO add your handling code here:
        String a = Dic.words[showDic.getSelectedIndex()].getWordTarget();
        inputWord.setText(a);
        outputWord.setText(Dic.tm.get(a)+"\n");
    }//GEN-LAST:event_showDicMouseClicked

    private void showDicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showDicKeyReleased
        // TODO add your handling code here:
        String a = Dic.words[showDic.getSelectedIndex()].getWordTarget();
        inputWord.setText(a);
        outputWord.setText(Dic.tm.get(a)+"\n");
    }//GEN-LAST:event_showDicKeyReleased

    private void showDicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showDicKeyPressed
        // TODO add your handling code here:
        //if(evt.equals(VK_UP)){
            //showDic.setSelectedIndex(showDic.getSelectedIndex()-1);
        //}
        //if(evt.equals(VK_DOWN)){
            //showDic.setSelectedIndex(showDic.getSelectedIndex()+1);
        //}
    }//GEN-LAST:event_showDicKeyPressed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Dm.insertFromFile(Dic);
            MyFrame mf = new MyFrame();
            mf.setLocationRelativeTo(null);
            mf.setVisible(true);
        });
       
        		
	
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField inputWord;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel outputWord;
    private javax.swing.JButton searchButton;
    private javax.swing.JList<String> showDic;
    // End of variables declaration//GEN-END:variables
}
