/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.mypanel;

import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.main.Base;
import com.compnay.beans.Skill;
import com.compnay.beans.UserSkills;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class SkillPanel extends javax.swing.JPanel {

    SkillDaoInter daoInter = new SkillDaoImpl();
    UserSkillDaoInter skillDaoInter = new UserSkillDaoImpl();

    /**
     * Creates new form SkillPanel
     */
    public SkillPanel() {
        initComponents();
    }

    public void fillWindow() {
        showUserSkill();
        List<Skill> list = daoInter.getAllSkill();
        for (Skill skill : list) {
            boxSkill.addItem(skill);
        }
    }
    List<UserSkills> userSkill = null;

    private void showUserSkill() {
        userSkill = skillDaoInter.getUserSkillById(Base.u.getId());
        Vector<Vector> rows = new Vector<>();

        for (UserSkills row : userSkill) {
            Vector vector = new Vector();
            vector.add(row.getSkill());
            vector.add(row.getPower());
            rows.add(vector);
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(rows, new Vector(Arrays.asList("Skill", "Power")));
        jTable1.setModel(defaultTableModel);

    }

    public void setSkills() {
        int power = sliderSkill.getValue();
        Skill skill = (Skill) boxSkill.getSelectedItem();
        UserSkills userSkills = new UserSkills(null, Base.u, skill, power);
        skillDaoInter.addUserSkill(userSkills);
        showUserSkill();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblSkill = new javax.swing.JLabel();
        boxSkill = new javax.swing.JComboBox<>();
        txtSkill = new javax.swing.JTextField();
        sliderSkill = new javax.swing.JSlider();
        btnSkillASC = new javax.swing.JButton();
        btnSkillDESC = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lblSkill.setText("Skill");

        boxSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSkillActionPerformed(evt);
            }
        });

        btnSkillASC.setText("+");
        btnSkillASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkillASCActionPerformed(evt);
            }
        });

        btnSkillDESC.setText("-");
        btnSkillDESC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkillDESCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSkillASC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSkillDESC)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliderSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSkillASC)
                    .addComponent(btnSkillDESC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSkillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSkillActionPerformed

    private void btnSkillASCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkillASCActionPerformed
        setSkills();

// TODO add your handling code here:
    }//GEN-LAST:event_btnSkillASCActionPerformed

    private void btnSkillDESCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkillDESCActionPerformed
        int index = jTable1.getSelectedRow();
        UserSkills ss = userSkill.get(index);
        System.err.println(ss);
        skillDaoInter.removeUserSkill(ss.getId());
        showUserSkill();
    }//GEN-LAST:event_btnSkillDESCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Skill> boxSkill;
    private javax.swing.JButton btnSkillASC;
    private javax.swing.JButton btnSkillDESC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JSlider sliderSkill;
    private javax.swing.JTextField txtSkill;
    // End of variables declaration//GEN-END:variables
}
