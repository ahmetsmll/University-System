import javax.swing.*;            
import javax.swing.table.*;      
import java.awt.*;               
import java.awt.event.*;         
import java.sql.*;               
import java.util.*; 

public class ExamResultsFrame extends javax.swing.JFrame {

   
    public ExamResultsFrame(int studentId) {
        initComponents();
        setLocationRelativeTo(null); 
        loadExamResults(studentId); 
        
    }
    
    private void loadExamResults(int studentId) {
    try {
        Connection conn = DBConnection.connect();
        String sql = "SELECT midterm, final, project FROM exam_results WHERE student_id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentId);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int midterm = rs.getInt("midterm");
            int finalExam = rs.getInt("final");
            int project = rs.getInt("project");

            double average = (midterm * 0.3) + (finalExam * 0.5) + (project * 0.2);

            lblMidterm.setText(String.valueOf(midterm));
            lblFinal.setText(String.valueOf(finalExam));
            lblProject.setText(String.valueOf(project));
            lblAverage.setText(String.format("%.2f", average));
        } else {
            JOptionPane.showMessageDialog(this, "No exam results found for this student.");
        }

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading exam results.");
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMidterm = new javax.swing.JLabel();
        lblFinal = new javax.swing.JLabel();
        lblProject = new javax.swing.JLabel();
        lblAverage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Database Exam Results");

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Midterm:");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Final:");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Project:");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Average:");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true));

        lblMidterm.setBackground(new java.awt.Color(153, 153, 153));
        lblMidterm.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblMidterm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMidterm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        lblFinal.setBackground(new java.awt.Color(153, 153, 153));
        lblFinal.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        lblProject.setBackground(new java.awt.Color(153, 153, 153));
        lblProject.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblProject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        lblAverage.setBackground(new java.awt.Color(153, 153, 153));
        lblAverage.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblAverage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMidterm, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(lblAverage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(lblMidterm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(lblFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblAverage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAverage;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblMidterm;
    private javax.swing.JLabel lblProject;
    // End of variables declaration//GEN-END:variables
}
