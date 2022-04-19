package simplex;

import javax.swing.table.DefaultTableModel;

public class simplex1 extends javax.swing.JFrame {

    int lp = 0;
    int cp = 0;
    double pivo;
    double max;
    double min;
    double[][] matrix;

    double[] k;

    int x, y;

   
    boolean add = true;
    int i = 1;
    int e = 1;
    Object columnNames;
    DefaultTableModel dtm = new DefaultTableModel();

    public simplex1() {

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addcolone = new javax.swing.JButton();
        addline = new javax.swing.JButton();
        run = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayZone = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addcolone.setText("add Xi");
        addcolone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcoloneActionPerformed(evt);
            }
        });

        addline.setText("add line");
        addline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlineActionPerformed(evt);
            }
        });

        run.setText("run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jButton1.setText("add Ei");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        displayZone.setColumns(20);
        displayZone.setRows(5);
        jScrollPane2.setViewportView(displayZone);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(addcolone, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(addline, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(849, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addcolone)
                            .addComponent(run)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 100, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(addline)
                    .addContainerGap(543, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlineActionPerformed

        if (add == true) {
            String p = "C";
            columnNames = p;
            dtm.addColumn(columnNames);
            table.setModel(dtm);
            add = false;
        }
        Object[] rowData = new String[]{};
        dtm.addRow(rowData);
    }//GEN-LAST:event_addlineActionPerformed

    private void addcoloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcoloneActionPerformed
        String p = "X" + i;
        columnNames = p;//new String[]{"nghj","rtret"};
        dtm.addColumn(columnNames);
        table.setModel(dtm);
        i++;
    }//GEN-LAST:event_addcoloneActionPerformed

//get valeus from table
    public void getValueFormTable() {
        x = table.getRowCount() - 1;
        y = table.getColumnCount() - 1;

        k = new double[x];
        matrix = new double[table.getRowCount()][table.getColumnCount()];

        //get valeus from table
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                matrix[i][j] = Double.valueOf((String) table.getValueAt(i, j));
                
                display(matrix[i][j] + "  ");
                System.out.print(matrix[i][j] + "  ");

            }
            System.out.println();
            display("");
        }

    }

    public boolean testZ() {
        x = table.getRowCount() - 1;
        y = table.getColumnCount() - 1;

        boolean a = false;

        for (int j = 0; j < y; j++) {
            if (matrix[x][j] > 0) {
                a = true;
            }
        }
        return a;
    }

    public void calculMaxZ() {
        max = matrix[x][0];
        for (int i = 0; i <= y; i++) {
            if (max < matrix[x][i]) {
                max = matrix[x][i];
                cp = i;
            }
        }
    }

    public void calculK() {
        //calcul k
        System.out.print("K : ");
        display("K : ");
        for (int j = 0; j < k.length; j++) {
            k[j] = matrix[j][y] / matrix[j][cp];
            System.out.print(+k[j] + ", ");
            display(+k[j] + ", ");
        }
        System.out.println();
        display("");
    }

    public double minK() {
        min = 1000;
        for (int i = 0; i < k.length; i++) {
            if (k[i] >= 0) {
                if (min > k[i]) {

                    min = k[i];
                    lp = i;
                }

            }
        }
        return lp;
    }

    public void display(String t) {
        String text = displayZone.getText();
        text = text + t;
        displayZone.setText(text + " " +"\n");
    }

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed

        getValueFormTable();

        testZ();

        while (testZ()) {

//  loop************************************************************
            //get column pivo 
            calculMaxZ();

            // System.out.println("-------------");
            display("max Z: " + max);
            System.out.println("max Z: " + max);
            display("colomn pivo : " + cp);
            System.out.println("colomn pivo : " + cp);

            calculK();
            minK();
            display("min K : " + min);
            System.out.println("min K : " + min);
            display("line pivo : " + lp);
            System.out.println("line pivo : " + lp);

            pivo = matrix[lp][cp];
            display("pivo = " + pivo);
            System.out.println("pivo = " + pivo);

            //update table     divide pivot line 
            for (int j = 0; j <= y; j++) {
                matrix[lp][j] = matrix[lp][j] / pivo;

            }

            // display the update of pivot line
//            for (int i = 0; i <= x; i++) {
//                for (int j = 0; j <= y; j++) {
//
//                    System.out.print(matrix[i][j] + "  ");
//
//                }
//                System.out.println();
//            }
            for (int i = 0; i <= x; i++) {
                double p = -matrix[i][cp];
                for (int j = 0; j <= y; j++) {
                    if (i != lp) {

                        matrix[i][j] = p * matrix[lp][j] + matrix[i][j];

                    }
                }
            }

            display("-------------------------------");
            System.out.println("-------------------");
            for (int i = 0; i <= x; i++) {
                for (int j = 0; j <= y; j++) {

                    System.out.print(matrix[i][j] + "  ");
                    display(matrix[i][j] + "  ");

                }
                System.out.println();
                display("");
            }

            //test la solution est-elle optimale?
            boolean solution = true;
            for (int i = 0; i <= x; i++) {
                if (matrix[x][i] > 0) {
                    solution = false;
                }
            }

            if (solution == true) {
                display("la solution est optimale");
                System.out.println("la solution est optimale");
                cp = 0;
                lp = 0;
                if(matrix[x][y] < 0){
                   matrix[x][y] =  -matrix[x][y];
                }
                System.out.println(" optimal :  " + matrix[x][y]);

            } else {
                display("la solution est ne pas optimale");

                System.out.println("la solution est ne pas optimale");
                cp = 0;
                lp = 0;
            }

        }

        // ************************************************************

    }//GEN-LAST:event_runActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String p = "e" + e;
        columnNames = p;//new String[]{"nghj","rtret"};
        dtm.addColumn(columnNames);
        table.setModel(dtm);
        i++;
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(simplex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(simplex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(simplex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(simplex1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new simplex1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcolone;
    private javax.swing.JButton addline;
    private javax.swing.JTextArea displayZone;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton run;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
